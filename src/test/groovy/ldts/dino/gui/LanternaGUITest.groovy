import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import ldts.dino.gui.LanternaGUI
import ldts.dino.gui.GUI
import ldts.dino.utils.Colors
import ldts.dino.utils.Position
import spock.lang.Specification
import org.mockito.Mockito


class LanternaGUITest extends Specification {

    LanternaGUI gui
    Screen screen
    TextGraphics textGraphics

    def setup() {
        screen = Mockito.mock(Screen.class)
        textGraphics = Mockito.mock(TextGraphics.class)
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics)
        gui = new LanternaGUI(screen)
    }

    def "test getNextAction"() {

        when:
        def action = gui.getNextAction()

        then:
        action == GUI.ACTION.NONE
    }

    def "test clear"() {

        when:
        gui.clear()

        then:
        Mockito.verify(screen).clear()
    }

    def "test refresh"() {

        when:
        gui.refresh()

        then:
        Mockito.verify(screen).refresh()
    }

    def "test close"() {

        when:
        gui.close()

        then:
        Mockito.verify(screen).close()
    }
}