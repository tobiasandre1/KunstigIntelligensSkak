package grp6.implementation;

import grp6.interfaces.AlphaBeta;
import grp6.interfaces.Move;
import grp6.interfaces.Node;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AlphaBetaV1 implements AlphaBeta{

    //List<Node> path;
    private Move[] path;
    private int[] scores;
    private Move[] temp;
    double starttime;


    @Override
    public int ab(Node node, int depth, int a, int b, boolean isMaximizer) {
        //path = new ArrayList<>();


        int result = -1000000;
        for(int i = depth; i <= depth; i++){
            path = new Move[depth];
            temp = new Move[depth];
            scores = new int[depth];
            starttime = System.currentTimeMillis();
            result = alphabeta(node, depth, a, b, isMaximizer);
            /*
            try{

                temp = path;
            } catch (Exception e){
                e.printStackTrace();
                break;
            }*/


        }

        return result;

        //return alphabeta(node, depth, a, b, isMaximizer);
    }

    public int alphabeta(Node node, int depth, int a, int b, boolean isMaximizer) {
        /*
        double curTime = System.currentTimeMillis();
        if(curTime-starttime > 5000.0){
            throw new Exception("Took too much time");
        }*/

        if(depth == 0 || node.isTerminal(isMaximizer)){
            return node.getStaticEvaluation();
        }

        int v;
        Move current = null;
        Move best = null;
        if(isMaximizer){
            //v = -2147483640;
            for(Move m : node.getMoves(isMaximizer)){
                current = m;
                v = alphabeta(m.apply(node), depth-1, a, b, !isMaximizer);

                if(a < v){
                    a=v;
                    best = current;
                }
                //a = max(a,v);
                if(b <= a){
                    break;
                }
            }
            scores[depth-1] = a;
            if(best != null){
                path[depth-1] = best;
            }
            //System.out.println(a);
            return a;
        }
        else{
            for(Move m : node.getMoves(isMaximizer)){
                current = m;
                v = alphabeta(m.apply(node), depth-1, a, b, !isMaximizer);

                if(b > v){
                    b = v;
                    best = current;
                }

                if(b <= a){
                    break;
                }
            }
            scores[depth-1] = b;
            if(best != null){
                path[depth-1] = best;
            }
            //System.out.println(b);
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
