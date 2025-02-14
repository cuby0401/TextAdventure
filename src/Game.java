import Creature.Entity;
import GameMap.GameMap;
import GameMap.Position;
import GameMap.Direction;
import java.util.Map;

/**
 * Die Klasse repräsentiert das Spiel.
 */
public class Game {
    /**
     * Die Methode ist eine Aufhübschung für die Main-Klasse.
     */
    public static void playGame() {
        Position currentPositionCheep = Position.D4;
        Position currentPosition = Position.B3;
        Entity mario = new Entity(1);
        Entity cheepCheep = new Entity(1);
        final GameMap gameMap = new GameMap();

        einfuehrung();
        System.out.println(currentPosition.getDescription());

        for (int i = 0; i < 30; i++) {
            System.out.println("Wähle eine Richtung:");

            String input = UserInput.stringInput();
            Direction move = Direction.fromString(input);
            Map<Direction, Position> positionMap = gameMap.getGameMap().get(currentPosition);

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
                        Versuche es mit diesen Befehlen:
                        W --> Du bewegst dich nach oben,
                        
                        A --> Du bewegst dich nach links,
                        
                        S --> Du bewegst dich nach unten,
                        
                        D --> Du bewegst dich nach rechts,
                        
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
                    System.out.println("Du bewegst dich nach " + move.getDescription() + " \n" + currentPosition.getDescription());
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
    }

    /**
     * Die Methode repräsentiert das Aufheben sowie nutzen der PowerUps.
     * @param currentPosition Ist die aktuelle Position des Spielers.
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

    private static void einfuehrung() {
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
}