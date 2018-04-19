package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.List;

public class GameStateChess implements Node {

    private char[] board = new char[64];

    @Override
    public List<Move> getMoves() {
        return null;
    }

    @Override
    public boolean isTerminal() {
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
