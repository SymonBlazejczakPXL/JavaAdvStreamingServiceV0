package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.Period;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public boolean allowedToWatch(Content content) {
        if (dateOfBirth == null) {
            return false;
        } else if (getAge(dateOfBirth) >= content.getMaturityRating().getMinimumAge()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Profile Name: ").append(name);

        if (dateOfBirth == null) {
            builder.append(" (date of birth not set)");
        }
        else {
            builder.append(", Age: ").append(getAge(dateOfBirth)).append(" years young.");
        }

        return builder.toString();
    }

}
