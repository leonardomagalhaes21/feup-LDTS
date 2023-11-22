package ldts.dino.gui;

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
import ldts.dino.utils.Position;
import ldts.dino.viewer.Colors;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private static final int WIDTH = 60, HEIGHT = 40, FONT_SIZE = 16;


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

        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.BACK;


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
        TextGraphics tg = screen.newTextGraphics();
        //background
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(WIDTH, HEIGHT + 1), ' ');
    }

    public void drawText(Position position, String text, String color, String backgroundColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        tg.putString(position.getX(), position.getY(), text);
    }
}