package ldts.dino.model.game.elements.dino

import spock.lang.Specification

class NormalDinoTest extends Specification {

    def "test changeDinoForm"() {
        given:
        def normalDino = new NormalDino()

        when:
        normalDino.changeDinoForm()

        then:
        normalDino.dinoNormalForm == 2

        when:
        normalDino.changeDinoForm()

        then:
        normalDino.dinoNormalForm == 1
    }

    def "test getDinoForm"() {
        given:
        def normalDino = new NormalDino()

        expect:
        normalDino.getDinoForm() == 1
    }
}