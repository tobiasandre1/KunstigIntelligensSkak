package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

public class MoveChess implements Move {



    @Override
    public Node apply(Node state) {
        if(state instanceof GameStateChess){
            //TODO Implement here
            return null;
        }
        return null;
    }
}
