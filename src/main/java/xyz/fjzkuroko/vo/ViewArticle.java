package xyz.fjzkuroko.vo;

import java.sql.Timestamp;

public class ViewArticle {

    private int aid;
    private String author;
    private String title;
    private int label;
    private String category;
    private Timestamp articleTime;
    private String tags;

    public ViewArticle() {}

    public ViewArticle(int aid, String author, String title, int label, String category, Timestamp articleTime, String tags) {
        this.aid = aid;
        this.author = author;
        this.title = title;
        this.label = label;
        this.category = category;
        this.articleTime = articleTime;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ViewArticle{" +
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", label=" + label +
                ", category='" + category + '\'' +
                ", articleTime=" + articleTime +
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

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
