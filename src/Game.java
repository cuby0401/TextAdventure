import game_individual.Entity;

import game_map.GameMap;
import game_map.Position;
import game_map.Direction;

import game_save.Loader;
import game_save.Saver;

import java.util.Map;

/**
 * Die Klasse repräsentiert das Spiel.
 */
public class Game {
    public static void playGame() {
        Entity mario = new Entity(1, Position.B3);
        Entity cheepCheep = new Entity(1, Position.D4);
        Position currentPositionCheep = cheepCheep.getPosition();
        Position currentPosition = mario.getPosition();
        Position previousPosition = currentPosition;
        //Saver saver = new Saver();
        //Loader loader = new Loader();
        //loader.loadGame(cheepCheep,mario);
        final GameMap gameMap = new GameMap();

        gameMenu();
        einleitenderText();
        System.out.println(currentPosition.getDescription());

        final int MAX_MOVES = 30;
        for (int i = 0; i < MAX_MOVES; i++) {
            System.out.println("Wähle eine Richtung:");

            String input = UserInput.stringInput();
            Direction move = Direction.fromString(input);
            Map<Direction, Position> positionMap = gameMap.getGameMap().get(currentPosition);

            if (move != Direction.RIGHT && move != Direction.LEFT && move != Direction.UP && move != Direction.DOWN) {
                switch (input) {
                    case "help":
                        helpText();
                        break;
                    case "exit":
                        //i = exit(i,saver);
                        break;
                    default:
                        System.out.println("Ungültige Eingabe! Falls du nicht weiter weißt, nutze 'help'");
                        break;
                }
            } else if (positionMap.containsKey(move)) {
                currentPosition = positionMap.get(move);
                if (currentPosition == Position.ZIEL) {
                    System.out.println("Herzlichen Glückwunsch, du hast Peach von Bowser befreit!");
                    //exit(i,saver);
                    break;
                } else {
                    System.out.println("Du bewegst dich nach " + move.getDescription() + " \n" + currentPosition.getDescription());
                }
            } else {
                System.out.println("Hier befindet sich ein Block, versuche eine andere Richtung!");
            }

            powerUpHandling(currentPosition,mario,cheepCheep);
            if (currentPosition == currentPositionCheep && cheepCheep.getHealthPoints() == 1) {
                mario.setHealthPoints(mario.getHealthPoints() - 1);
                currentPosition = previousPosition;
                if (mario.getHealthPoints() == 1) {
                    System.out.println("Pass auf! Du bist dem Cheep Cheep zu nahe gekommen, es hat dich getroffen! Dir bleibt nur noch ein Leben");
                } else {
                    System.out.println("Oh nein, das Cheep Cheep hat dich erwischt");
                    break;
                }
            }
            previousPosition = currentPosition;
            //saver.saveGame(cheepCheep,mario,i);
        }
    }

    /**
     * Die Methode repräsentiert das Aufheben sowie nutzen der PowerUps.
     * @param currentPosition Ist die aktuelle Position des Spielers
     * @param mario Übergibt die Stats von Mario
     * @param cheepCheep Übergibt die Stats vom Cheep Cheep
     */
    private static void powerUpHandling(Position currentPosition, Entity mario, Entity cheepCheep) {
        if (currentPosition == Position.D6 && mario.getHealthPoints() == 1) {
            mario.setHealthPoints(2);
            System.out.println("Du hast ein PowerUp gefunden! Deine Lebenspunkte betragen jetzt zwei.");
        }else if (currentPosition == Position.D2 && cheepCheep.getHealthPoints() == 1) {
            cheepCheep.setHealthPoints(0);
            System.out.println("Sehr gut! Du hast das Cheep Cheep kill-PowerUp gefunden!");
            System.out.println("Du hast jetzt einen freien Weg");
        }
    }

    /**
     * Die Methode repräsentiert den Text, der zu Anfang angezeigt wird.
     */
    private static void einleitenderText() {
        System.out.println("""
                Prinzessin Peach wurde erneut von Bowser entführt!
                Doch dieses Mal hat er sie nicht in sein Schloss gebracht, sondern tief unter die Wellen des Pilz-Königreichs verschleppt.
               
                Als mutiger Mario stürzt du dich in die finsteren Tiefen des Ozeans, um Peach zu retten.
                Doch Vorsicht! Die Unterwasserwelt steckt voller Gefahren.
                Am Ende deines Weges wartet ein besonders aufdringliches Cheep Cheep, das den Ausgang bewacht – halte die Augen offen und sei auf der Hut!
                
                Zum Glück gibt es in den Tiefen einige Power-Ups, die dir helfen können.
                Halte Ausschau nach ihnen, denn sie könnten dir den entscheidenden Vorteil bringen!
                
                Aber pass auf! Du hast nur eine begrenzte Anzahl an Zügen, bevor dir die Luft ausgeht.
                Überlege deine Schritte gut und verschwende keine Zeit!
                
                Kannst du den Weg zu Peach finden und sie aus Bowsers nassen Klauen befreien?
                """);
    }

    /**
     * Die Methode repräsentiert einen Hilfetext.
     */
    private static void helpText() {
            System.out.println("""
                        Versuche es mit diesen Befehlen:
                        W --> Du bewegst dich nach oben,
                        
                        A --> Du bewegst dich nach links,
                        
                        S --> Du bewegst dich nach unten,
                        
                        D --> Du bewegst dich nach rechts,
                        
                        Exit --> Das Spiel wird beendet
                        """);
    }

    /**
     * Die Methode repräsentiert das Spiele menü, indem man seinen Spielstand verwalten kann.
     */
    private static void gameMenu() {
        while (true) {
            System.out.println("""
                    1. Neues Spiel
                    2. Spiel laden
                    3. Exit
                    """);
            String input = UserInput.stringInput();
            if (input.equalsIgnoreCase("1")) {
                break;
            } else if (input.equalsIgnoreCase("2")) {
                //wenn kein Spielstand vorhanden ist, Ausgabe und erneut fragen
                try {
                    //loader.loadGame(cheepCheep,mario);
                } catch (Exception e) {
                    System.out.println("Es konnte kein Spiel geladen werden, da keiner vorhanden ist.");
                    break;
                }
            } else if (input.equalsIgnoreCase("3")) {
                    //exit(30,saver);
            } else {
                System.out.println("Du kannst nur 1, 2 oder 3 verwenden.");
            }
        }
    }
    /**
     * Die Methode repräsentiert eine Möglichkeit zum Verlassen bzw Neustarten des spiels.
     * @param i lässt das Spiel enden
     * @param saver sichert den Spielstand
     * @return i
     */
    private static int exit(int i, Saver saver) {
        while (true) {
            System.out.println("Spiel beendet. Möchtest du erneut spielen?");
            String inputRestart = UserInput.stringInput();
            if (inputRestart.equalsIgnoreCase("n")) {
                return 30;
            } else if (inputRestart.equalsIgnoreCase("j")) {
                saver.resetSaveFile();
                break;
            } else {
                System.out.println("Du kannst nur J oder N verwenden.");
            }
        }
        return i;
    }
}