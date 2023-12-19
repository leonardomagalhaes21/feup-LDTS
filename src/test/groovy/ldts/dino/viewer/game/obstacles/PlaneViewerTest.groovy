package ldts.dino.viewer.game.obstacles

import spock.lang.Specification
import ldts.dino.viewer.game.obstacles.PlaneViewer
import ldts.dino.model.game.elements.obstacles.Plane
import ldts.dino.gui.GUI

class PlaneViewerTest extends Specification {

    def "test draw method"() {
        given:
        def gui = Mock(GUI)
        def plane = new Plane()
        def planeViewer = new PlaneViewer()

        when:
        planeViewer.draw(plane, gui)

        then:
        1 * gui.drawImageFromFile(plane.getPosition(), "plane")
    }
}