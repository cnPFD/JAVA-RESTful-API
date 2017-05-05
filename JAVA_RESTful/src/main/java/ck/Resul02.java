package ck;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by soft01 on 2017/5/5.
 */
@Path("ck/login")
public class Resul02 {
    Resul01 r = new Resul01();
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String get(@FormParam("id") String id, @FormParam("name") String name, @FormParam("age") int age,@FormParam("hiredate")String birthday)
             throws Exception {
        RestFul( id, name, age, birthday );
        r.setState( "200" );
        String jsonStr = JSON.toJSONString( r );
        return jsonStr;
    }

   @GET
    @Produces("application/json")
    public String post(@QueryParam("id")String id,@QueryParam("name")String name, @QueryParam("age")int age,@QueryParam("hiredate")String birthday) throws ParseException {
        RestFul(id,name,age,birthday);
        r.setState( "200" );
       String jsonStr =JSON.toJSONString( r);
       return jsonStr;
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String put(@FormParam("id") String id, @FormParam("name") String name, @FormParam("age") int age,@FormParam("hiredate")String birthday)
            throws Exception {
        RestFul( id, name, age, birthday );
        r.setState( "200" );
        String jsonStr = JSON.toJSONString( r );
        return jsonStr;
    }
    @DELETE
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String delete(@FormParam("id") String id, @FormParam("name") String name, @FormParam("age") int age,@FormParam("hiredate")String birthday)
            throws Exception {
        RestFul( id, name, age, birthday );
        r.setState( "200" );
        String jsonStr = JSON.toJSONString( r );
        return jsonStr;
    }

    public String RestFul(String id,String name,int age,String birthday) throws ParseException{
        String json = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse( birthday);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setBirthday(date);
        user.setStr("恭喜，注册成功");
        r.addUser(user);
        json = JSON.toJSONString(user);
        return json;
    }
}

