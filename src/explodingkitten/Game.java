package explodingkitten;
//BUILD 1708160
import javax.swing.*;

public class Game {
    static JFrame frame = new JFrame();
    static JFrame framejoin = new JFrame();
    static JButton hostbutton = new JButton("Spiel erstellen");
    static JButton joinbutton = new JButton("Spiel beitreten");
    static JPanel panel = new JPanel();
    static JLabel textfeld = new JLabel("Willst du ein Spiel erstellen oder einem bestehendem Spiel beitreten ?");

    public Game() {

        frame.setLayout(null);
        panel.setLayout(null);
        frame.setTitle("Exploding Kittens");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        hostbutton.setSize(150, 50);
        joinbutton.setLocation(250, 45);
        hostbutton.setLocation(80, 45);
        joinbutton.setSize(150, 50);
        textfeld.setSize(500, 50);
        textfeld.setLocation(35, 1);
        panel.setSize(99999, 99999);
        panel.add(hostbutton);
        panel.add(joinbutton);
        panel.add(textfeld);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(0);


    }



}
