package wcc.wcc170509MyBatis;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.util.UUID;

/**
 * Created by soft01 on 2017/5/9.
 */
@Path("user")
public class UserCRUD {
    @GET
    @Produces("application/json")
    public String getUser(@QueryParam("idcardnum") String idcardnum){
        User user = new CRUD().selectUser(idcardnum);
        return JSON.toJSONString(user);
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
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid.toString(),name,idcardnum,account,password,username,gender,sign,headpicture);
        new CRUD().insertUser(user);
        return JSON.toJSONString(user);
    }

    @DELETE
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String deleteUser(   @FormParam("idcardnum") String idcardnum){
        User user = new CRUD().selectUser(idcardnum);
        new CRUD().deleteUser(idcardnum);
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
        User user = new CRUD().selectUser(idcardnum);
        user.setName(name);
        user.setAccount(account);
        user.setPassword(password);
        user.setUsername(username);
        user.setGender(gender);
        user.setSign(sign);
        user.setHeadpicture(headpicture);
        new CRUD().updateUser(user);
        return JSON.toJSONString(user);
    }
}
