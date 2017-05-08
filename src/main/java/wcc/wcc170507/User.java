package wcc.wcc170507;

/**
 * Created by soft01 on 2017/5/7.
 */
public class User {
    private String id;
    private String name;
    private String idcardnum;
    private String account;
    private String password;
    private String username;
    private String gender;
    private String sign;
    private String headpicure;

    public User() {
    }

    public User(String id, String name,
                String idcardnum,
                String account,
                String password,
                String username,
                String gender,
                String sign,
                String headpicure) {
        this.id = id;
        this.name = name;
        this.idcardnum = idcardnum;
        this.account = account;
        this.password = password;
        this.username = username;
        this.gender = gender;
        this.sign = sign;
        this.headpicure = headpicure;
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

    public String getIdcardnum() {
        return idcardnum;
    }

    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadpicure() {
        return headpicure;
    }

    public void setHeadpicure(String headpicure) {
        this.headpicure = headpicure;
    }
}
