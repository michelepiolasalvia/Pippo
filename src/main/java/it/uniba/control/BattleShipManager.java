package it.uniba.control;
import java.util.Random;


/**
 * Classe Battleship.
 * Utilizzata per gestire la griglia di gioco.
 * <i>&#60;Control&#62;</i>
 */
public final class BattleShipManager {

    /** Costante che indica la dimensione di default della griglia. */
    private static final int DEFAULT_DIM = 10;
    /** Costante che indica la dimensione large della griglia. */
    private static final int LARGE_DIM = 18;
    /** Costante che indica la dimensione extralarge della griglia. */
    private static final int EXTRA_DIM = 26;
    /** intero che indica il numero di righe della griglia. */
    private static int righe = DEFAULT_DIM;
    /** intero che indica il numero di colonne della griglia. */
    private static int colonne = DEFAULT_DIM;
    /** Array di interi costante che indica la lunghezza dei tipi di nave. */
    private static final int[] LUNGHEZZA_NAVI = {2, 2, 2, 2, 3, 3, 3, 4, 4, 5};

    /** Matrice di interi utilizzata per rappresentare la griglia di gioco.*/
    private static char[][] tabellaPos;

    /** Oggetto della classe Random.
     * Usato per generare casualmente valori interi e booleani
     */
    private static Random random = new Random();

    private BattleShipManager() { }



    /**
     * Procedura che posiziona randomicamente tutte le navi all'interno della griglia.
     */
    public static void piazzaNavi() {

        // Definisci i simboli delle navi
        char[] simboliNavi = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        for (int i = 0; i < LUNGHEZZA_NAVI.length; i++) {
            int lunghezza = LUNGHEZZA_NAVI[i];
            char simbolo = simboliNavi[i];

            // Genera casualmente le coordinate iniziali e la direzione
            int x;
            int y;
            boolean orizzontale;
            do {
                x = random.nextInt(righe);
                y = random.nextInt(colonne);
                orizzontale = random.nextBoolean();
            } while (!verificaPosizione(x, y, lunghezza, orizzontale));

            for (int j = 0; j < lunghezza; j++) {
                if (orizzontale) {
                    tabellaPos[x][y + j] = simbolo;
                } else {
                    tabellaPos[x + j][y] = simbolo;
                }
            }

        }
    }

    /**
     * Funzione che verifica se il posizionamento della nave è corretto.
     * @param x Riga in cui si vuole piazzare
     * @param y Colonna in cui si vuole piazzare
     * @param lunghezza lunghezza della nave
     * @param orizzontale true se orizzontale, false se verticale
     * @return true se è possibile piazzare la nave, false altrimenti
     */
    private static boolean verificaPosizione(final int x, final int y, final int lunghezza, final boolean orizzontale) {
        if (orizzontale) {
            if (y + lunghezza > colonne) {
                return false;
            }

            for (int i = y; i < y + lunghezza; i++) {
                if (tabellaPos[x][i] != ' ') {
                    return false;
                }
            }
        } else {
            if (x + lunghezza > righe) {
                return false;
            }

            for (int i = x; i < x + lunghezza; i++) {
                if (tabellaPos[i][y] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Cambia la dimensione della griglia di gioco in base al comando usato..
     * @param command stringa che indica la dimensione scelta
     */
     public static void changeDim(final String command) {
         if (command.equals("/standard")) {
             righe = DEFAULT_DIM;
             colonne = DEFAULT_DIM;
         } else if (command.equals("/large")) {
             righe = LARGE_DIM;
             colonne = LARGE_DIM;
         } else if (command.equals("/extralarge")) {
             righe = EXTRA_DIM;
             colonne = EXTRA_DIM;
        }
     }

    /**
     * Procedura che inizializza la Griglia alla dimensione scelta.
     */
    public static void inizializzaGriglia() {
         tabellaPos = new char[righe][colonne];
         for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                tabellaPos[i][j] = ' ';
            }
        }
    }

    /**
     * Funzione getRighe.
     * @return Restituisce il numero di righe della griglia
     */
    public static int getRighe() {
        return righe;
    }

    /**
     * Funzione getColonne.
     * @return Restituisce il numero di colonne della griglia
     */
    public static int getColonne() {
        return colonne;
    }

    /**
     * Funzione getValue.
     * @param r riga della cella desiderata
     * @param c colonna della cella desiderata
     * @return il valore contenuto nella cella di riga r e colonna c
     */
    public static char getValue(final int r, final int c) {
        return tabellaPos[r][c];
    }

    /**
     * Funzione setValue.
     * @param i riga della cella desiderata
     * @param j colonna della cella desiderata
     * @param c valore che si vuole inserire nella cella di riga r e colonna c
     */
    public static void setValue(final int i, final int j, final char c) {
        tabellaPos[i][j] = c;
    }

}
