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

        Assert.assertTrue(node.isTerminal(true));

        node = nodes.get(1);
        Assert.assertFalse(node.isTerminal(true));
        Assert.assertFalse(node.isTerminal(false));
    }

}
