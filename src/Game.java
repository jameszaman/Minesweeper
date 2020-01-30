import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends Actions {
    //GUI objects
    JFrame frame = new JFrame("Mines");
    JPanel panel = new JPanel(new GridLayout(10, 10));


    //Mouse Listener for the buttons
    Game.Listener listener = new Game.Listener();

    //Constructor for the game
    Game() {
        //Function to initiate the address of all bombs called
        initBombs(10);

        //All the buttons created
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boxes[i][j] = new Box();
                boxes[i][j].addMouseListener(listener);

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
    class Listener extends MouseAdapter {
        @Override
        //sets the image to whatever the state is
        public void mouseClicked(MouseEvent e) {
            //Checking every box to get which button was clicked
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == boxes[i][j]) {
                        //If left mouse button is clicked
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (!boxes[i][j].flagged) {
                                //Adding the icons based on the state of the box. i.e. no. of neighbors with bombs
                                if (boxes[i][j].state == -1) { //You lose the game in this case.
                                    boxes[i][j].setIcon(mine);
                                    reveal();
                                    JOptionPane.showMessageDialog(null, "You Lose");
                                    frame.dispose();
                                } else {
                                    if (!boxes[i][j].uncovered) {
                                        clicked(i, j);
                                    }
                                }
                            }
                        }

                        //if right mouse button is clicked
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            if (!boxes[i][j].uncovered) {
                                //switching flagged value to add/remove flags
                                boxes[i][j].flagged = !boxes[i][j].flagged;

                                //Adding/removing a flag if right mouse button is clicked
                                if (boxes[i][j].flagged) {
                                    boxes[i][j].setIcon(flag);
                                } else {
                                    boxes[i][j].setIcon(box);
                                }
                            }
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
