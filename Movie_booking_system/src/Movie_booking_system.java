import Controllers.MovieController;
import Controllers.TheatreController;
import Enums.SeatCatagory;
import Models.*;

import java.util.ArrayList;
import java.util.List;

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
        allshowofinox.add(cinebuzz_morning_show);
        allshowofinox.add(cinebuzz_evening_show);
        inox_bangalore.setShowlist(allshowofcinebuzz);

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