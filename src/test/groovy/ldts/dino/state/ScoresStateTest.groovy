package ldts.dino.state

import spock.lang.Specification
import ldts.dino.controller.menu.ScoresController
import ldts.dino.model.menu.ScoresMenu
import ldts.dino.viewer.menu.ScoresViewer

class ScoresStateTest extends Specification {
    ScoresState state

    def setup() {
        state = new ScoresState(new ScoresMenu())
    }

    def "test getController"() {
        when:
        def result = state.getController()

        then:
        result instanceof ScoresController
    }

    def "test getViewer"() {
        when:
        def result = state.getViewer()

        then:
        result instanceof ScoresViewer
    }
}