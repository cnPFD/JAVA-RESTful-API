package fqq;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soft01 on 2017/5/5.
 */
public class information {
    private List<user> result = new ArrayList<user>();
    private String status;

    public List<user> getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setResult(List<user> result) {
        this.result = result;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void addresult(user user){result.add(user);}
}
