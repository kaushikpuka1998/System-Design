package Models;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        random = new Random();
    }

    public int role()
    {
        return random.nextInt(6)+1;  //next it will return 0 to 5
    }
}
