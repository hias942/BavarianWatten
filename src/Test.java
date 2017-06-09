import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Benedikt on 09.06.2017.
 */
public class Test {

    public static void main(String... args){

       Runde runde= new Runde( Arrays.asList(new Spieler(false,1),new Spieler(false,2),new Spieler(false,3),new Spieler(true,4)));
       List<Spieler> nextRundeSorted= runde.dealCards();
        int itt=1;
       while(runde.getSpielers().get(0).getHand().size()>0){
          Stich stich= new Stich(itt);

           itt++;
           for(Spieler spieler:runde.getSpielers()){
               spieler.karteSpielen(stich);

           }
           runde.getStiche().add(stich);
           if(itt==5)
               itt=1;
       }
    }


}
