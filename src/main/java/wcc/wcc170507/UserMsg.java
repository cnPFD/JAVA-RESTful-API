package wcc.wcc170507;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by soft01 on 2017/5/7.
 */

@Path("wcc/usermsg")
public class UserMsg {
    @PUT
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String postadd(@FormParam("name") String name,
                          @FormParam("idcardnum") String idcardnum,
                          @FormParam("account") String account,
                          @FormParam("password") String password,
                          @FormParam("username") String username,
                          @FormParam("gender") String gender,
                          @FormParam("sign") String sign,
                          @FormParam("headpicture") String headpicture){
       UUID uid = UUID.randomUUID();
        String id = uid.toString();
       User user = new User(id,name,idcardnum,account,password,username,gender,sign,headpicture);
        add(user);
        return JSON.toJSONString(user);
    }
    @GET
    @Produces("application/json")
    public String getMsg(@QueryParam("name") String name,
                         @QueryParam("idcardnum") String idcardnum){
        User user = search(name,idcardnum);
        String jsonStr = JSON.toJSONString(user);
        return jsonStr;
    }
    @DELETE
    @Consumes("application/x-www-form-urlencoded")
    public int delete(@FormParam("name") String name,
                          @FormParam("idcardnum") String idcardnum){
        int del = deluser(name,idcardnum);
        System.out.println(del);
        return del;
    }
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String updateuser(@FormParam("name") String name,
                         @FormParam("idcardnum") String idcardnum,
                         @FormParam("account") String account,
                         @FormParam("password") String password,
                         @FormParam("username") String username,
                         @FormParam("gender") String gender,
                         @FormParam("sign") String sign,
                         @FormParam("headpicture") String headpicture){
        User user = search(name,idcardnum);
        user.setAccount(account);
        user.setPassword(account);
        user.setUsername(username);
        user.setGender(gender);
        user.setSign(sign);
        user.setHeadpicure(headpicture);
        update(user);
        return JSON.toJSONString(user);
    }

    public void update(User user){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update usermsg set " +
                    "account = ?," +
                    "password = ?," +
                    "username = ?," +
                    "gender = ?," +
                    "sign = ?," +
                    "headpicture = ?" +
                    "where name = ? and idcardnum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUsername());
            ps.setString(4,user.getGender());
            ps.setString(5,user.getSign());
            ps.setString(6,user.getHeadpicure());
            ps.setString(7,user.getName());
            ps.setString(8,user.getIdcardnum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改失败！",e);
        }finally {
            DBUtil.close(conn);
        }
    }

    public int deluser(String name,String idcardnum){
        User user = new User();
        int state = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from usermsg where name = ? and idcardnum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,idcardnum);
           state =  ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败！",e);
        }finally {
            DBUtil.close(conn);
        }
        return state;
    }


    public User search(String name,String idcardnum){
        User user = new User();
        String jsonStr = null;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from usermsg where name = ? and idcardnum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,idcardnum);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setIdcardnum(rs.getString("idcardnum"));
                user.setAccount(rs.getString("account"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setGender(rs.getString("gender"));
                user.setSign(rs.getString("sign"));
                user.setHeadpicure(rs.getString("headpicture"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查找失败！",e);
        }finally {
            DBUtil.close(conn);
        }
        return user;
    }

    public void add(User user){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into usermsg values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getIdcardnum());
            ps.setString(4,user.getAccount());
            ps.setString(5,user.getPassword());
            ps.setString(6,user.getUsername());
            ps.setString(7,user.getGender());
            ps.setString(8,user.getSign());
            ps.setString(9,user.getHeadpicure());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败！",e);
        }finally {
            DBUtil.close(conn);
        }
    }
}
