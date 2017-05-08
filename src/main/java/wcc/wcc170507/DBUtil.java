package wcc.wcc170507;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by soft01 on 2017/5/7.
 * 数据库驱动，连接，
 */
public class DBUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url  = "jdbc:mysql://localhost:3306/wcc";
    private static String username = "root";
    private static String pwd = "root";
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url,username,pwd);
    }
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("归还连接失败！",e);
            }
        }
    }
}
