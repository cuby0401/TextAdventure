package game_map;

import java.util.Map;
import java.util.HashMap;

/**
 * Die Klasse repräsentiert die Map und die Richtungen in die man sich bewegen darf.
 */
public class GameMap {
    public final Map<Position, Map<Direction, Position>> gameMap = new HashMap<>();

    /**
     * Die Methode deklariert die einzelnen Felder mit den Richtungen in die man sich bewegen kann.
     */
    public GameMap() {
        gameMap.put(Position.B3, new HashMap<>());
        gameMap.get(Position.B3).put(Direction.UP, Position.B4);
        gameMap.get(Position.B3).put(Direction.RIGHT, Position.C3);

        gameMap.put(Position.B4, new HashMap<>());
        gameMap.get(Position.B4).put(Direction.UP, Position.B5);
        gameMap.get(Position.B4).put(Direction.DOWN, Position.B3);
        gameMap.get(Position.B4).put(Direction.RIGHT, Position.C4);

        gameMap.put(Position.B5, new HashMap<>());
        gameMap.get(Position.B5).put(Direction.DOWN, Position.B4);
        gameMap.get(Position.B5).put(Direction.RIGHT, Position.C5);

        gameMap.put(Position.C3, new HashMap<>());
        gameMap.get(Position.C3).put(Direction.UP, Position.C4);
        gameMap.get(Position.C3).put(Direction.LEFT, Position.B3);
        gameMap.get(Position.C3).put(Direction.RIGHT, Position.D3);

        gameMap.put(Position.C4, new HashMap<>());
        gameMap.get(Position.C4).put(Direction.UP, Position.C5);
        gameMap.get(Position.C4).put(Direction.DOWN, Position.C3);
        gameMap.get(Position.C4).put(Direction.LEFT, Position.B4);
        gameMap.get(Position.C4).put(Direction.RIGHT, Position.D4);

        gameMap.put(Position.C5, new HashMap<>());
        gameMap.get(Position.C5).put(Direction.DOWN, Position.C4);
        gameMap.get(Position.C5).put(Direction.LEFT, Position.B5);
        gameMap.get(Position.C5).put(Direction.RIGHT, Position.D5);

        gameMap.put(Position.D2, new HashMap<>());
        gameMap.get(Position.D2).put(Direction.UP, Position.D3);

        gameMap.put(Position.D3, new HashMap<>());
        gameMap.get(Position.D3).put(Direction.DOWN, Position.D2);
        gameMap.get(Position.D3).put(Direction.UP, Position.D4);
        gameMap.get(Position.D3).put(Direction.LEFT, Position.C3);

        gameMap.put(Position.D4, new HashMap<>());
        gameMap.get(Position.D4).put(Direction.UP, Position.D5);
        gameMap.get(Position.D4).put(Direction.DOWN, Position.D3);
        gameMap.get(Position.D4).put(Direction.LEFT, Position.C4);
        gameMap.get(Position.D4).put(Direction.RIGHT, Position.ZIEL);

        gameMap.put(Position.D5, new HashMap<>());
        gameMap.get(Position.D5).put(Direction.DOWN, Position.D4);
        gameMap.get(Position.D5).put(Direction.LEFT, Position.C5);
        gameMap.get(Position.D5).put(Direction.UP, Position.D6);

        gameMap.put(Position.D6, new HashMap<>());
        gameMap.get(Position.D6).put(Direction.DOWN, Position.D5);
    }
    public Map<Position, Map<Direction, Position>> getGameMap() {
        return gameMap;
    }
}