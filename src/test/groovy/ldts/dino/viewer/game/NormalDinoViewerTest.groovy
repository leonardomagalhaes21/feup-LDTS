package ldts.dino.viewer.game

import spock.lang.Specification
import ldts.dino.viewer.game.NormalDinoViewer
import ldts.dino.model.game.elements.dino.NormalDino
import ldts.dino.gui.GUI

class NormalDinoViewerTest extends Specification {

    def "test draw normal dino form 1"() {
        given:
        def gui = Mock(GUI)
        def normalDino = new NormalDino()
        def normalDinoViewer = new NormalDinoViewer()

        when:
        normalDinoViewer.draw(normalDino, gui)

        then:
        1 * gui.drawImageFromFile(normalDino.getPosition(), "walk1")
    }

    def "test draw normal dino form 2"() {
        given:
        def gui = Mock(GUI)
        def normalDino = new NormalDino()
        normalDino.changeDinoForm()
        def normalDinoViewer = new NormalDinoViewer()

        when:
        normalDinoViewer.draw(normalDino, gui)

        then:
        1 * gui.drawImageFromFile(normalDino.getPosition(), "walk2")
    }
}