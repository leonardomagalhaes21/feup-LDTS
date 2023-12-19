package ldts.dino.model.game.elements

import spock.lang.Specification
import ldts.dino.gui.LanternaGUI

class GroundTest extends Specification {

    def "test Ground constructor"() {
        given:
        def ground = new Ground()

        expect:
        ground.position.x == 0
        ground.position.y == Ground.HEIGHT
        ground.width == LanternaGUI.WIDTH
        ground.height == LanternaGUI.HEIGHT - Ground.HEIGHT + 1
    }
}