package ldts.dino.viewer.menu

import ldts.dino.gui.GUI
import ldts.dino.model.menu.InstructionsMenu
import ldts.dino.utils.Position
import ldts.dino.viewer.menu.InstructionsViewer
import spock.lang.Specification

class InstructionsViewerTest extends Specification {

    def "InstructionsViewer constructor"() {
        given:
        def instructionsMenu = Mock(InstructionsMenu)

        when:
        def instructionsViewer = new InstructionsViewer(instructionsMenu)

        then:
        instructionsViewer != null
    }

    def "test drawEntries"() {
        given:
        def instructionsMenu = Mock(InstructionsMenu)
        def gui = Mock(GUI)
        def instructionsViewer = new InstructionsViewer(instructionsMenu)
        def position = new Position(0, 0)
        def image = "instructions"

        when:
        instructionsViewer.drawEntries(gui, 0, 0)

        then:
        1 * gui.drawImageFromFile(position, image)
    }
}