package xyz.fjzkuroko.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable {

    private static final long serialVersionUID = 4L;

    private int rid;
    @NotNull(message = "父级评论id不能为空")
    private int cid;
    private String cusername;
    @NotNull(message = "评论者名字不能为空")
    private String username;
    @NotNull(message = "评论内容不能为空")
    private String content;
    private Timestamp createDate;
    private int likesNum;

    public Reply(){}

    public Reply(int rid, int cid, String cusername, String username, String content, Timestamp createDate, int likesNum) {
        this.rid = rid;
        this.cid = cid;
        this.cusername = cusername;
        this.username = username;
        this.content = content;
        this.createDate = createDate;
        this.likesNum = likesNum;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", cid=" + cid +
                ", cusername='" + cusername + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
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

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
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
