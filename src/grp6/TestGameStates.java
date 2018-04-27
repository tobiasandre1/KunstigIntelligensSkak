package grp6;

import grp6.implementation.GameStateChess;
import grp6.interfaces.Node;

import java.util.ArrayList;
import java.util.List;

public class TestGameStates {

    private List<Node> nodes;

    private char[][] empty = { //0
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '}
    };

    private char[][] start = { //1
            {'r','n','b','q','k','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','Q','K','B','N','R'}
    };

    private char[][] checkmate = { //2
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'K','q',' ',' ',' ',' ',' ',' '},
            {' ','r',' ',' ',' ',' ',' ',' '},
            {' ','b',' ','k',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '}
    };


    public TestGameStates(){
        nodes = new ArrayList<>();

        nodes.add(makeboard(empty)); //number 0
        nodes.add(makeboard(start)); //1
        nodes.add(makeboard(checkmate)); //2

    }

    public List<Node> getNodes() {
        return nodes;
    }

    private GameStateChess makeboard(char[][] array){
        int place;
        char[] board = new char[64];

        for(int i=0; i<array.length && i<8; i++) {
            for (int j = 0; i < array[i].length && j<8; j++) {
                place = 7-i + j*8;
                board[place] = array[i][j];
            }
        }
        GameStateChess state = new GameStateChess();
        state.setBoard(board);
        return state;
    }
}
