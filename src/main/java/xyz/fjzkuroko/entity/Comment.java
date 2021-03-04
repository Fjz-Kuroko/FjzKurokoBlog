package xyz.fjzkuroko.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

    private static final long serialVersionUID = 3L;

    private int cid;
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "所评论文章id不能为空")
    private int aid;
    @NotNull(message = "评论内容不能为空")
    private String content;
    private Timestamp createDate;
    private int likesNum;

    public Comment(){}

    public Comment(int cid, String username, int aid, String content, Timestamp createDate, int likesNum) {
        this.cid = cid;
        this.username = username;
        this.aid = aid;
        this.content = content;
        this.createDate = createDate;
        this.likesNum = likesNum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", username='" + username + '\'' +
                ", aid=" + aid +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }
}
