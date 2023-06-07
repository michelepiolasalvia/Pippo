package it.uniba.app;

import it.uniba.control.BattleShipManager;
import it.uniba.control.GameManager;
import it.uniba.control.TimeManager;
import it.uniba.utils.InputOutputUtils;

/**
 * Classe principale dell'applicazione.
 * In questa classe vengono gestite le
 * chiamate dei comandi da parte dell'utente
 * <i>&#60;Boundary&#62;</i>
 */
public final class App {


    /**
     * Funzione di benvenuto nell'applicazione.
     * Restituisce il messaggio
     * di benvenuto in seguito all'apertura
     * dell'applicazione
     * @return la stringa di benvenuto nel gioco
     */
    public String getGreeting() {
        return "Benvenuto nella battaglia navale per giocatore singolo.\n"
                + "La difficoltà di default è impostata a facile.";
    }

    /**
     * Entrypoint dell'applicazione.
     * Gestisce l'inserimento dei comandi da parte dell'utente
     * @param args argomenti della linea di comando
     */
    public static void main(final String[] args) {
        System.out.println(new App().getGreeting());
        String command;
        int number = -1; // Valore di default nel caso in cui non venga specificato un numero
        boolean loopMenu = true;
        boolean gioca = false;
        boolean appLoop = true;
        if (args.length > 0 && (args[0].equals("--help") || args[0].equals("-h"))) {
            InputOutputUtils.printHelp();
        }
        while (appLoop) {
            while (loopMenu) {
                String[] parts = InputOutputUtils.prendiComando().split(" ");
                command = parts[0];
                if (parts.length > 1) {
                    number = InputOutputUtils.checkNumber(parts[1]);
                }
                switch (command) {
                    case "/help" -> InputOutputUtils.printHelp();
                    case "/esci" -> {
                        if (InputOutputUtils.exit()) {
                            loopMenu = false;
                            appLoop = false;
                        }
                    }
                    case "/facile", "/medio", "/difficile" -> {
                        if (number != -1) {
                            GameManager.impostaTentativi(command, number);
                            number = -1;
                        } else {
                            GameManager.impostaLivello(command);
                        }
                    }


                    case "/mostralivello" -> InputOutputUtils.showLevel();
                    case "/mostranavi" -> InputOutputUtils.mostraNavi();
                    case "/tentativi" -> {
                        if (number != -1) {
                            GameManager.setMaxAttempts(number);
                            number = -1;
                        }
                    }

                    case "/standard", "/large", "/extralarge" -> {
                        BattleShipManager.changeDim(command);
                        System.out.println("Ok");
                    }

                    case "/tempo" -> {
                        if (number != -1) {
                            TimeManager.impostaTimer(number);
                            number = -1;
                        }
                    }

                    case "/gioca" -> {
                        loopMenu = false;
                        gioca = true;
                        BattleShipManager.inizializzaGriglia();
                        InputOutputUtils.stampaGriglia("Svela");
                        BattleShipManager.piazzaNavi();
                        GameManager.resetTutteAffondate();
                    }
                    default -> { }
                }
            }

            if (gioca) {
                InputOutputUtils.startGame();
                TimeManager.iniziaTimer();
            }
            while (gioca) {
                if (!TimeManager.giocoAttivo()) {
                    InputOutputUtils.endGame("Tempo");
                    gioca = false;
                    loopMenu = true;
                    break;
                }

                if (GameManager.tentativiFiniti()) {
                    InputOutputUtils.endGame("Tentativi");
                    gioca = false;
                    loopMenu = true;
                    command = " ";
                    TimeManager.bloccaTimer();
                    break;
                }

                if (GameManager.checkNaviAffondate()) {
                    InputOutputUtils.endGame("Navi");
                    gioca = false;
                    loopMenu = true;
                    command = " ";
                    TimeManager.bloccaTimer();
                    break;
                }

                command = InputOutputUtils.prendiComando();
                switch (command) {
                    case "/help" -> InputOutputUtils.printHelp();
                    case "/esci" -> {
                        if (InputOutputUtils.exit()) {
                            gioca = false;
                            appLoop = false;
                            TimeManager.bloccaTimer();
                        }
                    }
                    case "/mostralivello" -> InputOutputUtils.showLevel();
                    case "/mostranavi" -> InputOutputUtils.mostraNavi();
                    case "/svelagriglia" -> InputOutputUtils.stampaGriglia("Svela");
                    case "/mostratempo" -> TimeManager.mostraTempo();
                    case "/mostragriglia" -> InputOutputUtils.stampaGriglia("Mostra");
                    case "/mostratentativi" -> InputOutputUtils.stampaTentativi();
                    case "/abbandona" -> {
                        if (InputOutputUtils.exit()) {
                            loopMenu = true;
                            gioca = false;
                            InputOutputUtils.stampaGriglia("Svela");
                        }
                    }


                    default -> System.out.println(" ");
                }
                command = command.toUpperCase();
                if (command.matches("[A-Z]-([1-9]|1[0-9]|2[0-6])")) {
                    GameManager.colpo(command);
                }
            }
        }
    }
}
