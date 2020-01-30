import javax.swing.*;

public class Box extends JButton {

    int state;
    boolean flagged;
    boolean uncovered;

    Box() {
        this.setIcon(new ImageIcon("box.png"));

        this.state = 0;
        this.flagged = false;
        this.uncovered = false;
    }
}
