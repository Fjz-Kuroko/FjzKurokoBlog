package xyz.fjzkuroko.vo;

public class ViewLabels {

    private int lid;
    private String label;
    private int num;

    public ViewLabels() {}

    public ViewLabels(int lid, String label, int num) {
        this.lid = lid;
        this.label = label;
        this.num = num;
    }

    @Override
    public String toString() {
        return "ViewLabels{" +
                "lid=" + lid +
                ", label='" + label + '\'' +
                ", num=" + num +
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
