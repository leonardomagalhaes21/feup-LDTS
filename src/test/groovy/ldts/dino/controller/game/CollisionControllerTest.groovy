package ldts.dino.controller.game

import ldts.dino.model.game.elements.collectables.Coin
import ldts.dino.model.game.elements.obstacles.Plane
import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.gui.GUI
import ldts.dino.model.game.Game
import ldts.dino.model.game.elements.collectables.Bomb
import ldts.dino.state.GameOverState

class CollisionControllerTest extends Specification {
    CollisionController controller
    Game game
    Application application

    def setup() {
        game = new Game()
        controller = new CollisionController(game)
        application = Mock(Application)
    }

    def "test step with collision"() {
        given:
        game.addObstacle(new Plane())
        game.getObstacles().get(0).getPosition().setX(game.getDino().getPosition().getX())
        game.getObstacles().get(0).getPosition().setY(game.getDino().getPosition().getY())

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        1 * application.setState(_ as GameOverState)
    }

    def "test step with collectable"() {
        given:
        game.addCollectable(new Coin())
        game.getCollectables().get(0).getPosition().setX(game.getDino().getPosition().getX())
        game.getCollectables().get(0).getPosition().setY(game.getDino().getPosition().getY())

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        game.getCollectables().isEmpty()
    }

    def "test step with bomb"() {
        given:
        game.addCollectable(new Bomb())
        game.getCollectables().get(0).getPosition().setX(game.getDino().getPosition().getX())
        game.getCollectables().get(0).getPosition().setY(game.getDino().getPosition().getY())

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        game.getBombs() == 1
    }
}