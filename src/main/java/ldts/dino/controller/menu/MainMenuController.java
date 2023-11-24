package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.menu.MainMenu;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    public void entrySelected(Application application) {
        if(getModel().isSelectedStart()) System.out.println("Começa o jogo!!");
        if(getModel().isSelectedInstructions()) System.out.println("Intruções");
        if(getModel().isSelectedLeaderboard()) System.out.println("Top Score");
        if(getModel().isSelectedExit()) application.setState(null);
    }

    @Override
    public void backSelected(Application application) {

    }
}