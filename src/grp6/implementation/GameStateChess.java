package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStateChess implements Node {

    private char[] board;

    private int[] allmove = {1,7,8,9,-1,-7,-8,-9};
    private int[] crossmove = {7,9,-7,-9};
    private int[] alongmove = {1,8,-1,-8};
    private int[] knightmove = {6,10,15,17,-6,-10,-15,-17};
    private int[] pawnattack = {-7, 9};

    List<Move> whiteMoves;
    List<Move> blackMoves;


    public GameStateChess(){
        board = new char[64];
    }

    public GameStateChess(GameStateChess state){
        board = new char[64];
        System.arraycopy(state.getBoard(), 0, this.board, 0, 64);
    }

    @Override
    public List<Move> getMoves(boolean isWhite) {
        //If we've already run getMoves once, then we should not do so again
        if(whiteMoves != null && isWhite){
            return whiteMoves;
        }
        if(blackMoves != null && !isWhite){
            return blackMoves;
        }

        //If it is the first time running getMoves, then initialize the Lists.
        if(isWhite){
            whiteMoves = new ArrayList<>();
        } else {
            blackMoves = new ArrayList<>();
        }

        List<Move> pawnMoves = new ArrayList<>();

        //Keep track of the current piece and whether the current piece is white
        char current;
        boolean isWhitePiece;
        Move moveToAdd;
        int end, prev;
        double distance;
        GameStateChess check;
        boolean tookPiece;

        //We go through the board. Each piece has moves generated for it.
        for (int i = 0; i < board.length; i++) {
            current = Character.toLowerCase(board[i]); //This is the current type of piece we are looking at
            isWhitePiece = Character.isUpperCase(board[i]); //This is whether the piece we are looking at is white

            switch (current) {
                //King's move
                case 'k':
                    for(int j : allmove){
                        prev = i;
                        end = j+i;
                        while(insideNotKing(end)){
                            distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                            if(distance > 2){
                                break;
                            }

                            tookPiece = tookPiece(end, isWhitePiece);
                            //We start by checking if we are allowed to take the piece at the end of our move
                            if(tookPiece || board[end]==' ') {
                                moveToAdd = new MoveChess(i, end, board[i], board[end], false);

                                //Check if the move is legal
                                check = (GameStateChess) moveToAdd.apply(this);
                                if (!check.isInCheck(isWhite)) {
                                    if (isWhite && isWhitePiece) {
                                        whiteMoves.add(moveToAdd);
                                    } else if (!isWhite && !isWhitePiece) {
                                        blackMoves.add(moveToAdd);
                                    }
                                }
                                //if we actually came across an enemy piece in our move, we are not allowed to move further
                                if(tookPiece){
                                    break;
                                } else{
                                    break; //The king cannot move further anyway
                                }
                            } else{
                                //if the square is not empty, and it's not an enemy piece, then it must be a friendly piece blocking our movement
                                break;
                            }
                        }

                    }
                    break;
                //Queen's move
                case 'q':
                    for(int j : allmove){
                        prev = i;
                        end = j+i;
                        while(insideNotKing(end)){
                            distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                            if(distance > 2){
                                break;
                            }
                            tookPiece = tookPiece(end, isWhitePiece);
                            //We start by checking if we are allowed to take the piece at the end of our move
                            if(tookPiece || board[end]==' ') {
                                moveToAdd = new MoveChess(i, end, board[i], board[end], false);

                                //Check if the move is legal
                                check = (GameStateChess) moveToAdd.apply(this);
                                if (!check.isInCheck(isWhite)) {
                                    if (isWhite && isWhitePiece) {
                                        whiteMoves.add(moveToAdd);
                                    } else if (!isWhite && !isWhitePiece) {
                                        blackMoves.add(moveToAdd);
                                    }
                                }
                                //if we actually came across an enemy piece in our move, we are not allowed to move further
                                if(tookPiece){
                                    break;
                                } else {
                                    prev = end;
                                    end += j;
                                }
                            } else{
                                //if the square is not empty, and it's not an enemy piece, then it must be a friendly piece blocking our movement
                                break;
                            }
                        }

                    }
                    break;
                //Bishop's move
                case 'b':
                    for(int j : crossmove){
                        prev = i;
                        end = j+i;
                        while(insideNotKing(end)){
                            distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                            if(distance > 2){
                                break;
                            }
                            tookPiece = tookPiece(end, isWhitePiece);
                            //We start by checking if we are allowed to take the piece at the end of our move
                            if(tookPiece || board[end]==' ') {
                                moveToAdd = new MoveChess(i, end, board[i], board[end], false);

                                //Check if the move is legal
                                check = (GameStateChess) moveToAdd.apply(this);
                                if (!check.isInCheck(isWhite)) {
                                    if (isWhite && isWhitePiece) {
                                        whiteMoves.add(moveToAdd);
                                    } else if (!isWhite && !isWhitePiece) {
                                        blackMoves.add(moveToAdd);
                                    }
                                }
                                //if we actually came across an enemy piece in our move, we are not allowed to move further
                                if(tookPiece){
                                    break;
                                } else {
                                    prev = end;
                                    end += j;
                                }
                            } else{
                                //if the square is not empty, and it's not an enemy piece, then it must be a friendly piece blocking our movement
                                break;
                            }
                        }

                    }
                    break;
                //Knight's move
                case 'n':
                    for(int j : knightmove) {
                        prev = i;
                        end = j+i;
                        while(insideNotKing(end)){
                            distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                            if(distance > 3){
                                break;
                            }
                            tookPiece = tookPiece(end, isWhitePiece);
                            //We start by checking if we are allowed to take the piece at the end of our move
                            if (tookPiece || board[end] == ' ') {
                                moveToAdd = new MoveChess(i, end, board[i], board[end], false);

                                //Check if the move is legal
                                check = (GameStateChess) moveToAdd.apply(this);
                                if (!check.isInCheck(isWhite)) {
                                    if (isWhite && isWhitePiece) {
                                        whiteMoves.add(moveToAdd);
                                    } else if (!isWhite && !isWhitePiece) {
                                        blackMoves.add(moveToAdd);
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;
                //Rook's move
                case 'r':
                    for(int j : alongmove){
                        prev = i;
                        end = j+i;
                        while(insideNotKing(end)){
                            distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                            if(distance > 1){
                                break;
                            }
                            tookPiece = tookPiece(end, isWhitePiece);
                            //We start by checking if we are allowed to take the piece at the end of our move
                            if(tookPiece || board[end]==' ') {
                                moveToAdd = new MoveChess(i, end, board[i], board[end], false);

                                //Check if the move is legal
                                check = (GameStateChess) moveToAdd.apply(this);
                                if (!check.isInCheck(isWhite)) {
                                    if (isWhite && isWhitePiece) {
                                        whiteMoves.add(moveToAdd);
                                    } else if (!isWhite && !isWhitePiece) {
                                        blackMoves.add(moveToAdd);
                                    }
                                }
                                //if we actually came across an enemy piece in our move, we are not allowed to move further
                                if(tookPiece){
                                    break;
                                } else {
                                    prev = end;
                                    end += j;
                                }
                            } else{
                                //if the square is not empty, and it's not an enemy piece, then it must be a friendly piece blocking our movement
                                break;
                            }
                        }

                    }
                    break;
                //Pawn's move
                case 'p':
                    if(isWhitePiece == !isWhite){
                        break;
                    }
                    int factor = 1;
                    if(!isWhite){
                        factor = -1;
                    }

                    end = i+factor;
                    if(end >= 0 && end < 64) {
                        if(board[end] == ' ') {
                            pawnMoves.add(new MoveChess(i, end, board[i], board[end], false));
                            //This part is for the double move at the start of the game
                            if ((i % 8 == 1 && isWhite) || (i % 8 == 6 && !isWhite)) {
                                end += factor;
                                if (board[end] == ' ' && end >= 0 && end < 64) {
                                    pawnMoves.add(new MoveChess(i, end, board[i], board[end], false));
                                }
                            }
                        }
                    }

                    for(int j: pawnattack){
                        end = i+j*factor;
                        if(insideNotKing(end)) {

                            tookPiece = tookPiece(end, isWhitePiece);
                            if (tookPiece) {
                                pawnMoves.add(new MoveChess(i, end, board[i], board[end], false));
                            }
                        }
                    }

                    break;
            }

        }
        for(Move m: pawnMoves){
            //Check if the move is legal
            check = (GameStateChess) m.apply(this);
            if (!check.isInCheck(isWhite)) {
                if (isWhite) {
                    whiteMoves.add(m);
                } else {
                    blackMoves.add(m);
                }
            }
        }


        if(isWhite){
            return Sort.sortList(whiteMoves, isWhite);
            /*
            Collections.sort(whiteMoves);
            return whiteMoves;*/
        } else {
            /*
            Collections.sort(blackMoves);
            return blackMoves;*/
            return Sort.sortList(blackMoves, !isWhite);
        }
    }

    @Override
    public boolean isTerminal(boolean isWhite) {
        if(getMoves(isWhite).size() < 1){
            return true;
        }
        return false;
    }

    @Override
    public int getStaticEvaluation() {
        return StaticEvaluation.calculateScores(this);
    }

    public char[] getBoard(){
        return board;
    }

    public void setBoard(char[] board){
        this.board = board;
    }

    public boolean isInCheck(boolean isWhite){
        for(int i = 0; i<board.length; i++){
            if(board[i] == 'K' && isWhite){
                return isThreatened(i, true);
            }
            if(board[i] == 'k' && !isWhite){
                return isThreatened(i, false);
            }
        }
        return false;
    }

    public boolean isThreatened(int pos, boolean isWhite){
        int end, prev;
        double distance;
        for(int m : knightmove){
            prev = pos;
            end = pos + m;
            //System.out.println(t + " " + board[t]);
            distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
            if(end<64 && end>=0 && distance < 4){ //If the square we are potentially threatened from is inside the board

                //Then we check whether the piece on that square is a knight of the opposite color. Only if this is the case do we return true.
                if((board[end]=='n' && isWhite) || (board[end]=='N' && !isWhite)){
                    return true;
                }
            }
        }
        int factor = -1; //Needs to be the opposite of the pawn's normal attack since we are looking the other way
        if(isWhite){
            factor = 1;
        }
        for(int m : pawnattack){
            end = pos + (m*factor);
            if(end<64 && end>=0){
                //We do the same, but for the pawn's attack
                if((board[end]=='p' && isWhite) || (board[end]=='P' && !isWhite)){
                    //System.out.println("wut");
                    return true;
                }
            }
        }
        for(int m : crossmove){
            prev = pos;
            end = pos + m;
            while(end<64 && end>=0){
                distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                if(distance > 2){
                    break;
                }
                if(Character.isUpperCase(board[end]) && isWhite || Character.isLowerCase(board[end]) && !isWhite){
                    break;
                }
                //System.out.println(t + " " + board[t]);
                //We do the same, but for the queen and bishop attack
                if(((board[end]=='q' || board[end]=='b') && isWhite) || ((board[end]=='Q' || board[end]=='B') && !isWhite)){
                    //System.out.println("waat");
                    return true;
                } else if(board[end] != ' '){
                    break;
                }

                prev = end;
                end += m;
            }
        }
        for(int m : alongmove){
            prev = pos;
            end = pos + m;
            while(end<64 && end>=0){
                distance = Math.abs(end%8-prev%8)+Math.abs(Math.floor(end/8)-Math.floor(prev/8));
                if(distance > 1){
                    break;
                }
                if(Character.isUpperCase(board[end]) && isWhite || Character.isLowerCase(board[end]) && !isWhite){
                    break;
                }
                //We do the same, but for the queen and bishop attack
                if(((board[end]=='q' || board[end]=='r') && isWhite) || ((board[end]=='Q' || board[end]=='R') && !isWhite)){
                    return true;
                } else if(board[end] != ' '){
                    break;
                }

                end += m;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                sb.append(board[7-i + 8*j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean insideNotKing(int pos){
        if(pos < 64 && pos >= 0){
            if(board[pos] != 'K' && board[pos] != 'k'){
                return true;
            }
        }
        return false;
    }

    private boolean tookPiece(int end, boolean isWhitePiece){
        if((Character.isUpperCase(board[end]) && !isWhitePiece) || (Character.isLowerCase(board[end]) && isWhitePiece)){
            return true;
        }
        return false;
    }
}
