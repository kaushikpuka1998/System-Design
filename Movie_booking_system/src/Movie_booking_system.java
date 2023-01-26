import Controllers.MovieController;
import Controllers.TheatreController;
import Models.City;
import Models.Movie;

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
    }

    public void create_theatre()
    {

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
    }
}