package ldts.dino.model.game.elements.dino

import spock.lang.Specification
import ldts.dino.utils.Position

class CrouchDinoTest extends Specification {

    def "test changeDinoForm"() {
        given:
        def crouchDino = new CrouchDino(new Position(0, 0))

        when:
        crouchDino.changeDinoForm()

        then:
        crouchDino.crouchDinoForm == 2

        when:
        crouchDino.changeDinoForm()

        then:
        crouchDino.crouchDinoForm == 1
    }

    def "test getCrouchDinoForm"() {
        given:
        def crouchDino = new CrouchDino(new Position(0, 0))

        expect:
        crouchDino.getCrouchDinoForm() == 1
    }
}