package grp6.interfaces;

import java.util.List;

public interface Node {

    List<Move> getMoves(boolean isWhite); //Generate all legal moves for the current gamestate (for alphabeta)
    boolean isTerminal(boolean isWhite); //Check if game is over (checkmate)
    int getStaticEvaluation(); //Get static evaluation of game board
}
