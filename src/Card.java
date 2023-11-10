/**
 * Created by Benedikt on 09.06.2017.
 */
public class Card {
    private Farbe farbe;
    private Wert wert;
    private Spieler spieler;

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

    public Spieler getSpieler() {
        return spieler;
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    @Override
    public String toString() {
        return farbe +" "+ wert;
    }
}
