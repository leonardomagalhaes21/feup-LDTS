package ldts.dino.state

import spock.lang.Specification
import ldts.dino.controller.game.GameController
import ldts.dino.model.game.Game
import ldts.dino.viewer.game.GameViewer

class GameStateTest extends Specification {
    GameState state

    def setup() {
        state = new GameState(new Game())
    }

    def "test getController"() {
        when:
        def result = state.getController()

        then:
        result instanceof GameController
    }

    def "test getViewer"() {
        when:
        def result = state.getViewer()

        then:
        result instanceof GameViewer
    }
}