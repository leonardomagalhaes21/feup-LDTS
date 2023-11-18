package ldts.stickhero.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.stickhero.viewer.Colors;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private static final int WIDTH =60, HEIGHT = 40, FONT_SIZE = 16;


    public LanternaGUI() throws IOException {
        Terminal terminal = createTerminal();
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal() throws IOException {
        TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        return terminalFactory.createTerminal();
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }

    public void paintBackground(String color) {
        /* TODO: make this only work on map build or something
        int width = 316;  // Replace with your actual width
        int sizeMin = 5;
        int sizeMax = 20;

        // Create an instance of Random
        Random random = new Random();

        // Generate a random position (x) within the specified range
        int x = random.nextInt(width - sizeMax - 15) + 15;

        // Generate a random size within the specified range
        int size = random.nextInt(sizeMax - sizeMin + 1) + sizeMin;
         */
        TextGraphics tg = screen.newTextGraphics();
        //background
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(WIDTH, HEIGHT + 1), ' ');
        //first tower
        tg.setBackgroundColor(TextColor.Factory.fromString(Colors.BLACK.getHex()));
        tg.fillRectangle(new TerminalPosition(5, 25), new TerminalSize(11, HEIGHT + 1), ' ');

        //vertical line
        tg.setBackgroundColor(TextColor.Factory.fromString(Colors.ORANGE.getHex()));
        tg.drawLine(new TerminalPosition(15, 10), new TerminalPosition(15,24), ' ');
        //second tower
        tg.setBackgroundColor(TextColor.Factory.fromString(Colors.BLACK.getHex()));
        tg.fillRectangle(new TerminalPosition(40, 25), new TerminalSize(12, HEIGHT + 1), ' ');
        //horizontal line
        tg.setBackgroundColor(TextColor.Factory.fromString(Colors.BROWN.getHex()));
        tg.drawLine(new TerminalPosition(15, 25), new TerminalPosition(45,25), ' ');

    }

}