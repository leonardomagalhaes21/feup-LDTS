package ldts.dino.viewer.menu

import ldts.dino.gui.GUI
import ldts.dino.gui.LanternaGUI
import ldts.dino.model.menu.ScoresMenu
import ldts.dino.utils.Colors
import ldts.dino.utils.Position
import ldts.dino.viewer.menu.ScoresViewer
import spock.lang.Specification

class ScoresViewerTest extends Specification {

    def "test ScoresViewer constructor"() {
        given:
        def scoresMenu = Mock(ScoresMenu)
        def position = new Position(LanternaGUI.WIDTH / 2 - 50 as int, 100)

        when:
        def scoresViewer = new ScoresViewer(scoresMenu)

        then:
        scoresViewer != null
    }

    def "test drawEntries method"() {
        given:
        def scoresMenu = Mock(ScoresMenu)
        def gui = Mock(GUI)
        def scoresViewer = new ScoresViewer(scoresMenu)
        def position = new Position(10, 0)
        def color = Colors.WHITE.getHex()

        scoresMenu.getNumberEntries() >> 1
        scoresMenu.getEntry(0) >> "entry"

        when:
        scoresViewer.drawEntries(gui, 0, 0)

        then:
        1 * gui.drawText(position, "entry", 10, color)
    }
}