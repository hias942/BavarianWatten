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
    private Boolean isDeciding=true;
    private Stich currentStich;


    public Spieler(Boolean isDealer,Integer position,String name) {
        this.isDealer = isDealer;
        this.hand = new HashSet<>();
        this.position=position;
        this.name=name;
    }

    public void karteSpielenLassen(Stich stich) {
        isDeciding=true;
        currentStich=stich;
        HandGui handGui=new HandGui();
        handGui.initGui(this);
        while(isDeciding){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
               //ignore
            }

        }

    }

    public void playCard(Card card){
        isDeciding=false;
        currentStich.getCardList().add(card);
        hand.remove (card);
    }






    public void decideTrumpf(Runde runde){
        if(position==4&&isDealer){
            selectTrumpf.main(runde,this);
        }
    }
    public void decideSchlag(Runde runde){
        if(position==1){
            selectSchlag.main(runde,this);
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

    public Boolean getDeciding() {
        return isDeciding;
    }

    public void setDeciding(Boolean deciding) {
        isDeciding = deciding;
    }

    public Stich getCurrentStich() {
        return currentStich;
    }

    public void setCurrentStich(Stich currentStich) {
        this.currentStich = currentStich;
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
