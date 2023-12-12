package ldts.dino;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.state.MainMenuState;
import ldts.dino.state.State;
import ldts.dino.utils.SoundEffect;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI();
        this.state = new MainMenuState(new MainMenu());
        SoundEffect.getInstance();
        //TODO
    }

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException {
        int FPS = 30;
        int frameTime = 1000 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        gui.close();
    }
}