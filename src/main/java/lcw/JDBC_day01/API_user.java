package lcw.JDBC_day01;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by soft01 on 2017/5/8.
 */
@Path("lcw")
public class API_user {
    private String account;

    @Path("insert")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String setDate_put(@FormParam("name") String name, @FormParam("idcardnum") String idcardnum,
                               @FormParam("account") String account, @FormParam("password") String password,
                               @FormParam("username") String username, @FormParam("gender") String gender,
                               @FormParam("sign") String sign, @FormParam("headpicture") String headpicture
    ) {
        Users user = new Users(name, idcardnum, account, password, username, gender, sign, headpicture);
        JDBC_Demo.Insert_JDBC(user);
        String str = JSON.toJSONString(user);
        return str;
    }

    @Path("select")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_get(@QueryParam("account") String account){
        System.out.println(account);
        Users user=JDBC_Demo.Selcet_JDBC(account);
        System.out.println(user);
        String str = JSON.toJSONString(user);
        return str;
    }

    @Path("pp")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String pp(@QueryParam("account") String account){
        String str = JSON.toJSONString(account);
        return str;
    }

    @Path("delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDate_delete(@QueryParam("account") String account){
        JDBC_Demo.Delete_JDBC(account);
    }

    @Path("update")
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDate_post(@QueryParam("account") String account,
                                  @FormParam("username") String username,@FormParam("password") String password){
        JDBC_Demo.Update_JDBC(username,password,account);
    }
}
