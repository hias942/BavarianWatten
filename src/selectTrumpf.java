import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class selectTrumpf extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JList list2;
    private Runde runde;
    private Spieler spieler;

    public selectTrumpf(Runde runde,Spieler spieler) {
        this.setAutoRequestFocus(true);
        this.runde=runde;
        this.spieler=spieler;
        list1.setListData(Farbe.values());
        list1.setDragEnabled(false);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setListData(spieler.getHand().toArray());
        list2.setDragEnabled(false);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if(list1.getSelectedValue()!=null) {
            runde.setTrumpf((Farbe) list1.getSelectedValue());
            dispose();
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(Runde runde,Spieler spieler) {

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


        selectTrumpf dialog = new selectTrumpf(runde,spieler);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
        dialog.setTitle(spieler.getName());
        dialog.pack();
        dialog.setVisible(true);
    }




}
