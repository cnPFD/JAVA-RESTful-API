package lcw.JDBC_day01;

import java.util.UUID;

/**
 * Created by soft01 on 2017/5/8.
 */
    public class Users {
        private String name;
        private String idcardnum;
        private String account;
        private String password;
        private String username;
        private String gender;
        private String sign;
        private String headpicture;
        private String uuid;


        public Users(String name, String idcardnum, String account, String password, String username, String gender, String sign, String headpicture) {
            this.name = name;
            this.idcardnum = idcardnum;
            this.account = account;
            this.password = password;
            this.username = username;
            this.gender = gender;
            this.sign = sign;
            this.headpicture = headpicture;
            this.uuid = UUID.randomUUID().toString();
        }

        public Users() {
        }

        public String toString() {
            return "(\'"+ uuid +'\''+
                    ",'" + name + '\'' +
                    ",'" + idcardnum + '\'' +
                    ",'" + account + '\'' +
                    ",'" + password + '\'' +
                    ",'" + username + '\'' +
                    ",'" + gender + '\'' +
                    ",'" + sign + '\'' +
                    ",'" + headpicture + "\')";
        }

        public String getName() {
            return name;
        }

        public String getIdcardnum() {
            return idcardnum;
        }

        public String getAccount() {
            return account;
        }

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }

        public String getGender() {
            return gender;
        }

        public String getSign() {
            return sign;
        }

        public String getHeadpicture() {
            return headpicture;
        }

        public String getUuid() {
            return uuid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setIdcardnum(String idcardnum) {
            this.idcardnum = idcardnum;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public void setHeadpicture(String headpicture) {
            this.headpicture = headpicture;
        }

        public void setUuid(String uuid) {
            this.uuid = UUID.randomUUID().toString();
        }
    }
