package ldts.dino.model.menu

import spock.lang.Specification

class MainMenuTest extends Specification {
    MainMenu menu

    def setup() {
        menu = new MainMenu()
    }

    def "test isSelectedStart"() {
        given:
        MainMenu.setCurrentEntry(0)

        when:
        def selected = menu.isSelectedStart()

        then:
        selected
    }

    def "test isSelectedInstructions"() {
        given:
        MainMenu.setCurrentEntry(1)

        when:
        def selected = menu.isSelectedInstructions()

        then:
        selected
    }

    def "test isSelectedLeaderboard"() {
        given:
        MainMenu.setCurrentEntry(2)

        when:
        def selected = menu.isSelectedLeaderboard()

        then:
        selected
    }

    def "test isSelectedExit"() {
        given:
        MainMenu.setCurrentEntry(3)

        when:
        def selected = menu.isSelectedExit()

        then:
        selected
    }
}