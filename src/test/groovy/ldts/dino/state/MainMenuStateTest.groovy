package ldts.dino.state

import spock.lang.Specification
import ldts.dino.controller.menu.MainMenuController
import ldts.dino.model.menu.MainMenu
import ldts.dino.viewer.menu.MainMenuViewer

class MainMenuStateTest extends Specification {
    MainMenuState state

    def setup() {
        state = new MainMenuState(new MainMenu())
    }

    def "test getController"() {
        when:
        def result = state.getController()

        then:
        result instanceof MainMenuController
    }

    def "test getViewer"() {
        when:
        def result = state.getViewer()

        then:
        result instanceof MainMenuViewer
    }
}