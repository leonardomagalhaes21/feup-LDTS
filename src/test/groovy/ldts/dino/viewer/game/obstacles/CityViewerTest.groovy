package ldts.dino.viewer.game.obstacles

import ldts.dino.utils.Position
import spock.lang.Specification
import ldts.dino.viewer.game.obstacles.CityViewer
import ldts.dino.model.game.elements.obstacles.City
import ldts.dino.gui.GUI

class CityViewerTest extends Specification {

    def "test draw"() {
        given:
        def gui = Mock(GUI)
        def city = new City()
        def cityViewer = new CityViewer()

        when:
        cityViewer.draw(city, gui)

        then:
        city.getBuildings().size() * gui.drawImageFromFile(_,_)
    }
}