package ldts.dino.model.game.elements.dino

import ldts.dino.model.game.elements.Ground
import ldts.dino.utils.Position
import spock.lang.Specification

class DinoTest extends Specification {

    def "test collisions"() {
        given:
        NormalDino normalDino = new NormalDino()
        CrouchDino crouchDino = new CrouchDino(new Position(normalDino.getPosition().getX() + 2, Ground.HEIGHT - CrouchDino.HEIGHT))

        when:
        boolean isColliding = normalDino.isColliding(crouchDino)

        then:
        isColliding
    }

    def "test setSpeed"() {
        given:
        def dino = Spy(NormalDino)

        when:
        dino.setSpeed(15)

        then:
        dino.speed == dino.MAX_SPEED
    }

    def "test getSpeed"() {
        given:
        def dino = Spy(NormalDino)

        when:
        dino.setSpeed(7)

        then:
        dino.getSpeed() == 7
    }

    def "test getGravity method"() {
        setup:
        def dino = Spy(NormalDino)

        expect:
        dino.getGravity() == 1
    }

}