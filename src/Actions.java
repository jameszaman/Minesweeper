import javax.swing.*;
import java.util.HashSet;

public class Actions {
    //Boxes/main game elements
    Box boxes[][] = new Box[10][10];


    //Address of all bombs
    HashSet<Integer> bombAddress = new HashSet<>();

    //To check if you won the game or not.
    protected int noOfBoxesLeft; // The value is set along with the bombs.

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

    void emptyBox(int i, int j) {
        try{
            Clicked(i+1,j);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i-1,j);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i,j+1);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i,j-1);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i+1,j+1);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i+1,j-1);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i-1,j+1);
        }
        catch (Exception e) {

        }
        try{
            Clicked(i-1,j-1);
        }
        catch (Exception e) {

        }
    }

    //Method to initialize the bomb addresses
    void initBombs(int noOfBombs) {
        while (bombAddress.size() != noOfBombs) {
            bombAddress.add((int) (Math.random() * 100));
        }
        noOfBoxesLeft = 100 - noOfBombs;

        System.out.println(bombAddress.size());
    }

    void Clicked(int i, int j) {
        if(boxes[i][j].isEnabled()) {
            if (boxes[i][j].state == 0) {
                boxes[i][j].setVisible(false);
                System.out.println("i = " + i + " j = " + j);
                emptyBox(i,j);
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
    }
}
