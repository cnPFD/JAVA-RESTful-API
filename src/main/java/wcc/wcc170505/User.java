package wcc.wcc170505;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by soft01 on 2017/5/4.
 */
public class User {
    private String username;
    private String password;
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String state;

    public User() {
    }

    public User(String username, String password, String name, int age, Date birthday, String state) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
