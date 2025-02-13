package Creature;

import GameMap.Position;

/**
 * Die Klasse repräsentiert die allgemeinen Stats eines Entitys.
 */
public class Entity {
    private int healthPoints = 0;

    public Entity(int healthPoints, Position position) {
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
