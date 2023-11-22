package ldts.dino.controller.menu;

import ldts.dino.Game;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.model.menu.Menu;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    public void entrySelected(Game game) {
        if(getModel().isSelectedStart()) System.out.println("Começa o jogo!!");
        if(getModel().isSelectedInstructions()) System.out.println("Intruções");
        if(getModel().isSelectedLeaderboard()) System.out.println("Leaderboard");
        if(getModel().isSelectedExit()) game.setState(null);
    }

    @Override
    public void backSelected(Game game) {

    }
}