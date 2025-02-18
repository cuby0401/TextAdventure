package game_save;

import game_individual.Entity;
import game_map.Position;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Die Klasse repräsentiert das sichern alle nötigen Parameter
 */
public class Saver {
    private static final String DELIMITER = ";";
    private final String gameSave = "src/game_save/cheepSave.txt";

    /**
     * Die Methode sichert das Spiel
     * @param cheepCheep übergibt die Lebenspunkte und die Position
     * @param mario übergibt die Lebenspunkte und die Position
     * @param round übergibt die Rundenanzahl
     */
    public void saveGame(Entity cheepCheep, Entity mario, int round) {
        int cheepHealth =  cheepCheep.getHealthPoints();
        Position marioPosition = mario.getPosition();
        Position cheepPosition = cheepCheep.getPosition();
        int marioHealth = mario.getHealthPoints();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(gameSave))){
            writer.write(cheepHealth + DELIMITER + marioPosition.name() + DELIMITER + cheepPosition.name() + DELIMITER + marioHealth + DELIMITER + round);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Die Methode löscht die aktuelle File
     */
    public void deleteSaveFile() {
        File file = new File(gameSave);
        file.delete();
    }
}