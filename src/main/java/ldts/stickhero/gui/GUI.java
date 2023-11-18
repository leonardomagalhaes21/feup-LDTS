package ldts.stickhero.gui;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    void paintBackground(String hashtag);

    enum ACTION {UP, DOWN, NONE, QUIT, SELECT, SPACE}
}