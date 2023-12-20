package ldts.dino.model.menu

import spock.lang.Specification

class ScoresMenuTest extends Specification {

    def "test ScoresMenu constructor"() {
        given:
        def menu = new ScoresMenu()

        when:
        expect:
        menu.entries != null
        menu.entries.size() > 0
    }
}