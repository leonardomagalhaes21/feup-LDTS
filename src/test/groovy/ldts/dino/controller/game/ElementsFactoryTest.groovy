package ldts.dino.controller.game

import spock.lang.Specification
import ldts.dino.model.game.Game

class ElementsFactoryTest extends Specification {
    ElementsFactory factory
    Game game

    def setup() {
        game = new Game()
        factory = new ElementsFactory(game)
    }

    def "test generateObstacle"() {
        given:
        int initialObstaclesCount = game.getObstacles().size()

        when:
        factory.generateObstacle()

        then:
        game.getObstacles().size() == initialObstaclesCount + 1
    }

    def "test generateCollectable"() {
        given:
        int initialCollectablesCount = game.getCollectables().size()

        when:
        factory.generateCollectable()

        then:
        game.getCollectables().size() == initialCollectablesCount + 1
    }

    def "test step"() {
        given:
        def obstaclesSize = game.getObstacles().size()
        def collectablesSize = game.getCollectables().size()

        when:
        50.times { game.updateClock() }
        factory.step()

        then:
        game.getObstacles().size() == obstaclesSize + 1


        when:
        39.times { game.updateClock() }
        factory.step()

        then:
        game.getCollectables().size() == collectablesSize + 1
    }
}