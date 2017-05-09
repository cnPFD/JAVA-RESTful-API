package lcw.dataBase;

import lcw.webApi.User;

/**
 * Created by soft01 on 2017/5/9.
 */
public interface User_DAO {
    public User selectUser_ByAccount(String account);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(String account);
}
