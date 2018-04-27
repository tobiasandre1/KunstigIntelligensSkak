package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.Comparator;

public class MoveChess extends Move {

    public MoveChess(int startPos, int endPos, char movingPiece, char takenPiece, boolean special){
        this.startPos = startPos;
        this.endPos = endPos;
        this.movingPiece = movingPiece;
        this.takenPiece = takenPiece;
        this.special = special;
    }


    @Override
    public Node apply(Node state) {
        //We only want to apply our move if the GameState we are applying it to is an instance of GameStateChess
        if(state instanceof GameStateChess){
            GameStateChess game = new GameStateChess((GameStateChess) state);
            char[] board = game.getBoard();
            if(!special) {
                board[startPos] = ' ';
                board[endPos] = movingPiece;
            }
            game.setBoard(board);
            return game;
        }
        return null;
    }

    @Override
    public String toString(){ //We use toString to convert from our representation into chess move notation like e2e8
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};

        StringBuilder sb = new StringBuilder();
        sb.append(letters[(int)Math.floor(startPos/8)]);
        sb.append(startPos%8+1);
        sb.append(letters[(int)Math.floor(endPos/8)]);
        sb.append(endPos%8+1);

        return sb.toString();

      //  return startPos + " " + endPos + " " + movingPiece + " " + takenPiece;
    }
}
