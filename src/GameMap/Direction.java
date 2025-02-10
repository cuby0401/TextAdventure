package GameMap;

/**
 * Die Klasse repräsentiert die Richtung in die man sich bewegen kann und mit welchen Tasten.
 */
public enum Direction {
    UP("oben"),
    DOWN("unten"),
    LEFT("links"),
    RIGHT("rechts");

    private String description = "";
    Direction(String description) {
        this.description = description;
    }

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