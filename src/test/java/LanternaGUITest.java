import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.dino.gui.LanternaGUI;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaGUITest {

    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void testDrawPixel(){
        Position position = new Position(10, 10);
        String color = Colors.WHITE.getHex();

        gui.drawPixel(position, color);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(color));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(color));
        Mockito.verify(tg, Mockito.times(1)).putString(position.getX(), position.getY(), " ");
    }

    @Test
    void testPaintBackground(){
        String color = Colors.BLUE.getHex();

        gui.paintBackground(color);

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(color));
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.WIDTH, LanternaGUI.HEIGHT + 1), ' ');
    }

    @Test
    void testDrawArea(){
        Position position = new Position(10, 10);
        int width = 7;
        int height = 7;
        String color = Colors.GREEN.getHex();

        gui.drawArea(position, width, height, color);

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(color));
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), ' ');
    }
}