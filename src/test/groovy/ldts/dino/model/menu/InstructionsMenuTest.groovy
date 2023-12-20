package ldts.dino.model.menu

import spock.lang.Specification

class InstructionsMenuTest extends Specification {

    def "test InstructionsMenu constructor"() {
        given:
        def menu = new InstructionsMenu()

        when:
        def list = menu.entries

        then:
        list != null
        list.size() > 0
    }
}