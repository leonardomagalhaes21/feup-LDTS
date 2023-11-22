import ldts.dino.gui.GUI;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.utils.Position;
import ldts.dino.viewer.menu.MainMenuViewer;
import ldts.dino.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuViewerTest {

    private final GUI gui = Mockito.mock(GUI.class);
    private MenuViewer viewer;

    @Test
    void testDrawElementsMainMenu() {
        viewer = new MainMenuViewer(new MainMenu());

        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), Mockito.eq(">Start"), Mockito.eq("#FC6A03"), Mockito.eq("#358e9c"));
        //TODO especificar o teste
    }
}
