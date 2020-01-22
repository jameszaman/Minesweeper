import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class Mine {
    static int freeSpaceLeft = 54;
    JFrame frame = new JFrame("Minesweeper");
    JPanel panel = new JPanel();
    JButton buttons[] = new JButton[64];
    HashSet<Integer> bombs = new HashSet<>();
    ImageIcon correct = new ImageIcon("star 50x50.png");
    ImageIcon button = new ImageIcon("button 64x64.png");

    Mine() {
        frame.setSize(400,400);
        panel.setLayout(new GridLayout(8,8));

        for(int i = 0; i < 64; ++i) {
            buttons[i] = new JButton(button);
            buttons[i].addActionListener(new Listen());
            panel.add(buttons[i]);
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        init(10);
    }

    void init(int noOfBombs) {
        while (bombs.size() < noOfBombs) {
            bombs.add((int)(Math.random()*64));
        }
        for(int i: bombs) {
            System.out.println(i);
        }
    }


    class Listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for(int i = 0; i < 64; ++i) {
                if(actionEvent.getSource() == buttons[i]) {
                    if(bombs.contains(i)) {
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "GAME OVER!");
                    }
                    else {
                        buttons[i].setIcon(correct);
                    }
//                    buttons[i].setEnabled(false);
                    freeSpaceLeft--;
                    if(freeSpaceLeft == 0) {
                        JOptionPane.showMessageDialog(null, "You Win");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Mine mine = new Mine();
    }
}
