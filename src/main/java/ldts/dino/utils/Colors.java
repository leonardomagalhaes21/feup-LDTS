package ldts.dino.utils;

public enum Colors {
    MENU("#3bd156"),
    BLUE("#8ECAE6"),
    GREEN("#499a3c"),
    GROUND("#474c55"),
    WHITE("#f2f2f2");

    private final String hex;

    Colors(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}