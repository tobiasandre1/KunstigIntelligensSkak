package grp6.implementation;

import grp6.interfaces.Node;

import java.util.List;

public class GameStateChess implements Node {


    @Override
    public List<Node> getChildren() {
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
