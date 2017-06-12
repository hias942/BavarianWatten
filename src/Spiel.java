import java.util.Arrays;
import java.util.List;

/**
 * Created by Benedikt on 11.06.2017.
 */
public class Spiel {

    public void playGame(){

        Runde runde= new Runde( Arrays.asList(new Spieler(false,1,"Spieler 1"),new Spieler(false,2,"Spieler 2"),new Spieler(false,3,"Spieler 3"),new Spieler(true,4,"Spieler 4")));
        runde.dealCards();
        runde.rundeSpielen();
        runde.nextTurn();
        runde.dealCards();
        runde.rundeSpielen();

        //Rundenstatistiken ausgeben

        System.out.println("Schlag: "+runde.getSchlag());
        System.out.println("Trumpf: "+runde.getTrumpf());

        int itt=0;
        for(Stich stich:runde.getStiche()){
            itt++;
            System.out.println("Stich N. "+itt);
            System.out.println("Aufgebender: "+stich.getAufgebender());
            System.out.println("Gewinner: "+stich.getGewinner());
            System.out.println("Gespielte Karten: "+ stich.getCardList());

        }

    }




    }


