package grp6.interfaces;

import java.util.List;

public interface Node {

    List<Node> getChildren(); //Generate possible new gamestates
    boolean isTerminal(); //Check if game is over
    int getHeuristicValue();
}
