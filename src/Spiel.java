import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Benedikt on 11.06.2017.
 */
public class Spiel {

    Runde currentRound;

    public Spiel(){

        currentRound= new Runde( Arrays.asList(new Spieler(false,1,"Spieler 1"),new Spieler(false,2,"Spieler 2"),new Spieler(false,3,"Spieler 3"),new Spieler(true,4,"Spieler 4")));

        playRound();
    }
    public void playRound(){
        currentRound.dealCards();
        currentRound.rundeSpielen();
        showResults(currentRound);
    }

    private void showResults(Runde runde){

        JFrame jFrame=new JFrame("Endergebnisse");

        jFrame.setSize(500,300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width/2-jFrame.getSize().width/2, dim.height/2-jFrame.getSize().height/2);

        JPanel jPanel= new JPanel();
        JList jList=new JList(runde.getStiche().toArray());
        jPanel.add(jList, BorderLayout.CENTER);
        jFrame.add(jPanel);
        JButton jButton=new JButton("Nächste Runde");
        jFrame.getRootPane().setDefaultButton(jButton);
        jButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    currentRound.nextTurn();
                    jFrame.dispose();
                    playRound();

            }
        });

       jFrame.add(jButton,BorderLayout.SOUTH);
       jButton.setVisible(true);
       jFrame.setVisible(true);
       jList.setVisible(true);
       jPanel.setVisible(true);

    }

}


