import grp6.implementation.GameStateChess;
import grp6.interfaces.Move;
import org.junit.Test;

import java.util.List;

public class GetMovesTest {

    @Test
    public void testGetMoves(){
        TestGameStates test = new TestGameStates();

        System.out.println("START GAME");
        GameStateChess state = (GameStateChess) test.getNodes().get(1);
        List<Move> moves = state.getMoves(true);
        for(Move m : moves){
            System.out.println(m.toString());
        }

        System.out.println("SECOND GAME");
        state = (GameStateChess) test.getNodes().get(2);
        moves = state.getMoves(true);
        for(Move m : moves){
            System.out.println(m.toString());
        }



    }
}
