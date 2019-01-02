package daoimp;

import dao.PostDao;
import entity.Dept;
import entity.Post;
import utils.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 职位具体实现类
 */
public class PostDaoImp implements PostDao {

    //声明连接对象
    Connection connection=null;
    //声明数据库操作对象
    PreparedStatement preparedStatement=null;
    //声明结果存储对象
    ResultSet resultSet=null;

    @Override
    public ArrayList<Post> getAllPost() throws Exception {
        ArrayList<Post> arrayList=new ArrayList<>();
        connection= JDBCHelper.getConn();
        String findSql="select * from post where pstatus=1";
        preparedStatement=connection.prepareStatement(findSql);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Post post=new Post();
            post.setPid(resultSet.getInt("pid"));
            post.setPname(resultSet.getString("pname"));
            post.setPstatus(resultSet.getInt("pstatus"));
            arrayList.add(post);
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return arrayList;
    }

    @Override
    public Post getPostById(int pid) throws Exception {
        Post post=new Post();
        connection=JDBCHelper.getConn();
        String findSql="select * from post where pid=? and pstatus=1";
        preparedStatement=connection.prepareStatement(findSql);
        preparedStatement.setInt(1,pid);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            post.setPid(resultSet.getInt("pid"));
            post.setPname(resultSet.getString("pname"));
            post.setPstatus(resultSet.getInt("pstatus"));
        }
        JDBCHelper.close(connection,preparedStatement,resultSet);
        return post;
    }

}
