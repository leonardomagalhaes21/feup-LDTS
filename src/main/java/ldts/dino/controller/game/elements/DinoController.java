package ldts.dino.controller.game.elements;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.utils.Position;

public class DinoController extends Controller<Game> {
    private final Dino dino;

    public DinoController(Game model) {
        super(model);
        this.dino = model.getDino();
    }
    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        dinoForm();
    }

    private void dinoForm() {
        if(getModel().getClock() % 5 == 0) {
            getModel().getDino().changeDinoForm();
        }
    }
}