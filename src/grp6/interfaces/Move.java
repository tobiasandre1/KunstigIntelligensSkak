package grp6.interfaces;

import grp6.implementation.MoveChess;
import grp6.implementation.StaticEvaluation;

import java.util.Comparator;

public abstract class Move implements Comparable<Move>, Comparator<Move> {

    public abstract Node apply(Node state); //Applies a move to the parent gamestate to get the child gamestate

    protected int startPos;       //Start position of the moving piece according to our representation
    protected int endPos;         //End position of the moving piece according to our representation
    protected char movingPiece;   //Used to represent which piece is moving, is technically made redundant by startpos and endpos, but might be useful if we validate moves
    protected char takenPiece;    //Used to store any taken pieces
    protected boolean special;    //Used to represent that this is a special move, like reshuffle (rokade) or moving to the end

    @Override
    public int compareTo(Move o2){
        int n1, n2, tac1, tac2;
        /*
        n1 =  StaticEvaluation.calculatePieceValue(this.takenPiece)+StaticEvaluation.getScoreForPositionAndType(this.movingPiece, endPos);
        n2 =  StaticEvaluation.calculatePieceValue(o2.takenPiece)+StaticEvaluation.getScoreForPositionAndType(o2.movingPiece, endPos);
        */
        tac1 = StaticEvaluation.getScoreForPositionAndType(this.movingPiece, startPos)-StaticEvaluation.getScoreForPositionAndType(this.movingPiece, endPos);
        tac2 = StaticEvaluation.getScoreForPositionAndType(this.movingPiece, startPos)-StaticEvaluation.getScoreForPositionAndType(this.movingPiece, endPos);

        n1 = StaticEvaluation.calculatePieceValue(this.takenPiece)+tac1;
        n2 = StaticEvaluation.calculatePieceValue(o2.takenPiece)+tac2;
        if(n2-n1 > 0){
            return -1;
        }
        if(n2-n1 < 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int compare(Move o1, Move o2) {
        return o1.compareTo(o2);
    }
}
