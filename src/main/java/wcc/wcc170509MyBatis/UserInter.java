package wcc.wcc170509MyBatis;

/**
 * Created by soft01 on 2017/5/9.
 */
public interface UserInter {
    public User showusermsg(String idcardnum);
    public void insertuser(User user);
    public void deleteuser(String idcardnum);
    public void updateuser(User user);
}
