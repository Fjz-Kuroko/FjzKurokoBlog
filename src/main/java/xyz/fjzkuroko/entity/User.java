package xyz.fjzkuroko.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    @NotNull(message = "用户名不能为空")
    private String username;
    @Pattern(regexp = "[男女]", message = "性别只能为男或女，且不能为空")
    private String sex;
    @NotNull(message = "密码不能为空")
    @Size(max = 16, min = 6, message = "密码长度应在6-16个字符之间")
    private String password;
    private String email;
    private String info;
    private String avatar;
    private Timestamp registerTime;

    public User(){}

    public User(int id, String username, String sex, String password, String email,
                String info, String avatar, Timestamp registerTime) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.password = password;
        this.email = email;
        this.info = info;
        this.avatar = avatar;
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", info='" + info + '\'' +
                ", avatar='" + avatar + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }
}
