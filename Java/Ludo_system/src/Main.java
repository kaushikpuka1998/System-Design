import Models.Game;
import Models.Pieces;
import Models.Player;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ludo System Design");


        ArrayList<Pieces> piece1 = new ArrayList<>();
        piece1.add(new Pieces("Red",0));
        piece1.add(new Pieces("Red",0));
        piece1.add(new Pieces("Red",0));
        piece1.add(new Pieces("Red",0));

        ArrayList<Pieces> piece2 = new ArrayList<>();
        piece2.add(new Pieces("Yellow",0));
        piece2.add(new Pieces("Yellow",0));
        piece2.add(new Pieces("Yellow",0));
        piece2.add(new Pieces("Yellow",0));

        ArrayList<Pieces> piece3 = new ArrayList<>();
        piece3.add(new Pieces("Green",0));
        piece3.add(new Pieces("Green",0));
        piece3.add(new Pieces("Green",0));
        piece3.add(new Pieces("Green",0));

        ArrayList<Pieces> piece4 = new ArrayList<>();

        piece4.add(new Pieces("Blue",0));
        piece4.add(new Pieces("Blue",0));
        piece4.add(new Pieces("Blue",0));
        piece4.add(new Pieces("Blue",0));


        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(new Player("P1",piece1));
        playerArrayList.add(new Player("P2",piece2));
        playerArrayList.add(new Player("P3",piece3));
        playerArrayList.add(new Player("P4",piece4));

        Game game = new Game(playerArrayList);

        game.play();


    }
}