import grp6.interfaces.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestIsTerminal {

    @Test
    public void testIsTerminal() {
        TestGameStates testdata = new TestGameStates();
        List<Node> nodes = testdata.getNodes();
        Node node = nodes.get(2); //Use Check mate position

        Assert.assertEquals(true, node.isTerminal());

        Assert.assertTrue(node.isTerminal());

        // Assert.assertEquals(
    }

}
