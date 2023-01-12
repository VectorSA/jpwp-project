package pl.vectorsa.corridoors;
import javax.swing.JOptionPane;

/**
 * Klasa LogikaMagika - odpowiada za logike gry
 */
class LogikaMagika{
    /**
     * "00"-sciana "01"-podloga "02"-drzwi "03"-otwarte_drzwi "04"-pies "05"-klucz "06"-gracz "07"-dzwignia 
     * "08"-przelaczona_dzwignia "09"-wyjscie "10"-jedzenie "11"-brama "12"-brama_otwarta 
     */
    String mapy[][][]={
        {
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","01","01","06","00","01","01","01","00","00","00","00","00"},
            {"00","00","00","01","00","00","00","01","00","01","10-5","00","00","00","00"},
            {"00","00","00","01","01","01","02-3","01","01","01","00","00","00","00","00"},
            {"00","00","00","01","00","01","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","01","01","07-2","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","00","11-2","00","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","00","01","00","00","00","01","04-5","01","01","01","00","00"},
            {"00","00","00","00","01","00","00","00","01","00","00","00","01","00","00"},
            {"00","00","00","01","01","00","05-3","00","01","00","01","01","01","09","00"},
            {"00","00","00","01","00","00","01","00","01","00","00","00","00","00","00"},
            {"00","00","00","01","01","01","01","00","01","00","00","00","00","00","00"},
            {"00","00","00","00","00","00","01","01","01","00","00","00","00","00","00"},
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
        },
        {
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","01","01","06","00","00","00","01","11-2","10-5","00","00","00"},
            {"00","00","00","01","00","00","00","01","01","01","00","00","00","00","00"},
            {"00","01","01","01","01","01","02-3","01","00","01","01","01","00","00","00"},
            {"00","00","00","01","00","01","00","01","01","01","00","04-5","11-2","01","00"},
            {"00","00","00","01","01","07-2","00","04-5","00","00","00","00","00","01","00"},
            {"00","00","00","00","11-2","00","00","07-2","00","00","00","00","00","01","00"},
            {"00","00","00","00","01","00","00","00","01","04-5","01","00","00","01","00"},
            {"00","00","00","00","01","00","00","00","01","00","05","00","00","01","00"},
            {"00","10-5","00","01","01","01","05-3","00","01","00","00","00","01","09","00"},
            {"00","01","01","01","00","00","01","00","01","00","00","00","00","00","00"},
            {"00","00","00","01","01","01","01","00","01","00","00","00","00","00","00"},
            {"00","00","00","01","00","00","01","01","01","00","00","00","00","00","00"},
            {"00","00","00","01","00","00","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
        },
        {
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
            {"00","00","00","00","00","06","00","00","00","00","00","00","00","00","00"},
            {"00","05-3","11-2","01","01","01","01","01","01","01","00","00","00","00","00"},
            {"00","00","00","01","00","00","01","00","00","01","00","00","00","00","00"},
            {"00","00","00","01","00","00","01","01","00","01","00","00","00","00","00"},
            {"00","00","00","01","00","00","00","01","00","01","00","00","00","00","00"},
            {"00","00","00","01","00","00","00","01","00","01","00","00","00","00","00"},
            {"00","00","00","01","00","00","01","01","00","01","01","02-3","07-2","11-2","09"},
            {"00","00","00","01","01","00","01","00","00","01","00","00","00","00","00"},
            {"00","00","00","00","01","00","01","00","00","01","00","00","00","00","00"},
            {"00","00","01","01","04-5","01","01","01","01","01","00","00","00","00","00"},
            {"00","00","01","00","01","00","01","00","00","00","00","00","00","00","00"},
            {"00","00","07-2","00","01","00","01","01","00","00","00","00","00","00","00"},
            {"00","00","01","01","01","00","01","10-5","00","00","00","00","00","00","00"},
            {"00","00","00","00","00","00","00","00","00","00","00","00","00","00","00"},
        },
    };
/**
 *  Interfejs - aktywny interfejs uzytkownika
 */
    Interfejs interfejs;
/**
 *  ostatniElement - ostatni aktywny element
 */
    String ostatniElement;
/**
 *  poziom - zmienna, aktualny poziom
 */
    int poziom;
/**
 *  ostatniPoziom - zmienna ostatniego poziomu
 */
    int ostatniPoziom;
/**
 *  LogikaMagika - przypisanie interfejsu
 * @param interfejs aktywny interfejs uzytkownika
 */
    LogikaMagika(Interfejs interfejs) {
        this.interfejs = interfejs;
        this.poziom = 0;
        this.ostatniPoziom = 3;
        this.ostatniElement = "01";
    }
/**
 *  logika - glowna logika gry
 * @param strona String
 */
    void logika(String strona) {
        int wektor[] = new int[2];
        int graczxy[] = new int[2];
        String mapy[][] = this.mapy[this.poziom];
        boolean wyjdz = false;
        for (int i = 0; i < mapy.length; i++) {
            for (int j = 0; j < mapy.length; j++) {
                if (mapy[i][j].startsWith("06")) {
                    graczxy[0] = j;
                    graczxy[1] = i;
                    wyjdz = true;
                    break;
                }
            }
            if (wyjdz) {
                break;
            }
        }
        if (strona == "prawo") {
            wektor[0]= 1;
            wektor[1]= 0;
        } else if (strona == "lewo") {
            wektor[0]= -1;
            wektor[1]= 0;        
        } else if (strona == "gora") {
            wektor[0]= 0;
            wektor[1]= -1;
        } else if (strona == "dol") {
            wektor[0]= 0;
            wektor[1]= 1;
        } else {
            return;
        }
        int vx = graczxy[0]+wektor[0];
        int vy = graczxy[1]+wektor[1];
        if (vx < 0 || vx >= this.mapy[0].length || vy < 0 || vy >= this.mapy[0].length) {
            return;
        }
        String gracz[] = mapy[graczxy[1]][graczxy[0]].split("-", 0);
        String obiekt[] = mapy[vy][vx].split("-", 0);
        String calyGracz = mapy[graczxy[1]][graczxy[0]];
        String calyObiekt = mapy[vy][vx];
        if (Integer.valueOf(obiekt[0]) == 0 || Integer.valueOf(obiekt[0]) == 11) {
            return;
        } else if (Integer.valueOf(obiekt[0]) == 1) {
        } else if (Integer.valueOf(obiekt[0]) == 2) {
            boolean znalezione = false;
            for (int i = 1; i<gracz.length; i++) {
                for (int j = 1; j<obiekt.length; j++) {
                    if (Integer.valueOf(gracz[i]) == Integer.valueOf(obiekt[j])) {
                        znalezione = true;
                        break;
                    }
                }
                if (znalezione) {
                    break;
                }
            }
            if (!znalezione) {
                return;
            }
                obiekt[0] = "03";
            calyObiekt = "";
            for (int i = 0; i<obiekt.length; i++) {
                calyObiekt += obiekt[i];
                if (i<obiekt.length-1) {
                    calyObiekt += "-";
                }
            }
            mapy[vy][vx] = calyObiekt;
        } else if (Integer.valueOf(obiekt[0]) == 3 || Integer.valueOf(obiekt[0]) == 12) {
        } else if (Integer.valueOf(obiekt[0]) == 4) {
            for (int i = 1; i<gracz.length; i++) {
                if (Integer.valueOf(gracz[i]) == Integer.valueOf(obiekt[1])) {
                    mapy[vy][vx] = "01";
                    calyGracz = "";
                    for (int j = 0; j<gracz.length; j++) {
                        if (i == j) {
                            continue;
                        }
                        calyGracz += gracz[j];
                        if (j<gracz.length-1) {
                            calyGracz += "-";
                        }
                    }
                    break;
                 }
            }
            if (!mapy[vy][vx].startsWith("01")) {
                return;
            }
        } else if (Integer.valueOf(obiekt[0]) == 5 || Integer.valueOf(obiekt[0]) == 10) {
            calyGracz = "";
            for (int j = 0; j<gracz.length; j++) {
                calyGracz += gracz[j];
                if (j<gracz.length-1) {
                    calyGracz += "-";
                }
            }
            if (obiekt.length > 1) {
                calyGracz += "-";
            }
            for (int j = 1; j<obiekt.length; j++) {
                calyGracz += obiekt[j];
                if (j<obiekt.length-1) {
                    calyGracz += "-";
                }
            }
            mapy[vy][vx] = "01";
        } else if (Integer.valueOf(obiekt[0]) == 7 || Integer.valueOf(obiekt[0]) == 8) {
            for (int i = 1; i<obiekt.length; i++) {
                for (int j = 0; j<mapy.length; j++) {
                    for (int k = 0; k<mapy.length; k++) {
                        if (mapy[j][k].startsWith("11") || mapy[j][k].startsWith("12")) {
                            String tymczasowyObiekt = "";
                            String podzielonyObiekt[] = mapy[j][k].split("-", 0);
                            if (Integer.valueOf(mapy[j][k].substring(0,2)) == 11) {
                                tymczasowyObiekt = "12";
                            } else if (Integer.valueOf(mapy[j][k].substring(0,2)) == 12) {
                                tymczasowyObiekt = "11";
                            }
                            for (int h = 1; h<podzielonyObiekt.length; h++) {
                                tymczasowyObiekt += podzielonyObiekt[h];
                                if (h<podzielonyObiekt.length-1) {
                                    tymczasowyObiekt += "-";
                                }
                            }
                            mapy[j][k] = tymczasowyObiekt;
                        }
                    }
                }
            }
            if (this.ostatniElement.startsWith("11") || this.ostatniElement.startsWith("12")) {
                String tymczasowyObiekt = "";
                String podzielonyObiekt[] = this.ostatniElement.split("-", 0);
                if (Integer.valueOf(this.ostatniElement.substring(0,2)) == 11) {
                    tymczasowyObiekt = "12";
                } else if (Integer.valueOf(this.ostatniElement.substring(0,2)) == 12) {
                    tymczasowyObiekt = "11";
                }
                for (int i = 1; i<podzielonyObiekt.length; i++) {
                    tymczasowyObiekt += podzielonyObiekt[i];
                    if (i<podzielonyObiekt.length-1) {
                        tymczasowyObiekt += "-";
                    }
                }
                this.ostatniElement = tymczasowyObiekt;
            }
        } else if (Integer.valueOf(obiekt[0]) == 9) {
            this.interfejs.mapa.repaint();
            this.poziom++;
            mapy[graczxy[1]][graczxy[0]] = this.ostatniElement;
            if(poziom!=ostatniPoziom)
                this.ostatniElement = "01";
            mapy[vy][vx] = calyGracz;
            if(poziom==ostatniPoziom) {
                this.ostatniElement = mapy[vy][vx];
                JOptionPane.showMessageDialog(null, "Wygrales, jesli chcesz zagrać ponownie, uruchom ponownie gre!");
            }
            return;
        }
        mapy[graczxy[1]][graczxy[0]] = this.ostatniElement;
        this.ostatniElement = mapy[vy][vx];
        mapy[vy][vx] = calyGracz;
        this.mapy[this.poziom] = mapy;
        this.interfejs.mapa.repaint();
    }
}