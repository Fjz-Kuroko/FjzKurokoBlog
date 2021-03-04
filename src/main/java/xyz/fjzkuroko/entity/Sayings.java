package xyz.fjzkuroko.entity;

public class Sayings {

    private int id;
    private String saying;

    public Sayings() {}

    public Sayings(int id, String saying) {
        this.id = id;
        this.saying = saying;
    }

    @Override
    public String toString() {
        return "Sayings{" +
                "id=" + id +
                ", saying='" + saying + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }
}
