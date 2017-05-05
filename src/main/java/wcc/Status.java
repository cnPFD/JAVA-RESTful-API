package wcc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soft01 on 2017/5/4.
 */
public class Status {
    private int status;
    private List<User> result = new ArrayList<User>();

    public Status() {
    }

    public Status(int status, List<User> result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void addUser(User user){
        result.add(user);
    }
}
