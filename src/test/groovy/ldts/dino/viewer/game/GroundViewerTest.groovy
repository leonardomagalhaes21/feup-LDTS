package ldts.dino.viewer.game

import spock.lang.Specification
import ldts.dino.viewer.game.GroundViewer
import ldts.dino.model.game.elements.Ground
import ldts.dino.gui.GUI
import ldts.dino.utils.Colors
import ldts.dino.utils.Position

class GroundViewerTest extends Specification {

    def "test draw"() {
        given:
        def gui = Mock(GUI)
        def ground = new Ground()
        def groundViewer = new GroundViewer()
        def color = Colors.GROUND.getHex()

        when:
        groundViewer.draw(ground, gui)

        then:
        1 * gui.drawArea(ground.getPosition(), ground.getWidth(), ground.getHeight(), color)
    }
}