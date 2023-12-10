import ldts.dino.model.game.elements.dino.NormalDino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DinoTest {

    //TODO adicionar mais testes
    @Test
    void testIsColliding1() {
        NormalDino dino1 = new NormalDino();
        NormalDino dino2 = new NormalDino();

        dino2.setPosition(new Position(NormalDino.X + 1, Ground.HEIGHT - NormalDino.HEIGHT));

        assertTrue(dino1.isColliding(dino2));
    }

    @Test
    void testIsColliding2() {
        NormalDino dino1 = new NormalDino();
        NormalDino dino2 = new NormalDino();

        dino2.setPosition(new Position(NormalDino.X + 2, Ground.HEIGHT - NormalDino.HEIGHT));

        assertFalse(dino1.isColliding(dino2));
    }

}