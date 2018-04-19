package grp6.implementation;

import grp6.interfaces.AlphaBeta;
import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AlphaBetaV1 implements AlphaBeta{

    //List<Node> path;
    private Move[] path;
    private int[] scores;


    @Override
    public int ab(Node node, int depth, int a, int b, boolean isMaximizer) {
        //path = new ArrayList<>();
        path = new Move[depth];
        scores = new int[depth];
        return alphabeta(node, depth, a, b, isMaximizer);
    }

    public int alphabeta(Node node, int depth, int a, int b, boolean isMaximizer) {
        if(depth == 0 || node.isTerminal()){
            return node.getHeuristicValue();
        }

        Move current = null;
        if(isMaximizer){
            //v = -2147483640;
            for(Move m : node.getMoves()){
                current = m;
                a = max(a, alphabeta(m.apply(node), depth-1, a, b, !isMaximizer));
                if(b <= a){
                    break;
                }
            }
            scores[depth-1] = a;
            path[depth-1] = current;
            return a;
        }
        else{
            for(Move m : node.getMoves()){
                current = m;
                b = min(b, alphabeta(m.apply(node), depth-1, a, b, !isMaximizer));
                if(b <= a){
                    break;
                }
            }
            scores[depth-1] = b;
            path[depth-1] = current;
            return b;
        }
    }

    public int[] getScores() {
        return scores;
    }

    public Move[] getPath() {
        return path;
    }
}
//v = 2147483640;
