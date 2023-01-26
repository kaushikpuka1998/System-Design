package Models;

import Enums.SeatCatagory;

public class Seat {
    int id;
    int price;
    SeatCatagory seatCatagory;

    public Seat(int id, int price, SeatCatagory seatCatagory) {
        this.id = id;
        this.price = price;
        this.seatCatagory = seatCatagory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SeatCatagory getSeatCatagory() {
        return seatCatagory;
    }

    public void setSeatCatagory(SeatCatagory seatCatagory) {
        this.seatCatagory = seatCatagory;
    }
}
