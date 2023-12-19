package ldts.dino.viewer.game.collectables

import spock.lang.Specification
import ldts.dino.viewer.game.collectables.BootsViewer
import ldts.dino.model.game.elements.collectables.Boots
import ldts.dino.gui.GUI

class BootsViewerTest extends Specification {

    def "test draw"() {
        given:
        def gui = Mock(GUI)
        def boots = new Boots()
        def bootsViewer = new BootsViewer()

        when:
        bootsViewer.draw(boots, gui)

        then:
        1 * gui.drawImageFromFile(boots.getPosition(), "boots")
    }
}