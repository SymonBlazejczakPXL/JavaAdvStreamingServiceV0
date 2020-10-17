package be.pxl.ja.streamingservice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.Profile;

public class AccountConstructorTest {
    private Account account;

    @BeforeEach
    public void init() {
        // ARRANGE
        account = new Account("jeff.bezos@gmail.com", "TRIHARD7");
    }

    @Test
    public void accountConstructorWithoutProfileDateOfBirth() {
        // ACT
        Profile profile = account.getFirstProfile();

        // ASSERT
        assertEquals("Profile Name: profile1 (date of birth not set)", profile.toString());
    }

    @Test
    public void accountConstructorWithProfileDateOfBirth() {
        // ACT
        Profile profile = account.getFirstProfile();
        profile.setDateOfBirth(LocalDate.of(1998, 8, 29));

        // ASSERT
        assertEquals("Profile Name: profile1, Age: 22 years young.", profile.toString());
    }
}
