import Creature.Entity;
import GameMap.GameMap;
import GameMap.Position;
import GameMap.Direction;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Die Klasse repräsentiert das Spiel.
 */
public class Game {
    public static void playGame() {
        Position currentPositionCheep = Position.D4;
        Position currentPosition = Position.B3;
        Entity mario = new Entity(1,currentPosition);
        Entity cheepCheep = new Entity(1,currentPositionCheep);
        final GameMap gameMap = new GameMap();
        final Scanner scanner = new Scanner(System.in);

        einfuehrung();
        System.out.println("Du befindest dich an: " + currentPosition);

        for (int i = 0; i < 50; i++) {
            System.out.println("Wähle eine Richtung (W: Hoch, S: Runter, A: Links, D: Rechts) oder 'exit' zum Beenden:");

            String input = UserInput.stringInput();
            Direction move = Direction.fromString(input);
            Map<Direction, Position> positionMap = gameMap.getGameMap().get(currentPosition);

            //Hier muss noch ne richtige Funktion rein, dass nur J oder N verwendet werden kann
            if (input.equalsIgnoreCase("exit")) {
                while (true) {
                    System.out.println("Spiel beendet. Möchtest du erneut spielen?");
                        String inputRestart = UserInput.stringInput();
                        if (inputRestart.equalsIgnoreCase("n")) {
                            i = 50;
                            break;
                        } else if (inputRestart.equalsIgnoreCase("j")) {
                            break;
                        } else {
                            System.out.println("Du kannst nur J oder N verwenden.");
                        }
                }
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("""
                        Versuche es mit den Befehlen:
                        W --> Du bewegst dich nach oben,\n
                        A --> Du bewegst dich nach links,\n
                        S --> Du bewegst dich nach unten,\n
                        D --> Du bewegst dich nach rechts,\n
                        Exit --> Das Spiel wird beendet
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
            powerUpHandling(currentPosition,mario,cheepCheep);
            if (currentPosition == currentPositionCheep && cheepCheep.getHealthPoints() == 1) {
                mario.setHealthPoints(mario.getHealthPoints() - 1);
                if (mario.getHealthPoints() == 1) {
                    System.out.println("Pass auf! Du bist dem Cheep Cheep zu nahe gekommen, es hat dich getroffen! Dir bleibt nur noch ein Leben");
                } else {
                    System.out.println("Oh nein, das Cheep Cheep hat dich erwischt");
                    break;
                }
            }
        }
        scanner.close();
    }
    public static void powerUpHandling(Position currentPosition, Entity mario, Entity cheepCheep) {
        if (currentPosition == Position.D6 && mario.getHealthPoints() == 1) {
            mario.setHealthPoints(2);
            System.out.println("Du hast ein PowerUp gefunden! Deine Lebenspunkte betragen jetzt zwei.");
        }else if (currentPosition == Position.D2 && cheepCheep.getHealthPoints() == 1) {
            cheepCheep.setHealthPoints(0);
            System.out.println("Sehr gut! Du hast das Cheep Cheep kill-PowerUp gefunden!");
            System.out.println("Du hast jetzt einen freien Weg");
        }
    }
    public static void einfuehrung() {
        System.out.println("""
                Herzlich Willkommen zu diesem kleinen Super Mario Bros Unterwasser Text Adventure!
                Dieses Spiel 
                """);
    }
}