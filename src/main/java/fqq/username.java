package fqq;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by soft01 on 2017/5/4.
 */


@Path("username")
public class username {
    information infor = new information();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    @GET
    @Produces("application/json")
    public String getinformation(@QueryParam("username") String username,
                                 @QueryParam("name") String name,
                                 @QueryParam("age") int age,
                                 @QueryParam("birthday") String birthday) throws ParseException {
        Date date = fmt.parse(birthday);
        user user = new user(username,name,age,date,"恭喜,注册成功!");
        infor.setStatus("200");
        infor.addresult(user);
        String jsonuser = JSON.toJSONString(infor);
        return jsonuser;
    }
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String postinformation(@FormParam("username") String username,
                                 @FormParam("name") String name,
                                 @FormParam("age") int age,
                                 @FormParam("birthday") String birthday) throws ParseException {
        Date date = fmt.parse(birthday);
        user user = new user(username,name,age,date,"恭喜,注册成功!");
        infor.setStatus("200");
        infor.addresult(user);
        String jsonuser = JSON.toJSONString(infor);
        return jsonuser;
    }

    @DELETE
    @Consumes("application/x-www-form-urlencoded")
    public String deleteinformation(@FormParam("username") String username,
                                  @FormParam("name") String name,
                                  @FormParam("age") int age,
                                  @FormParam("birthday") String birthday) throws ParseException {
        Date date = fmt.parse(birthday);
        user user = new user(username,name,age,date,"恭喜,注册成功!");
        infor.setStatus("200");
        infor.addresult(user);
        String jsonuser = JSON.toJSONString(infor);
        return jsonuser;
    }
    @PUT
    @Consumes("application/x-www-form-urlencoded")
    public String putinformation(@FormParam("username") String username,
                                    @FormParam("name") String name,
                                    @FormParam("age") int age,
                                    @FormParam("birthday")String birthday) throws ParseException {
        Date date = fmt.parse(birthday);
        user user = new user(username,name,age,date,"恭喜,注册成功!");
        infor.setStatus("200");
        infor.addresult(user);
        String jsonuser = JSON.toJSONString(infor);
        return jsonuser;

    }

}

