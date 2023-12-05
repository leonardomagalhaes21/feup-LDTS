package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.controller.game.elements.MotionController;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;

public class GameController extends Controller<Game> {
    private final ElementsFactory elementsFactory;
    private final MotionController motionController;

    public GameController(Game model) {
        super(model);
        this.elementsFactory = new ElementsFactory(model);
        this.motionController = new MotionController(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        switch (action) {
            case QUIT:
                application.setState(null);
                break;
        }
        elementsFactory.step();
        motionController.step(application, action, time);
    }
}