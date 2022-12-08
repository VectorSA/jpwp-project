package pl.vectorsa.corridoors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Interfejs extends JFrame {
    JPanel mapa;
    JPanel guziory;
    JButton exit;
    JButton menu;
    JButton restart;

    Interfejs() {
        super("Corri-Doors");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(960,1000));
        this.setLayout(null);
        this.setResizable(false);
        this.mapa = new JPanel();
        this.mapa.setSize(960,960);
        this.mapa.setLocation(0,40);
        this.mapa.setOpaque(true);
        this.mapa.setBackground(new Color(0,0,0));
        this.guziory = new JPanel();
        this.guziory.setSize(960,34);
        this.guziory.setLocation(0,0);
        this.guziory.setOpaque(true);
        this.guziory.setBackground(new Color(100,100,100));
        this.exit = new JButton("WYJŚCIE");
        this.menu = new JButton("MENU");
        this.restart = new JButton("RESTART");
        this.exit.setSize( 90,25);
        this.exit.setLocation(850,5);
        this.exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.guziory.add(exit);
        this.restart.setSize( 95,25);
        this.restart.setLocation(740,5);
        this.guziory.add(restart);
        this.menu.setSize( 90,25);
        this.menu.setLocation(630,5);
        this.guziory.add(menu);
        this.guziory.setLayout(null);
        this.add(mapa);
        this.add(guziory);
        
        this.setVisible(true);




    }
}