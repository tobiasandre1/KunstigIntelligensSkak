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
}
