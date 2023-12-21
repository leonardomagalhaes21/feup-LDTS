package ldts.dino.gui

import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import spock.lang.Specification

class LanternaGUITest extends Specification {

    LanternaGUI gui
    Screen screen
    TextGraphics textGraphics

    def setup() {
        screen = Mock(Screen)
        textGraphics = Mock(TextGraphics)
        screen.newTextGraphics() >> textGraphics
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
        1 * screen.clear()
    }

    def "test refresh"() {

        when:
        gui.refresh()

        then:
        1 * screen.refresh()
    }

    def "test close"() {

        when:
        gui.close()

        then:
        1 * screen.close()
    }
}