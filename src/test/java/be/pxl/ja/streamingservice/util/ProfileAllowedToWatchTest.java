package be.pxl.ja.streamingservice.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Profile;
import be.pxl.ja.streamingservice.model.Rating;

public class ProfileAllowedToWatchTest {
    private Profile profile1;
    private Profile profile2;
    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    public void init() {
        // ARRANGE
        profile1 = new Profile();
        profile2 = new Profile();
        movie1 = new Movie("TENET", Rating.TEENS);
        movie2 = new Movie("VIVARIUM", Rating.MATURE);

        // ACT
        profile1.setName("Billy Bob");
        profile1.setDateOfBirth(LocalDate.of(2007, 4, 20));

        profile2.setName("Billy Bob");
    }

    @Test
    public void returnsTrueWhenDateOfBirthEqualsOrGreaterThanSetRatingMinimumAge() {
        // ASSERT
        assertTrue(profile1.allowedToWatch(movie1));
    }

    @Test
    public void returnsFalseWhenDateOfBirthLowerThanSetRatingMinimumAge() {
        // ASSERT
        assertFalse(profile1.allowedToWatch(movie2));
    }

    @Test
    public void returnsFalseWhenDateOfBirthNotSet() {
        // ASSERT
        assertFalse(profile2.allowedToWatch(movie1));
    }
}
