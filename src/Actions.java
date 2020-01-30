import javax.swing.*;
import java.util.HashSet;

public class Actions {
    //Image icons initialized
    ImageIcon box = new ImageIcon("box.png");
    ImageIcon mine = new ImageIcon("mine.png");
    ImageIcon flag = new ImageIcon("flag.png");
    ImageIcon one = new ImageIcon("1.png");
    ImageIcon two = new ImageIcon("2.png");
    ImageIcon three = new ImageIcon("3.png");
    ImageIcon four = new ImageIcon("4.png");
    ImageIcon five = new ImageIcon("5.png");
    ImageIcon six = new ImageIcon("6.png");
    ImageIcon seven = new ImageIcon("7.png");
    ImageIcon eight = new ImageIcon("8.png");


    //Boxes/main game elements
    Box[][] boxes = new Box[10][10];

    //Address of all bombs
    HashSet<Integer> bombAddress = new HashSet<>();

    //To check if you won the game or not.
    static int noOfBoxesLeft = 100;

    //Method to initialise the state of the buttons
    //state of 0 if it has no neighbors as bombs, 1 if it has 1 bombed neighbor, 2 if it has 2 bombed neighbor and so on...
    //exception may occur in the boxes at the edge so they are handled in a try-catch block
    void initState() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //boxes are checked only if itself doesn't have a bomb
                if (boxes[i][j].state != -1) {
                    //above row checked
                    try {
                        if (boxes[i - 1][j - 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    try {
                        if (boxes[i - 1][j].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    try {
                        if (boxes[i - 1][j + 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    //same row checked
                    try {
                        if (boxes[i][j - 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    try {
                        if (boxes[i][j + 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    //below row checked
                    try {
                        if (boxes[i + 1][j - 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    try {
                        if (boxes[i + 1][j].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
                    }
                    try {
                        if (boxes[i + 1][j + 1].state == -1)
                            boxes[i][j].state++;
                    } catch (Exception ignored) {
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

        noOfBoxesLeft -= 10;
    }

    //Method to uncover boxes if a box with state 0 is clicked
    //calls emptyBox method
    void clicked(int i, int j) {
        // if (boxes[i][j].isEnabled()) {
        if (!boxes[i][j].uncovered) {
            if (boxes[i][j].state == 0) {
                boxes[i][j].uncovered = true;
                boxes[i][j].setIcon(null);
                boxes[i][j].setEnabled(false);
                noOfBoxesLeft--;
                emptyBox(i, j);
            } else {
                setNumber(i, j);
            }
        }
        System.out.println(noOfBoxesLeft);
    }

    void emptyBox(int i, int j) {
        //Unlocking in the above row
        try {
            clicked(i + 1, j - 1);
        } catch (Exception ignored) {
        }
        try {
            clicked(i + 1, j);
        } catch (Exception ignored) {
        }
        try {
            clicked(i + 1, j + 1);
        } catch (Exception ignored) {
        }

        //Unlocking in the same row
        try {
            clicked(i, j - 1);
        } catch (Exception ignored) {
        }
        try {
            clicked(i, j + 1);
        } catch (Exception ignored) {
        }

        //unlocking in the below row
        try {
            clicked(i - 1, j - 1);
        } catch (Exception ignored) {
        }
        try {
            clicked(i - 1, j);
        } catch (Exception ignored) {
        }
        try {
            clicked(i - 1, j + 1);
        } catch (Exception ignored) {
        }
    }

    //Method to set the icons of the boxes to the number of neighbors
    void setNumber(int i, int j) {
        if (boxes[i][j].state == 1) {
            boxes[i][j].setIcon(one);
        } else if (boxes[i][j].state == 2) {
            boxes[i][j].setIcon(two);
        } else if (boxes[i][j].state == 3) {
            boxes[i][j].setIcon(three);
        } else if (boxes[i][j].state == 4) {
            boxes[i][j].setIcon(four);
        } else if (boxes[i][j].state == 5) {
            boxes[i][j].setIcon(five);
        } else if (boxes[i][j].state == 6) {
            boxes[i][j].setIcon(six);
        } else if (boxes[i][j].state == 7) {
            boxes[i][j].setIcon(seven);
        } else if (boxes[i][j].state == 8) {
            boxes[i][j].setIcon(eight);
        }

        boxes[i][j].uncovered = true;
        noOfBoxesLeft--;
    }

    //Method to reveals all the bombs if the player loses
    void reveal() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (boxes[i][j].state == -1) {
                    boxes[i][j].setIcon(mine);
                }
            }
        }
    }
}
