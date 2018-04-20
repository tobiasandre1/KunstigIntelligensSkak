package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameStateChess implements Node {

    private char[] board = new char[65];

    @Override
    public List<Move> getMoves() {
        return null;
    }

    @Override
    public boolean isTerminal() {
// Needs to be change for when Move interfaces is done and can be implemented correctly, at this point, the structure seems to be correct.
            if (getMoves().contains('k')){
                List<Move> whiteKing = getMoves();
                if (whiteKing.isEmpty()) {
                    return true;
                }
            }
            else if (getMoves().contains('K') ){
                List<Move> blackKing = getMoves();
                if (blackKing.isEmpty()) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public int getHeuristicValue() {
        return 0;
    }
}
