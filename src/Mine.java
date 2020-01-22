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
import java.util.HashSet;

public class Mine {
    static int freeSpaceLeft = 54;
    JFrame frame = new JFrame("Minesweeper");
    JPanel panel = new JPanel();//Using a panel for resize purpose.
    JButton buttons[] = new JButton[64];
    HashSet<Integer> bombs = new HashSet<>();// This is where the location for all the bombs are stored.
    //Still testing the icons. Not Final.
    ImageIcon done = new ImageIcon("like.png");
    ImageIcon button = new ImageIcon("button.png");
    ImageIcon mine = new ImageIcon("cross.png");// Not using this right now.

    Mine() {
        //This is to show the game.
        frame.setSize(450,450);
        panel.setLayout(new GridLayout(8,8));

        for(int i = 0; i < 64; ++i) {
            //Adding all the buttons.
            buttons[i] = new JButton(done);
            buttons[i].addActionListener(new Listen());
            panel.add(buttons[i]);
        }

        frame.add(panel);
        //Basic frame details.
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        init(10);
    }

    //All the things necessary at the start of the game
    void init(int noOfBombs) {
        while (bombs.size() < noOfBombs) {//Adding all the bombs.
            bombs.add((int)(Math.random()*64));
        }
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
                    else {
                        buttons[i].setIcon(button);
                    }
                    buttons[i].setEnabled(false);
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
