package ldts.dino.model.game.elements.collectables

import spock.lang.Specification
import ldts.dino.model.game.Game
import ldts.dino.gui.LanternaGUI
import ldts.dino.model.game.elements.Ground

class BombTest extends Specification {

    def "test bomb properties"() {
        given:
        def bomb = new Bomb()

        expect:
        bomb.position.x == LanternaGUI.WIDTH
        bomb.position.y >= 50
        bomb.position.y <= Ground.HEIGHT - Bomb.HEIGHT
        bomb.width == Bomb.WIDTH
        bomb.height == Bomb.HEIGHT
    }

    def "test bomb consume"() {
        given:
        def bomb = new Bomb()
        def game = Spy(Game)

        when:
        bomb.consume(game)

        then:
        game.getBombs() == 1
    }
}