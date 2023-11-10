/**
 * Created by Benedikt on 09.06.2017.
 */
public enum Wert {
    Ass(8),
    König(7),
    Ober(6),
    Unter(5),
    Zehn(4),
    Neun(3),
    Acht(2),
    Sieben(1);

    private Integer kartenWert;
    Wert(Integer kartenWert){
        this.kartenWert=kartenWert;
    }

    public Integer getKartenWert() {
        return kartenWert;
    }

    public void setKartenWert(Integer kartenWert) {
        this.kartenWert = kartenWert;
    }
}
