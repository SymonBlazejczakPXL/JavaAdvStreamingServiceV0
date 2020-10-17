package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieGetPlayingTimeTest {

    private Movie movie;
    private static final String TITLE = "Titanic";

    @BeforeEach
    public void init() {
        // ARRANGE
        movie = new Movie(TITLE, Rating.TEENS);
    }

    @Test
    public void returnsQuestionmarkWhenDurationZero() {
        // ACT
        movie.setDuration(0);

        // ASSERT
        assertEquals("?", movie.getPlayingTime());
    }

    @Test
    public void retunsMinutesWhenDurationLessThan60() {
        // ACT
        movie.setDuration(59);

        // ASSERT
        assertEquals("59 min", movie.getPlayingTime());
    }

    @Test
    public void returnsHoursWhenDurationMultipleOf60() {
        // ACT
        movie.setDuration(120);

        // ASSERT
        assertEquals("2 h", movie.getPlayingTime());
    }

    @Test
    public void returnsHoursAndMinutesWhenDurationNotMultipleOf60() {
        // ACT
        movie.setDuration(135);

        // ASSERT
        assertEquals("2 h 15 min", movie.getPlayingTime());
    }
}
