package Models;

public class Movie {
    int movie_id;
    String name;
    int duration;

    public Movie(int movie_id, String name, int duration) {
        this.movie_id = movie_id;
        this.name = name;
        this.duration = duration;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
