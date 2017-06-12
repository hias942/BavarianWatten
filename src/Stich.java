import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Stich {
    private List<Card> cardList;
    private Spieler gewinner;
    private Spieler aufgebender;
    private Runde runde;


    public Stich(Spieler aufgebender, Runde runde) {
        this.runde = runde;
        this.aufgebender = aufgebender;
        cardList = new ArrayList<>();
    }


    public void calculateGewinner() {
        Card bestCard=getWinnerByRunde(cardList);
        gewinner= bestCard.getSpieler();
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

    public Spieler getAufgebender() {
        return aufgebender;
    }

    public void setAufgebender(Spieler aufgebender) {
        this.aufgebender = aufgebender;
    }

    public Runde getRunde() {
        return runde;
    }

    public void setRunde(Runde runde) {
        this.runde = runde;
    }


    private  Card  getWinnerByRunde( List<Card> cards){

        Farbe ersteFarbe= cards.get(0).getFarbe();

        class BesteKarte{
            private Integer wert=0;
            private Card card;

             private BesteKarte(Integer wert, Card card) {
                this.wert = wert;
                this.card = card;
            }
        }
       BesteKarte besteKarte= new BesteKarte(0,null);

        for(Card card:cards){
            Integer currentPoints=evaluateCardByRundenContext(card,ersteFarbe);
            if(currentPoints>besteKarte.wert){
                besteKarte= new BesteKarte(currentPoints,card);
            }
        }

        return besteKarte.card;
    }


    private Integer evaluateCardByRundenContext(Card card,Farbe ersteFarbe){
         /*
        * 0-->Hohlt den Stich in jedem Fall nicht
        * 11-->Farben 7
        * 12-->Farben 8
        * 13-->Farben 9
        * 14-->Farben 10
        * 15-->Farben Unter
        * 16-->Farben Ober
        * 17-->Farben König
        * 18-->Farben Ass
        * 21-->Trumpf 7
        * 22-->Trumpf 8
        * 23-->Trumpf 9
        * 24-->Trumpf 10
        * 25-->Trumpf Unter
        * 26-->Trumpf Ober
        * 27-->Trumpf König
        * 28-->Trumpf Ass
        * 31-->Schlag
        * 32-->Hauptschlag
        * 41-->Eichelsieben
        * 42-->Schellensieben
        * 43-->Herzkönig
        *
        *
        * */

        Farbe trumpf=runde.getTrumpf();
        Wert schlag=runde.getSchlag();
        if(card.getFarbe().equals(Farbe.Herz)&&card.getWert().equals(Wert.König))
            return 43;
        else if(card.getFarbe().equals(Farbe.Schellen)&&card.getWert().equals(Wert.Sieben))
            return 42;
        else if(card.getFarbe().equals(Farbe.Eichel)&&card.getWert().equals(Wert.Sieben))
            return 41;
        else if(card.getFarbe().equals(trumpf)&&card.getWert().equals(schlag))
            return 32;
        else if(card.getWert().equals(schlag))
            return 31;
        else if(card.getFarbe().equals(trumpf))
            return 20+card.getWert().getKartenWert();
        else if(card.getFarbe().equals(ersteFarbe))
            return 10+card.getWert().getKartenWert();
        else
        return 0;
    }


    @Override
    public String toString() {
        return
                "Karten: " + cardList +
                ", Gewinner: " + gewinner.getName();
    }
}
