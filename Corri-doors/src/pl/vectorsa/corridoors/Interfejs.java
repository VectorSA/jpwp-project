package pl.vectorsa.corridoors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

class Interfejs extends JFrame {
    JPanel mapa;
    JPanel guziory;
    Interfejs() {
        super("Corri-Doors");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(960,1000));
        this.setLayout(null);
        this.setResizable(false);
        mapa = new JPanel();
        mapa.setSize(960,960);
        mapa.setLocation(0,40);
        mapa.setOpaque(true);
        mapa.setBackground(new Color(0,0,255));
        guziory = new JPanel();
        guziory.setSize(960,34);
        guziory.setLocation(0,0);
        guziory.setOpaque(true);
        guziory.setBackground(new Color(0,255,0));
        this.add(mapa);
        this.add(guziory);
        
        this.setVisible(true);
    }
}