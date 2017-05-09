package ck.ck170507;

/**
 * Created by soft01 on 2017/5/7.
 */

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private String driver = "com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/ck";
    private static String username="root";
    private static String password="root";
    Connection conn = null;

    public DBUtil(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("加载失败",e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException( "找不到这个驱动",e);
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException("归还连接失败",e);
            }
        }
    }

    public static void rollback(Connection conn) {
        if(conn!=null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("回滚失败",e);
            }
        }
    }

//    static {
//        Properties p = new Properties(  );
//
//    }

}
