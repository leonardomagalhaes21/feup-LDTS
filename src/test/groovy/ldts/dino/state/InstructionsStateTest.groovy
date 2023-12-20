package ldts.dino.state

import spock.lang.Specification
import ldts.dino.controller.menu.InstructionsController
import ldts.dino.model.menu.InstructionsMenu
import ldts.dino.viewer.menu.InstructionsViewer

class InstructionsStateTest extends Specification {
    InstructionsState state

    def setup() {
        state = new InstructionsState(new InstructionsMenu())
    }

    def "test getController"() {
        when:
        def result = state.getController()

        then:
        result instanceof InstructionsController
    }

    def "test getViewer"() {
        when:
        def result = state.getViewer()

        then:
        result instanceof InstructionsViewer
    }
}