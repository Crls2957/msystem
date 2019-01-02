package daoimp;

import bean.DeptPageBean;
import dao.DeptDao;
import entity.Dept;
import utils.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDaoImp implements DeptDao {

    //声明连接对象
    Connection connection=null;
    //声明数据库操作对象
    PreparedStatement preparedStatement=null;
    //声明结果存储对象
    ResultSet resultSet=null;

    @Override
    public Dept getDeptById(int did) throws Exception{
        Dept dept=new Dept();
        connection= JDBCHelper.getConn();
        String findSql="select * from dept where did=?";
            preparedStatement = connection.prepareStatement(findSql);
            preparedStatement.setInt(1, did);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                dept.setDname(resultSet.getString("dname"));
                dept.setDaddr(resultSet.getString("daddr"));
                dept.setDnumber(resultSet.getInt("dnumber"));
                dept.setEid(resultSet.getInt("eid"));
                dept.setDstatus(resultSet.getInt("dstatus"));
            }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return dept;
    }

    @Override
    public ArrayList<Dept> getAllDept() throws Exception{
        ArrayList<Dept> arrayList=new ArrayList<>();
        connection=JDBCHelper.getConn();
        String findSql="select * from dept where dstatus=1";
        preparedStatement=connection.prepareStatement(findSql);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Dept dept=new Dept();
            dept.setDid(resultSet.getInt("did"));
            dept.setDname(resultSet.getString("dname"));
            dept.setDaddr(resultSet.getString("daddr"));
            dept.setDnumber(resultSet.getInt("dnumber"));
            dept.setEid(resultSet.getInt("eid"));
            dept.setDstatus(resultSet.getInt("dstatus"));
            arrayList.add(dept);
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return arrayList;
    }

    //定义总的数据条数
    int lineCount=0;

    public int getLineCount() {
        return lineCount;
    }

    //定义总的页数

    int pageNum=0;

    public int getPageNum() {
        return pageNum;
    }

    @Override
    public DeptPageBean getAllDeptByPage(int n) throws Exception {
        ArrayList<Dept> arrayList=new ArrayList<>();
        DeptPageBean deptPageBean=new DeptPageBean();
        int crruntPage=n;//当前页
        int pageSize=3;//每页显示数据
        connection=JDBCHelper.getConn();
        String findLine="select count(*) from dept where dstatus=1";
        String findSql="select * from dept where dstatus=1 limit ?,?";
        preparedStatement=connection.prepareStatement(findLine);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            lineCount=resultSet.getInt(1);
        }
        pageNum=(int)Math.ceil(lineCount/pageSize);
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setInt(1,(crruntPage-1)*pageSize);
        preparedStatement.setInt(2,pageSize);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Dept dept=new Dept();
            dept.setDid(resultSet.getInt("did"));
            dept.setDname(resultSet.getString("dname"));
            dept.setDnumber(resultSet.getInt("dnumber"));
            dept.setDaddr(resultSet.getString("daddr"));
            dept.setEid(resultSet.getInt("eid"));
            dept.setDstatus(1);
            arrayList.add(dept);
        }
        deptPageBean.setPageNow(crruntPage);
        deptPageBean.setLineCount(lineCount);
        deptPageBean.setTotalPage(pageNum);
        deptPageBean.setArrayList(arrayList);
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return deptPageBean;
    }

    @Override
    public boolean insertDept(Dept dept) throws Exception {
        connection=JDBCHelper.getConn();
        String addSql="insert into dept(did,dname,dnumber,daddr,eid,dstatus) values(?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(addSql);
        preparedStatement.setInt(1, dept.getDid());
        preparedStatement.setString(2, dept.getDname());
        preparedStatement.setInt(3, dept.getDnumber());
        preparedStatement.setString(4, dept.getDaddr());
        preparedStatement.setInt(5, dept.getEid());
        preparedStatement.setInt(6,1);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,null);
        return count>0?true:false;
    }

    @Override
    public boolean updateDept(int did, Dept dept) throws Exception {
        connection=JDBCHelper.getConn();
        String updateSql="update dept set did=?,dname=?,dnumber=?,daddr=?,eid=? where did=?";
        preparedStatement=connection.prepareStatement(updateSql);
        preparedStatement.setInt(1, dept.getDid());
        preparedStatement.setString(2, dept.getDname());
        preparedStatement.setInt(3, dept.getDnumber());
        preparedStatement.setString(4, dept.getDaddr());
        preparedStatement.setInt(5, dept.getEid());
        preparedStatement.setInt(6, did);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,null);
        return count>0?true:false;
    }

    @Override
    public boolean deleteDept(int did) throws Exception {

        connection=JDBCHelper.getConn();
        String deleteSql="update  dept set dstatus=0 where did=?";
         preparedStatement=connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,did);
            int count=preparedStatement.executeUpdate();
            return count>0?true:false;
    }
}
