package ck.ck170507;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by soft01 on 2017/5/8.
 */
@Path( "ck" )
public class test03 {
    static DBUtil db=null;
    @DELETE
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String post(@FormParam("name") String name,@FormParam("idcardnum") String idcardnum,@FormParam("account") String account,@FormParam("password") String password,
                       @FormParam("username") String username,@FormParam("gender") String gender,@FormParam("sign") String sign,@FormParam("headpicture") String headpicture){
        String json = null;
        Connection conn = null;
        db = new DBUtil();
        try {
            Usermsg user = new Usermsg(  );
            user.setName(name);
            json = JSON.toJSONString(user);
            conn = DBUtil.getConnection();
            Statement smt =conn.createStatement();
            String sql = "delete from usermsg where name =?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1,user.getName() );
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return json;
    }
}
