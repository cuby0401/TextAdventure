package game_save;

import game_individual.Entity;
import game_map.Position;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    private static final String DELIMITER = ";";
    private final String gameSave = "src/game_save/cheepSave.txt";

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
    public void resetSaveFile()
    {
        File file = new File(gameSave);
        file.delete();
    }
}