import javax.swing.*;
import java.awt.*;


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

    //Main method
    public static void main(String[] args) {
        Game game = new Game();
    }

}
