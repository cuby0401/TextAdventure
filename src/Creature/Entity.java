package Creature;

/**
 * Die Klasse repräsentiert die allgemeinen Stats eines Entity's.
 */
public class Entity {
    private int healthPoints;

    public Entity(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}