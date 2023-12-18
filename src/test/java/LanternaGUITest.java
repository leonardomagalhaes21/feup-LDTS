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
    void testDrawText(){

        Position position = new Position(10, 10);
        String text = "Dinosaur";
        String color = Colors.WHITE.getHex();
        String backgroundColor = Colors.BLACK.getHex();

        gui.drawText(position, text, 40, backgroundColor);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(232,232,232));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(10, 10, text);

    }
}