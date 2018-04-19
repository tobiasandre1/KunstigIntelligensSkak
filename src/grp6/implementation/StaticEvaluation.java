package grp6.implementation;

public class StaticEvaluation {




    public  int calculateScores(char[] board){

 /*
        int whitePlayer =  getMatericalCount(board, true)+ getPositionCount(board, true);
        int blackPlayer =  getMatericalCount(board, false);
*/
        return 0;

    }

    //metode der tæller alle brikkernes værdier
    public  int getMatericalCount(char[] board, boolean isWhite){

        int result = 0;

        for (int i = 0; i < board.length; i++) {
            result += CalculatePieceValue(board[i], isWhite);
        }

        return result;
    }

    //udregner ens brik værdi
    private static int CalculatePieceValue(char pieceType, boolean isWhite) {

        switch ((pieceType)) {
            //pawn - bonde
            case 'P': { return 100; }
            //Knight - knægt
            case 'N': { return 320; }
            //Bishop - springer
            case 'B': { return 335; }
            //rook - tårn
            case 'R': { return 500; }
            //queen - dronning
            case 'Q': { return 900; }
            //king - konge
            case 'K': { return 20000; }
            //pawn - bonde
            case 'p': { return -100; }
            //Knight - knægt
            case 'n': { return -320; }
            //Bishop - springer
            case 'b': { return -335; }
            //rook - tårn
            case 'r': { return -500; }
            //queen - dronning
            case 'q': { return -900; }
            //king - konge
            case 'k': { return -20000; }
            default: { return 0; }
        }

    }




    //tæller summen af position af type.
    public int getPositionCount(char[] board, boolean isWhite){
        int result =0;

        for (int i = 0; i < board.length; i++) {
            //System.out.println(result);
            result += getScoreForPositionAndType(board[i],i,isWhite);
        }

        return result;
    }





    private  int getScoreForPositionAndType(char pieceType, int position, boolean isWhite){
        int result = 0;
        if(isWhite) {

            switch ((pieceType)) {
                //pawn - bonde
                case 'P': { result = pawnTable[position]; }
                System.out.println("p" + result);
                break;
                //Knight - knægt
                case 'N': { result =  knightTable[position]; }
                break;
                //Bishop - springer
                case 'B': { result =  bishopTable[position]; }
                break;
                //rook - tårn
                case 'R': { result =  rookTable[position]; }
                break;
                //queen - dronning
                case 'Q': {result =  queenTable[position]; }
                break;
                //king - konge
                case 'K': { result =  kingTable[position]; }
                break;
                default: {break; }
            }

        }

        return result;
    }

    public int getValue(int index){return pawnTable[index];};
    public static short[] pawnTable = new short[]{
            0,  0,  0,  0,  0,  0,  0,  0,
            50, 50, 50, 50, 50, 50, 50, 50,
            10, 10, 20, 30, 30, 20, 10, 10,
            5,  5, 10, 27, 27, 10,  5,  5,
            0,  0,  0, 25, 25,  0,  0,  0,
            5, -5,-10,  0,  0,-10, -5,  5,
            5   , 10, 10,-25,-25, 10, 10,  5,
            0,  0,  0,  0,  0,  0,  0,  0
    };


    private static  short[] knightTable = new short[]{

            -50,-40,-30,-30,-30,-30,-40,-50,
            -40,-20,  0,  0,  0,  0,-20,-40,
            -30,  0, 10, 15, 15, 10,  0,-30,
            -30,  5, 15, 20, 20, 15,  5,-30,
            -30,  0, 15, 20, 20, 15,  0,-30,
            -30,  5, 10, 15, 15, 10,  5,-30,
            -40,-20,  0,  5,  5,  0,-20,-40,
            -50,-40,-20,-30,-30,-20,-40,-50,
    };

    private static short[] bishopTable = new short[]{
            -20,-10,-10,-10,-10,-10,-10,-20,
            -10,  0,  0,  0,  0,  0,  0,-10,
            -10,  0,  5, 10, 10,  5,  0,-10,
            -10,  5,  5, 10, 10,  5,  5,-10,
            -10,  0, 10, 10, 10, 10,  0,-10,
            -10, 10, 10, 10, 10, 10, 10,-10,
            -10,  5,  0,  0,  0,  0,  5,-10,
            -20,-10,-40,-10,-10,-40,-10,-20,
    };

    private static short[] rookTable = new short[]{
            0,  0,  0,  0,  0,  0,  0,  0,
            5, 10, 10, 10, 10, 10, 10,  5,
            -5,  0,  0,  0,  0,  0,  0, -5,
            -5,  0,  0,  0,  0,  0,  0, -5,
            -5,  0,  0,  0,  0,  0,  0, -5,
            -5,  0,  0,  0,  0,  0,  0, -5,
            -5,  0,  0,  0,  0,  0,  0, -5,
            0,  0,  0,  5,  5,  0,  0,  0
    };

    private static short[] queenTable = new short[]{
            -20,-10,-10, -5, -5,-10,-10,-20,
            -10,  0,  0,  0,  0,  0,  0,-10,
            -10,  0,  5,  5,  5,  5,  0,-10,
            -5,  0,  5,  5,  5,  5,  0, -5,
            0,  0,  5,  5,  5,  5,  0, -5,
            -10,  5,  5,  5,  5,  5,  0,-10,
            -10,  0,  5,  0,  0,  0,  0,-10,
            -20,-10,-10, -5, -5,-10,-10,-20
    };

    private static short[] kingTable = new short[]{
            -30, -40, -40, -50, -50, -40, -40, -30,
            -30, -40, -40, -50, -50, -40, -40, -30,
            -30, -40, -40, -50, -50, -40, -40, -30,
            -30, -40, -40, -50, -50, -40, -40, -30,
            -20, -30, -30, -40, -40, -30, -30, -20,
            -10, -20, -20, -20, -20, -20, -20, -10,
            20,  20,   0,   0,   0,   0,  20,  20,
            20,  30,  10,   0,   0,  10,  30,  20
    };

    private static short[] kingTableEndGame = new short[]{
            -50,-40,-30,-20,-20,-30,-40,-50,
            -30,-20,-10,  0,  0,-10,-20,-30,
            -30,-10, 20, 30, 30, 20,-10,-30,
            -30,-10, 30, 40, 40, 30,-10,-30,
            -30,-10, 30, 40, 40, 30,-10,-30,
            -30,-10, 20, 30, 30, 20,-10,-30,
            -30,-30,  0,  0,  0,  0,-30,-30,
            -50,-30,-30,-30,-30,-30,-30,-50
    };

}
