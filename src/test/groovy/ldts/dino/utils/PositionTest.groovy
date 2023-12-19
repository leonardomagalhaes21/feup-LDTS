package ldts.dino.utils

import ldts.dino.utils.Position
import spock.lang.Specification

class PositionTest extends Specification {

    def "test Position"() {
        given:
        def pos = new Position(10,20)

        expect:
        pos.getX() == 10
        pos.getY() == 20
    }

    def "test Equals"() {
        given:
        def pos1 = new Position(21, 7)
        def pos2 = new Position(21, 7)
        def pos3 = new Position(5, 5)

        expect:
        pos1.equals(pos2)
        !pos1.equals(pos3)
    }

    def "test setX and setY"() {
        given:
        def position = new Position(10, 20)

        when:
        position.setX(25)
        position.setY(30)

        then:
        position.getX() == 25
        position.getY() == 30
    }

    def "test toString"() {
        given:
        def position = new Position(10, 10)

        expect:
        position.toString() == "(10, 10)"
    }

    def "test offset"() {
        given:
        def position = new Position(10, 10)

        when:
        def offsetPosition = position.offset(5, 10)

        then:
        offsetPosition.getX() == 15
        offsetPosition.getY() == 20
    }
}