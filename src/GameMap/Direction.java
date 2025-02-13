package GameMap;

/**
 * Die Klasse repräsentiert die Richtung in die man sich bewegen kann.
 */
public enum Direction {
    UP("oben"),
    DOWN("unten"),
    LEFT("links"),
    RIGHT("rechts");

    /**
     * Fügt eine Beschreibung der Richtung hinzu.
     */
    private String description = "";
    Direction(String description) {
        this.description = description;
    }

    /**
     * Die Klasse repräsentiert die Tasten zur Bewegung der Richtungen.
     * @param input
     * @return
     */
    public static Direction fromString(String input) {
        return switch (input.toLowerCase()) {
            case "w" -> UP;
            case "s" -> DOWN;
            case "a" -> LEFT;
            case "d" -> RIGHT;
            default -> null;
        };
    }
    public String getDescription() {
        return description;
    }
}