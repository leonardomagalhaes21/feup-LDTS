package ldts.dino.controller.game.elements

import spock.lang.Specification
import ldts.dino.Application
import ldts.dino.gui.GUI
import ldts.dino.model.game.Game
import ldts.dino.model.game.elements.dino.CrouchDino
import ldts.dino.model.game.elements.dino.NormalDino

class DinoControllerTest extends Specification {
    DinoController controller
    Game game
    Application application

    def setup() {
        game = new Game()
        controller = new DinoController(game)
        application = Mock(Application)
    }

    def "test step no action"() {
        given:
        game.setDino(new NormalDino())
        def y = game.getDino().getPosition().getY()

        when:
        controller.step(application, null, 0)

        then:
        game.getDino().getPosition().getY() == y + game.getDino().getGravity()
    }

    def "test step jump action"() {
        given:
        game.setDino(new NormalDino())
        def y = game.getDino().getPosition().getY()

        when:
        controller.step(application, GUI.ACTION.JUMP, 0)

        then:
        game.getDino().getPosition().getY() > y
    }

    def "test step down action"() {
        given:
        game.setDino(new NormalDino())

        when:
        controller.step(application, GUI.ACTION.DOWN, 0)

        then:
        game.getDino() instanceof CrouchDino
    }
}