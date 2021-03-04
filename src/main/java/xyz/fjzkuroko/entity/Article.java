package xyz.fjzkuroko.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {

    private static final long serialVersionUID = 2L;

    private int aid;
    private String author;
    private String title;
    private String content;
    private String articleBrief;
    private String articleImg;
    private int label;
    private int visited;
    private Timestamp articleTime;
    private int likesNum;
    private String tags;

    public Article(){}

    public Article(int aid, String author, String title, String content, String articleBrief,
                   String articleImg, int label, int visited, Timestamp articleTime, int likesNum, String tags) {
        this.aid = aid;
        this.author = author;
        this.title = title;
        this.content = content;
        this.articleBrief = articleBrief;
        this.articleImg = articleImg;
        this.label = label;
        this.visited = visited;
        this.articleTime = articleTime;
        this.likesNum = likesNum;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", articleBrief='" + articleBrief + '\'' +
                ", articleImg='" + articleImg + '\'' +
                ", label=" + label +
                ", visited=" + visited +
                ", articleTime=" + articleTime +
                ", likesNum=" + likesNum +
                ", tags='" + tags + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticleBrief() {
        return articleBrief;
    }

    public void setArticleBrief(String articleBrief) {
        this.articleBrief = articleBrief;
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
