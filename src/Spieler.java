import sun.security.provider.ConfigFile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Spieler{
    private Boolean isDealer;
    private Set<Card> hand;
    private Integer position;


    public Spieler(Boolean isDealer,Integer position) {
        this.isDealer = isDealer;
        this.hand = new HashSet<>();
        this.position=position;
    }

    public void karteSpielen(Stich stich){
        stich.getCardList().add((Card) hand.toArray()[0]);
        hand.remove ((Card) hand.toArray()[0]);
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
}
