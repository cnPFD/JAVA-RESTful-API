package ck;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by soft01 on 2017/5/5.
 */
public class User {
    private String id;
    private String name;
    private int age;

    @JSONField (format="yyyy-MM-dd")
    private Date birthday;

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public User(){}
    public User(String id,String name,int age,Date birthday,String str){
        this.id = id;
        this.name=name;
        this.age=age;
        this.birthday=birthday;
        this.str=str;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
