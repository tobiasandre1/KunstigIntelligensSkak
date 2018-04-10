package grp6.interfaces;

import java.util.List;

public interface Node {

    List<Move> getMoves(); //Generate all legal moves for the current gamestate (for alphabeta)
    boolean isTerminal(); //Check if game is over (checkmate)
    int getHeuristicValue(); //Get static evaluation of game board
}
