package ldts.dino.viewer.game

import ldts.dino.utils.Colors
import spock.lang.Specification
import ldts.dino.viewer.game.GameViewer
import ldts.dino.model.game.Game
import ldts.dino.model.game.elements.dino.NormalDino
import ldts.dino.model.game.elements.dino.CrouchDino
import ldts.dino.model.game.elements.obstacles.City
import ldts.dino.model.game.elements.obstacles.Plane
import ldts.dino.model.game.elements.collectables.Bomb
import ldts.dino.model.game.elements.collectables.Boots
import ldts.dino.model.game.elements.collectables.Coin
import ldts.dino.model.game.elements.collectables.Shield
import ldts.dino.gui.GUI
import ldts.dino.gui.LanternaGUI
import ldts.dino.utils.Position

class GameViewerTest extends Specification {

    def "test drawProgressBar"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        game.startBoots()
        game.startShield()
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawProgressBar(gui)

        then:
        2 * gui.drawImageFromFile(_,_)
        2 * gui.drawArea(_,_,_,_)
    }

    def "test drawExplosion"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        def position = new Position(10, 10)
        game.setExplosion(position)
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawExplosion(gui)

        then:
        1 * gui.drawImageFromFile(game.getExplosion(), "explosion")
    }

    def "test drawBackground"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawBackground(gui)

        then:
        1 * gui.paintBackground(Colors.BLUE.getHex())
    }

    def "test drawBombCounter"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        game.addBomb()
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawBombCounter(gui)

        then:
        1 * gui.drawText(new Position(LanternaGUI.WIDTH - 35, 1), game.getBombs() + "/" + Game.BOMBS_LIMIT, 10, Colors.WHITE.getHex())
        1 * gui.drawImageFromFile(new Position(game.getGround().getWidth()-10, 1), "bomb")
    }

    def "test drawScore"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        game.setScore(1000)
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawScore(gui)

        then:
        1 * gui.drawText(new Position((LanternaGUI.WIDTH / 2) as int - 40, 1), "SCORE: " + (int) game.getScore(), 10, Colors.WHITE.getHex())
    }

    def "test drawDino"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        game.setDino(new NormalDino())
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawDino(gui)

        then:
        1 * gui.drawImageFromFile(game.getDino().getPosition(), "walk1")
    }

    def "test drawObstacles"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        game.addObstacle(new Plane())
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawObstacles(gui, game.getObstacles())

        then:
        1 * gui.drawImageFromFile(_, "plane")
    }

    def "test drawCollectables"() {
        given:
        def gui = Mock(GUI)
        def game = new Game()
        game.addCollectable(new Bomb())
        game.addCollectable(new Boots())
        game.addCollectable(new Coin())
        game.addCollectable(new Shield())
        def gameViewer = new GameViewer(game)

        when:
        gameViewer.drawCollectables(gui, game.getCollectables())

        then:
        1 * gui.drawImageFromFile(_, "bomb")
        1 * gui.drawImageFromFile(_, "boots")
        1 * gui.drawImageFromFile(_, "coin")
        1 * gui.drawImageFromFile(_, "shield")
    }

}