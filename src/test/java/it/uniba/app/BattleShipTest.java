package it.uniba.app;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BattleShipTest {
    private static final int DEFAULT_DIM = 10;
    private static final int LARGE_DIM = 18;
    private static final int EXTRA_DIM = 26;
    private int righe;
    private int colonne;

    private static final int STANDCOLERIG = 10;
    private static final int LARGCOLERIG = 18;
    private static final int EXTRALARCOLERIG = 26;
    private static char[][] tabellaPos;

    //I TEST SEGUENTI SONO MEDIANTE LA MATRICE STANDARD 10X10
    @Test
    void testConGrigliaStandardOrizValido() {
        // Test caso valido orizzontale
        final int  x = 1;
        final int  y = 3;
        final int lunghezza = 4;
        final boolean orizzontale = true;
        // Imposta la dimensione a standard
        // Inizializza la griglia
        inizializzaGrigliaStand();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertTrue(result);
    }

    @Test
    void testConGrigliaStandardVerValido() {
        // Test caso valido orizzontale
        final int x = 5;
        final int y = 2;
        final int lunghezza = 3;
        final boolean orizzontale = false;
        // Imposta la dimensione a standard
        // Inizializza la griglia
        inizializzaGrigliaStand();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertTrue(result);
    }

    @Test
    void testConGrigliaStandardOrizInvalido() {
        // Test caso non valido orizzontale
        final int x = 0;
        final int y = 9;
        final int lunghezza = 6;
        final boolean orizzontale = true;
        inizializzaGrigliaStand();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertFalse(result);
    }

    @Test
    void testConGrigliaStandardVerInvalido() {
        // Test caso non valido verticale
        final int x = 7;
        final int y = 4;
        final int lunghezza = 5;
        boolean orizzontale = false;
        inizializzaGrigliaStand();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertFalse(result);
    }



    //I TEST SEGUENTI SONO MEDIANTE LA MATRICE LARGE 18X18
    @Test
    void testConGrigliaLargOrizValido() {
        // Test caso valido orizzontale
        final int x = 2;
        final int y = 3;
        final int lunghezza = 4;
        final boolean orizzontale = true;
        // Imposta la dimensione a standard
        // Inizializza la griglia
        inizializzaGrigliaLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertTrue(result);
    }

    @Test
    void testConGrigliaLargVerValido() {
        // Test caso valido orizzontale
        final int x = 5;
        final int y = 2;
        final int lunghezza = 3;
        final boolean orizzontale = false;
        // Imposta la dimensione a standard
        // Inizializza la griglia
        inizializzaGrigliaLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertTrue(result);
    }

    @Test
    void testConGrigliaLargOrizInvalido() {
        // Test caso non valido orizzontale
        final int x = 0;
        final int y = 9;
        final int lunghezza = 6;
        final boolean orizzontale = true;
        inizializzaGrigliaLarg();
        final boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertFalse(result);
    }

    @Test
    void testConGrigliaLargVerInvalido() {
        // Test caso non valido verticale
        final int x = 7;
        final int y = 4;
        final int lunghezza = 5;
        final boolean orizzontale = false;
        inizializzaGrigliaLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertFalse(result);
    }




    //I TEST SEGUENTI SONO MEDIANTE LA MATRICE EXTRALARGE 26X26
    @Test
    void testConGrigliaExtraLarOrizValido() {
        // Test caso valido orizzontale
        final int x = 2;
        final int y = 3;
        final int lunghezza = 4;
        boolean orizzontale = true;
        // Imposta la dimensione a standard
        // Inizializza la griglia
        inizializzaGrigliaExtraLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertTrue(result);
    }

    @Test
    void testConGrigliaExtraLarVerValido() {
        // Test caso valido orizzontale
        final int x = 5;
        final int y = 2;
        final int lunghezza = 3;
        boolean orizzontale = false;
        // Imposta la dimensione a standard
        // Inizializza la griglia
        inizializzaGrigliaExtraLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertTrue(result);
    }

    @Test
    void testConGrigliaExtraLarOrizInvalido() {
        // Test caso non valido orizzontale
        final int x = 0;
        final int y = 9;
        final int lunghezza = 6;
        boolean orizzontale = true;
        inizializzaGrigliaExtraLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertFalse(result);
    }

    @Test
    void testConGrigliaExtraLarVerInvalido() {
        // Test caso non valido verticale
        final int x = 7;
        final int y = 4;
        final int lunghezza = 5;
        final boolean orizzontale = false;
        inizializzaGrigliaExtraLarg();
        boolean result = verificaPosizione(x, y, lunghezza, orizzontale);
        Assertions.assertFalse(result);
    }






    @Test
    void testCambiaDimStand() {
        final String command = "/standard";
        final int expectedColeRig = DEFAULT_DIM;
        changeDim(command);
        Assertions.assertEquals(expectedColeRig, righe);
        Assertions.assertEquals(expectedColeRig, colonne);

    }

    @Test
    void testCambiaDimStandInv() {
        final String command = "/ciao";
        final int expectedColeRig = DEFAULT_DIM;
        changeDim(command);
        Assertions.assertNotEquals(expectedColeRig, righe);
        Assertions.assertNotEquals(expectedColeRig, colonne);

    }

    @Test
    void testCambiaDimLarg() {
        final String command = "/large";
        final int expectedColeRig = LARGE_DIM;
        changeDim(command);
        Assertions.assertEquals(expectedColeRig, righe);
        Assertions.assertEquals(expectedColeRig, colonne);

    }

    @Test
    void testCambiaDimLargInv() {
        final String command = "/ciao";
        final int expectedColeRig = LARGE_DIM;
        changeDim(command);
        Assertions.assertNotEquals(expectedColeRig, righe);
        Assertions.assertNotEquals(expectedColeRig, colonne);
    }

    @Test
    void testCambiaDimExtraLarg() {
        final String command = "/extralarge";
        final int expectedColeRig = EXTRA_DIM;
        changeDim(command);
        Assertions.assertEquals(expectedColeRig, righe);
        Assertions.assertEquals(expectedColeRig, colonne);

    }
    @Test
    void testCambiaDimExtraLargInv() {
        final String command = "/aiu";
        final int expectedColeRig = EXTRA_DIM;
        changeDim(command);
        Assertions.assertNotEquals(expectedColeRig, righe);
        Assertions.assertNotEquals(expectedColeRig, colonne);
    }


    //Le funzioni sottostanti sono usate come appoggio per i casi di test

    public void changeDim(final String command) {
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




    private static boolean verificaPosizione(final int x, final int y, final int lunghezza, final boolean orizzontale) {
        if (orizzontale) {
            if (y + lunghezza > STANDCOLERIG) {
                return false;
            }

            for (int i = y; i < y + lunghezza; i++) {
                if (tabellaPos[x][i] != ' ') {
                    return false;
                }
            }
        } else {
            if (x + lunghezza > STANDCOLERIG) {
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

    public static void inizializzaGrigliaStand() {
        tabellaPos = new char[STANDCOLERIG][STANDCOLERIG];
        for (int i = 0; i < STANDCOLERIG; i++) {
            for (int j = 0; j < STANDCOLERIG; j++) {
                tabellaPos[i][j] = ' ';
            }
        }
    }

    public static void inizializzaGrigliaLarg() {
        tabellaPos = new char[LARGCOLERIG][LARGCOLERIG];
        for (int i = 0; i < LARGCOLERIG; i++) {
            for (int j = 0; j < LARGCOLERIG; j++) {
                tabellaPos[i][j] = ' ';
            }
        }
    }

    public static void inizializzaGrigliaExtraLarg() {
        tabellaPos = new char[EXTRALARCOLERIG][EXTRALARCOLERIG];
        for (int i = 0; i < EXTRALARCOLERIG; i++) {
            for (int j = 0; j < EXTRALARCOLERIG; j++) {
                tabellaPos[i][j] = ' ';
            }
        }
    }

    public static char setValue(final char x, final int r, final int c) {
        tabellaPos[r][c] = x;
        return x;
    }

    public static char getValue(final int r, final int c) {
        return tabellaPos[r][c];
    }

    public static int getRigheStand() {
        final int righe = 10;
        final int imposta = righe;
        return imposta;

    }
    public static int getColonneStand() {
        final int colonne = 10;
        final int imposta = colonne;
        return imposta;
    }

}
