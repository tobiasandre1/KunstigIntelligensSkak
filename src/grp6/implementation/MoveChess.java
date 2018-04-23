package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

public class MoveChess implements Move {

    int startPos;       //Start position of the moving piece according to our representation
    int endPos;         //End position of the moving piece according to our representation
    char movingPiece;   //Used to represent which piece is moving, is technically made redundant by startpos and endpos, but might be useful if we validate moves
    char takenPiece;    //Used to store any taken pieces
    boolean special;    //Used to represent that this is a special move, like reshuffle (rokade) or moving to the end

    public MoveChess(){

    }

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

        //return sb.toString();

        return startPos + " " + endPos + " " + movingPiece + " " + takenPiece;
    }
}
