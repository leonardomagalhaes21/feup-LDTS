package ldts.dino.viewer.game

import spock.lang.Specification
import ldts.dino.viewer.game.CrouchDinoViewer
import ldts.dino.model.game.elements.dino.CrouchDino
import ldts.dino.gui.GUI
import ldts.dino.utils.Position

class CrouchDinoViewerTest extends Specification {

    def "test draw crouch form 1"() {
        given:
        def gui = Mock(GUI)
        def position = new Position(10,10)
        def crouchDino = new CrouchDino(position)
        def crouchDinoViewer = new CrouchDinoViewer()

        when:
        crouchDinoViewer.draw(crouchDino, gui)

        then:
        1 * gui.drawImageFromFile(crouchDino.getPosition(), "crouch1")
    }

    def "test draw crouch form 2"() {
        given:
        def gui = Mock(GUI)
        def position = new Position(10,10)
        def crouchDino = new CrouchDino(position)
        crouchDino.changeDinoForm()
        def crouchDinoViewer = new CrouchDinoViewer()

        when:
        crouchDinoViewer.draw(crouchDino, gui)

        then:
        1 * gui.drawImageFromFile(crouchDino.getPosition(), "crouch2")
    }
}