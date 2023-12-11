package ldts.dino.model.menu;

import java.util.Arrays;

public class GameOverMenu extends Menu{
    public GameOverMenu() {
        this.entries = Arrays.asList("Restart");
    }
    public boolean isSelectedRestart() { return isSelected(0); }
}