package lcw;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by soft01 on 2017/5/5.
 */
@Path("lcw")
public class Demo {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_post(@QueryParam("name") String name, @QueryParam("birthday") String s,
                          @QueryParam("username") String username,@QueryParam("age") int age) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        User_date date=new User_date();
        try {
            birthday = fmt.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            date.setStatus(400);
            throw new RuntimeException("转MMP");
        }
        User user = new User(username, name, age, birthday);
        List<User> result=new ArrayList();
        result.add(user);
        date.setStatus(200);
        date.setResult(result);
        String str = JSON.toJSONString(date);
        return str;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_get(@QueryParam("name") String name, @QueryParam("birthday") String s,
                          @QueryParam("username") String username,@QueryParam("age") int age) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        User_date date=new User_date();
        try {
            birthday = fmt.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            date.setStatus(400);
            throw new RuntimeException("转MMP");
        }
        User user = new User(username, name, age, birthday);
        List<User> result=new ArrayList();
        result.add(user);
        date.setStatus(200);
        date.setResult(result);
        String str = JSON.toJSONString(date);
        return str;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_delete(@QueryParam("name") String name, @QueryParam("birthday") String s,
                              @QueryParam("username") String username,@QueryParam("age") int age) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        User_date date=new User_date();
        try {
            birthday = fmt.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            date.setStatus(400);
            throw new RuntimeException("转MMP");
        }
        User user = new User(username, name, age, birthday);
        List<User> result=new ArrayList();
        result.add(user);
        date.setStatus(200);
        date.setResult(result);
        String str = JSON.toJSONString(date);
        return str;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String getDate_put(@QueryParam("name") String name, @QueryParam("birthday") String s,
                              @QueryParam("username") String username,@QueryParam("age") int age) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        User_date date=new User_date();
        try {
            birthday = fmt.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            date.setStatus(400);
            throw new RuntimeException("转MMP");
        }
        User user = new User(username, name, age, birthday);
        List<User> result=new ArrayList();
        result.add(user);
        date.setStatus(200);
        date.setResult(result);
        String str = JSON.toJSONString(date);
        return str;
    }
}
