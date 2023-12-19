package ldts.dino.model.game.creators

import ldts.dino.model.game.elements.collectables.Bomb
import ldts.dino.model.game.elements.collectables.Boots
import ldts.dino.model.game.elements.collectables.Coin
import ldts.dino.model.game.elements.collectables.Shield
import spock.lang.Specification

class CollectableCreatorTest extends Specification {

    def "test create method"() {
        given:
        def collectableCreator = new CollectableCreator()

        when:
        def result = collectableCreator.create()

        then:
        result instanceof Bomb || result instanceof Boots || result instanceof Coin || result instanceof Shield
    }
}