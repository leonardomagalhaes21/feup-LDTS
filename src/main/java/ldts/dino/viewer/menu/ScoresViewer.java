package ldts.dino.viewer.menu;

import ldts.dino.model.menu.ScoresMenu;
import ldts.dino.utils.Position;

public class ScoresViewer extends MenuViewer<ScoresMenu> {
    public ScoresViewer(ScoresMenu scoresMenu) {
        super(scoresMenu, new Position(25, 17));
    }
}
