package lcw.dataBase;


import lcw.webApi.User;
import org.apache.ibatis.session.SqlSession;


/**
 * Created by soft01 on 2017/5/9.
 */

public class User_DAOimpl {

    public static void main(String[] args) {
        User_DAOimpl.getUser_ByAccount("lcw8888");

//        User user=new User("JJC","532974199876780042",
//                "lcw5555","7777","66ccff","男","mmp","无");
//        User_DAOimpl.addUser(user);

//        User user=new User();
//        user.setAccount("lcw6666");
//        user.setPassword("123168957");
//        user.setUsername("WOC");
//        User_DAOimpl.updateUser(user);

//        User_DAOimpl.deleteUser("lcw5555");

    }


    public static User getUser_ByAccount(String account) {
        SqlSession session = dataBase_util.getSqlSessionFactory().openSession();
        User_DAO mapper = session.getMapper(User_DAO.class);
        User user = mapper.selectUser_ByAccount(account);
        try {
            if (user != null) {
                System.out.println(user);
            }
        } finally {
            session.close();
            return user;
        }
    }

    public static void addUser(User user) {
        System.out.println(user);
        SqlSession session = dataBase_util.getSqlSessionFactory().openSession();
        User_DAO mapper = session.getMapper(User_DAO.class);
        mapper.addUser(user);
        try {
            if (user != null) {
                System.out.println(user);
            }
        } finally {
            session.commit();
            session.close();
        }
    }

    public static void updateUser(User user) {
        SqlSession session = dataBase_util.getSqlSessionFactory().openSession();
        User_DAO mapper = session.getMapper(User_DAO.class);
        mapper.updateUser(user);
        try {
            if (user != null) {
                System.out.println(user);
            }
        } finally {
            session.commit();
            session.close();
        }
    }

    public static void deleteUser(String account) {
        SqlSession session = dataBase_util.getSqlSessionFactory().openSession();
        User_DAO mapper = session.getMapper(User_DAO.class);
        mapper.deleteUser(account);
        session.commit();
        session.close();
    }
}
