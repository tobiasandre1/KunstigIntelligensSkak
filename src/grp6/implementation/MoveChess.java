package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.Comparator;

public class MoveChess extends Move {

    public MoveChess(int startPos, int endPos, char movingPiece, char takenPiece, boolean special){
        this.startPos = startPos;
        this.endPos = endPos;
        this.movingPiece = movingPiece;
        this.takenPiece = takenPiece;
        this.special = special;
    }


    @Override
    public Node apply(Node state) {
        //We only want to apply our move if the GameState we are applying it to is an instance of GameStateChess
        if(state instanceof GameStateChess){
            GameStateChess game = new GameStateChess((GameStateChess) state);
            char[] board = game.getBoard();

            //Normal move
            board[startPos] = ' ';
            board[endPos] = movingPiece;


            //Shuffles
            if(movingPiece == 'K' && startPos == 32){
                switch (endPos){
                    case 48:
                        board[56] = ' ';
                        board[40] = 'R';
                        break;
                    case 8:
                        board[0] = ' ';
                        board[16] = 'R';
                }
            }
            if(movingPiece == 'k' && startPos == 39){
                switch (endPos){
                    case 55:
                        board[63] = ' ';
                        board[47] = 'r';
                        break;
                    case 15:
                        board[7] = ' ';
                        board[23] = 'r';
                }
            }

            //En passant
            if(movingPiece == 'P' && endPos%8==5){
                if(board[endPos-1] == 'p' && takenPiece == ' '){
                    board[endPos-1] = ' ';
                    takenPiece = 'p';
                }
            }
            if(movingPiece == 'p' && endPos%8==2){
                if(board[endPos+1] == 'P' && takenPiece == ' '){
                    board[endPos+1] = ' ';
                    takenPiece = 'P';
                }
            }

            game.setBoard(board);
            return game;
        }
        return null;
    }

    @Override
    public String toString(){ //We use toString to convert from our representation into chess move notation like e2e8
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};

        StringBuilder sb = new StringBuilder();
        sb.append(letters[(int)Math.floor(startPos/8)]);
        sb.append(startPos%8+1);
        sb.append(letters[(int)Math.floor(endPos/8)]);
        sb.append(endPos%8+1);

        return sb.toString();

      //  return startPos + " " + endPos + " " + movingPiece + " " + takenPiece;
    }
}
