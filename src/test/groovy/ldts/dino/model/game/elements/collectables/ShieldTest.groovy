package ldts.dino.model.game.elements.collectables

import spock.lang.Specification
import ldts.dino.model.game.Game
import ldts.dino.gui.LanternaGUI
import ldts.dino.model.game.elements.Ground

class ShieldTest extends Specification {

    def "test shield properties"() {
        given:
        def shield = new Shield()

        expect:
        shield.position.x == LanternaGUI.WIDTH
        shield.position.y >= 50
        shield.position.y <= Ground.HEIGHT - Shield.HEIGHT
        shield.width == Shield.WIDTH
        shield.height == Shield.HEIGHT
    }

    def "test shield consume"() {
        given:
        def shield = new Shield()
        def game = Spy(Game)

        when:
        shield.consume(game)

        then:
        game.isShieldActivated()
    }
}