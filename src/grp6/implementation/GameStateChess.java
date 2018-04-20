package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.ArrayList;
import java.util.List;

public class GameStateChess implements Node {

    private char[] board = new char[64];
    private boolean whiteThreats;
    private boolean blackThreats;

    private int[] allmove = {1,7,8,9,-1,-7,-8,-9};
    private int[] crossmove = {7,9,-7,-9};
    private int[] alongmove = {1,8,-1,-8};
    private int[] knightmove = {6,10,15,17,-6,-10,-15,-17};

    List<Move> whiteMoves;
    List<Move> blackMoves;

    /*
    private class MoveCoordinate
    {
    	int from, to;
    	MoveCoordinate(int from, int to){
    	
    		this.from = from;
    		this.to = to;
    	}
    	
    }*/

    @Override
    public List<Move> getMoves(boolean isWhite) {
        //If we've already run getMoves once, then we should not do so again
        if(whiteMoves != null && isWhite){
            return whiteMoves;
        }
        if(blackMoves != null && !isWhite){
            return blackMoves;
        }

        //If it is the first time running getMoves, then initialize the Lists.
        whiteMoves = new ArrayList<Move>();
        blackMoves = new ArrayList<Move>();

        //Keep track of the current piece and whether the current piece is white
        char current;
        boolean isWhitePiece;
        Move moveToAdd = null;
        int end;

        for (int i = 0; i < board.length; i++) {
            current = Character.toLowerCase(board[i]);
            isWhitePiece = Character.isUpperCase(board[i]);

            switch (current) {
                //King's move
                case 'k':
                    for(int j : allmove){
                        end = j+i;
                        while(end >= 0 && end <= 63){
                            moveToAdd = new MoveChess(i, end, board[i], board[end], false);
                        }

                    }

                    break;
                //Queen's move
                case 'q':

                    break;
                //Bishop's move
                case 'b':

                    break;
                //Knight's move
                case 'n':

                    break;
                //Rook's move
                case 'r':

                    break;
                //Pawn's move
                case 'p':

                    break;
            }
            if(isWhite && moveToAdd != null){whiteMoves.add(moveToAdd);}
            else if(!isWhite && moveToAdd != null) {blackMoves.add(moveToAdd);}

        }

        if(isWhite){
            return whiteMoves;
        } else {
            return blackMoves;
        }
    }

    @Override
    public boolean isTerminal() {
        //Needs to be change when getMoves gets updated.
        for (int i = 0; i< board.length; i++) {
            if (board[i] == ('k')){
            List<Move> whiteKing = null;
            //whiteKing.clear();
            if (whiteKing == null) {
                return true;
            }
        }
        else if (board[i] ==('K') ) {
            List<Move> blackKing = null;
            //blackKing.clear();
            if (blackKing == null) {
                return true;
            }
        }
        }
        return false;
    }

    @Override
    public int getHeuristicValue() {
        return 0;
    }

    public char[] getBoard(){
        return board;
    }

    public void setBoard(char[] board){
        this.board = board;
    }

    public boolean isInCheck(boolean isWhite){
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                sb.append(board[7-i + 8*j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
