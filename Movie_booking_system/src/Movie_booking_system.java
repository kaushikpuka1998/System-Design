import Controllers.MovieController;
import Controllers.TheatreController;
import Enums.PaymentStatus;
import Enums.SeatCatagory;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static Enums.SeatCatagory.GOLD;

public class Movie_booking_system {
    MovieController movieController;
    TheatreController theatreController;

    Movie_booking_system()
    {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Movie_booking_system movie_booking_system = new Movie_booking_system();
        movie_booking_system.initialize_data();

//        Movie movie = movie_booking_system.movieController.getMovieByName("Avatar");
//        System.out.println("Selected movie"+movie.getMovie_id()+movie.getName());
    }

    public void initialize_data()
    {
        createMovie();
        create_theatre();
        create_booking("Avenger end game",new City(1,"Bangalore"),30);
        create_booking("Avenger end game",new City(1,"Bangalore"),50);
    //create_booking("Avenger end game",new City(1,"Bangalore"),40);
    }

    public void create_booking(String movie_name,City city_name,int seat_number)
    {
        //all movie running in the city
        List<Movie> movie_running_in_city = movieController.getAllmoviesByCityName(city_name);
        //System.out.println("KKK"+movie_running_in_city.get(0));
        Movie interested_movie = null;
        for(Movie movie:movie_running_in_city)
        {
            if(movie.getName() == movie_name)
            {
                interested_movie = movie;
            }
        }
        //selected_city with interested movies show
        Map<Theatre, List<Show>> allshow_of_selected_city = theatreController.getAllShow(city_name,interested_movie);
        //System.out.println("HHH"+allshow_of_selected_city.toString());
        Map.Entry<Theatre, List<Show>> particular_show =  allshow_of_selected_city.entrySet().iterator().next();

        List<Show> list = particular_show.getValue();
        Show interestedshow = list.get(0);

        int seatnumber = seat_number;
        List<Integer> bookedSeats = interestedshow.getBookedseatIds();
        if(bookedSeats.contains(seatnumber))
        {
            System.out.println("Seat Number "+seatnumber+" already booked,try another");
        }
        else{
            bookedSeats.add(seatnumber);
            Screen screen = interestedshow.getScreen();
            List<Seat> allseast = screen.getSeats();

            List<Seat> booking_Seats = new ArrayList<>();
            Booking booking1 = new Booking();
            for(Seat seat:allseast)
            {
                if(seat.getId() ==  seatnumber)
                {
                    booking_Seats.add(seat);
                }
            }
            Payment payment_for_booking1 =  new Payment(1, PaymentStatus.SUCEESSFUL);
            interestedshow.setBookedseatIds(bookedSeats);
            booking1.setShow(interestedshow);
            booking1.setPayment(payment_for_booking1);
            booking1.setSeats(booking_Seats);
            System.out.println("Booking Successful,Seat Number: "+booking_Seats.get(0).getId()+" locked");
            System.out.println("Payment Status: "+payment_for_booking1.getPaymentstatus());
        }
    }

    public void create_theatre()
    {
        Movie movie1 = movieController.getMovieByName("Avenger end game");
        Movie movie2 = movieController.getMovieByName("Avatar");
        City bangalore = new City(1,"Bangalore");
        City kolkata = new City(2,"Kolkata");


        Screen screen1= create_screen(1,createSeats());
        List<Screen> screenlist = new ArrayList<>();
        screenlist.add(screen1);

        Theatre inox_bangalore = new Theatre(1,"Infantry Road",bangalore,screenlist,new ArrayList<>());
        Show inox_morning_show = create_show(1,movie1,inox_bangalore.getScreenList().get(0),10);
        Show inox_evening_show = create_show(2,movie1,inox_bangalore.getScreenList().get(0),16);

        List<Show> allshowofinox = new ArrayList<>();
        allshowofinox.add(inox_morning_show);
        allshowofinox.add(inox_evening_show);
        inox_bangalore.setShowlist(allshowofinox);



        Theatre cinebuzz_bangalore = new Theatre(1,"Infantry Road",bangalore,screenlist,new ArrayList<>());
        Show cinebuzz_morning_show = create_show(1,movie1,inox_bangalore.getScreenList().get(0),9);
        Show cinebuzz_evening_show = create_show(2,movie1,inox_bangalore.getScreenList().get(0),20);

        List<Show> allshowofcinebuzz = new ArrayList<>();
        allshowofcinebuzz.add(cinebuzz_morning_show);
        allshowofcinebuzz.add(cinebuzz_evening_show);
        inox_bangalore.setShowlist(allshowofinox);

        theatreController.addTheatre(bangalore,inox_bangalore);
        theatreController.addTheatre(bangalore,cinebuzz_bangalore);


        System.out.println("Theatre CReated");


    }

    public Show create_show(int id,Movie movie,Screen screenlist,int startingtime)
    {
        return new Show(id, movie, screenlist,startingtime);
    }

    public Screen create_screen(int id,List<Seat> seats)
    {
        return new Screen(id,seats);
    }

    public List<Seat> createSeats()
    {
        List<Seat> seats = new ArrayList<>();

        for(int i=1;i<=30;i++)
        {
            Seat seat = new Seat(i,85, SeatCatagory.SILVER);
            seats.add(seat);
        }

        for(int i=31;i<=60;i++)
        {
            Seat seat = new Seat(i,95, SeatCatagory.GOLD);
            seats.add(seat);
        }

        for(int i=61;i<=90;i++)
        {
            Seat seat = new Seat(i,105, SeatCatagory.PLATINUM);
            seats.add(seat);
        }


        return seats;


    }
    public void createMovie()
    {
        Movie movie1 = new Movie(1,"Avenger end game",180);
        Movie movie2 = new Movie(2,"Avatar",210);

        City bangalore = new City(1,"Bangalore");
        City kolkata = new City(2,"Kolkata");

        movieController.addMovie(kolkata,movie1);
        movieController.addMovie(bangalore,movie1);
        movieController.addMovie(kolkata,movie2);
        movieController.addMovie(bangalore,movie2);

        System.out.println("Movie CReated");
    }
}