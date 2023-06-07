package it.uniba.control;

import it.uniba.utils.InputOutputUtils;

/**
 * Classe GameManager dell'applicazione.
 * Utilizzata per gestire le funzionalità
 * e regolare una partita
 * <i>&#60;Control&#62;</i>
 */
public final class GameManager {

    //COSTANTI DI DEFAULT
    /**
     * Tentativi di default per la difficoltà facile.
     */
    private static final int MAX_FACILE = 50;
    /**
     * Tentativi di default per la difficoltà media.
     */
    private static final int MAX_MEDIO = 30;
    /**
     * Tentativi di default per la difficoltà difficile.
     */
    private static final  int MAX_DIFFICILE = 10;

    //VARIABILI PER I TENTATIVI, MODIFICABILI
    /**
     * Tentativi difficoltà media.
     */
    private static int tentativiMedio = MAX_MEDIO;
    /**
     * Tentativi difficoltà facile.
     */
    private static int tentativiFacile = MAX_FACILE;
    /**
     * Tentativi difficoltà difficile.
     */
    private static int tentativiDifficile = MAX_DIFFICILE;
    /**
     * Tentativi effettuati durante la partita.
     */
    private static int tentativiEffettuati = 0;
    /**
     * Tentativi sbagliati durante la partita.
     */
    private static int tentativiSbagliati = 0;
    /**
     * Stringa che indica la difficoltà della partita.
     */
    private static String difficolta = "facile";
    /**
     * Variabile booleana che indica se tutte le navi sono state affondate.
     */
    private static boolean tutteAffondate = false;


    /**
     * Variabile che indica il numero di tentativi massimi falliti nel gioco.
     */
    private static int maxAttempts = tentativiFacile;


    /**
     * Costruttore della classe GameManager.
     */
    private GameManager() {

    }

    /**
     * Funzione che imposta il livello di difficoltà.
     * @param comando Comando che indica la difficoltà scelta dall'utente
     */
    public static void impostaLivello(final String comando) {
        switch (comando) {
            case "/facile" -> {
                maxAttempts = tentativiFacile;
                InputOutputUtils.printCasiSetDiff("Facile");
                difficolta = "facile";
            }
            case "/medio" -> {
                maxAttempts = tentativiMedio;
                InputOutputUtils.printCasiSetDiff("Media");
                difficolta = "media";
            }
            case "/difficile" -> {
                maxAttempts = tentativiDifficile;
                InputOutputUtils.printCasiSetDiff("Diff");
                difficolta = "difficile";
            }
            default -> InputOutputUtils.printCasiSetDiff("NA");
        }
    }

    /**
     * Procedura che modifica il numero max di tentativi falliti.
     * Imposta un un nuovo numero di tentativi, in base al comando di difficoltà scelto
     * @param command comando corrispondente alla difficoltà inserito in input nel main
     * @param numero numero di tentativi che si vogliono impostare per la difficoltà scelta
     */
    public static void impostaTentativi(final String command, final int numero) {
        switch (command) {
            case "/facile" -> {
                if (maxAttempts == tentativiFacile) {
                    maxAttempts = numero;
                }
                tentativiFacile = numero;
                System.out.println("Ok");
            }
            case "/medio" -> {
                if (maxAttempts == tentativiMedio) {
                    maxAttempts = numero;
                }
                tentativiMedio = numero;
                System.out.println("Ok");
            }
            case "/difficile" -> {
                if (maxAttempts == tentativiDifficile) {
                    maxAttempts = numero;
                }
                tentativiDifficile = numero;
                System.out.println("Ok");
            }

            default  -> { }
        }
    }

    /**
     * Permette di impostare il numero massimo di tentativi falliti.
     * @param numero nuovo numero massimo di tentativi falliti
     */
    public static void setMaxAttempts(final int numero) {
        maxAttempts = numero;
        System.out.println("OK");
    }


    /**
     * Funzione Colpo.
     * Riceve in input un comando che indica una cella,
     * Verifica se la cella rientra nella dimensione scelta della griglia.
     * Se rientra allora controlla la griglia e prova a colpire la cella.
     *
     * @param input Stringa che indica la cella che si vuole colpire
     */
    public static void colpo(final String input) {
        int x = 0;
        int y = 0;
        final int grigliaS = 10;
        final int grigliaL = 18;
        final int grigliaXL = 26;
        tentativiEffettuati++;
        RisultatoSparo risultato = null;

        if (BattleShipManager.getRighe() == grigliaS) {
            if (input.matches("[A-J]-(10|[1-9])")) {
                String[] parts = input.split("-");
                x = Integer.parseInt(parts[1]) - 1;
                y = parts[0].charAt(0) - 'A';
                risultato = esitoSparo(x, y);
            }
        } else if (BattleShipManager.getRighe() == grigliaL) {
            if (input.matches("[A-R]-([1-9]|1[0-8])")) {
                String[] parts = input.split("-");
                x = Integer.parseInt(parts[1]) - 1;
                y = parts[0].charAt(0) - 'A';
                risultato = esitoSparo(x, y);
            }
        } else if (BattleShipManager.getRighe() == grigliaXL) {
            if (input.matches("[A-Z]-([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-6])")) {
                String[] parts = input.split("-");
                x = Integer.parseInt(parts[1]) - 1;
                y = parts[0].charAt(0) - 'A';
                risultato = esitoSparo(x, y);
            }
        }
        if (risultato != null) {
            switch (risultato) {
                case ACQUA:
                    InputOutputUtils.printCasiSparo("A");
                    BattleShipManager.setValue(x, y, '~'); //simbolo ondina
                    tentativiSbagliati++;
                    break;

                case COLPITO:
                    InputOutputUtils.printCasiSparo("C");
                    BattleShipManager.setValue(x, y, 'X');
                    break;

                case COLPITO_E_AFFONDATO:
                    InputOutputUtils.printCasiSparo("CA");
                    BattleShipManager.setValue(x, y, 'X');
                    break;

                case GIACOLPITO:
                    InputOutputUtils.printCasiSparo("GC");
                    tentativiEffettuati--;
                    break;

                default:
                    InputOutputUtils.printCasiSparo("NA");
            }
        }

        InputOutputUtils.stampaTentativiEffettuati();
        InputOutputUtils.stampaGriglia("Mostra");
        InputOutputUtils.leggiTempoTrascorso();

        if (risultato == RisultatoSparo.COLPITO_E_AFFONDATO) {
            tutteAffondate = true;
            for (int i = 0; i < BattleShipManager.getRighe(); i++) {
                for (int j = 0; j < BattleShipManager.getColonne(); j++) {
                    if (BattleShipManager.getValue(i, j) != ' ' && BattleShipManager.getValue(i, j) != 'X'
                            && BattleShipManager.getValue(i, j) != '~') {
                        tutteAffondate = false;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Funzione EsitoSparo.
     * Riceve in input le coordinate di una cella e tramite dei controlli
     * verifica l'esito del colpo.
     * @param x intero che indica la riga che si vuole colpire
     * @param y intero che indica la colonna che si vuole colpire
     * @return Restituisce l'esito del colpo sulla cella ricevuta in input
     */
    private static RisultatoSparo esitoSparo(final int x, final int y) {
        if (BattleShipManager.getValue(x, y) == ' ') {
            return RisultatoSparo.ACQUA;
        } else if (BattleShipManager.getValue(x, y) != 'X' && BattleShipManager.getValue(x, y) != '\u007E') {
            char simboloNave = BattleShipManager.getValue(x, y);
            boolean affondato = true;

            for (int i = 0; i < BattleShipManager.getRighe(); i++) {
                for (int j = 0; j < BattleShipManager.getColonne(); j++) {
                    if (BattleShipManager.getValue(i, j) == simboloNave && (i != x || j != y)) {
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

    /**
     * Funzione tentativiFiniti.
     * @return true se i tentativi disponibili sono finiti, false altrimenti
     */
    public static boolean tentativiFiniti() {
        return tentativiSbagliati > maxAttempts;
    }

    /**
     * Funzione checkNaviAffondate.
     * @return true se tutte le navi sono state affondate
     */
    public static boolean checkNaviAffondate() {
        return tutteAffondate;
    }

    /**
     * Funzione resetTutteAffondate.
     * All'inizio di ogni partita setta tutteAffondate a false,
     * in quanto potrebbe rimanere impostato il valore a true dopo aver
     * vinto una partita precedente.
     */
    public static void resetTutteAffondate() {
        tutteAffondate = false;
    }

    /**
     * Funzione getTentativiEffettuati.
     * @return numero di tentativi effettuati
     */
    public static int getTentativiEffettuati() {
        return tentativiEffettuati;
    }

    /**
     * Funzione getTentativiSbagliati.
     * @return numero di tentativi effettuati
     */
    public static int getTentativiSbagliati() {
        return tentativiSbagliati;
    }

    /**
     * Funzione getMaxAttempts.
     * @return numero massimo di tentativi falliti disponibili
     */
    public static int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Funzione getDifficolta.
     * @return la difficoltà del gioco
     */
    public static String getDifficolta() {
        return difficolta;
    }


}

