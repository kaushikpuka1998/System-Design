package Models;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int show_id;
    Movie movie;
    Screen screen;
    int starttime;
    List<Integer> bookedseatIds = new ArrayList<>();

    public Show(int show_id, Movie movie, Screen screen, int starttime) {
        this.show_id = show_id;
        this.movie = movie;
        this.screen = screen;
        this.starttime = starttime;
    }

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public List<Integer> getBookedseatIds() {
        return bookedseatIds;
    }

    public void setBookedseatIds(List<Integer> bookedseatIds) {
        this.bookedseatIds = bookedseatIds;
    }
}
