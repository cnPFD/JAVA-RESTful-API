
package ck.ck170507;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by soft01 on 2017/5/7.
 */

@Path("ck")
public class test01 {
    static DBUtil db = null;
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String post(@FormParam("name") String name,@FormParam("idcardnum") String idcardnum,@FormParam("account") String account,@FormParam("password") String password,
                       @FormParam("username") String username,@FormParam("gender") String gender,@FormParam("sign") String sign,@FormParam("headpicture") String headpicture){
        String json = null;
        Connection conn = null;
        db = new DBUtil();
        try {

            Usermsg user = new Usermsg(  );
            user.setName( name );
            user.setIdcardnum( idcardnum );
            user.setAccount( account );
            user.setPassword( password);
            user.setUsername( username );
            user.setGender( gender );
            user.setSign( sign );
            user.setHeadpicture( headpicture );
            json = JSON.toJSONString(user);

            conn = DBUtil.getConnection();
            Statement smt = conn.createStatement();
            String sql = "insert into usermsg (name,idcardnum,account,password,username,gender,sign,headpicture)values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps =
                    conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getIdcardnum());
            ps.setString(3,user.getAccount());
           ps.setString(4,  user.getPassword() );
           ps.setString(5, user.getUsername());
            ps.setString(6,user.getGender());
            ps.setString(7,user.getSign());
            ps.setString(8,user.getHeadpicture());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }
}

