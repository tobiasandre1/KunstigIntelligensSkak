import grp6.implementation.AlphaBetaV1;
import grp6.implementation.GameStateChess;
import grp6.implementation.MoveChess;
import grp6.interfaces.AlphaBeta;
import grp6.interfaces.Move;
import org.junit.Test;

public class TestAlphaBeta {

    @Test
    public void testAB(){
        AlphaBetaV1 chessAI = new AlphaBetaV1();
        TestGameStates test = new TestGameStates();

        GameStateChess state = (GameStateChess) test.getNodes().get(1);

        Move[] path;
        int[] scores;
        MoveChess move;

        //Continued play...
        boolean isWhite;
        for(int i=1; i<12; i++){
            if(i%2 == 1){
                isWhite = true;
            } else {
                isWhite = false;
            }

            chessAI.ab(state, 4, -500000, 500000, isWhite);
            path = chessAI.getPath();
            move = (MoveChess) path[path.length-1];
            scores = chessAI.getScores();
            state = (GameStateChess) move.apply(state);

            System.out.println(move);
            //System.out.println(scores);
            System.out.println(state);


        }

        //System.out.println(state);

    }
}
