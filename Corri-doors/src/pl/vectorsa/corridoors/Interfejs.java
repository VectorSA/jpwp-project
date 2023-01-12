package pl.vectorsa.corridoors;

import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;

/**
 * Klasa Rysuj - Panel rysowania mapy
 */
class Rysuj extends JPanel { 
/**
 *  Interfejs - aktywny interfejs uzytkownika
 */
    Interfejs interfejs;
/**
 *  Rysuj - Przypisuje panel graficzny dla mapy w interfejsie uzytkownika
 * @param interfejs aktywny interfejs uzytkownika
 */
    Rysuj(Interfejs interfejs) {
        super();
        this.interfejs = interfejs;
    }
/**
 * Paint - wrzucenie grafik na panel mapy
 */
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String mapa[][];
        if (this.interfejs.logika.poziom == this.interfejs.logika.ostatniPoziom)
            mapa = this.interfejs.logika.mapy[this.interfejs.logika.ostatniPoziom-1];
        else
            mapa = this.interfejs.logika.mapy[this.interfejs.logika.poziom];
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 960, 960);
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                try {  // ---------------- wrzucenie grafik na panel mapy
                    if (Integer.valueOf(mapa[i][j].substring(0,2).substring(0,2)) == 0) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"sciana.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 1) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"podloga.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 2) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"drzwi.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 3) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"drzwiotwarte.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 4) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"pies.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 5) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"klucz.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 6) {
                        
                        if (Integer.valueOf(mapa[i][j].substring(0,2).substring(0,2)) == 0) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"sciana.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 1) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"podloga.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 2) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"drzwi.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 3) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"drzwiotwarte.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 4) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"pies.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 5) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"klucz.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 7) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"dzwignia.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 8) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"dzwignia_przelaczona.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 9) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"exit.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 10) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"jedzenie.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 11) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"brama.png")), j*64, i*64, null);
                        } else if (Integer.valueOf(this.interfejs.logika.ostatniElement.substring(0,2)) == 12) {
                            g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"bramaotwarta.png")), j*64, i*64, null);
                        }
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"gracz.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 7) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"dzwignia.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 8) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"dzwignia_przelaczona.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 9) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"exit.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 10) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"jedzenie.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 11) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"brama.png")), j*64, i*64, null);
                    } else if (Integer.valueOf(mapa[i][j].substring(0,2)) == 12) {
                        g2.drawImage((BufferedImage)ImageIO.read(new URL(new Main().getClass().getResource("images/").toString()+"bramaotwarta.png")), j*64, i*64, null);
                    }
                } catch (Exception e) {}
            }
        }
    }
}
/**
 *  Klasa Interfejs - aktywny interfejs uzytkownika
 */
class Interfejs extends JFrame {
/**
 *  Atrybut Rysuj mapa - przypisywanie nazwy mapa
 */
    Rysuj mapa; // ---------------- Panel rysowania mapy
/**
 *  JPanel guziory - Panel przyciskow
 */
    JPanel guziory; // ---------------- panel przyciskow
/**
 *  JButton exit - przycisk wyjscia
 */
    JButton exit; // ---------------- przycisk wyjscia
/**
 *  JButton menu - przycisk menu
 */
    JButton menu; // ---------------- przycisk menu
/**
 *  JButton restart - przycisk restart
 */
    JButton restart; // ---------------- przycisk restartu
/**
 *  Atrybut LogikaMagika - przypisywanie nazwy logika
 */
    LogikaMagika logika; // ---------------- logika gry

/**
 *  Interfejs - aktywny interfejs uzytkownika
 */
    Interfejs() {
        super("Corri-Doors");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(960,1000));
        this.setLayout(null);
        this.setResizable(false);
        this.logika = new LogikaMagika(this);
        this.mapa = new Rysuj(this);
        this.mapa.setSize(960,960);
        this.mapa.setLocation(0,40);
        this.mapa.setOpaque(true);
        this.mapa.setBackground(new Color(0,0,0));
        this.guziory = new JPanel();
        this.guziory.setSize(960,34);
        this.guziory.setLocation(0,0);
        this.guziory.setOpaque(true);
        this.guziory.setBackground(new Color(100,100,100));
        this.exit = new JButton("WYJSCIE");
        this.menu = new JButton("MENU");
        this.restart = new JButton("RESTART");
        this.exit.setSize(90,25);
        this.exit.setLocation(850,5);
        this.exit.addActionListener(new ActionListener(){ // --------- Na sluchiwanie klawiszy WASD
/**
 *  actionPerformed - wykonanie akcji
 */
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.guziory.add(exit);
        this.restart.setSize( 95,25);
        this.restart.setLocation(740,5);
        this.guziory.add(restart);
        this.menu.setSize(90,25);
        this.menu.setLocation(630,5);
        // ------------------------------------------ Na sluchiwanie klawiszy WASD
        this.mapa.addKeyListener(new KeyListener(){
/**
 *  keyTyped - nacisniety przycisk / poruszanie sie klawiszami WASD
 */
            public void keyTyped(KeyEvent e) {
                if (logika.poziom == logika.ostatniPoziom) {
                    mapa.repaint();
/**
 *  JOptionPane.showMessageDialog - wysylanie powiadomienia (w tym przypadku o wygranej)
 */
                    JOptionPane.showMessageDialog(null, "Wygrales, jesli chcesz zagrać ponownie, uruchom ponownie gre!");
                    return;
                }
                if (Character.toLowerCase(e.getKeyChar()) == 'd') {
                    logika.logika("prawo");
                } else if (Character.toLowerCase(e.getKeyChar()) == 'a') {
                    logika.logika("lewo");
                } else if (Character.toLowerCase(e.getKeyChar()) == 'w') {
                    logika.logika("gora");
                } else if (Character.toLowerCase(e.getKeyChar()) == 's') {
                    logika.logika("dol");
                }
                repaint();
            }
/**
 *  keyPressed - klawisz wcisniety
 */
            public void keyPressed(KeyEvent e) {} // ---------- klawisz wcisniety
/**
 *  keyReleased - klawisz wycisniety
 */
            public void keyReleased(KeyEvent e) {} // ---------- klawisz puszczony
        });
        this.guziory.add(menu);
        this.guziory.setLayout(null);
        this.add(mapa);
        this.add(guziory);
        this.repaint();
        this.restart.setVisible(false);
        this.menu.setVisible(false);
        this.menu.setFocusable(false);
        this.guziory.setFocusable(false);
        this.exit.setFocusable(false);
        this.restart.setFocusable(false);
        this.setFocusable(false);
        this.mapa.setFocusable(true);
        this.mapa.requestFocusInWindow();
        this.setVisible(true);
    }
}