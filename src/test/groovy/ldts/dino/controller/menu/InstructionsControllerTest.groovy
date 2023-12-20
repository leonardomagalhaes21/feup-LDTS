package ldts.dino.controller.menu

import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.model.menu.InstructionsMenu
import ldts.dino.state.MainMenuState

class InstructionsControllerTest extends Specification {
    InstructionsController controller
    Application application

    def setup() {
        controller = new InstructionsController(new InstructionsMenu())
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