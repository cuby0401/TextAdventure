package GameMap;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction fromString(String input) {
        return switch (input.toLowerCase()) {
            case "w" -> UP;
            case "s" -> DOWN;
            case "a" -> LEFT;
            case "d" -> RIGHT;
            default -> null;
        };
    }
}