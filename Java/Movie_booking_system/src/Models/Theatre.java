package Models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int theatre_id;
    String address;
    City city;
    List<Screen> screenList = new ArrayList<>();
    List<Show> showlist = new ArrayList<>();

    public Theatre(int theatre_id, String address, City city, List<Screen> screenList, List<Show> showlist) {
        this.theatre_id = theatre_id;
        this.address = address;
        this.city = city;
        this.screenList = screenList;
        this.showlist = showlist;
    }

    public int getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(int theatre_id) {
        this.theatre_id = theatre_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowlist() {
        return showlist;
    }

    public void setShowlist(List<Show> showlist) {
        this.showlist = showlist;
    }
}
