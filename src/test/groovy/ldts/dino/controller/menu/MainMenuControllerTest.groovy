package ldts.dino.controller.menu

import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.model.menu.MainMenu
import ldts.dino.state.GameState
import ldts.dino.state.InstructionsState
import ldts.dino.state.ScoresState

class MainMenuControllerTest extends Specification {
    MainMenuController controller
    Application application

    def setup() {
        application = Mock(Application)
    }

    def "test entrySelected start"() {
        given:
        controller = new MainMenuController(new MainMenu())

        when:
        controller.entrySelected(application)

        then:
        1 * application.setState(_ as GameState)
    }

    def "test entrySelected instructions"() {
        given:
        controller = new MainMenuController(Mock(MainMenu) {
            isSelectedInstructions() >> true
        })

        when:
        controller.entrySelected(application)

        then:
        1 * application.setState(_ as InstructionsState)
    }

    def "test entrySelected scores"() {
        given:
        controller = new MainMenuController(Mock(MainMenu) {
            isSelectedLeaderboard() >> true
        })

        when:
        controller.entrySelected(application)

        then:
        1 * application.setState(_ as ScoresState)
    }

    def "test entrySelected exit"() {
        given:
        controller = new MainMenuController(Mock(MainMenu) {
            isSelectedExit() >> true
        })

        when:
        controller.entrySelected(application)

        then:
        1 * application.exit()
    }

    def "test backSelected"() {
        given:
        controller = new MainMenuController(new MainMenu())

        when:
        controller.backSelected(application)

        then:
        0 * _
    }
}