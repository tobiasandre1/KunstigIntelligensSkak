import grp6.implementation.AlphaBetaV1;
import grp6.implementation.GameStateChess;
import grp6.implementation.MoveChess;
import grp6.interfaces.Move;
import org.junit.Test;

import java.util.Scanner;

public class GUITest {

    Scanner input = new Scanner(System.in);
    AlphaBetaV1 chessAI = new AlphaBetaV1();

    TestGameStates test = new TestGameStates();

    GameStateChess state = (GameStateChess) test.getNodes().get(1);

@Test public void Test() {

    Move[] path;
    int[] scores;
    MoveChess move;
    System.out.println("Choose color: w/b ");
    String playerColor = input.nextLine();
    boolean isWhite;

    if(playerColor.equals("w")){
        isWhite = true;
        System.out.println("You chose white");
    }
    else{
        isWhite = false;
        System.out.println("You chose black");
    }
    System.out.println(state);

    /*
    for (int i = 1; i < 12; i++) {

        chessAI.ab(state, 4, -500000, 500000, isWhite);
        path = chessAI.getPath();
        move = (MoveChess) path[path.length - 1];
        scores = chessAI.getScores();
        state = (GameStateChess) move.apply(state);

        System.out.println(move);
        //System.out.println(scores);
        System.out.println(state);

    }
*/

}
}



