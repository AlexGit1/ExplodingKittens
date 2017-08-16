package explodingkitten;
//BUILD 1708161

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static JFrame frame = new JFrame();
    static JFrame waitscreen = new JFrame();
    static JFrame framejoin = new JFrame();
    static JButton hostbutton = new JButton("Spiel erstellen");
    static JButton joinbutton = new JButton("Spiel beitreten");
    static JPanel panelwarten = new JPanel();
    static JPanel panel = new JPanel();
    static JLabel textwarten = new JLabel("Es wird gewartet bis alle Spieler dem Spiel beigetreten sind...");
    static JLabel textfeld = new JLabel("Willst du ein Spiel erstellen oder einem bestehendem Spiel beitreten ?");
    static Boolean h = true;

    public static void main(String[] args) {
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setTitle("Exploding Kittens");
        frame.setSize(500,180);
        waitscreen.setTitle("Warten");
        waitscreen.setSize(500,80);
        frame.setLocationRelativeTo(null);
        waitscreen.setLocationRelativeTo(null);
        textwarten.setLocation(50,10);
        hostbutton.setSize(150,50);
        panelwarten.setSize(9999,9999);
        joinbutton.setLocation(250,45);
        hostbutton.setLocation(80,45);
        joinbutton.setSize(150,50);
        textfeld.setSize(500,50);
        textfeld.setLocation(35,1);
        panel.setSize(99999,99999);
        textwarten.setSize(100, 100);
        panel.add(hostbutton);
        panel.add(joinbutton);
        panel.add(textfeld);
        frame.add(panel);
        frame.setVisible(true);
        panelwarten.add(textwarten);
        waitscreen.add(panelwarten);
        frame.setDefaultCloseOperation(3);

        hostbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p = 0;
                while (p < 2 || p > 5) {
                    String eingabe = JOptionPane.showInputDialog(null, "Wieviele Spieler soll es geben ? (2-5)",
                            "Spieleranzahl",
                            JOptionPane.PLAIN_MESSAGE);

                    try {
                        p = Integer.parseInt(eingabe);

                    }
                    catch(NumberFormatException ex)
                    {

                    }

                }
                frame.setVisible(false);


                //if (Netzwerk.recive() == 1){
                Netzwerk.send(Netzwerk.get_ip(),2);
                     Game game = new Game();
                //}
            }
        });
        joinbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eingabe = JOptionPane.showInputDialog(null, "Wie lautet die Adresse des Hostes ?","", JOptionPane.PLAIN_MESSAGE);
                try {
                    Netzwerk.send(eingabe,1);
                }
                catch(InputMismatchException s){

                };

                     if (Netzwerk.recive() == 2){
                         System.out.println("Arschwasser");
                     }

                    }
                });
            }



}
