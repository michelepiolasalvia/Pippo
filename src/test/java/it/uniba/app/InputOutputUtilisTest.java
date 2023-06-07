package it.uniba.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

class InputOutputUtilisTest {

    private static final int STANDCOLERIG = 10;
    private static final int LARGCOLERIG = 18;
    private static final int EXTRALARCOLERIG = 26;
    @Test
    void testStampaGrigliaPerStandardSvelaMenu() {
        final String menu = "Svela";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J       \n"
                        + " 1                         \n"
                        + " 2                         \n"
                        + " 3                         \n"
                        + " 4                         \n"
                        + " 5                         \n"
                        + " 6                         \n"
                        + " 7                         \n"
                        + " 8                         \n"
                        + " 9                         \n"
                        + "10                         \n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8)) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaStand();
            stampaGrigliaPerStandard(menu);
            String actualOutput = outputStream.toString(StandardCharsets.UTF_8);
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testStampaGrigliaPerStandardMostraMenu() {
        final String menu = "Mostra";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J       \n"
                        + " 1                         \n"
                        + " 2                         \n"
                        + " 3                         \n"
                        + " 4                         \n"
                        + " 5                         \n"
                        + " 6                         \n"
                        + " 7                         \n"
                        + " 8                         \n"
                        + " 9                         \n"
                        + "10                         \n";
        PrintStream originalOut = System.out;
        String actualOutput;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8)) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaStand();
            stampaGrigliaPerStandard(menu);
            actualOutput = outputStream.toString(StandardCharsets.UTF_8);
        } finally {
            System.setOut(originalOut);  // Ripristino di System.out
        }

        expectedOutput = expectedOutput.replaceAll("\\s", "");
        actualOutput = actualOutput.replaceAll("\\s", "");
        Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
    }

    @Test
    void testStampaGrigliaPerStandardErratoSvelaMenu() {
        // Stringa errata
        final String menu = "Pippo";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J        \n"
                        + " 1                         \n"
                        + " 2                         \n"
                        + " 3                         \n"
                        + " 4                         \n"
                        + " 5                         \n"
                        + " 6                         \n"
                        + " 7                         \n"
                        + " 8                         \n"
                        + " 9                         \n"
                        + "10                         \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaStand();
            stampaGrigliaPerStandard(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertNotEquals(expectedOutput.trim(), actualOutput.trim());
        } catch (UnsupportedEncodingException e) {
            // Gestione dell'eccezione
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testStampaGrigliaPerStandardErratoMostraMenu() {
        // Stringa errata
        final String menu = "Ciao";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J       \n"
                        + " 1                         \n"
                        + " 2                         \n"
                        + " 3                         \n"
                        + " 4                         \n"
                        + " 5                         \n"
                        + " 6                         \n"
                        + " 7                         \n"
                        + " 8                         \n"
                        + " 9                         \n"
                        + "10                         \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaStand();
            stampaGrigliaPerStandard(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertNotEquals(expectedOutput.trim(), actualOutput.trim());
        } catch (UnsupportedEncodingException e) {
            // Gestione dell'eccezione
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
        }
    }




    @Test
    void testStampaGrigliaPerLargeSvelaMenu() {
        final String menu = "Svela";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  \n"
                        + " 1                                                  \n"
                        + " 2                                                  \n"
                        + " 3                                                  \n"
                        + " 4                                                  \n"
                        + " 5                                                  \n"
                        + " 6                                                  \n"
                        + " 7                                                  \n"
                        + " 8                                                  \n"
                        + " 9                                                  \n"
                        + "10                                                  \n"
                        + "11                                                  \n"
                        + "12                                                  \n"
                        + "13                                                  \n"
                        + "14                                                  \n"
                        + "15                                                  \n"
                        + "16                                                  \n"
                        + "17                                                  \n"
                        + "18                                                  \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaLarg();
            stampaGrigliaPerLarge(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
        } catch (UnsupportedEncodingException e) {
            // Gestione dell'eccezione
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testStampaGrigliaPerLargeMostraMenu() {
        final String menu = "Mostra";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  \n"
                        + " 1                                                  \n"
                        + " 2                                                  \n"
                        + " 3                                                  \n"
                        + " 4                                                  \n"
                        + " 5                                                  \n"
                        + " 6                                                  \n"
                        + " 7                                                  \n"
                        + " 8                                                  \n"
                        + " 9                                                  \n"
                        + "10                                                  \n"
                        + "11                                                  \n"
                        + "12                                                  \n"
                        + "13                                                  \n"
                        + "14                                                  \n"
                        + "15                                                  \n"
                        + "16                                                  \n"
                        + "17                                                  \n"
                        + "18                                                  \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8)) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaLarg();
            stampaGrigliaPerLarge(menu);
            String actualOutput = outputStream.toString(StandardCharsets.UTF_8);
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testStampaGrigliaPerLargeErratoSvelaMenu() {
        // stringa errata
        final String menu = "Ciao";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  \n"
                        + " 1                                                  \n"
                        + " 2                                                  \n"
                        + " 3                                                  \n"
                        + " 4                                                  \n"
                        + " 5                                                  \n"
                        + " 6                                                  \n"
                        + " 7                                                  \n"
                        + " 8                                                  \n"
                        + " 9                                                  \n"
                        + "10                                                  \n"
                        + "11                                                  \n"
                        + "12                                                  \n"
                        + "13                                                  \n"
                        + "14                                                  \n"
                        + "15                                                  \n"
                        + "16                                                  \n"
                        + "17                                                  \n"
                        + "18                                                  \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8)) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaLarg();
            stampaGrigliaPerLarge(menu);
            String actualOutput = outputStream.toString(StandardCharsets.UTF_8);
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertNotEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }


    @Test
    void testStampaGrigliaPerLargeErratoMostraMenu() throws UnsupportedEncodingException {
        // stringa errata
        final String menu = "Mimmo";
        String expectedOutput =
                " A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  \n"
                        + " 1                                                  \n"
                        + " 2                                                  \n"
                        + " 3                                                  \n"
                        + " 4                                                  \n"
                        + " 5                                                  \n"
                        + " 6                                                  \n"
                        + " 7                                                  \n"
                        + " 8                                                  \n"
                        + " 9                                                  \n"
                        + "10                                                  \n"
                        + "11                                                  \n"
                        + "12                                                  \n"
                        + "13                                                  \n"
                        + "14                                                  \n"
                        + "15                                                  \n"
                        + "16                                                  \n"
                        + "17                                                  \n"
                        + "18                                                  \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaLarg();
            stampaGrigliaPerLarge(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertNotEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }




    @Test
    void testStampaGrigliaPerExtraLargeSvelaMenu() throws UnsupportedEncodingException {
        final String menu = "Svela";
        String expectedOutput =
                "   A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z\n"
                        + " 1                                                                        \n"
                        + " 2                                                                        \n"
                        + " 3                                                                        \n"
                        + " 4                                                                        \n"
                        + " 5                                                                        \n"
                        + " 6                                                                        \n"
                        + " 7                                                                        \n"
                        + " 8                                                                        \n"
                        + " 9                                                                        \n"
                        + "10                                                                        \n"
                        + "11                                                                        \n"
                        + "12                                                                        \n"
                        + "13                                                                        \n"
                        + "14                                                                        \n"
                        + "15                                                                        \n"
                        + "16                                                                        \n"
                        + "17                                                                        \n"
                        + "18                                                                        \n"
                        + "19                                                                        \n"
                        + "20                                                                        \n"
                        + "21                                                                        \n"
                        + "22                                                                        \n"
                        + "23                                                                        \n"
                        + "24                                                                        \n"
                        + "25                                                                        \n"
                        + "26                                                                        \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaExtraLarg();
            stampaGrigliaPerExtraLarge(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }



    @Test
    void testStampaGrigliaPerExtraLargeMostraMenu() throws UnsupportedEncodingException {
        final String menu = "Mostra";
        String expectedOutput =
                "   A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z\n"
                        + " 1                                                                        \n"
                        + " 2                                                                        \n"
                        + " 3                                                                        \n"
                        + " 4                                                                        \n"
                        + " 5                                                                        \n"
                        + " 6                                                                        \n"
                        + " 7                                                                        \n"
                        + " 8                                                                        \n"
                        + " 9                                                                        \n"
                        + "10                                                                        \n"
                        + "11                                                                        \n"
                        + "12                                                                        \n"
                        + "13                                                                        \n"
                        + "14                                                                        \n"
                        + "15                                                                        \n"
                        + "16                                                                        \n"
                        + "17                                                                        \n"
                        + "18                                                                        \n"
                        + "19                                                                        \n"
                        + "20                                                                        \n"
                        + "21                                                                        \n"
                        + "22                                                                        \n"
                        + "23                                                                        \n"
                        + "24                                                                        \n"
                        + "25                                                                        \n"
                        + "26                                                                        \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaExtraLarg();
            stampaGrigliaPerExtraLarge(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }



    @Test
    void testStampaGrigliaPerExtraLargeErratoSvelaMenu() throws UnsupportedEncodingException {
        final String menu = "OP";
        String expectedOutput =
                "   A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z\n"
                        + " 1                                                                        \n"
                        + " 2                                                                        \n"
                        + " 3                                                                        \n"
                        + " 4                                                                        \n"
                        + " 5                                                                        \n"
                        + " 6                                                                        \n"
                        + " 7                                                                        \n"
                        + " 8                                                                        \n"
                        + " 9                                                                        \n"
                        + "10                                                                        \n"
                        + "11                                                                        \n"
                        + "12                                                                        \n"
                        + "13                                                                        \n"
                        + "14                                                                        \n"
                        + "15                                                                        \n"
                        + "16                                                                        \n"
                        + "17                                                                        \n"
                        + "18                                                                        \n"
                        + "19                                                                        \n"
                        + "20                                                                        \n"
                        + "21                                                                        \n"
                        + "22                                                                        \n"
                        + "23                                                                        \n"
                        + "24                                                                        \n"
                        + "25                                                                        \n"
                        + "26                                                                        \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);
            BattleShipTest.inizializzaGrigliaExtraLarg();
            stampaGrigliaPerExtraLarge(menu);
            String actualOutput = outputStream.toString("UTF-8");
            expectedOutput = expectedOutput.replaceAll("\\s", "");
            actualOutput = actualOutput.replaceAll("\\s", "");
            Assertions.assertNotEquals(expectedOutput.trim(), actualOutput.trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testStampaGrigliaPerExtraLargeErratoMostraMenu() throws UnsupportedEncodingException {
        final String menu = "IP";
        String expectedOutput =
                "   A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z\n"
                        + " 1                                                                        \n"
                        + " 2                                                                        \n"
                        + " 3                                                                        \n"
                        + " 4                                                                        \n"
                        + " 5                                                                        \n"
                        + " 6                                                                        \n"
                        + " 7                                                                        \n"
                        + " 8                                                                        \n"
                        + " 9                                                                        \n"
                        + "10                                                                        \n"
                        + "11                                                                        \n"
                        + "12                                                                        \n"
                        + "13                                                                        \n"
                        + "14                                                                        \n"
                        + "15                                                                        \n"
                        + "16                                                                        \n"
                        + "17                                                                        \n"
                        + "18                                                                        \n"
                        + "19                                                                        \n"
                        + "20                                                                        \n"
                        + "21                                                                        \n"
                        + "22                                                                        \n"
                        + "23                                                                        \n"
                        + "24                                                                        \n"
                        + "25                                                                        \n"
                        + "26                                                                        \n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream, true, "UTF-8")); // Imposta l'encoding su UTF-8
        BattleShipTest.inizializzaGrigliaExtraLarg();
        stampaGrigliaPerExtraLarge(menu);
        System.setOut(originalOut);
        String actualOutput = outputStream.toString("UTF-8"); //Specifica l'encoding UTF-8 per la conversione in stringa
        expectedOutput = expectedOutput.replaceAll("\\s", "");
        actualOutput = actualOutput.replaceAll("\\s", "");
        Assertions.assertNotEquals(expectedOutput.trim(), actualOutput.trim());
    }

    public static void stampaGrigliaPerStandard(final String menu) {
          /*Questo blocco di codice imposta il carattere di encoding del flusso di output standard a UTF-8,
            in modo che i caratteri unicode possano essere correttamente visualizzati sulla console.

            In particolare, System.out è il flusso di output standard,
            che viene sovrascritto con un nuovo PrintStream che ha come carattere di encoding UTF-8.

            Il secondo parametro true indica che il flusso di output viene pulito
            automaticamente ogni volta che viene utilizzato il metodo println. */
        PrintStream stdout = System.out;
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (menu.equals("Svela")) {
            System.out.printf("%2s", " ");
            for (int i = 0; i < STANDCOLERIG; i++) {
                System.out.printf("%3s", (char) ('A' + i));
            }
            System.out.println();

            for (int i = 0; i < STANDCOLERIG; i++) {
                System.out.printf("%2d", (i + 1));
                for (int j = 0; j < STANDCOLERIG; j++) {
                    char cell = BattleShipTest.getValue(i, j);
                    if (cell == '\u0000' || cell == ' ' || cell == '~') {
                        System.out.printf("%3s", " ");
                    } else {
                        System.out.printf("%3c", '\u25A0');
                    }
                }
                System.out.println();
            }
        } else if (menu.equals("Mostra")) {
            System.out.printf("%2s", " ");
            for (int i = 0; i < STANDCOLERIG; i++) {
                System.out.printf("%3s", (char) ('A' + i));
            }
            System.out.println();
            for (int i = 0; i < STANDCOLERIG; i++) {
                System.out.printf("%2d", (i + 1));
                for (int j = 0; j < STANDCOLERIG; j++) {
                    char cell = BattleShipTest.getValue(i, j);
                    if (cell == '\u0000' || cell == ' ' || cell == 'X' || cell == '~') {
                        System.out.printf("%3s", cell);
                    } else {
                        System.out.printf("%3c", ' ');
                    }
                }
                System.out.println();
            }
        }
        System.setOut(stdout);  // Reimposta il flusso di output al suo valore originale
    }

    public static void stampaGrigliaPerLarge(final String menu) {
          /*Questo blocco di codice imposta il carattere di encoding del flusso di output standard a UTF-8,
            in modo che i caratteri unicode possano essere correttamente visualizzati sulla console.

            In particolare, System.out è il flusso di output standard,
            che viene sovrascritto con un nuovo PrintStream che ha come carattere di encoding UTF-8.

            Il secondo parametro true indica che il flusso di output viene pulito
            automaticamente ogni volta che viene utilizzato il metodo println. */
        PrintStream stdout = System.out;
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (menu.equals("Svela")) {
            System.out.printf("%2s", " ");
            for (int i = 0; i < LARGCOLERIG; i++) {
                System.out.printf("%3s", (char) ('A' + i));
            }
            System.out.println();

            for (int i = 0; i < LARGCOLERIG; i++) {
                System.out.printf("%2d", (i + 1));
                for (int j = 0; j < LARGCOLERIG; j++) {
                    char cell = BattleShipTest.getValue(i, j);
                    if (cell == '\u0000' || cell == ' ' || cell == '~') {
                        System.out.printf("%3s", " ");
                    } else {
                        System.out.printf("%3c", '\u25A0');
                    }
                }
                System.out.println();
            }
        } else if (menu.equals("Mostra")) {
            System.out.printf("%2s", " ");
            for (int i = 0; i < LARGCOLERIG; i++) {
                System.out.printf("%3s", (char) ('A' + i));
            }
            System.out.println();
            for (int i = 0; i < LARGCOLERIG; i++) {
                System.out.printf("%2d", (i + 1));
                for (int j = 0; j < LARGCOLERIG; j++) {
                    char cell = BattleShipTest.getValue(i, j);
                    if (cell == '\u0000' || cell == ' ' || cell == 'X' || cell == '~') {
                        System.out.printf("%3s", cell);
                    } else {
                        System.out.printf("%3c", ' ');
                    }
                }
                System.out.println();
            }
        }
        System.setOut(stdout);  // Reimposta il flusso di output al suo valore originale
    }

    public static void stampaGrigliaPerExtraLarge(final String menu) {
          /*Questo blocco di codice imposta il carattere di encoding del flusso di output standard a UTF-8,
            in modo che i caratteri unicode possano essere correttamente visualizzati sulla console.

            In particolare, System.out è il flusso di output standard,
            che viene sovrascritto con un nuovo PrintStream che ha come carattere di encoding UTF-8.

            Il secondo parametro true indica che il flusso di output viene pulito
            automaticamente ogni volta che viene utilizzato il metodo println. */
        PrintStream stdout = System.out;
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (menu.equals("Svela")) {
            System.out.printf("%2s", " ");
            for (int i = 0; i < EXTRALARCOLERIG; i++) {
                System.out.printf("%3s", (char) ('A' + i));
            }
            System.out.println();

            for (int i = 0; i < EXTRALARCOLERIG; i++) {
                System.out.printf("%2d", (i + 1));
                for (int j = 0; j < EXTRALARCOLERIG; j++) {
                    char cell = BattleShipTest.getValue(i, j);
                    if (cell == '\u0000' || cell == ' ' || cell == '~') {
                        System.out.printf("%3s", " ");
                    } else {
                        System.out.printf("%3c", '\u25A0');
                    }
                }
                System.out.println();
            }
        } else if (menu.equals("Mostra")) {
            System.out.printf("%2s", " ");
            for (int i = 0; i < EXTRALARCOLERIG; i++) {
                System.out.printf("%3s", (char) ('A' + i));
            }
            System.out.println();
            for (int i = 0; i < EXTRALARCOLERIG; i++) {
                System.out.printf("%2d", (i + 1));
                for (int j = 0; j < EXTRALARCOLERIG; j++) {
                    char cell = BattleShipTest.getValue(i, j);
                    if (cell == '\u0000' || cell == ' ' || cell == 'X' || cell == '~') {
                        System.out.printf("%3s", cell);
                    } else {
                        System.out.printf("%3c", ' ');
                    }
                }
                System.out.println();
            }
        }
        System.setOut(stdout);  // Reimposta il flusso di output al suo valore originale
    }

}
