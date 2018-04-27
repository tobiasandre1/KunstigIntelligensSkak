package grp6;

import grp6.implementation.AlphaBetaV1;
import grp6.implementation.GameStateChess;
import grp6.implementation.MoveChess;
import grp6.interfaces.AlphaBeta;
import grp6.interfaces.Move;

import java.util.Scanner;

public class Main {



    public static void startGame() {
        Scanner input = new Scanner(System.in);
        AlphaBetaV1 chessAI = new AlphaBetaV1();
        TestGameStates test = new TestGameStates();
        GameStateChess state = (GameStateChess) test.getNodes().get(1);
        Move[] path;


        MoveChess move;
        String playerMove;
        System.out.println("Choose color: w/b ");

        String playerColor = input.nextLine();

        boolean isAIWhite;

        if (playerColor.equals("w")) {
            isAIWhite = false;
            System.out.println("You chose white.");
        } else {
            isAIWhite = true;
            System.out.println("You chose black");
        }
        System.out.println(state);
        while(!state.isTerminal(isAIWhite)) {

            //
            System.out.print("Enter move: ");
            playerMove = input.nextLine();
            String[] parts = playerMove.split("-");
            int startPos = Integer.valueOf(parts[0]);
            int endPos = Integer.valueOf(parts[1]);
            char mPiece = parts[2].charAt(0);
            // char tPiece =  parts[3].charAt(0);
            move = new MoveChess(startPos, endPos, mPiece, ' ', false);

            state = (GameStateChess) move.apply(state);

            //AIs move
            chessAI.ab(state, 4, -500000, 500000, isAIWhite);
            path = chessAI.getPath();
            move = (MoveChess) path[path.length - 1];
            state = (GameStateChess) move.apply(state);

            System.out.println(state);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        startGame();
    }
}
