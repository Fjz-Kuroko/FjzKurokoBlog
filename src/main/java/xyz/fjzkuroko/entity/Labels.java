package xyz.fjzkuroko.entity;

public class Labels {

    private int lid;
    private String label;

    public Labels() {}

    public Labels(int lid, String label) {
        this.lid = lid;
        this.label = label;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "lid=" + lid +
                ", label='" + label + '\'' +
                '}';
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
