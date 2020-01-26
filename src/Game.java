import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;


public class Game {
    //GUI objects
    JFrame frame = new JFrame("Mines");
    JPanel panel = new JPanel(new GridLayout(10, 10));

    //Address of all bombs
    HashSet<Integer> bombAddress = new HashSet<>();

    //Boxes/main game elements
    Box boxes[][] = new Box[10][10];

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

    //Method to initialise the state of the buttons
    //state of 0 if it has no neighbors as bombs, 1 if it has 1 bombed neighbor, 2 if it has 2 bombed neighbor and so on...
    //exception may occur in the boxes at the edge so they are handled
    void initState() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                //boxes are checked only if itself doesn't have a bomb
                if (boxes[i][j].state != -1) {
                    //above row checked
                    try {
                        if (boxes[i - 1][j - 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        if (boxes[i - 1][j].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        if (boxes[i - 1][j + 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    //same row checked
                    try {
                        if (boxes[i][j - 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        if (boxes[i][j + 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    //below row checked
                    try {
                        if (boxes[i + 1][j - 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        if (boxes[i + 1][j].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        if (boxes[i + 1][j + 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

    }

    //Method to initialize the bomb addresses
    void initBombs(int noOfBombs) {
        while (bombAddress.size() != noOfBombs) {
            bombAddress.add((int) (Math.random() * 100));
        }

        System.out.println(bombAddress.size());
    }

    //ActionListener interface implemented
    class Listener implements ActionListener {

        @Override
        //sets the image to whatever the state is
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (actionEvent.getSource() == boxes[i][j]) {
                        if (boxes[i][j].state == -1) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("mine.png"));
                        } else if (boxes[i][j].state == 0) {
                            boxes[i][j].setVisible(false);
                            //boxes[i][j].setIcon(new ImageIcon("mine.png"));
                        } else if (boxes[i][j].state == 1) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("1.png"));
                        } else if (boxes[i][j].state == 2) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("2.png"));
                        } else if (boxes[i][j].state == 3) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("3.png"));
                        } else if (boxes[i][j].state == 4) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("4.png"));
                        } else if (boxes[i][j].state == 5) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("5.png"));
                        } else if (boxes[i][j].state == 6) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("6.png"));
                        } else if (boxes[i][j].state == 7) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("7.png"));
                        } else if (boxes[i][j].state == 8) {
                            //boxes[i].setVisible(false);
                            boxes[i][j].setIcon(new ImageIcon("8.png"));
                        }
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
