package bitcamp.javatest.cms.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable{
    protected String name;
    protected String email;
    protected String password;
    protected String tel;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
