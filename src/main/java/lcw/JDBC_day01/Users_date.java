package lcw.JDBC_day01;

import java.util.List;

/**
 * Created by soft01 on 2017/5/8.
 */
public class Users_date {
    private int status;
    private List<Users> result;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setResult(List<Users> result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public List<Users> getResult() {
        return result;
    }
}
