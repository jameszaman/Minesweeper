/**
 * @author
 * James Hedayet Zaman
 * Mohammad Mubin
 * */

//Could not do much work here, cause I was checking some other stuff.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class is for everything related to the frame.
public class Mine extends Game{
    static int freeSpaceLeft = 54;
    JFrame frame = new JFrame("Minesweeper");
    JPanel panel = new JPanel();//Using a panel for resize purpose.
    JButton buttons[] = new JButton[64];
    JPanel panels[] = new JPanel[64];
    JLabel label[] = new JLabel[64];

    Mine() {
        //This is to show the game.
        frame.setSize(520,520);
        panel.setLayout(new GridLayout(8,8));
        panel.setBackground(Color.GREEN);

        for(int i = 0; i < 64; ++i) {
            //Adding all the buttons.
            buttons[i] = new JButton(button);
            buttons[i].addActionListener(new Listen());
            //using a panel for every Button. Because you cannot access GridLayout.
            panels[i] = new JPanel(new BorderLayout());
            panels[i].add(buttons[i]);
            panel.add(panels[i]);
        }

        frame.add(panel);
        //Basic frame details.
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        init(10);
    }

    //What happens while playing the game.
    class Listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for(int i = 0; i < 64; ++i) {
                if(actionEvent.getSource() == buttons[i]) {
                    if(bombs.contains(i)) {//If bomb is found. Game Over
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "GAME OVER!");
                    }
                    //Adding a label where bomb was not found!
                    label[i] = new JLabel(like);
                    panels[i].add(label[i]);
                    buttons[i].setVisible(false);
                    freeSpaceLeft--;
                    if(freeSpaceLeft == 0) {// If no more Free space is left, only bomb is left. You Win.
                        JOptionPane.showMessageDialog(null, "You Win");
                    }
                }
            }
        }
    }
    //Calling the Class to start the program
    public static void main(String[] args) {
        Mine mine = new Mine();
    }
}
