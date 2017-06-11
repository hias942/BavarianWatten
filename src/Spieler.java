import com.sun.javafx.collections.MappingChange;
import com.sun.javafx.collections.UnmodifiableObservableMap;
import sun.security.provider.ConfigFile;

import java.util.*;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Spieler{
    private Boolean isDealer;
    private Set<Card> hand;
    private Integer position;
    private String name;


    public Spieler(Boolean isDealer,Integer position,String name) {
        this.isDealer = isDealer;
        this.hand = new HashSet<>();
        this.position=position;
        this.name=name;
    }

    public void karteSpielen(Stich stich){
        stich.getCardMap().put((Card) hand.toArray()[0],this);
        hand.remove ((Card) hand.toArray()[0]);
    }

    public void decideTrumpf(Runde runde){
        if(position==4&&isDealer){
            runde.setTrumpf(Farbe.Eichel);//TODO: deciding logic
        }
    }
    public void decideSchlag(Runde runde){
        if(position==1){
            runde.setSchlag(Wert.Acht);//TODO: deciding logic
        }
    }


    public Boolean getDealer() {
        return isDealer;
    }

    public void setDealer(Boolean dealer) {
        isDealer = dealer;
    }

    public Set<Card> getHand() {
        return hand;
    }

    public void setHand(Set<Card> hand) {
        this.hand = hand;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "isDealer=" + isDealer +
                ", hand=" + hand +
                ", position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
