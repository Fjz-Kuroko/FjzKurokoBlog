package xyz.fjzkuroko.vo;

import java.sql.Timestamp;

public class ViewAlertCard {

    private int aid;
    private String content;
    private Timestamp articleTime;
    private int commentNum;

    public ViewAlertCard() {}

    public ViewAlertCard(int aid, String content, Timestamp articleTime, int commentNum) {
        this.aid = aid;
        this.content = content;
        this.articleTime = articleTime;
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "ViewAlertCard{" +
                "aid=" + aid +
                ", content='" + content + '\'' +
                ", articleTime=" + articleTime +
                ", commentNum=" + commentNum +
                '}';
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

    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}
