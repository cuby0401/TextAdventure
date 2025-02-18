package game_save;

import game_individual.Entity;
import game_map.Position;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
    private final String gameSave = "src/game_save/cheepSave.txt";

    public int loadGame(Entity cheepCheep, Entity mario) {
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
            gameSave.replace("cheepSave.txt", "cheepSave.sav");
            System.out.println("Datei wurde nicht gefunden. Erstelle eine neue Datei mit dem Namen cheepSave.sav");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}