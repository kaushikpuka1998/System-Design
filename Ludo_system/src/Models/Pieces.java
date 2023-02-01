package Models;

public class Pieces {
    private String color;
    private int position;

    public Pieces(String color, int position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public Integer getPosition() {
        return position;
    }

    public boolean isAtStart()
    {
        return position == 0;
    }
    public boolean isFinished()
    {
        return position >= 100;
    }

    public boolean isOnBoard()
    {
        return (position>=0 && position<100);
    }

    public void move(int diceroll)
    {
        position+=diceroll;
    }
}
