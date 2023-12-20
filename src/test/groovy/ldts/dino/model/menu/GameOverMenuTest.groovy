package ldts.dino.model.menu

import spock.lang.Specification

class GameOverMenuTest extends Specification {

    def "test GameOverMenu constructor"() {
        given:
        def menu = new GameOverMenu()

        when:
        def result = menu.entries

        then:
        result != null
        result.size() > 0
    }

    def "test isSelectedRestart"() {
        given:
        GameOverMenu.setCurrentEntry(0)

        when:
        def selected = new GameOverMenu().isSelectedRestart()

        then:
        selected
    }

    def "test isSelectedMenu"() {
        given:
        GameOverMenu.setCurrentEntry(1)

        when:
        def selected = new GameOverMenu().isSelectedMenu()

        then:
        selected
    }
}