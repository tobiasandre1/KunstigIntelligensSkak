package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;
import java.util.List;

public class GameStateChess implements Node {

    private char[] board = new char[65];

    @Override
    public List<Move> getMoves() {
        return null;
    }

    @Override
    public boolean isTerminal() {

        for (int i = 0; i < getMoves().size(); i++) {
            if (Character.isLowerCase(getMoves().indexOf(i)) && getMoves().indexOf(i) == 'k'){
                List<Move> whiteKing = getMoves();
                if (whiteKing.isEmpty()) {
                    return true;
                }
            }
            else if (Character.isUpperCase(getMoves().indexOf(i) ) && getMoves().indexOf(i) == 'K'){
                List<Move> blackKing = getMoves();
                if (blackKing.isEmpty()) {
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
}
