package wcc;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by soft01 on 2017/5/4.
 */
@Path("wcc")
public class Login {
    SimpleDateFormat smt = new SimpleDateFormat("yy-MM-dd");
    @GET
    @Path("login")
    @Produces("application/json")
    public String getsearch(@QueryParam("username") String username,
                            @QueryParam("password") String password,
                            @QueryParam("name") String name,
                            @QueryParam("age") String age,
                            @QueryParam("birthday") String birthday) throws ParseException {
        Date date = smt.parse(birthday);
        Status s = new Status();
        s.setStatus(200);
        User user = new User(username,password,name,Integer.parseInt(age),date,"恭喜注册成功");
        System.out.println(user.getBirthday());
        s.addUser(user);
        String jsonStr = JSON.toJSONString(s);
        return jsonStr;
    }
    @POST
    @Path("login")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String postLogin(@FormParam("username") String username,
                          @FormParam("password") String password,
                          @FormParam("name") String name,
                          @FormParam("age") String age,
                          @FormParam("birthday") String birthday) throws ParseException {
        Date date = smt.parse(birthday);
        Status s = new Status();
        s.setStatus(200);
        User user = new User(username,password,name,Integer.parseInt(age),date,"恭喜注册成功");
        System.out.println(user.getBirthday());
        s.addUser(user);
        String jsonStr = JSON.toJSONString(s);
        return jsonStr;
    }
    @PUT
    @Path("login")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String putLogin(@FormParam("username") String username,
                            @FormParam("password") String password,
                            @FormParam("name") String name,
                            @FormParam("age") String age,
                            @FormParam("birthday") String birthday) throws ParseException {
        Date date = smt.parse(birthday);
        Status s = new Status();
        s.setStatus(200);
        User user = new User(username,password,name,Integer.parseInt(age),date,"恭喜注册成功");
        System.out.println(user.getBirthday());
        s.addUser(user);
        String jsonStr = JSON.toJSONString(s);
        return jsonStr;
    }
    @DELETE
    @Path("login")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String deleteLogin(@FormParam("username") String username,
                            @FormParam("password") String password,
                            @FormParam("name") String name,
                            @FormParam("age") String age,
                            @FormParam("birthday") String birthday) throws ParseException {
        Date date = smt.parse(birthday);
        Status s = new Status();
        s.setStatus(200);
        User user = new User(username,password,name,Integer.parseInt(age),date,"恭喜注册成功");
        System.out.println(user.getBirthday());
        s.addUser(user);
        String jsonStr = JSON.toJSONString(s);
        return jsonStr;
    }
}
