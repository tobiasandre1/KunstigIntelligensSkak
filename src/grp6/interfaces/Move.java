package grp6.interfaces;

import grp6.implementation.MoveChess;
import grp6.implementation.StaticEvaluation;

import java.util.Comparator;

public abstract class Move {

    public abstract Node apply(Node state); //Applies a move to the parent gamestate to get the child gamestate

    protected int startPos;       //Start position of the moving piece according to our representation
    protected int endPos;         //End position of the moving piece according to our representation
    protected char movingPiece;   //Used to represent which piece is moving, is technically made redundant by startpos and endpos, but might be useful if we validate moves
    protected char takenPiece;    //Used to store any taken pieces
    protected boolean special;    //Used to represent that this is a special move, like reshuffle (rokade) or moving to the end

    public int getHeuristicValue(){
        int tac, n;

        tac = StaticEvaluation.getScoreForPositionAndType(this.movingPiece, endPos)-StaticEvaluation.getScoreForPositionAndType(this.movingPiece, startPos);
        n = StaticEvaluation.calculatePieceValue(this.takenPiece);

        return tac + n;
    }


}
