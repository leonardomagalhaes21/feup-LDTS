package ldts.dino.model.game.elements.obstacles

import ldts.dino.model.game.elements.Ground
import spock.lang.Specification
import ldts.dino.gui.LanternaGUI

class PlaneTest extends Specification {

    def "test plane properties"() {
        given:
        def plane = new Plane()

        expect:
        plane.position.x == LanternaGUI.WIDTH
        plane.position.y >= 50
        plane.position.y <= Ground.HEIGHT-Plane.HEIGHT
        plane.width == Plane.WIDTH
        plane.height == Plane.HEIGHT
    }
}