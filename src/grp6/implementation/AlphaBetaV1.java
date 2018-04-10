package grp6.implementation;

import grp6.interfaces.AlphaBeta;
import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AlphaBetaV1 implements AlphaBeta{

    List<Node> path;

    @Override
    public int ab(Node node, int depth, int a, int b, boolean isMaximizer) {
        path = new ArrayList<>();
        return alphabeta(node, depth, a, b, isMaximizer);
    }

    public int alphabeta(Node node, int depth, int a, int b, boolean isMaximizer) {
        if(depth == 0 || node.isTerminal()){
            //path.add(node);
            return node.getHeuristicValue();
        }

        int v;

        if(isMaximizer){
            v = -2147483640;
            for(Move m : node.getMoves()){
                v = max(v, alphabeta(m.apply(node), depth-1, a, b, false));
                a = max(a, v);
                if(b <= a){
                    //path.add(n);
                    break;
                }
            }
            return v;
        }
        else{
            v = 2147483640;
            for(Move m : node.getMoves()){
                v = min(v, alphabeta(m.apply(node), depth-1, a, b, false));
                b = min(b, v);
                if(b <= a){
                    //path.add(n);
                    break;
                }
            }
            return v;
        }
    }
}
