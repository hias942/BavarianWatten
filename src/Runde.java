import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Runde {

    private List<Spieler> spielers;
    private List<Stich> stiche;
    private Farbe trumpf;
    private Wert schlag;

    public Runde(List<Spieler> spielers) {
        this.spielers = spielers;
        this.stiche=new ArrayList<>();
    }

    public List<Spieler> dealCards() {
        Deck.generateDeck();
        List<Card> deck = Deck.getCards();
        if (deck.size() % spielers.size() == 0) {
            while (deck.size() > 32-spielers.size()*5)
                for (Spieler spieler : spielers) {
                    Set<Card> hand = spieler.getHand();
                    deck.get(0).setSpieler(spieler);
                    hand.add(deck.get(0));
                    spieler.setHand(hand);
                    deck.remove(0);
                    if (deck.size() == 0)
                        break;
                }

        }

        return spielers;
    }

    public void nextTurn() {
        spielers.get(spielers.size() - 1).setDealer(false);
        spielers.get(0).setDealer(true);
        for (Spieler spieler : spielers) {
            if (spieler.getPosition() == 1) {
                spieler.setPosition(spielers.size());
            } else
                spieler.setPosition(spieler.getPosition() - 1);
        }
        sortByPosition();
    }


    public List<Spieler> getSpielers() {
        return spielers;
    }

    public void setSpielers(List<Spieler> spielers) {
        this.spielers = spielers;
    }

    public List<Stich> getStiche() {
        return stiche;
    }

    public void setStiche(List<Stich> stiche) {
        this.stiche = stiche;
    }

    private void sortByPosition() {

        Comparator<Spieler> spielerComparator = new Comparator<Spieler>() {
            @Override
            public int compare(Spieler o1, Spieler o2) {
                return (o1.getPosition() < o2.getPosition()) ? -1 : 1;
            }
        };

        Collections.sort(spielers, spielerComparator);
    }
    public void rundeSpielen(){
        Stich stich= new Stich(spielers.get(0),this);
        spielers.get(0).decideSchlag(this);
        spielers.get(spielers.size()-1).decideTrumpf(this);
        while(stiche.size()<5){
            for(Spieler spieler:spielers){
                spieler.karteSpielenLassen(stich);
            }
            stich.calculateGewinner();
            stiche.add(stich);
            sortSpielersByGewinner(stich.getGewinner());
            JOptionPane.showInputDialog(null, "Gewinner ist: "+stich.getGewinner().getName() , null);
            stich= new Stich(stich.getGewinner(),this);
        }
    }

    private void sortSpielersByGewinner(Spieler gewinner) {

        List<Spieler> spielersList=new ArrayList<>();
        spielersList.addAll(spielers);


       int index= spielersList.indexOf(gewinner);
       int itts=spielers.size()-index;
       for(int i=0;i<itts&&itts<spielers.size();i++){
           Spieler letzter=spielersList.get(3);
           spielersList.remove(3);
           spielersList.add(0,letzter);

       }
       spielers=spielersList;
    }

    public Farbe getTrumpf() {
        return trumpf;
    }

    public void setTrumpf(Farbe trumpf) {
        this.trumpf = trumpf;
    }

    public Wert getSchlag() {
        return schlag;
    }

    public void setSchlag(Wert schlag) {
        this.schlag = schlag;
    }
}
