import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DinoTest {

    //TODO adicionar mais testes
    @Test
    void testIsColliding1() {
        Dino dino1 = new Dino();
        Dino dino2 = new Dino();

        dino2.setPosition(new Position(Dino.X + 1, Ground.HEIGHT - Dino.HEIGHT));

        assertTrue(dino1.isColliding(dino2));
    }

    @Test
    void testIsColliding2() {
        Dino dino1 = new Dino();
        Dino dino2 = new Dino();

        dino2.setPosition(new Position(Dino.X + 2, Ground.HEIGHT - Dino.HEIGHT));

        assertFalse(dino1.isColliding(dino2));
    }

}
