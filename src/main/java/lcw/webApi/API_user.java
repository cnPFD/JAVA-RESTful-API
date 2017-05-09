package lcw.webApi;

import com.alibaba.fastjson.JSON;
import lcw.dataBase.User_DAOimpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by soft01 on 2017/5/8.
 */
@Path("lcw_Mybatis")
public class API_user {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String setDate_put(@FormParam("name") String name, @FormParam("idcardnum") String idcardnum,
                               @FormParam("account") String account, @FormParam("password") String password,
                               @FormParam("username") String username, @FormParam("gender") String gender,
                               @FormParam("sign") String sign, @FormParam("headpicture") String headpicture
    ) {
        User user = new User(name, idcardnum, account, password, username, gender, sign, headpicture);
        User_DAOimpl.addUser(user);
        String str = JSON.toJSONString(user);
        return str;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_get(@QueryParam("account") String account){
        System.out.println(account);
        User user=User_DAOimpl.getUser_ByAccount(account);
        System.out.println(user);
        String str = JSON.toJSONString(user);
        return str;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDate_delete(@QueryParam("account") String account){
        User_DAOimpl.deleteUser(account);
    }

    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDate_post(@QueryParam("account") String account,
                                  @FormParam("username") String username,@FormParam("password") String password){

    }
}
