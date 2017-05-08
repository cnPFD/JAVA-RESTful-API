package lcw.JDBC_day01;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by soft01 on 2017/5/8.
 */
@Path("lcw")
public class API_user {
    @Path("insert")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String setDate_put(@FormParam("name") String name, @FormParam("idcardnum") String idcardnum,
                               @FormParam("account") String account, @FormParam("password") String password,
                               @FormParam("username") String username, @FormParam("gender") String gender,
                               @FormParam("sign") String sign, @FormParam("headpicture") String headpicture
    ) {
//        User_date date=new User_date();
        Users user = new Users(name, idcardnum, account, password, username, gender, sign, headpicture);
//        result.add(user);
//        date.setStatus(200);
//        date.setResult(result);
        JDBC_Demo.Insert_JDBC(user);
        String str = JSON.toJSONString(user);
        return str;
    }

    @Path("select")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_get(@QueryParam("account") String account){
        Users user=JDBC_Demo.Selcet_JDBC(account);
        String str = JSON.toJSONString(user);
        return str;
    }
}
