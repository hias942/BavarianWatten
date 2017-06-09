import java.util.*;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Runde {

    private List<Spieler> spielers;
    private List<Stich> stiche;

    public Runde(List<Spieler> spielers) {
        this.spielers = spielers;
        this.stiche=new ArrayList<>();
    }

    public List<Spieler> dealCards() {
        Deck.generateDeck();
        List<Card> deck = Deck.getCards();
        if (deck.size() % spielers.size() == 0) {
            while (deck.size() > deck.size()-spielers.size()*5)
                for (Spieler spieler : spielers) {
                    Set<Card> hand = spieler.getHand();
                    hand.add(deck.get(0));
                    spieler.setHand(hand);
                    deck.remove(0);
                    if (deck.size() == 0)
                        break;
                }

        }
        spielers.get(spielers.size() - 1).setDealer(false);
        spielers.get(0).setDealer(true);

        nextTurn();

        return spielers;
    }

    public void nextTurn() {
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

}
