/**
 * Created by Benedikt on 09.06.2017.
 */
public class Card {
    private Farbe farbe;
    private Wert wert;

    public Card(Farbe farbe, Wert wert) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public void setFarbe(Farbe farbe) {
        this.farbe = farbe;
    }

    public Wert getWert() {
        return wert;
    }

    public void setWert(Wert wert) {
        this.wert = wert;
    }


    @Override
    public String toString() {
        return "Card{" +
                "farbe=" + farbe +
                ", wert=" + wert +
                '}';
    }
}
