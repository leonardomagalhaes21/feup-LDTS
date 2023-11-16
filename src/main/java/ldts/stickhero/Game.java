package ldts.stickhero;

import ldts.stickhero.gui.LanternaGUI;
import ldts.stickhero.model.menu.Menu;
import ldts.stickhero.state.MenuState;
import ldts.stickhero.state.State;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException {
        this.gui = new LanternaGUI();
        this.state = new MenuState(new Menu());
        //TODO: initialize state
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Game().start();
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