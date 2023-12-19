package ldts.dino.viewer.game.collectables

import spock.lang.Specification
import ldts.dino.viewer.game.collectables.ShieldViewer
import ldts.dino.model.game.elements.collectables.Shield
import ldts.dino.gui.GUI

class ShieldViewerTest extends Specification {

    def "test draw"() {
        given:
        def gui = Mock(GUI)
        def shield = new Shield()
        def shieldViewer = new ShieldViewer()

        when:
        shieldViewer.draw(shield, gui)

        then:
        1 * gui.drawImageFromFile(shield.getPosition(), "shield")
    }
}