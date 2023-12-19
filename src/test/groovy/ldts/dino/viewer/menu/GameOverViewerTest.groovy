package ldts.dino.viewer.menu

import spock.lang.Specification
import ldts.dino.viewer.menu.GameOverViewer
import ldts.dino.model.menu.GameOverMenu
import ldts.dino.gui.GUI

class GameOverViewerTest extends Specification {

    def "GameOverViewer constructor"() {
        given:
        def gameOverMenu = Mock(GameOverMenu)

        when:
        def gameOverViewer = new GameOverViewer(gameOverMenu)

        then:
        gameOverViewer != null
    }

    def "test drawEntries"() {
        given:
        def gameOverMenu = Mock(GameOverMenu)
        def gui = Mock(GUI)
        def gameOverViewer = new GameOverViewer(gameOverMenu)

        when:
        gameOverViewer.drawEntries(gui, 10, 20)

        then:
        3 * gameOverMenu.getNumberEntries() >> 2
        1 * gameOverMenu.isSelected(0) >> true
        1 * gameOverMenu.getEntry(0) >> 'Restart'
        1 * gameOverMenu.isSelected(1) >> false
        1 * gameOverMenu.getEntry(1) >> 'Menu'
    }
}