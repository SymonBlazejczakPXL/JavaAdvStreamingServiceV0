package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements Playable {
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    public final int LONG_PLAYING_TIME = 135;

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        int durationAbsolute = Math.abs(duration);
        this.duration = durationAbsolute;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isLongPlayingTime() {
        return duration > LONG_PLAYING_TIME;
    }

    public String getPlayingTime() {
        // TODO implement correctly, stuur eventueel mail @ Mevr. Custers voor te vragen
        // of ie correct is

        int hours = duration / 60;
        int remainingMinutes = duration - (hours * 60);
        String playingTimeString = "";

        if (duration == 0) {
            playingTimeString = "?";
        } else if (duration <= 60) {
            playingTimeString = duration + " min";
        } else if (duration % 2 == 0) {
            playingTimeString = hours + " h";
        } else if (duration % 2 != 0) {
            playingTimeString = hours + " h " + remainingMinutes + " min";
        }
        return playingTimeString;
    }

    @Override
    public String toString() {
        // TODO: mogen we ook de String.format gebruiken

        // return String.format("%s (%s)", super.getTitle(), releaseDate.getYear());
        
        StringBuilder builder = new StringBuilder(super.toString());
        if (releaseDate != null) {
            builder.append(" (").append(releaseDate.getYear()).append(")");
        }
        return builder.toString();
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);

    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

}
