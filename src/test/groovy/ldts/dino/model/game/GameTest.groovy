package ldts.dino.model.game

import ldts.dino.model.game.elements.collectables.Collectable
import ldts.dino.model.game.elements.dino.Dino
import ldts.dino.model.game.elements.obstacles.Obstacle
import spock.lang.Specification
import ldts.dino.model.game.elements.dino.NormalDino
import ldts.dino.model.game.elements.collectables.Bomb
import ldts.dino.model.game.elements.obstacles.Plane
import ldts.dino.utils.Position

class GameTest extends Specification {

    Game game

    def setup() {
        game = new Game()
    }

    def "test addObstacle"() {
        given:
        Obstacle obstacle = new Plane()

        when:
        game.addObstacle(obstacle)

        then:
        game.getObstacles().contains(obstacle)
    }

    def "test addCollectable"() {
        given:
        Collectable collectable = new Bomb()

        when:
        game.addCollectable(collectable)

        then:
        game.getCollectables().contains(collectable)
    }

    def "test addBomb"() {
        given:
        int initialBombs = game.getBombs()

        when:
        game.addBomb()

        then:
        game.getBombs() == initialBombs + 1
    }

    def "test setDino"() {
        given:
        Dino dino = new NormalDino()

        when:
        game.setDino(dino)

        then:
        game.getDino() == dino
    }

    def "test getScore and setScore"() {
        given:
        float score = 1000

        when:
        game.setScore(score)

        then:
        game.getScore() == score
    }

    def "test consumeCollectable"() {
        given:
        Collectable collectable = new Bomb()

        when:
        game.consumeCollectable(collectable)

        then:
        game.getBombs() == 1
    }

    def "test removeBomb"() {
        given:
        game.addBomb()

        expect:
        game.getBombs() == 1

        when:
        game.removeBomb()

        then:
        game.getBombs() == 0
    }

    def "test updateClock"() {
        given:
        int initialClock = game.getClock()

        when:
        game.updateClock()

        then:
        game.getClock() == initialClock + 1
    }

    def "test startShield and isShieldActivated"() {
        when:
        game.startShield()

        then:
        game.isShieldActivated()
    }

    def "test startBoots and isBootsActivated"() {
        when:
        game.startBoots()

        then:
        game.isBootsActivated()
    }

    def "test getExplosion and setExplosion"() {
        given:
        Position position = new Position(10, 10)

        when:
        game.setExplosion(position)

        then:
        game.getExplosion() == position
    }
}