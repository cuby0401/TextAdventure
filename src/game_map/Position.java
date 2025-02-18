package game_map;

/**
 * Das Enum repräsentiert die Positionen, auf denen man sich bewegen kann.
 */
public enum Position {
    B3("""
            Du sieht nicht viel. Unter dir und links von dir sind Blöcke die dir den Weg versperren.
            vor dir und über dir kannst du nichts erkennen, da das Wasser sehr trüb ist.
            """),
    B4("""
            Das Wasser wird hier gefühlt immer Trüber,
            du kannst nichts mehr sehen, außer einem Block direkt hinter dir.
            """),
    B5("""
            Du sieht nicht viel. Über dir und links von dir sind Blöcke die dir den Weg versperren.
            vor dir und unter dir kannst du nichts erkennen, da das Wasser sehr trüb ist.
            """),
    C3("""
            Unter dir befindet sich ein Block.
            Rechts unten kannst du etwas ungewöhnliches sehen, jedoch kannst du es nicht richtig erkennen.
            Gehe näher ran um zu erkennen was es ist.
            """),
    C4("""
            Wow! Du hast eine Art Aussichtspunkt gefunden. Von hier aus siehst du ziemlich weit!
            In der Ferne rechts über dir siehst du einen Pilz, was dieser nur macht?
            Den gleichen Pilz siehst du in Blau weit entfernt unter dir rechts.
            Genau gerade aus ist etwas pinkes, du kannst es jedoch nicht genau erkennen.
            Das könnte Peach sein, ich muss es erreichen.
            Oh! Was ist das das? Ein wildes Cheep Cheep schwimmt auf "Position in Textform angeben"
            """),
    C5("""
            Du kannst nicht viel erkennen. Über dir befindet sich ein Block.
            Rechts oben kannst du etwas ungewöhnliches sehen, jedoch kannst du es nicht richtig erkennen.
            Gehe näher ran um zu erkennen was es ist.
            """),
    D2("""
            Du hast ein PowerUp gefunden und verwendest es, um das Cheep Cheep zu füttern.
            Nördlich öffnet sich ein Block durch dass das Cheep Cheep wegschwimmt.
            Du brauchst dich jetzt nicht mehr vor dem Cheep Cheep fürchten.
            """),
    D3("""
            Rechts von dir befindet sich ein Block.
            Rechts über dir kannst du etwas pinkes sehen, jedoch nicht richtig erkennen.
            Ansonsten kannst du nicht viel sehen
            """),
    D4("Von rechts hörst du Peach verzweifelt rufen!"),
    D5("Rechts von dir befindet sich ein Block."),
    D6("""
            Du hast ein PowerUp gefunden und verwendest es. Es gibt dir mehr Leben.
            Dein Lebensanzahl beträgt nun zwei.
            """),
    ZIEL("Ziel");

    /**
     * Fügt eine Beschreibung der Positionen hinzu.
     */
    private final String description;

    Position(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}