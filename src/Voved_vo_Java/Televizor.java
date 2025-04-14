package Voved_vo_Java;

public class Televizor {
    private String proizvoditel;
    private int ekran;
    private boolean isSmart;

    public Televizor(String proizvoditel, int ekran, boolean isSmart) {
        this.proizvoditel = proizvoditel;
        this.ekran = ekran;
        this.isSmart = isSmart;
    }

    public Televizor() {
    }

    public String getProizvoditel() {
        return proizvoditel;
    }

    public void setProizvoditel(String proizvoditel) {
        this.proizvoditel = proizvoditel;
    }

    public int getEkran() {
        return ekran;
    }

    public void setEkran(int ekran) {
        this.ekran = ekran;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    @Override
    public String toString() {
        return "Televizor{" +
                "proizvoditel='" + proizvoditel + '\'' +
                ", ekran=" + ekran +
                ", isSmart=" + isSmart +
                '}';
    }
}
