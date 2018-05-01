package grp6;

import grp6.implementation.AlphaBetaV1;
import grp6.implementation.GameStateChess;
import grp6.implementation.MoveChess;
import grp6.interfaces.Move;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //start a testgame
        startGame();

    }


    public static void startGame() {
        Scanner input = new Scanner(System.in);
        AlphaBetaV1 chessAI = new AlphaBetaV1();
        TestGameStates test = new TestGameStates();
        GameStateChess state = (GameStateChess) test.getNodes().get(1);

        Move[] path;
        MoveChess move;
        String playerMove;
        String transPlayerMove;
        System.out.println("Welcome To Most Amazing Chess UI ever\n");
        System.out.println("White is represented with upper case chars, black lower case chars");
        System.out.println("Moves are entered like: a2a3\n");
        System.out.print("Choose your color: w/b: ");

        String playerColor = input.nextLine();

        boolean isAIWhite;
        boolean isAIturn = false;
        if (playerColor.equals("w")) {
            isAIWhite = false;
            System.out.println("You chose white.");
            System.out.println(state);
        } else {
            isAIWhite = true;
            isAIturn = true;
            System.out.println("You chose black");
        }
        //
        String msg ="";
        while (!state.isTerminal(isAIWhite)) {
            if(msg != ""){
                System.out.println(msg);
                msg = "";
            }

            if (!isAIturn) {
                //our move
                System.out.print("Enter move: ");
                playerMove = input.nextLine();
                //translate to our board representation
                try {
                    transPlayerMove = translateMove(playerMove);
                    //split stuff
                    String[] parts = transPlayerMove.split("-");

                    int startPos = Integer.valueOf(parts[0]);
                    int endPos = Integer.valueOf(parts[1]);
                    char mPiece = state.getBoard()[startPos];

                    move = new MoveChess(startPos, endPos, mPiece, ' ', false);
                    state = (GameStateChess) move.apply(state);
                } catch (Exception e){
                    StringBuilder sb = new StringBuilder();
                    sb.append("Something went wrong \n");

                    for(StackTraceElement element : e.getStackTrace()){
                        sb.append(element.toString()+"\n");
                    }
                    msg = sb.toString();

                }

            }
            if(msg == "") {
                //AIs move
                chessAI.ab(state, 4, -500000, 500000, isAIWhite);
                path = chessAI.getPath();
                move = (MoveChess) path[path.length - 1];
                state = (GameStateChess) move.apply(state);
                isAIturn = false;
                System.out.println(move);
                System.out.println(state);
                System.out.println();
            }
        }
    }

        //tramslates the move from normal representation to our
    public static String translateMove(String move) throws Exception{
        int startCol = colTranslate(move,0);
        int endCol = colTranslate(move,2);


        return String.valueOf((8*startCol)+Character.getNumericValue(move.charAt(1))-1)+"-" +
                String.valueOf((8*endCol)+Character.getNumericValue(move.charAt(3))-1);
    }


    public static int colTranslate(String move, int index) throws Exception {
        int a = 0;
        switch (move.charAt(index)) {
            case 'a':
                a = 0;
                break;
            case 'b':
                a = 1;
                break;
            case 'c':
                a = 2;
                break;
            case 'd':
                a = 3;
                break;
            case 'e':
                a = 4;
                break;
            case 'f':
                a = 5;
                break;
            case 'g':
                a = 6;
                break;
            case 'h':
                a = 7;
                break;
        }

        return a;
    }
}
