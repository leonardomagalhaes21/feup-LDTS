package ldts.dino.viewer.menu;

import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.utils.Position;

public class GameOverViewer extends MenuViewer<GameOverMenu>{

    public GameOverViewer(GameOverMenu gameOverMenu) {
        super(gameOverMenu, new Position(25, 17));
    }
}
