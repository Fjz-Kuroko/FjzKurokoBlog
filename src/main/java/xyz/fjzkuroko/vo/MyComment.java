package xyz.fjzkuroko.vo;

import java.sql.Timestamp;
import java.util.List;

public class MyComment {

    private int id;
    private String username;
    private int aid;
    private CommentUser commentUser;
    private String content;
    private Timestamp createDate;
    private List<ChildComment> childrenList;

    public MyComment() {}

    public MyComment(int id, String username, int aid, CommentUser commentUser, String content,
                     Timestamp createDate, List<ChildComment> childrenList) {
        this.id = id;
        this.username = username;
        this.aid = aid;
        this.commentUser = commentUser;
        this.content = content;
        this.createDate = createDate;
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "MyComment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", aid=" + aid +
                ", commentUser=" + commentUser +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", childrenList=" + childrenList +
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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public CommentUser getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(CommentUser commentUser) {
        this.commentUser = commentUser;
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

    public List<ChildComment> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<ChildComment> childrenList) {
        this.childrenList = childrenList;
    }
}
