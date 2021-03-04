package xyz.fjzkuroko.vo;

import java.sql.Timestamp;

public class ChildComment {

    private int id;
    private CommentUser commentUser;
    private CommentUser targetUser;
    private String content;
    private Timestamp createDate;

    public ChildComment() {}

    public ChildComment(int id, CommentUser commentUser, CommentUser targetUser, String content, Timestamp createDate) {
        this.id = id;
        this.commentUser = commentUser;
        this.targetUser = targetUser;
        this.content = content;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "ChildComment{" +
                "id=" + id +
                ", commentUser=" + commentUser +
                ", targetUser=" + targetUser +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CommentUser getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(CommentUser commentUser) {
        this.commentUser = commentUser;
    }

    public CommentUser getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(CommentUser targetUser) {
        this.targetUser = targetUser;
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
}
