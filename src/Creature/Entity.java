package Creature;

import GameMap.Direction;
import GameMap.Position;

/**
 * Die Klasse repräsentiert die allgemeinen Stats eines Entitys.
 */
public class Entity {
    private int healthPoints = 0;
    private int speed = 0;
    private Position position;

    public Entity(int healthPoints, int speed, Position position) {
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Entity setPosition(Position position) {
        this.position = position;
        return this;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Entity setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public Entity setSpeed(int speed) {
        this.speed = speed;
        return this;
    }
}
