package ldts.dino.controller.game.elements

import ldts.dino.Application
import ldts.dino.gui.GUI
import ldts.dino.model.game.elements.collectables.Coin
import ldts.dino.model.game.elements.obstacles.Plane
import spock.lang.Specification
import ldts.dino.model.game.Game


class MotionControllerTest extends Specification {
    MotionController controller
    Game game
    Application application

    def setup() {
        game = new Game()
        controller = new MotionController(game)
        application = Mock(Application)
    }

    /*def "test moveObstacles"() {
        given:
        game.addObstacle(new Plane())
        def x = game.getObstacles().get(0).getPosition().getX()

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        game.getObstacles().get(0).getPosition().getX() < x
    }

    def "test moveCollectables"() {
        given:
        game.addCollectable(new Coin())
        def x = game.getCollectables().get(0).getPosition().getX()

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        game.getCollectables().get(0).getPosition().getX() < x
    }

    def "test difficultyControl"() {
        given:
        game.addCollectable(new Coin())
        game.addObstacle(new Plane())
        game.setScore(250)
        def obstacleSpeed = game.getObstacles().get(0).getSpeed()
        def collectableSpeed = game.getCollectables().get(0).getSpeed()

        when:
        controller.step(application, GUI.ACTION.NONE, 0)

        then:
        game.getObstacles().get(0).getSpeed() > obstacleSpeed
        game.getCollectables().get(0).getSpeed() > collectableSpeed
    }*/
}