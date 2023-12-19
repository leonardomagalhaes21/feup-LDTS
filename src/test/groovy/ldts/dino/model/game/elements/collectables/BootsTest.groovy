package ldts.dino.model.game.elements.collectables

import spock.lang.Specification
import ldts.dino.model.game.Game
import ldts.dino.gui.LanternaGUI
import ldts.dino.model.game.elements.Ground

class BootsTest extends Specification {

    def "test boots properties"() {
        given:
        def boots = new Boots()

        expect:
        boots.position.x == LanternaGUI.WIDTH
        boots.position.y >= 50
        boots.position.y <= Ground.HEIGHT - Boots.HEIGHT
        boots.width == Boots.WIDTH
        boots.height == Boots.HEIGHT
    }

    def "test boots consume"() {
        given:
        def boots = new Boots()
        def game = Spy(Game)

        when:
        boots.consume(game)

        then:
        game.isBootsActivated()
    }
}