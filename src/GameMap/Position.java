package GameMap;

/**
 * Das Enum repräsentiert die Positionen auf denen man sich bewegen kann.
 */
public enum Position {
    B3("B3"),
    B4("B4"),
    B5("B5"),
    C3("C3"),
    C4("C4"),
    C5("C5"),
    D2("D2"),
    D3("D3"),
    D4("D4"),
    D5("D5"),
    D6("D6"),
    ZIEL("Ziel");

    /**
     * Fügt eine Beschreibung der Positionen hinzu.
     */
    private String description = "";
    Position(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}