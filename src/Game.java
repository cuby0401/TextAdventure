import GameMap.GameMap;
import GameMap.Position;
import GameMap.Direction;

import java.util.Map;
import java.util.Scanner;

/**
 * Die Klasse repräsentiert das Spiel.
 */
public class Game {
    public static void playGame() {
        final GameMap gameMap = new GameMap();
        final Scanner scanner = new Scanner(System.in);

        Position currentPosition = Position.B3;
        System.out.println("Du befindest dich an: " + currentPosition.getDescription());

        while (true) {
            System.out.println("Wähle eine Richtung (W: Hoch, S: Runter, A: Links, D: Rechts) oder 'exit' zum Beenden:");

            String input = scanner.nextLine();
            Direction move = Direction.fromString(input);
            Map<Direction, Position> positionMap = gameMap.getGameMap().get(currentPosition);

            //Hier muss noch ne richtige Funktion rein, dass nur J oder N verwendet werden kann
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Spiel beendet. Möchtest du erneut spielen?");
                String inputRestart = scanner.nextLine();
                if (inputRestart.equalsIgnoreCase("n")) {
                    break;
                } else if (!inputRestart.equalsIgnoreCase("j")) {
                    System.out.println("Du kannst nur J oder N verwenden.");
                }
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("""
                        Versuche es mit den Befehlen:
                        W --> oben,\n
                        A --> links,\n
                        S --> unten,\n
                        D --> rechts,\n
                        Exit --> Spiel beenden
                        """);
            } else if (move != Direction.RIGHT && move != Direction.LEFT && move != Direction.UP && move != Direction.DOWN) {
                System.out.println("Ungültige Eingabe! Falls du nicht weiter weißt, nutze 'help'");
            } else if (positionMap.containsKey(move)) {
                currentPosition = positionMap.get(move);
                if (currentPosition == Position.ZIEL) {
                    System.out.println("Herzlichen Glückwunsch, du hast Peach von Bowser befreit!");
                    break;
                } else {
                    System.out.println("Du bewegst dich nach " + move.getDescription() + " und befindest dich nun an: " + currentPosition.getDescription());
                }
            } else {
                System.out.println("Hier befindet sich ein Block, versuche eine andere Richtung!");
            }
        }
        scanner.close();
    }
    public static String inputExecution(String input) {
        return input;
    }
}