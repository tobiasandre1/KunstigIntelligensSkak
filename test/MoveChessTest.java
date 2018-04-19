import grp6.implementation.GameStateChess;
import grp6.implementation.MoveChess;
import grp6.interfaces.Move;
import grp6.interfaces.Node;
import org.junit.Assert;
import org.junit.Test;

public class MoveChessTest {

    @Test
    public void testApply() {
        GameStateChess state = new GameStateChess();
        char[] board = new char[64];
        for(char c: board){
            c = ' ';
        }
        for(int i = 1; i<board.length; i=i+8){
            board[i] = 'P';
        }
        for(int i = 6; i<board.length; i=i+8){
            board[i] = 'p';
        }
        board[0] = 'R';
        board[56] = 'R';
        board[7] = 'r';
        board[63] = 'r';
        board[8] = 'N';
        board[48] = 'N';
        board[15] = 'n';
        board[55] = 'n';
        board[16] = 'B';
        board[40] = 'B';
        board[23] = 'b';
        board[47] = 'b';
        board[23] = 'b';
        board[24] = 'Q';
        board[31] = 'q';
        board[32] = 'K';
        board[39] = 'k';

        state.setBoard(board);
        Node node = state;

        Move move = new MoveChess(25, 27, 'P', ' ', false);
        Node result = move.apply(node);

        GameStateChess resultstate = (GameStateChess) node;
        Assert.assertEquals('P', resultstate.getBoard()[27]);
        Assert.assertEquals(' ', resultstate.getBoard()[25]);

        System.out.println(board);
    }
}
