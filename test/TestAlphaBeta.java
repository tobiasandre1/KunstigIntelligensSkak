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


        //Start of white move
        chessAI.ab(state, 3, -270000, 27000, true); //Initial move with white
        Move[] path = chessAI.getPath();
        MoveChess move = (MoveChess) path[path.length-1];
        System.out.println(move);
        state = (GameStateChess) move.apply(state);
        //End of initial white move

        //Continued play...
        boolean isWhite;
        for(int i=0; i<11; i++){
            if(i%2 == 1){
                isWhite = true;
            } else {
                isWhite = false;
            }

            chessAI.ab(state, 3, -270000, 27000, isWhite);
            path = chessAI.getPath();
            move = (MoveChess) path[path.length-1];
            System.out.println(move);
            state = (GameStateChess) move.apply(state);
            System.out.println(state);

        }

        //System.out.println(state);

    }
}
