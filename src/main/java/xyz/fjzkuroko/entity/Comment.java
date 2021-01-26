package xyz.fjzkuroko.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

    private static final long serialVersionUID = 3L;

    private int cid;
    private String username;
    private int aid;
    private String content;
    private Timestamp time;
    private int likesNum;

    public Comment(){}

    public Comment(int cid, String username, int aid, String content, Timestamp time, int likesNum) {
        this.cid = cid;
        this.username = username;
        this.aid = aid;
        this.content = content;
        this.time = time;
        this.likesNum = likesNum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", username='" + username + '\'' +
                ", aid=" + aid +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likesNum=" + likesNum +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }
}
