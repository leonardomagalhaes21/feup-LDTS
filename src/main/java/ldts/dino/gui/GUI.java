package ldts.dino.gui;

import java.io.IOException;
import ldts.dino.utils.Position;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    void paintBackground(String hashtag);
    void drawText(Position position, String text, String color, String backgroundColor);

    enum ACTION {UP, DOWN, NONE, QUIT, SELECT, SPACE, BACK}
}