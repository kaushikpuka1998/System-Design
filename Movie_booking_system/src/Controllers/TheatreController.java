package Controllers;

import Models.City;
import Models.Movie;
import Models.Show;
import Models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<String, List<Theatre>> cityagainsttheatre;
    List<Theatre> alltheatres;

    public TheatreController()
    {
        cityagainsttheatre = new HashMap<>();
        alltheatres = new ArrayList<>();
    }

    public void addTheatre(City city,Theatre theatre)
    {
        alltheatres.add(theatre);
        List<Theatre> list_of_theatres = cityagainsttheatre.getOrDefault(city.getName(),new ArrayList<>());

        list_of_theatres.add(theatre);
        cityagainsttheatre.put(city.getName(),list_of_theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(City city, Movie movie)
    {
        Map<Theatre, List<Show>> allshow = new HashMap<>();
        List<Theatre> list_of_theatres = cityagainsttheatre.get(city.getName());

        for(Theatre theatre :list_of_theatres)
        {
            List<Show> return_show_array = new ArrayList<>();
            List<Show> all_show_mapped_with_theatre = theatre.getShowlist();

            for(Show show:all_show_mapped_with_theatre)
            {
                if(show.getMovie().getMovie_id() == movie.getMovie_id())
                {
                    return_show_array.add(show);
                }
            }
            allshow.put(theatre,return_show_array);
        }

        return allshow;

    }


}
