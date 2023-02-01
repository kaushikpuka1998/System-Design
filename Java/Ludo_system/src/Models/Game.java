package Models;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int currentplayer;
    private Dice dice;

    public  Game(ArrayList<Player> allplayer)
    {
        this.players = allplayer;
        this.currentplayer = 0;
        this.dice = new Dice();
    }

    public void play()
    {
        while(!isFinished())
        {

            int value = dice.role();

            Player cur_player = players.get(this.currentplayer);
            System.out.println("Current Player:"+cur_player.getName()+"  Dice Value:"+value+"  current completed piece:"+cur_player.getCompleteAllPieces());
            cur_player.movePiece(value);
            if(isFinished())
            {
                System.out.println("++++++++++WINNER POSITION+++++++++");
                System.out.println("Current Player:"+cur_player.getName()+"  Dice Value:"+value+"  current completed piece:"+cur_player.getCompleteAllPieces());
                System.out.println("Winner is :"+ cur_player.getName());
                break;
            }
            this.currentplayer = (this.currentplayer+1)%players.size();
        }

    }
    public boolean isFinished()
    {
        for(Player player:players)
        {
            if(player.completeAllPieces == 4)
            {
                return true;
            }
        }
        return false;
    }
}
