package lcw.JDBC_day01;


import lcw.HTTP.User;

import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by soft01 on 2017/5/7.
 */
public class JDBC_Demo {
    private static final String className;

    private static final String url;

    private static final String username;

    private static final String password;

    private static final Integer maxactive;

    private static final Integer maxwait;

    static {
        Properties properties = new Properties();
        InputStream is = null;
        try {
//            File file = new File("src/main/java/lcw/JDBC_day01/config.properties");
//            System.out.println("文件:"+file.isFile());
            File file = new File("D:/MyGit/Java_api/JAVA-RESTful-API/src/main/java/lcw/JDBC_day01/config.properties");
            is = new FileInputStream(file);
            properties.load(is);
            className = properties.getProperty("className");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            maxactive = Integer.valueOf(properties.getProperty("maxactive"));
            maxwait = Integer.valueOf(properties.getProperty("maxwait"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("配置文件找不到");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("流取不到");
        }
    }

    public static Connection JDBC() {
        Connection conn = null;

        try {
            Class.forName(className);
            System.out.println("驱动加载成功");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("JDBC配置出错");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("连接数据库失败");
        }
        return conn;
    }

    public static void main(String[] args) {
        JDBC();
    }

    public static Users Selcet_JDBC(String account) {
        Users user = new Users();
        Connection conn = null;
        try {
            conn = JDBC();
            String sql = "SELECT * FROM User WHERE account=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ResultSet rr = ps.executeQuery();
            while (rr.next()) {
                user.setUuid(rr.getString("uuid"));
                user.setName(rr.getString("name"));
                user.setAccount(rr.getString("account"));
                user.setIdcardnum(rr.getString("idcardnum"));
                user.setPassword(rr.getString("password"));
                user.setUsername(rr.getString("username"));
                user.getGender(rr.getString("gender"));
                user.setSign(rr.getString("sign"));
                user.setHeadpicture(rr.getString("headpicture"));
            }
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("sql执行失败");
        } finally {
            if (conn != null) {
                try {
                    conn.clearWarnings();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("关闭数据库连接失败！");
                }
            }
        }
        return user;
    }

    public static void Insert_JDBC(Users user) {
        List<User> list = new ArrayList();
        Connection conn = null;
        conn = JDBC();
        String sql = "INSERT INTO User VALUES " + user;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("SQL:"+sql);
            int num = ps.executeUpdate();
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.clearWarnings();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("关闭数据库连接失败！");
                }
            }
        }
    }

}

