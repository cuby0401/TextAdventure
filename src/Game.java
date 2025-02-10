import GameMap.GameMap;
import GameMap.Position;
import GameMap.Direction;

import java.util.Map;
import java.util.Scanner;

public class Game {
    public static void playGame() {
        GameMap gameMap = new GameMap();
        Scanner scanner = new Scanner(System.in);

        Position beginningPosition = Position.B3;
        Position currentPosition =beginningPosition;
        System.out.println("Du befindest dich an: " + currentPosition.getDescription());

        while (true) {
            System.out.println("Wähle eine Richtung (W: Hoch, S: Runter, A: Links, D: Rechts) oder 'exit' zum Beenden:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Spiel beendet.");
                break;
            }

            Direction move = Direction.fromString(input);
            if (move != Direction.RIGHT && move != Direction.LEFT && move != Direction.UP && move != Direction.DOWN) {
                System.out.println("Ungültige Eingabe! Falls du nicht weiter weißt, nutze 'help'");
                continue;
            }

            Map<Direction, Position> positionMap = gameMap.getGameMap().get(currentPosition);
            if (positionMap.containsKey(move)) {
                currentPosition = positionMap.get(move);
                if (currentPosition == Position.ZIEL) {
                    System.out.println("Herzlichen Glückwunsch, du hast Peach von Bowser befreit!");
                    break;
                } else {
                    System.out.println("Du bewegst dich nach " + move + " und befindest dich nun an: " + currentPosition.getDescription());
                }
            } else {
                System.out.println("Hier befindet sich ein Block, versuche eine andere Richtung!");
            }
        }
        scanner.close();
    }
}