package ldts.dino.viewer.game.collectables

import spock.lang.Specification
import ldts.dino.viewer.game.collectables.BombViewer
import ldts.dino.model.game.elements.collectables.Bomb
import ldts.dino.gui.GUI
import ldts.dino.utils.Position

class BombViewerTest extends Specification {

    def "test draw"() {
        given:
        def gui = Mock(GUI)
        def bomb = new Bomb()
        def bombViewer = new BombViewer()

        when:
        bombViewer.draw(bomb, gui)

        then:
        1 * gui.drawImageFromFile(bomb.getPosition(), "bomb")
    }
}