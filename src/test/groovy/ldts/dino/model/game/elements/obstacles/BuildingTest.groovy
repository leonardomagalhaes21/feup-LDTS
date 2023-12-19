package ldts.dino.model.game.elements.obstacles

import spock.lang.Specification
import ldts.dino.utils.Position

class BuildingTest extends Specification {

    def "test small building"() {

        given:
        Position position = new Position(10, 10)
        def building = Building.Factory.buildSmall(new Position(10, 10))
        int width = Building.WIDTH
        int height = Building.SMALL_BUILDING_HEIGHT

        when:
        building = Building.Factory.build(position, height)

        then:
        building.position == position
        building.width == width
        building.height == height
    }

    def "test large building"() {

        given:
        Position position = new Position(10, 10)
        def building = Building.Factory.buildLarge(new Position(10, 10))
        int width = Building.WIDTH
        int height = Building.LARGE_BUILDING_HEIGHT

        when:
        building = Building.Factory.build(position, height)

        then:
        building.position == position
        building.width == width
        building.height == height
    }

}