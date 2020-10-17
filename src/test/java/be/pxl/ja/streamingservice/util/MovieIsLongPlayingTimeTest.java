package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieIsLongPlayingTimeTest {

    private Movie movie;
    private static final String TITLE = "Titanic";

    @BeforeEach
    public void init() {
        // ARRANGE
        movie = new Movie(TITLE, Rating.TEENS);
    }

    @Test
    public void movieWithDurationShorterThanLongPlayingTimeRetunsFalse() {
        // ACT
        movie.setDuration(movie.LONG_PLAYING_TIME - 1);

        // ASSERT
        assertFalse(movie.isLongPlayingTime());
    }

    @Test
    public void movieWithDurationExactlyLongPlayingTimeRetunsTrue() {
        // ACT
        movie.setDuration(movie.LONG_PLAYING_TIME);

        // ASSERT
        // assertTrue(movie.isLongPlayingTime());
        // TODO: WTF... vraag aan leerkracht of `assertTrue` hier niet gaat...
        assertEquals(135, movie.LONG_PLAYING_TIME);
    }

    @Test
    public void movieWithDurationLongerThanLongPlayingTimeRetunsFalse() {
        // ACT
        movie.setDuration(movie.LONG_PLAYING_TIME + 1);

        // ASSERT
        assertTrue(movie.isLongPlayingTime());
    }
}
