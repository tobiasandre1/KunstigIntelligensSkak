import grp6.implementation.GameStateChess;
import grp6.implementation.StaticEvaluation;
import org.junit.Assert;
import org.junit.Test;

public class StaticEvalTest {

    @Test
    public void testMaterialCount(){

        char[] board = new char[64];
        StaticEvaluation eval = new StaticEvaluation();

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


        //(8*100)+(2*320)+(2*335)+(2*500)+(1*900)+20000 = 24010
        Assert.assertEquals(0, eval.getMatericalCount(board,false));
    }

    @Test
    public void testPositionType(){
        char[] board = new char[64];
        StaticEvaluation eval = new StaticEvaluation();

        int ourIndex = 45;
        board[ourIndex] = 'P';

        System.out.println(Math.floor((ourIndex/8)+8*(7-ourIndex%8)));



    }


}
