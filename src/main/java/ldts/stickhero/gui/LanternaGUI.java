package ldts.stickhero.gui;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class LanternaGUI {
    private final Screen screen;
    LanternaGUI(int width, int height) {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }
    private Terminal createTerminal(int width, int height) {

    }

    private Screen createScreen(Terminal terminal) {
    }
}