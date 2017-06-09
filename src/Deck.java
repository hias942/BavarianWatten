import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Deck {

    private static List<Card> cards= new ArrayList<>();



    public static void generateDeck(){
        cards= new ArrayList<>();
        for(Farbe farbe : Farbe.values()){
            for(Wert wert:Wert.values()){
                cards.add(new Card(farbe,wert));
            }
        }
        long random=System.nanoTime();
        Collections.shuffle(cards,new Random(random));
    }

    public static List<Card> getCards() {
        return cards;
    }

    public static void setCards(List<Card> cards) {
        Deck.cards = cards;
    }
}
