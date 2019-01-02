package daoimp;

import bean.NewsPageBean;
import dao.ManagerDao;
import dao.MessageDao;
import entity.Message;
import utils.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.jar.JarEntry;

/**
 * 消息的具体实现类
 */
public class MessageDaoImp implements MessageDao {

    //声明连接对象
    Connection connection=null;
    //声明数据库操作对象
    PreparedStatement preparedStatement=null;
    //声明结果存储对象
    ResultSet resultSet=null;

    public MessageDaoImp() {
        super();
    }

    @Override
    public ArrayList<Message> getALlMsg() throws Exception {
        ArrayList<Message> arrayList=new ArrayList<>();
        connection= JDBCHelper.getConn();
        String findSql="select * from message where mstatus=1";
        preparedStatement=connection.prepareStatement(findSql);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Message message=new Message();
            message.setMid(resultSet.getInt("mid"));
            message.setMuser(resultSet.getString("muser"));
            message.setMtitle(resultSet.getString("mtitle"));
            message.setMtime(resultSet.getDate("mtime"));
            message.setMcontent(resultSet.getString("mcontent"));
            arrayList.add(message);
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
    public NewsPageBean getALlMsgByPage(int n) throws Exception {
        NewsPageBean newsPageBean=new NewsPageBean();
        ArrayList<Message> arrayList=new ArrayList<>();
        int crruntPage=n;//当前页
        int pageSize=3;//每页显示数据
        connection=JDBCHelper.getConn();
        String findLine="select count(*) from message where mstatus=1";
        String findSql="select * from message where mstatus=1 limit ?,?";
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
            Message message=new Message();
            message.setMid(resultSet.getInt("mid"));
            message.setMuser(resultSet.getString("muser"));
            message.setMtitle(resultSet.getString("mtitle"));
            message.setMtime(resultSet.getDate("mtime"));
            message.setMcontent(resultSet.getString("mcontent"));
            arrayList.add(message);
        }
        newsPageBean.setCrruntPage(crruntPage);
        newsPageBean.setLineCount(lineCount);
        newsPageBean.setTotalPage(pageNum);
        newsPageBean.setArrayList(arrayList);
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return newsPageBean;
    }

    @Override
    public boolean addMessage(Message msg) throws Exception {
        connection=JDBCHelper.getConn();
        String addSql="insert into message(mtitle,mcontent,mtime,muser,mstatus) values(?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(addSql);
        preparedStatement.setString(1, msg.getMtitle());
        preparedStatement.setString(2, msg.getMcontent());
        preparedStatement.setDate(3, new java.sql.Date(msg.getMtime().getTime()));
        preparedStatement.setString(4, msg.getMuser());
        preparedStatement.setInt(5, 1);
        int count=preparedStatement.executeUpdate();
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return count>0?true:false;
    }

    @Override
    public Message getMsgByUser(String muser) throws Exception {
        Message message=new Message();
        connection=JDBCHelper.getConn();
        String findSql="select * from message where muser=?";
        preparedStatement.setString(1,muser);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            message.setMid(resultSet.getInt("mid"));
            message.setMtitle(resultSet.getString("mtitle"));
            message.setMtime(resultSet.getDate("mtime"));
            message.setMcontent(resultSet.getString("mcontent"));
            message.setMstatus(resultSet.getInt("mstatus"));
        }
        return message;
    }

    @Override
    public boolean deleteNews(int mid) throws Exception {
        connection=JDBCHelper.getConn();
        String deleteSql="update message set mstatus=0 where mid=?";
        preparedStatement=connection.prepareStatement(deleteSql);
        preparedStatement.setInt(1,mid);
        int count=preparedStatement.executeUpdate();
        return count>0?true:false;
    }
}
