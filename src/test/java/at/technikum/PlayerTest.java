package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void returnsMarkerX() {
        Player player = new Player('X');

        assertEquals('X', player.getMarker());
    }

    @Test
    void returnsMarkerO() {
        Player player = new Player('O');

        assertEquals('O', player.getMarker());
    }
}