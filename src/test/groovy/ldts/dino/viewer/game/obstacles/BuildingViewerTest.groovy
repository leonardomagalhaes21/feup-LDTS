package ldts.dino.viewer.game.obstacles

import spock.lang.Specification
import ldts.dino.viewer.game.obstacles.BuildingViewer
import ldts.dino.model.game.elements.obstacles.Building
import ldts.dino.gui.GUI
import ldts.dino.utils.Position

class BuildingViewerTest extends Specification {

    def "test draw for small building"() {
        given:
        def gui = Mock(GUI)
        def building = Building.Factory.buildSmall(new Position(10, 10))
        def buildingViewer = new BuildingViewer()

        when:
        buildingViewer.draw(building, gui)

        then:
        1 * gui.drawImageFromFile(building.getPosition(), "smallBuilding")
    }

    def "test draw for large building"() {
        given:
        def gui = Mock(GUI)
        def building = Building.Factory.buildLarge(new Position(10, 10))
        def buildingViewer = new BuildingViewer()

        when:
        buildingViewer.draw(building, gui)

        then:
        1 * gui.drawImageFromFile(building.getPosition(), "largeBuilding")
    }

    def "test building collision"() {
        given:
        def building1 = Building.Factory.buildSmall(new Position(10, 10))
        def building2 = Building.Factory.buildLarge(new Position(15, 10))

        expect:
        building1.isColliding(building2)
    }
}