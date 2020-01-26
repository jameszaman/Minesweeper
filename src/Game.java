import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends Actions {
    //GUI objects
    JFrame frame = new JFrame("Mines");
    JPanel panel = new JPanel(new GridLayout(10, 10));

    Game() {
        //Function to initiate the address of all bombs called
        initBombs(20);

        //All the buttons created
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boxes[i][j] = new Box();
                boxes[i][j].addActionListener(new Listener());

                //Buttons containing bombs are assigned a state of -1
                if (bombAddress.contains(i * 10 + j)) {
                    boxes[i][j].state = -1;
                }

                panel.add(boxes[i][j]);
            }
        }

        //state of the remaining buttons initialized
        initState();

        //GUI elements added and properties set
        frame.add(panel);

        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    //Inner Class for button Actions
    //ActionListener interface implemented
    class Listener implements ActionListener {

        @Override
        //sets the image to whatever the state is
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (actionEvent.getSource() == boxes[i][j]) {
                        //Adding the icons based on the state of the box. i.e. no. of neighbors with bombs
                        if (boxes[i][j].state == -1) { //You lose the game in this case.
                            boxes[i][j].setIcon(new ImageIcon("mine.png"));
                            JOptionPane.showMessageDialog(null, "You Lose");
                            frame.dispose();
                        }
                        else {
                            if (boxes[i][j].state == 0) {
                                boxes[i][j].setVisible(false);
                            } else if (boxes[i][j].state == 1) {
                                boxes[i][j].setIcon(new ImageIcon("1.png"));
                            } else if (boxes[i][j].state == 2) {
                                boxes[i][j].setIcon(new ImageIcon("2.png"));
                            } else if (boxes[i][j].state == 3) {
                                boxes[i][j].setIcon(new ImageIcon("3.png"));
                            } else if (boxes[i][j].state == 4) {
                                boxes[i][j].setIcon(new ImageIcon("4.png"));
                            } else if (boxes[i][j].state == 5) {
                                boxes[i][j].setIcon(new ImageIcon("5.png"));
                            } else if (boxes[i][j].state == 6) {
                                boxes[i][j].setIcon(new ImageIcon("6.png"));
                            } else if (boxes[i][j].state == 7) {
                                boxes[i][j].setIcon(new ImageIcon("7.png"));
                            } else if (boxes[i][j].state == 8) {
                                boxes[i][j].setIcon(new ImageIcon("8.png"));
                            }
                            noOfBoxesLeft--;
                        }
                        if(noOfBoxesLeft == 0) JOptionPane.showMessageDialog(null, "You Win!");
                    }
                }
            }
        }
    }

    //Main method
    public static void main(String[] args) {
        Game game = new Game();
    }

}
