import javax.swing.*;
import java.util.HashSet;

//This class is to handled the game play element.
public class Game {
    //Graphical part.
    //Still testing the icons. Not Final.
    ImageIcon like = new ImageIcon("like.png");//not using this right now.
    ImageIcon button = new ImageIcon("button.png");
    ImageIcon mine = new ImageIcon("mine.png");// Not using this right now.
    //this is to show how many bombs are around.
    ImageIcon one = new ImageIcon("one.png");//Not using it right now.
    ImageIcon two = new ImageIcon("two.png");//Not using it right now.
    ImageIcon three = new ImageIcon("three.png");//Not using it right now.
    ImageIcon four = new ImageIcon("four.png");//Not using it right now.
    ImageIcon five = new ImageIcon("five.png");//Not using it right now.
    ImageIcon six = new ImageIcon("six.png");//Not using it right now.
    ImageIcon seven = new ImageIcon("seven.png");//Not using it right now.
    ImageIcon eight = new ImageIcon("eight.png");//Not using it right now.


    HashSet<Integer> bombs = new HashSet<>();// This is where the location for all the bombs are stored.


    //All the things necessary at the start of the game
    void init(int noOfBombs) {
        while (bombs.size() < noOfBombs) {//Adding all the bombs.
            bombs.add((int)(Math.random()*64));
        }
    }
}
