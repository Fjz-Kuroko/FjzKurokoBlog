package xyz.fjzkuroko.entity;

import javax.validation.constraints.NotNull;

public class Message {

    private static final long serialVersionUID = 6L;

    private int mid;
    @NotNull(message = "email不嫩为空")
    private String email;
    @NotNull(message = " name不能为空")
    private String name;
    @NotNull(message = "留言内容不能为空")
    private String msg;

    public Message() {}

    public Message(int mid, String email, String name, String msg) {
        this.mid = mid;
        this.email = email;
        this.name = name;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
