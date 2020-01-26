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

    //Method to initialize the bomb addresses
    void initBombs(int noOfBombs) {
        while (bombAddress.size() != noOfBombs) {
            bombAddress.add((int) (Math.random() * 100));
        }
        noOfBoxesLeft = 100 - noOfBombs;

        System.out.println(bombAddress.size());
    }
}
