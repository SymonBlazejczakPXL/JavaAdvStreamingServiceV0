package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class MovieToStringTest {

    private Movie movie1;
    private Movie movie2;
    private static final String TITLE = "Titanic";

    @BeforeEach
    public void init() {
        // ARRANGE
        movie1 = new Movie(TITLE, Rating.TEENS);
        movie2 = new Movie(TITLE, Rating.TEENS);
    }

    @Test
    public void movieWithReleaseDateToStringRetunsCorrectString() {
        // ACT
        movie1.setReleaseDate(LocalDate.of(2017, 05, 02));
        String movie1Summary = movie1.toString();

        // ASSERT
        assertEquals("Titanic (2017)", movie1Summary);
    }

    @Test
    public void movieWithDurationExactlyLongPlayingTimeRetunsTrue() {
        // ACT
        String movie2Summary = movie2.toString();

        // ASSERT
        assertEquals("Titanic", movie2Summary);
    }
}
