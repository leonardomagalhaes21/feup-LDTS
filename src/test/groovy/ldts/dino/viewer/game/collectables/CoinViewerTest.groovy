package ldts.dino.viewer.game.collectables

import spock.lang.Specification
import ldts.dino.viewer.game.collectables.CoinViewer
import ldts.dino.model.game.elements.collectables.Coin
import ldts.dino.gui.GUI

class CoinViewerTest extends Specification {

    def "test draw"() {
        given:
        def gui = Mock(GUI)
        def coin = new Coin()
        def coinViewer = new CoinViewer()

        when:
        coinViewer.draw(coin, gui)

        then:
        1 * gui.drawImageFromFile(coin.getPosition(), "coin")
    }
}