package wcc;

import java.util.Date;

/**
 * Created by soft01 on 2017/5/4.
 */
public class User {
    private String username;
    private String password;
    private String name;
    private int age;
    private Date birthday;

    public User() {
    }

    public User(String username, String password, String name, int age, Date birthday) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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
