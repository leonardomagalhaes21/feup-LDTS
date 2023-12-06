package ldts.dino.model.game.elements;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.utils.Position;

public class Dino extends Element {
    public static int HEIGHT = 30;
    public static int WIDTH = 30;
    public int speed = 1;
    public final int MAX_SPEED = 3;
    public int gravity = 1;
    public int dinoForm = 1;
    public Dino() {
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }
}