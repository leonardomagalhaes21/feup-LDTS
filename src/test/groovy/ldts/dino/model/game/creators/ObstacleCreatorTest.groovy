package ldts.dino.model.game.creators

import ldts.dino.model.game.elements.obstacles.City
import ldts.dino.model.game.elements.obstacles.Plane
import spock.lang.Specification

class ObstacleCreatorTest extends Specification {

    def "test create method"() {
        given:
        def obstacleCreator = new ObstacleCreator()

        when:
        def result = obstacleCreator.create()

        then:
        result instanceof City || result instanceof Plane
    }
}