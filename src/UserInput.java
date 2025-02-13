import java.util.Scanner;

/**
 * Diese Klasse ist für die Eingaben des Users zuständig.
 */
public class UserInput {
    public static String stringInput() {
        Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
    }
}