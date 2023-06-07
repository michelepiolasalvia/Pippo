package it.uniba.app;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class GameManagerTest {
    private String difficolta;
    private int maxAttempts;
    private int tentativiFacile;
    private int tentativiMedio;
    private int tentativiDifficile;
    @Test
    void testImpostaLivelloFacile() {
        difficolta = " ";
        final String stringa = "/facile";
        impostaLivello(stringa);
        Assertions.assertEquals("facile", difficolta);
    }

    @Test
    void testImpostaLivelloMedio() {
        difficolta = " ";
        final String stringa = "/medio";
        impostaLivello(stringa);
        Assertions.assertEquals("media", difficolta);
    }
    @Test
    void testImpostaLivelloDifficile() {
        difficolta = " ";
        final String stringa = "/difficile";
        impostaLivello(stringa);
        Assertions.assertEquals("difficile", difficolta);
    }

    @Test
    void testImpostaLivelloSbagliato() {
        difficolta = " ";
        final String stringa = "/ciao";
        impostaLivello(stringa);
        Assertions.assertNotEquals("facile", difficolta);
        Assertions.assertNotEquals("media", difficolta);
        Assertions.assertNotEquals("difficile", difficolta);

    }


    @Test
    void testImpostaTentativiFacile() {
        final String stringa = "/facile";
        final int x = 5;
        impostaTentativi(stringa, x);
        Assertions.assertEquals(x, maxAttempts);
    }

    @Test
    void testImpostaTentativiMedio() {
        final String stringa = "/medio";
        final int x = 10;
        impostaTentativi(stringa, x);
        Assertions.assertEquals(x, maxAttempts);
    }

    @Test
    void testImpostaTentativiDifficile() {
        final String stringa = "/difficile";
        final int x = 5;
        impostaTentativi(stringa, x);
        Assertions.assertEquals(x, maxAttempts);
    }

    @Test
    void testImpostaTentativiSbagliato() {
        final String stringa = "/ciao";
        final int x = 76;
        impostaTentativi(stringa, x);
        Assertions.assertNotEquals(x, maxAttempts);
    }

    @Test
    void testColpito() {
       String stringa = "A-1";
       final int x;
       final int y;
       String[] parti = stringa.split("-");
       x = Integer.parseInt(parti[1]) - 1;
       y = parti[0].charAt(0) - 'A';
       BattleShipTest.inizializzaGrigliaStand();
       BattleShipTest.setValue('\u25A0', 0, 0);
       BattleShipTest.setValue('\u25A0', 1, 0);
       RisultatoSparo expectedOutput = RisultatoSparo.valueOf("COLPITO");
       RisultatoSparo output = esitoSparo(x, y);
       Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void testColpitoEaffondato() {
        String stringa = "A-1";
        final int x;
        final int y;
        String[] parti = stringa.split("-");
        x = Integer.parseInt(parti[1]) - 1;
        y = parti[0].charAt(0) - 'A';
        BattleShipTest.inizializzaGrigliaStand();
        BattleShipTest.setValue('\u25A0', 0, 0);
        RisultatoSparo expectedOutput = RisultatoSparo.valueOf("COLPITO_E_AFFONDATO");
        RisultatoSparo output = esitoSparo(x, y);
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void testAcqua() {
        String stringa = "A-1";
        final int x;
        final int y;
        String[] parti = stringa.split("-");
        x = Integer.parseInt(parti[1]) - 1;
        y = parti[0].charAt(0) - 'A';
        BattleShipTest.inizializzaGrigliaStand();
        BattleShipTest.setValue('\u25A0', 1, 1);
        RisultatoSparo expectedOutput = RisultatoSparo.valueOf("ACQUA");
        RisultatoSparo output = esitoSparo(x, y);
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void testGiaColpito() {
        String stringa = "A-1";
        final int x;
        final int y;
        String[] parti = stringa.split("-");
        x = Integer.parseInt(parti[1]) - 1;
        y = parti[0].charAt(0) - 'A';
        BattleShipTest.inizializzaGrigliaStand();
        BattleShipTest.setValue('X', 0, 0);
        RisultatoSparo expectedOutput = RisultatoSparo.valueOf("GIACOLPITO");
        RisultatoSparo output = esitoSparo(x, y);
        Assertions.assertEquals(expectedOutput, output);
    }

    private static RisultatoSparo esitoSparo(final int x, final int y) {
        if (BattleShipTest.getValue(x, y) == ' ') {
            return RisultatoSparo.ACQUA;
        } else if (BattleShipTest.getValue(x, y) != 'X' && BattleShipTest.getValue(x, y) != '\u007E') {
            char simboloNave = BattleShipTest.getValue(x, y);
            boolean affondato = true;

            for (int i = 0; i < BattleShipTest.getRigheStand(); i++) {
                for (int j = 0; j < BattleShipTest.getColonneStand(); j++) {
                    if (BattleShipTest.getValue(i, j) == simboloNave && (i != x || j != y)) {
                        affondato = false;
                        break;
                    }
                }
            }

            if (affondato) {
                return RisultatoSparo.COLPITO_E_AFFONDATO;
            } else {
                return RisultatoSparo.COLPITO;
            }
        } else {
            return RisultatoSparo.GIACOLPITO;
        }
    }

    /**
     * Enumerazione RisultatoSparo.
     * Rappresenta tutti i possibili esiti di uno sparo
     * in una cella
     */
    private enum RisultatoSparo {
        ACQUA,
        COLPITO,
        COLPITO_E_AFFONDATO,
        GIACOLPITO
    }
    private void impostaTentativi(final String command, final int numero) {
        switch (command) {
            case "/facile" -> {
                if (maxAttempts == tentativiFacile) {
                    maxAttempts = numero;
                }
                tentativiFacile = numero;
            }
            case "/medio" -> {
                if (maxAttempts == tentativiMedio) {
                    maxAttempts = numero;
                }
                tentativiMedio = numero;
            }
            case "/difficile" -> {
                if (maxAttempts == tentativiDifficile) {
                    maxAttempts = numero;
                }
                tentativiDifficile = numero;
            }

            default  -> { }
        }
    }









    private void impostaLivello(final String comando) {
        switch (comando) {
            case "/facile" -> {
                difficolta = "facile";
            }
            case "/medio" -> {
                difficolta = "media";
            }
            case "/difficile" -> {
                difficolta = "difficile";
            }
            default -> { }
        }
    }
}
