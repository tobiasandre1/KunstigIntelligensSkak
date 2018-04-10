package grp6.implementation;

import grp6.interfaces.AlphaBeta;
import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AlphaBetaV1 implements AlphaBeta{

    List<Move> path;

    @Override
    public int ab(Node node, int depth, int a, int b, boolean isMaximizer) {
        if(depth == 0 || node.isTerminal()){
            return node.getHeuristicValue();
        }

        int v;

        if(isMaximizer){
            v = -2147483640;
            for(Node n : node.getChildren()){
                v = max(v, ab(n, depth-1, a, b, false));
                a = max(a, v);
                if(b <= a) break;
            }
            return v;
        }
        else{
            v = 2147483640;
            for(Node n : node.getChildren()){
                v = min(v, ab(n, depth-1, a, b, false));
                b = min(b, v);
                if(b <= a) break;
            }
            return v;
        }
    }
}
