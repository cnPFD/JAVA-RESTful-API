package lcw.JDBC_day01;


import java.io.*;
import java.sql.*;
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
    public static void main(String[] args) {
        JDBC();
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
                user.setGender(rr.getString("gender"));
                user.setSign(rr.getString("sign"));
                user.setHeadpicture(rr.getString("headpicture"));
            }

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

    public static void Delete_JDBC(String account){
        Users user = new Users();
        Connection conn = null;
        try {
            conn = JDBC();
            String sql = "DELETE FROM User WHERE account=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            int rr = ps.executeUpdate();
            System.out.println(rr+"条已被删除");
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
    }

    public static void Update_JDBC(String username,String password,String account){
        Connection conn = null;
        conn = JDBC();
        String sql = "UPDATE User SET password=?, username=?  WHERE account=?" ;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            Users sel=JDBC_Demo.Selcet_JDBC(user.getAccount());
//            if(user.getUuid()!=sel.getUuid())
//                user.setName(sel.getName());
//            if(user.getName()==null)
//                user.setName(sel.getName());
//            if(user.getIdcardnum()==null)
//                user.setIdcardnum(sel.getIdcardnum());
//            if(user.getPassword()==null)
//                user.setPassword(sel.getPassword());
//            if(user.getUsername()==null)
//                user.setUsername(sel.getUsername());
//            if(user.getGender()==null)
//                user.setGender(sel.getGender());
//            if(user.getSign()==null)
//                user.setSign(sel.getSign());
//            if(user.getHeadpicture()==null)
//                user.setHeadpicture(sel.getHeadpicture());
//            System.out.println("SEL:"+sel);
//            System.out.println("USER:"+user);
//            ps.setString(1,user.getName());
//            ps.setString(2,user.getIdcardnum());
//            ps.setString(3,user.getAccount());
            ps.setString(1,password);
            ps.setString(2,username);
//            ps.setString(6,user.getGender());
//            ps.setString(7,user.getSign());
            ps.setString(3,account);
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

