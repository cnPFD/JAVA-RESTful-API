package wcc.wcc170509MyBatis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.ws.rs.*;
import java.io.IOException;
import java.io.Reader;
import java.util.UUID;

/**
 * Created by soft01 on 2017/5/9.
 */
@Path("user")
public class UserCRUD {
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
    @GET
    @Produces("application/json")
    public String getUser(@QueryParam("idcardnum") String idcardnum){
        SqlSession session = sqlSessionFactory.openSession();
        UserInter userInter = session.getMapper(UserInter.class);
        User user = userInter.showusermsg(idcardnum);
        session.close();
        if(user!=null) {
            return JSON.toJSONString(user);
        }
        return null;
    }

    @PUT
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String putUser(@FormParam("name") String name,
                          @FormParam("idcardnum") String idcardnum,
                          @FormParam("account") String account,
                          @FormParam("password") String password,
                          @FormParam("username") String username,
                          @FormParam("gender") String gender,
                          @FormParam("sign") String sign,
                          @FormParam("headpicture") String headpicture){
        SqlSession session = sqlSessionFactory.openSession();
        UserInter userInter = session.getMapper(UserInter.class);
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid.toString(),name,idcardnum,account,password,username,gender,sign,headpicture);
        userInter.insertuser(user);
        session.commit();
        session.close();
        return JSON.toJSONString(user);
    }

    @DELETE
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String deleteUser(@FormParam("idcardnum") String idcardnum){
        SqlSession session = sqlSessionFactory.openSession();
        UserInter userInter = session.getMapper(UserInter.class);
        System.out.println(1);
        User user = userInter.showusermsg(idcardnum);
        System.out.println(1);
        userInter.deleteuser(idcardnum);
        System.out.println(1);
        session.commit();
        session.close();
        return JSON.toJSONString(user);
    }


    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String postUser(@FormParam("name") String name,
                           @FormParam("idcardnum") String idcardnum,
                           @FormParam("account") String account,
                           @FormParam("password") String password,
                           @FormParam("username") String username,
                           @FormParam("gender") String gender,
                           @FormParam("sign") String sign,
                           @FormParam("headpicture") String headpicture){
        SqlSession session = sqlSessionFactory.openSession();
        UserInter userInter = session.getMapper(UserInter.class);
        User user = userInter.showusermsg(idcardnum);
        user.setName(name);
        user.setAccount(account);
        user.setPassword(password);
        user.setUsername(username);
        user.setGender(gender);
        user.setSign(sign);
        user.setHeadpicture(headpicture);

        userInter.updateuser(user);

        session.commit();
        session.close();
        return JSON.toJSONString(user);
    }
}
