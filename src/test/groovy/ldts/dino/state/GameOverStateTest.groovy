package ldts.dino.state

import spock.lang.Specification
import ldts.dino.controller.menu.GameOverController
import ldts.dino.model.menu.GameOverMenu
import ldts.dino.viewer.menu.GameOverViewer


class GameOverStateTest extends Specification {
    GameOverState state

    def setup() {
        state = new GameOverState(new GameOverMenu(), 1000)
    }

    def "test getController"() {
        when:
        def result = state.getController()

        then:
        result instanceof GameOverController
    }

    def "test getViewer"() {
        when:
        def result = state.getViewer()

        then:
        result instanceof GameOverViewer
    }

}