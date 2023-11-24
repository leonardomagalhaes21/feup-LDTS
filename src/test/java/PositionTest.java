import ldts.dino.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    void testPosition(){
        Position pos = new Position(10,20);
        assertEquals(pos.getX(), 10);
        assertEquals(pos.getY(), 20);
    }


    @Test
    void testEquals() {
        Position pos1 = new Position(21, 7);
        Position pos2 = new Position(21, 7);
        Position pos3 = new Position(5, 5);

        assertTrue(pos1.equals(pos2));
        assertFalse(pos1.equals(pos3));
    }
}
