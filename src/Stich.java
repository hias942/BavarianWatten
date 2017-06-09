import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Stich {
    private List<Card> cardList;
    private Spieler gewinner;
    private Integer aufgabePosition;

    public Stich(Integer aufgabePosition) {
        this.aufgabePosition = aufgabePosition;
        cardList=new ArrayList<>();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Spieler getGewinner() {
        return gewinner;
    }

    public void setGewinner(Spieler gewinner) {
        this.gewinner = gewinner;
    }

    public Integer getAufgabePosition() {
        return aufgabePosition;
    }

    public void setAufgabePosition(Integer aufgabePosition) {
        this.aufgabePosition = aufgabePosition;
    }
}
