package ldts.dino.controller.game

import ldts.dino.model.game.elements.collectables.Bomb
import ldts.dino.model.game.elements.obstacles.Obstacle
import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.gui.GUI
import ldts.dino.model.game.Game

class GameControllerTest extends Specification {
    GameController controller
    Application application

    def setup() {
        controller = new GameController(new Game())
        application = Mock(Application)
    }

    def "test step quit"() {
        when:
        controller.step(application, GUI.ACTION.QUIT, 0)

        then:
        1 * application.setState(null)
    }

    /*def "test step bomb"() {
        given:
        controller.model.addBomb()
        controller.model.addObstacle(Mock(Bomb))
        when:
        controller.step(application, GUI.ACTION.BOMB, 0)

        then:
        controller.model.getBombs() == 0
    }*/

    def "test step score"() {
        given:
        def initialScore = controller.model.getScore()

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        controller.model.getScore() > initialScore
    }
}