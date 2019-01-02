package daoimp;

import bean.EmploePageBean;
import dao.EmploeDao;
import entity.Emploe;
import entity.Manager;
import utils.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 职员具体实现类
 */
public class EmploeDaoImp implements EmploeDao {

    //声明连接对象
    Connection connection=null;
    //声明数据库操作对象
    PreparedStatement preparedStatement=null;
    //声明结果存储对象
    ResultSet resultSet=null;

    @Override
    public boolean registerEmploe(Emploe emploe) throws Exception {
        connection= JDBCHelper.getConn();
        String registerSql="insert into emploe(eid,epassword,ename,equestion,eanswer,estatus) values(?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(registerSql);
        preparedStatement.setInt(1,emploe.getEid());
        preparedStatement.setString(2,emploe.getEpassword());
        preparedStatement.setString(3,emploe.getEname());
        preparedStatement.setString(4,emploe.getEquestion());
        preparedStatement.setString(5,emploe.getEanswer());
        preparedStatement.setInt(6,1);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,null);
        return count>0?true:false;
    }

    @Override
    public boolean registerEmploe2(Emploe emploe) throws Exception {
        connection= JDBCHelper.getConn();
        String registerSql="insert into emploe(eid,epassword,ename,estatus) values(?,?,?,?)";
        preparedStatement=connection.prepareStatement(registerSql);
        preparedStatement.setInt(1,emploe.getEid());
        preparedStatement.setString(2,emploe.getEpassword());
        preparedStatement.setString(3,emploe.getEname());
        preparedStatement.setInt(4,1);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,null);
        return count>0?true:false;
    }

    @Override
    public boolean addEmploe(Emploe emploe) throws Exception {
        connection=JDBCHelper.getConn();
        String addSql="insert into emploe(eid,ename,esex,esalary,ebir,emarry,eedu,did,pid,ephone,eaddr,estatus) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(addSql);
        preparedStatement.setInt(1, emploe.getEid());
        preparedStatement.setString(2, emploe.getEname());
        preparedStatement.setString(3, emploe.getEsex());
        preparedStatement.setString(4, emploe.getEsalary());
        preparedStatement.setDate(5, new java.sql.Date(emploe.getEbir().getTime()));
        preparedStatement.setString(6, emploe.getEmarry());
        preparedStatement.setString(7, emploe.getEedu());
        preparedStatement.setInt(8, emploe.getDid());
        preparedStatement.setInt(9, emploe.getPid());
        preparedStatement.setString(10, emploe.getEphone());
        preparedStatement.setString(11, emploe.getEaddr());
        preparedStatement.setInt(12, 1);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,null);
        return count>0?true:false;
    }

    @Override
    public boolean remove(int eid) throws Exception {
        connection=JDBCHelper.getConn();
        String removeSql="update emploe set estatus=0 where eid=?";
        preparedStatement=connection.prepareStatement(removeSql);
        preparedStatement.setInt(1,eid);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return count>0?true:false;
    }

    @Override
    public boolean updateEmploe(int eid, Emploe emploe) throws Exception {
        connection=JDBCHelper.getConn();
        String updateSql="update emploe set ename=?,esex=?,ebir=?,emarry=?,ephone=?,eaddr=?,did=?,pid=?,eedu=?,epassword=?,ephoto=?,equestion=?,eanswer=?,esalary=? where eid=?";
        preparedStatement=connection.prepareStatement(updateSql);
        preparedStatement.setString(1, emploe.getEname());
        preparedStatement.setString(2, emploe.getEsex());
        preparedStatement.setDate(3, new java.sql.Date(emploe.getEbir().getTime()));
        preparedStatement.setString(4, emploe.getEmarry());
        preparedStatement.setString(5, emploe.getEphone());
        preparedStatement.setString(6, emploe.getEaddr());
        preparedStatement.setInt(7, emploe.getDid());
        preparedStatement.setInt(8, emploe.getPid());
        preparedStatement.setString(9, emploe.getEedu());
        preparedStatement.setString(10, emploe.getEpassword());
        preparedStatement.setString(11, emploe.getEphoto());
        preparedStatement.setString(12, emploe.getEquestion());
        preparedStatement.setString(13, emploe.getEanswer());
        preparedStatement.setString(14, emploe.getEsalary());
        preparedStatement.setInt(15, eid);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return count>0?true:false;
    }

    @Override
    public Emploe getEmploeByName(String ename) throws Exception {
        Emploe emploe=new Emploe();
        connection=JDBCHelper.getConn();
        String findSql="select * from emploe where ename=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setString(1,ename);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            emploe.setEid(resultSet.getInt("eid"));
            emploe.setEname(resultSet.getString("ename"));
            emploe.setEsex(resultSet.getString("esex"));
            emploe.setEbir(resultSet.getDate("ebir"));
            emploe.setEmarry(resultSet.getString("emarry"));
            emploe.setEphone(resultSet.getString("ephone"));
            emploe.setEaddr(resultSet.getString("eaddr"));
            emploe.setDid(resultSet.getInt("did"));
            emploe.setPid(resultSet.getInt("pid"));
            emploe.setEedu(resultSet.getString("eedu"));
            emploe.setEsalary(resultSet.getString("esalary"));
            emploe.setEpassword(resultSet.getString("epassword"));
            emploe.setEphoto(resultSet.getString("ephoto"));
            emploe.setEquestion(resultSet.getString("equestion"));
            emploe.setEanswer(resultSet.getString("eanswer"));
            emploe.setEstatus(resultSet.getInt("estatus"));
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return emploe;
    }

    @Override
    public Emploe getEmploeById(int eid) throws Exception {
        Emploe emploe=new Emploe();
        connection=JDBCHelper.getConn();
        String findSql="select * from emploe where eid=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setInt(1,eid);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            emploe.setEid(resultSet.getInt("eid"));
            emploe.setEname(resultSet.getString("ename"));
            emploe.setEsex(resultSet.getString("esex"));
            emploe.setEbir(resultSet.getDate("ebir"));
            emploe.setEmarry(resultSet.getString("emarry"));
            emploe.setEphone(resultSet.getString("ephone"));
            emploe.setEaddr(resultSet.getString("eaddr"));
            emploe.setDid(resultSet.getInt("did"));
            emploe.setPid(resultSet.getInt("pid"));
            emploe.setEedu(resultSet.getString("eedu"));
            emploe.setEsalary(resultSet.getString("esalary"));
            emploe.setEpassword(resultSet.getString("epassword"));
            emploe.setEphoto(resultSet.getString("ephoto"));
            emploe.setEquestion(resultSet.getString("equestion"));
            emploe.setEanswer(resultSet.getString("eanswer"));
            emploe.setEstatus(resultSet.getInt("estatus"));
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return emploe;
    }

    @Override
    public ArrayList<Emploe> getEmploeByDname(String dname) throws Exception {
        ArrayList<Emploe> arrayList=new ArrayList<>();
        connection=JDBCHelper.getConn();
        String findSql="select * from emploe where did=(select did from dept where dname=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setString(1,dname);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Emploe emploe=new Emploe();
            emploe.setEid(resultSet.getInt("eid"));
            emploe.setEname(resultSet.getString("ename"));
            emploe.setEsex(resultSet.getString("esex"));
            emploe.setEbir(resultSet.getDate("ebir"));
            emploe.setEmarry(resultSet.getString("emarry"));
            emploe.setEphone(resultSet.getString("ephone"));
            emploe.setEaddr(resultSet.getString("eaddr"));
            emploe.setDid(resultSet.getInt("did"));
            emploe.setPid(resultSet.getInt("pid"));
            emploe.setEedu(resultSet.getString("eedu"));
            emploe.setEsalary(resultSet.getString("esalary"));
            emploe.setEpassword(resultSet.getString("epassword"));
            emploe.setEphoto(resultSet.getString("ephoto"));
            emploe.setEquestion(resultSet.getString("equestion"));
            emploe.setEanswer(resultSet.getString("eanswer"));
            emploe.setEstatus(resultSet.getInt("estatus"));
            arrayList.add(emploe);
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return arrayList;
    }

    @Override
    public ArrayList<Emploe> getEmploeByPname(String pname) throws Exception {
        ArrayList<Emploe> arrayList=new ArrayList<>();
        connection=JDBCHelper.getConn();
        String findSql="select * from emploe where did=(select did from dept where dname=?)";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setString(1,pname);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Emploe emploe=new Emploe();
            emploe.setEid(resultSet.getInt("eid"));
            emploe.setEname(resultSet.getString("ename"));
            emploe.setEsex(resultSet.getString("esex"));
            emploe.setEbir(resultSet.getDate("ebir"));
            emploe.setEmarry(resultSet.getString("emarry"));
            emploe.setEphone(resultSet.getString("ephone"));
            emploe.setEaddr(resultSet.getString("eaddr"));
            emploe.setDid(resultSet.getInt("did"));
            emploe.setPid(resultSet.getInt("pid"));
            emploe.setEedu(resultSet.getString("eedu"));
            emploe.setEsalary(resultSet.getString("esalary"));
            emploe.setEpassword(resultSet.getString("epassword"));
            emploe.setEphoto(resultSet.getString("ephoto"));
            emploe.setEquestion(resultSet.getString("equestion"));
            emploe.setEanswer(resultSet.getString("eanswer"));
            emploe.setEstatus(resultSet.getInt("estatus"));
            arrayList.add(emploe);
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return arrayList;
    }

    @Override
    public boolean updatePidByEid(int eid, int pid) throws Exception {
        connection=JDBCHelper.getConn();
        String updateSql="update emploe set pid=? where eid=? and estatus=1";
        preparedStatement=connection.prepareStatement(updateSql);
        preparedStatement.setInt(1,pid);
        preparedStatement.setInt(2,eid);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return count>0?true:false;
    }

    @Override
    public ArrayList<Emploe> getAllEmploe() throws Exception {
        ArrayList<Emploe> arrayList=new ArrayList<>();
        connection=JDBCHelper.getConn();
        String findSql="select * from emploe where estatus=1";
        preparedStatement=connection.prepareStatement(findSql);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Emploe emploe=new Emploe();
            emploe.setEid(resultSet.getInt("eid"));
            emploe.setEname(resultSet.getString("ename"));
            emploe.setEsex(resultSet.getString("esex"));
            emploe.setEbir(resultSet.getDate("ebir"));
            emploe.setEmarry(resultSet.getString("emarry"));
            emploe.setEphone(resultSet.getString("ephone"));
            emploe.setEaddr(resultSet.getString("eaddr"));
            emploe.setDid(resultSet.getInt("did"));
            emploe.setPid(resultSet.getInt("pid"));
            emploe.setEedu(resultSet.getString("eedu"));
            emploe.setEsalary(resultSet.getString("esalary"));
            emploe.setEpassword(resultSet.getString("epassword"));
            emploe.setEphoto(resultSet.getString("ephoto"));
            emploe.setEquestion(resultSet.getString("equestion"));
            emploe.setEanswer(resultSet.getString("eanswer"));
            emploe.setEstatus(resultSet.getInt("estatus"));
            arrayList.add(emploe);
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
    public EmploePageBean  getAllEmploeByPage(int pageNow) throws Exception {
        ArrayList<Emploe> arrayList=new ArrayList<>();
        EmploePageBean emploePageBean=new EmploePageBean();
        int crruntPage=pageNow;//当前页
        int pageSize=3;//每页显示数据
        connection=JDBCHelper.getConn();
        String findLine="select count(*) from emploe where estatus=1";
        String findSql="select * from emploe where estatus=1 limit ?,?";
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
            Emploe emploe=new Emploe();
            emploe.setEid(resultSet.getInt("eid"));
            emploe.setEname(resultSet.getString("ename"));
            emploe.setEsex(resultSet.getString("esex"));
            emploe.setEbir(resultSet.getDate("ebir"));
            emploe.setEmarry(resultSet.getString("emarry"));
            emploe.setEphone(resultSet.getString("ephone"));
            emploe.setEaddr(resultSet.getString("eaddr"));
            emploe.setDid(resultSet.getInt("did"));
            emploe.setPid(resultSet.getInt("pid"));
            emploe.setEedu(resultSet.getString("eedu"));
            emploe.setEsalary(resultSet.getString("esalary"));
            emploe.setEpassword(resultSet.getString("epassword"));
            emploe.setEphoto(resultSet.getString("ephoto"));
            emploe.setEquestion(resultSet.getString("equestion"));
            emploe.setEanswer(resultSet.getString("eanswer"));
            emploe.setEstatus(resultSet.getInt("estatus"));
            arrayList.add(emploe);
        }
        emploePageBean.setCrruntPage(pageNow);
        emploePageBean.setLineCount(lineCount);
        emploePageBean.setTotalPage(pageNum);
        emploePageBean.setArrayList(arrayList);
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return emploePageBean;
    }

    @Override
    public int emploeLogin(int eid, String epassword) throws Exception {
        int flag=0;//1代表登陆成功，2代表登陆失败，3代表查无此人
        connection=JDBCHelper.getConn();
        String findSql="select epassword from emploe where eid=?";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setInt(1,eid);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            if(resultSet.getString("epassword").equals(epassword)){
                flag=1;
            }else {
                flag=2;
            }
        }else {
            flag=3;
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return flag;
    }
}
