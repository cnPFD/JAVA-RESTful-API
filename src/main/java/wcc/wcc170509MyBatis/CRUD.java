package wcc.wcc170509MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by soft01 on 2017/5/9.
 */

public class CRUD {
    private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            reader = Resources.getResourceAsReader("wcc_SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("加载文件失败！",e);
        }
    }

    public User selectUser(String idcardnum){
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("showusermsg",idcardnum);
        return user;
    }

    public void insertUser(User user){
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("insertuser",user);
        session.commit();
    }

    public void deleteUser(String idcardnum){
        SqlSession session = sqlSessionFactory.openSession();
        int n = session.delete("deleteuser",idcardnum);
        session.commit();
        session.close();
    }

    public void updateUser(User user){
        SqlSession session = sqlSessionFactory.openSession();
        int n = session.update("updateuser",user);
        session.commit();
        session.close();
    }
}
