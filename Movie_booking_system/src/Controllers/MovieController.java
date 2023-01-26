package Controllers;

import Models.City;
import Models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<String, List<Movie>> cityagainstmovie;
    List<Movie> allmovies;

    public MovieController()
    {
        cityagainstmovie = new HashMap<>();
        allmovies = new ArrayList<>();
    }

    public void addMovie(City city,Movie movie)
    {
        allmovies.add(movie);
        List<Movie> allmoviesmappedwithcity = cityagainstmovie.getOrDefault(city.getName(),new ArrayList<>());
        allmoviesmappedwithcity.add(movie);
        cityagainstmovie.put(city.getName(),allmoviesmappedwithcity);
    }

    public Movie getMovieByName(String name)
    {
        for(Movie movie:allmovies)
        {
            if(movie.getName() == name)
            {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getAllmoviesByCityName(City city)
    {
        return cityagainstmovie.get(city.getName());
    }

}
