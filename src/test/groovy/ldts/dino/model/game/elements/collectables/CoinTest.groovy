package ldts.dino.model.game.elements.collectables

import spock.lang.Specification
import ldts.dino.model.game.Game
import ldts.dino.gui.LanternaGUI
import ldts.dino.model.game.elements.Ground

class CoinTest extends Specification {

    def "test coin properties"() {
        given:
        def coin = new Coin()

        expect:
        coin.position.x == LanternaGUI.WIDTH
        coin.position.y >= 50
        coin.position.y <= Ground.HEIGHT - Coin.HEIGHT
        coin.width == Coin.WIDTH
        coin.height == Coin.HEIGHT
    }

    def "test coin consume"() {
        given:
        def coin = new Coin()
        def game = Spy(Game)

        when:
        coin.consume(game)

        then:
        game.getScore() == Coin.VALUE
    }
}