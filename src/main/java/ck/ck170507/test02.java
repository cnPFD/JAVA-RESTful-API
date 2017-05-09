package ck.ck170507;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by soft01 on 2017/5/8.
 */
@Path( "ck" )
public class test02 {
    static DBUtil db = null;
    @GET
    @Produces("application/json")
    public String post(@QueryParam("name") String name,@QueryParam("idcardnum") String idcardnum,@QueryParam("account") String account,@QueryParam("password") String password,
                       @QueryParam("username") String username,@QueryParam("gender") String gender,@QueryParam("sign") String sign,@QueryParam("headpicture") String headpicture){
        String json = null;
        Connection conn = null;
        db = new DBUtil();

        try {
            conn = DBUtil.getConnection();
            Statement smt = conn.createStatement();
            String sql = "select * from usermsg";
            ResultSet rs = smt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("idcardnum"));
                System.out.println(rs.getString("account"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("gender"));
                System.out.println(rs.getString("sign"));
                System.out.println(rs.getString("headpicture"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return json;
    }
}
