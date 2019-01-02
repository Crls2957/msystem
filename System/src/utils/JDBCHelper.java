package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCHelper {

    //声明连接池
    private static ComboPooledDataSource comboPooledDataSource=null;
    static {
        comboPooledDataSource=new ComboPooledDataSource("Mysql");
    }

    //获取连接对象
    public static Connection getConn(){
        Connection connection=null;
        try{
                connection=comboPooledDataSource.getConnection();
                return connection;
            }catch (Exception e){
                e.printStackTrace();
            }
        return null;
    }

    //关闭数据库连接，sql语句执行，结果存储
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws Exception{
        if (connection!=null){
            connection.close();
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }
    }
    /*public static void main(String [] args){
        System.err.println(JDBCHelper.getConn());
    }*/
}
