package daoimp;

import dao.ManagerDao;
import entity.Manager;
import utils.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * 经理的具体实现类
 */
public class ManagerDaoImp implements ManagerDao {


    //声明连接对象
    Connection connection=null;
    //声明数据库操作对象
    PreparedStatement preparedStatement=null;
    //声明结果存储对象
    ResultSet resultSet=null;

    @Override
    public int managerLogin(String mname, String mpassword) throws Exception {

        int falg=0;//1代表登陆成功，2代表登陆失败，3代表查无此人
        connection= JDBCHelper.getConn();
        String findSql="select mpassword from manager where mname=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setString(1,mname);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            if(resultSet.getString("mpassword").equals(mpassword)){
                falg=1;
            }else {
                falg=2;
            }
        }else {
            falg=3;
        }
        return falg;
    }

    @Override
    public boolean mupdatePassword(int mid, String newPsw) throws Exception {
        connection=JDBCHelper.getConn();
        String findSql="update manager set mpassword=? where mid=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setString(1,newPsw);
        preparedStatement.setInt(2,mid);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,null);
        return count>0?true:false;
    }

    @Override
    public Manager getMangerByName(String mname) throws Exception {
        Manager manager=new Manager();
        connection=JDBCHelper.getConn();
        String findSql="select * from manager where mname=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setString(1,mname);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            manager.setMid(resultSet.getInt("mid"));
            manager.setMname(resultSet.getString("mname"));
            manager.setMpassword(resultSet.getString("mpassword"));
            manager.setMpower(resultSet.getInt("mpower"));
            manager.setMstatus(resultSet.getInt("mstatus"));
        }
        return manager;
    }
}
