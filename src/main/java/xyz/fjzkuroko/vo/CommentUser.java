package xyz.fjzkuroko.vo;

public class CommentUser {

    private int id;
    private String nickName;
    private String avatar;

    public CommentUser() {}

    public CommentUser(int id, String nickName, String avatar) {
        this.id = id;
        this.nickName = nickName;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "CommentUser{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
