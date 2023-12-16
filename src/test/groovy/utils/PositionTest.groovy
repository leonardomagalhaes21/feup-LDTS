package utils

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
}