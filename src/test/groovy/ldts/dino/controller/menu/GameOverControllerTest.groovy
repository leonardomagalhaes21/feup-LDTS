package ldts.dino.controller.menu

import ldts.dino.model.menu.MainMenu
import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.model.menu.GameOverMenu
import ldts.dino.state.GameState
import ldts.dino.state.MainMenuState

class GameOverControllerTest extends Specification {
    /*
    GameOverController controller
    Application application

    def setup() {
        application = Mock(Application)
    }

    def "test entrySelected restart"() {
        given:
        controller = new GameOverController(new GameOverMenu())

        when:
        controller.entrySelected(application)

        then:
        1 * application.setState(_ as GameState)
    }

    /*def "test entrySelected menu"() {
        given:
        controller.model.isSelectedMenu() >> true
        controller.model.isSelectedRestart() >> false

        when:
        controller.entrySelected(application)

        then:
        1 * application.setState(_ as MainMenuState)
    }

    def "test backSelected"() {
        when:
        controller.backSelected(application)

        then:
        0 * _
    }
    */
}