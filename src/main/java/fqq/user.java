package fqq;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by soft01 on 2017/5/4.
 */
public class user {

    private String username;
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String str;

    public user(){

    }

    public user(String username, String name, int age, Date birthday, String str) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.str = str;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public  void setStr(String str){this.str=str;}
}
