import grp6.implementation.GameStateChess;
import org.junit.Assert;
import org.junit.Test;

public class isInCheckTest {

    @Test
    public void testIsInCheck(){
        TestGameStates test = new TestGameStates();
        GameStateChess state1 = (GameStateChess) test.getNodes().get(1);
        GameStateChess state2 = (GameStateChess) test.getNodes().get(2);
        GameStateChess state3 = (GameStateChess) test.getNodes().get(3);

        System.out.println(state1);

        Assert.assertEquals(false, state1.isInCheck(true));
        Assert.assertEquals(true, state2.isInCheck(true));
        Assert.assertEquals(false, state3.isInCheck(false));
    }

    @Test
    public void pawnCheckTest(){
        TestGameStates test = new TestGameStates();
        GameStateChess state1 = (GameStateChess) test.getNodes().get(5);

        Assert.assertEquals(true, state1.isInCheck(true));
        Assert.assertEquals(true, state1.isInCheck(false));
    }
}
