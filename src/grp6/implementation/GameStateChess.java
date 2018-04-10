package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.List;

public class GameStateChess implements Node {

    char[] board = new char[65];

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
}
