import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Diese Klasse ist für die Eingaben des Users zuständig.
 */
public class UserInput {
    public static String stringInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("Ungültige Eingabe! Falls du nicht weiter weißt, nutze 'help'");
            return "";
        }
    }
}