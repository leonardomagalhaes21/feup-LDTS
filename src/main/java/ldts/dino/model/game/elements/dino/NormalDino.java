package ldts.dino.model.game.elements.dino;

import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

public class NormalDino extends Dino {
    public static int HEIGHT = 30;
    public static int WIDTH = 30;
    public static int X = 30;
    public int dinoNormalForm = 1;

    public NormalDino() {
        super(new Position(X, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }

    public void changeDinoForm() {
        if(dinoNormalForm == 1) {
            dinoNormalForm = 2;
        } else {
            dinoNormalForm = 1;
        }
    }

    public int getDinoForm() {
        return dinoNormalForm;
    }


}