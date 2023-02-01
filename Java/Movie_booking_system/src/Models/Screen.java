package Models;

import java.util.List;

public class Screen {
    int screen_id;
    List<Seat> seats;

    public Screen(int screen_id, List<Seat> seats) {
        this.screen_id = screen_id;
        this.seats = seats;
    }

    public int getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(int screen_id) {
        this.screen_id = screen_id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
