package game_save;

import game_individual.Entity;
import game_map.Position;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Die Klasse repräsentiert das Laden des Spiels.
 */
public class Loader {

    /**
     * Die Methode lädt das alle übergebenen Sachen in das Spiel.
     * @param cheepCheep übergibt CheepCheeps Position und die Lebenspunkte.
     * @param mario übergibt Marios Position und die Lebenspunkte.
     * @return die Rundenanzahl
     */
    public int loadGame(Entity cheepCheep, Entity mario) {
        String gameSave = "src/game_save/cheepSave.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(gameSave))) {
            String lineContent;
            if ((lineContent = reader.readLine()) != null) {
                final String[] split = lineContent.split(";");
                final int cheepHealth = Integer.parseInt(split[0]);
                final Position marioPosition = Position.valueOf(split[1]);
                final Position cheepPosition = Position.valueOf(split[2]);
                final int marioHealth = Integer.parseInt(split[3]);
                final int round = Integer.parseInt(split[4]);

                cheepCheep.setHealthPoints(cheepHealth);
                cheepCheep.setPosition(cheepPosition);
                mario.setPosition(marioPosition);
                mario.setHealthPoints(marioHealth);

                return round;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei wurde nicht gefunden.");
        } catch (IOException e) {
            System.out.println("Datei konnte nicht geladen werden.");
        }
        return 0;
    }
}