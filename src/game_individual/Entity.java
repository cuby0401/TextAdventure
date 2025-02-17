package game_individual;

import game_map.Position;

/**
 * Die Klasse repräsentiert die allgemeinen Stats eines Entity's.
 */
public class Entity {
    private int healthPoints;
    private Position position;

    public Entity(int healthPoints, Position position) {
        this.healthPoints = healthPoints;
        this.position = position;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}