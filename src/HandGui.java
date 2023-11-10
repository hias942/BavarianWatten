import com.sun.deploy.panel.JSmartTextArea;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Benedikt on 11.06.2017.
 */
public class HandGui {

    public void initGui(Spieler spieler){

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {

                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }


        JFrame frame = new JFrame(spieler.getName());
        frame.setAutoRequestFocus(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        frame.setAutoRequestFocus(true);
        frame.setSize(500,200);


        JList<Card> jListHand=new JList(spieler.getHand().toArray());


        if(spieler.getHand().size()==1){
            jListHand.setSelectedIndex(0);
        }


        JButton playButton=new JButton("Spielen");
        playButton.setBackground(Color.RED);
        playButton.setForeground(Color.BLUE);
        playButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               if(jListHand.getSelectedValue()!=null) {
               spieler.playCard((Card) jListHand.getSelectedValue());
               frame.dispose();
               }
            }
        });

        JSeparator jSeparator=new JSeparator();
        jSeparator.setOrientation(SwingConstants.VERTICAL);

        frame.getRootPane().setDefaultButton(playButton);
        frame.getContentPane().add(playButton,BorderLayout.PAGE_END);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);


        class CardByPlayer{
            private Card card;
            private String spielerName;

            private CardByPlayer(Card card) {
                    this.card=card;
                    this.spielerName=card.getSpieler().getName();
            }

            @Override
            public String toString() {
                return card.toString()+" von "+spielerName;
            }
        }

        java.util.List<CardByPlayer> cardsStich=new ArrayList<>();
        for (Card card:spieler.getCurrentStich().getCardList()) {
            cardsStich.add(new CardByPlayer(card));
        }


        JTextArea textArea=new JTextArea();
        textArea.setText("Schlag: "+spieler.getCurrentStich().getRunde().getSchlag().toString()+"\n");
        textArea.append("Trumpf: "+spieler.getCurrentStich().getRunde().getTrumpf().toString());
        textArea.setVisible(true);




        JList<CardByPlayer> jListStich=new JList(cardsStich.toArray());

        jListStich.setDragEnabled(false);
        jListHand.setDragEnabled(false);

        jListHand.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JToolBar jToolBarKarten=new JToolBar();
        jToolBarKarten.setFloatable(false);
        jToolBarKarten.add(jListHand);
        jToolBarKarten.addSeparator(new Dimension(40,100));
        jToolBarKarten.add(jListStich);
        jToolBarKarten.addSeparator(new Dimension(120,100));
        jToolBarKarten.add(textArea);
        frame.getContentPane().add(jToolBarKarten,BorderLayout.CENTER);

       // frame.getContentPane().add(jListHand,BorderLayout.WEST);
       // frame.getContentPane().add(jListStich,BorderLayout.CENTER);
        jListHand.setVisible(true);
        jListStich.setVisible(true);
        playButton.setVisible(true);
        jSeparator.setVisible(true);
        playButton.setVisible(true);
        frame.setVisible(true);






    }

}
