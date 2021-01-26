package xyz.fjzkuroko.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable {

    private static final long serialVersionUID = 4L;

    private int rid;
    private int cid;
    private String username;
    private String content;
    private Timestamp time;
    private int likesNum;

    public Reply(){}

    public Reply(int rid, int cid, String username, String content, Timestamp time, int likesNum) {
        this.rid = rid;
        this.cid = cid;
        this.username = username;
        this.content = content;
        this.time = time;
        this.likesNum = likesNum;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", cid=" + cid +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likesNum=" + likesNum +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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
