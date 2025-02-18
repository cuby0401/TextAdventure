import java.util.NoSuchElementException;

/**
 *Die Klasse repräsentiert die Main.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Game.playGame();
        } catch (NoSuchElementException e) {
            System.out.println("Ungültige Eingabe! Das Programm wird nun geschlossen!");
        }
    }
}