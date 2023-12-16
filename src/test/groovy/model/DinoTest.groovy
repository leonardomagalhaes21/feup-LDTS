package model

import ldts.dino.model.game.elements.Ground
import ldts.dino.model.game.elements.dino.NormalDino
import ldts.dino.model.game.elements.dino.CrouchDino
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
}