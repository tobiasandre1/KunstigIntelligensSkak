package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

public class MoveChess implements Move {

    int startPos;       //Start position of the moving piece according to our representation
    int endPos;         //End position of the moving piece according to our representation
    char movingPiece;   //Used to represent which piece is moving, is technically made redundant by startpos and endpos, but might be useful if we validate moves
    char takenPiece;    //Used to store any taken pieces
    boolean special;    //Used to represent that this is a special move, like reshuffle (rokade) or moving to the end

    @Override
    public Node apply(Node state) {
        //We only want to apply our move if the GameState we are applying it to is an instance of GameStateChess
        if(state instanceof GameStateChess){
            //TODO Implement here
            return null;
        }
        return null;
    }

    @Override
    public String toString(){ //We use toString to convert from our representation into chess move notation like e2e8

        return null;
    }
}
