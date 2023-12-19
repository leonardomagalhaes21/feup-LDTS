package ldts.dino.model.game.elements.obstacles

import spock.lang.Specification
import ldts.dino.gui.LanternaGUI
import ldts.dino.model.game.elements.Ground

class CityTest extends Specification {

    def "test city properties"() {
        given:
        def city = new City()

        expect:
        city.position.x == LanternaGUI.WIDTH
    }
}