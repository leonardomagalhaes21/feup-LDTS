package ldts.dino.model.game.elements.dino;

import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

public class NormalDino extends Dino {
    public static int HEIGHT = 30;
    public static int WIDTH = 30;
    public int dinoForm = 1;

    public NormalDino() {
        super(new Position(30, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }

    public void changeDinoForm() {
        if(dinoForm == 1) {
            dinoForm = 2;
        } else {
            dinoForm = 1;
        }
    }

    public int getDinoForm() {
        return dinoForm;
    }


}