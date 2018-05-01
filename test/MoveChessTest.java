import grp6.implementation.GameStateChess;
import grp6.implementation.MoveChess;
import grp6.interfaces.Move;
import grp6.interfaces.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MoveChessTest {

    @Test
    public void testApply() {
        TestGameStates testdata = new TestGameStates();
        List<Node> nodes = testdata.getNodes();
        Node node = nodes.get(1); //Use start board

        Move move = new MoveChess(25, 27, 'P', ' ', false);
        Node result = move.apply(node);

        GameStateChess resultstate = (GameStateChess) node;
        Assert.assertEquals('P', resultstate.getBoard()[27]);
        Assert.assertEquals(' ', resultstate.getBoard()[25]);

        System.out.println(node);

        Move move2 = new MoveChess(7+8, 5+(2*8), 'n', ' ', false);
        result = move2.apply(node);
        resultstate = (GameStateChess) node;
        Assert.assertEquals(' ', resultstate.getBoard()[7+8]);
        Assert.assertEquals('n', resultstate.getBoard()[5+(2*8)]);

        System.out.println(node);

    }

    @Test
    public void testShuffle(){
        TestGameStates testdata = new TestGameStates();
        List<Node> nodes = testdata.getNodes();
        Node node = nodes.get(4); //get gamestate

        Node result;

        Move shuffle1 = new MoveChess(32, 48, 'K', ' ', false);
        result = shuffle1.apply(node);

        System.out.println("Shuffle 1:");
        System.out.println(result);

        Move shuffle2 = new MoveChess(32, 8, 'K', ' ', false);
        result = shuffle2.apply(node);

        System.out.println("Shuffle 2:");
        System.out.println(result);

        Move shuffle3 = new MoveChess(39, 55, 'k', ' ', false);
        result = shuffle3.apply(node);

        System.out.println("Shuffle 3:");
        System.out.println(result);

        Move shuffle4 = new MoveChess(39, 15, 'k', ' ', false);
        result = shuffle4.apply(node);

        System.out.println("Shuffle 4:");
        System.out.println(result);

    }

    @Test
    public void testEnPassant(){
        TestGameStates testdata = new TestGameStates();
        List<Node> nodes = testdata.getNodes();
        Node node = nodes.get(4); //get gamestate

        Node result;

        Move ep1 = new MoveChess(44, 37, 'P', ' ', false);
        result = ep1.apply(node);

        System.out.println("En passant 1:");
        System.out.println(result);

        Move ep2 = new MoveChess(11, 18, 'p', ' ', false);
        result = ep2.apply(node);

        System.out.println("En passant 2:");
        System.out.println(result);
    }
}
