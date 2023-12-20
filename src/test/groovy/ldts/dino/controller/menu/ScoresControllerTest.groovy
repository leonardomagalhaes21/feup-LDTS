package ldts.dino.controller.menu

import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.model.menu.ScoresMenu
import ldts.dino.state.MainMenuState

class ScoresControllerTest extends Specification {
    ScoresController controller
    Application application

    def setup() {
        controller = new ScoresController(new ScoresMenu())
        application = Mock(Application)
    }

    def "test entrySelected"() {
        when:
        controller.entrySelected(application)

        then:
        1 * application.setState(_ as MainMenuState)
    }

    def "test backSelected"() {
        when:
        controller.backSelected(application)

        then:
        1 * application.setState(_ as MainMenuState)
    }
}