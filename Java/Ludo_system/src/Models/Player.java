package Models;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Pieces> pieces;
    int completeAllPieces;

    public Player(String name, ArrayList<Pieces> pieces) {
        this.name = name;
        this.pieces = pieces;
        completeAllPieces = 0;
    }

    public String getName() {
        return name;
    }

    public int getCompleteAllPieces() {
        return completeAllPieces;
    }

    public void movePiece(int dicerole)
    {
        for(Pieces piece:pieces)
        {
            System.out.println("PIECE:"+piece.getColor()+" curposition:"+piece.getPosition());
            if(piece.isAtStart() && dicerole!=6)
            {
                continue;
            }
            else if(piece.isOnBoard())
            {
                System.out.println("HLO");
                piece.move(dicerole);
                if(piece.isFinished())
                {
                    completeAllPieces++;
                }
                break;
            }

        }
    }
}
