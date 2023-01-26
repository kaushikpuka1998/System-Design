package Controllers;

import Models.City;
import Models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityagainsttheatre;
    List<Theatre> alltheatres;

    public TheatreController()
    {
        cityagainsttheatre = new HashMap<>();
        alltheatres = new ArrayList<>();
    }

    public void addTheatre(City city,Theatre theatre)
    {
        alltheatres.add(theatre);
        List<Theatre> list_of_theatres = cityagainsttheatre.getOrDefault(city,new ArrayList<>());

        list_of_theatres.add(theatre);
        cityagainsttheatre.put(city,list_of_theatres);




    }


}
