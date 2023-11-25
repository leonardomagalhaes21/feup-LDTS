import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.state.State;
import ldts.dino.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class StateTest {

    private Application app;
    private GUI gui;
    private Controller<ModelStub> controller;
    private Viewer<ModelStub> viewer;
    private ModelStub model;
    private State<ModelStub> state;


    @BeforeEach
    void setUp() {
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        controller = Mockito.mock(Controller.class);
        viewer = Mockito.mock(Viewer.class);
        model = Mockito.mock(ModelStub.class);
        state = new State<ModelStub>(model) {
            @Override
            protected Controller<ModelStub> getController() {
                return controller;
            }

            @Override
            protected Viewer<ModelStub> getViewer() {
                return viewer;
            }
        };
    }

    @Test
    void testStep() throws IOException {
        Mockito.when(gui.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        state.step(app, gui, (long) 7);

        Mockito.verify(controller, Mockito.times(1)).step(app, GUI.ACTION.DOWN, (long) 7);
        Mockito.verify(viewer, Mockito.times(1)).draw(gui);
    }

    static class ModelStub {

    }
}
