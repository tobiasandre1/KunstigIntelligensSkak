package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.List;

public class GameStateChess implements Node {

    char[] board = new char[65];
    private class Move
    {
    	int from, to;
    	
    	MoveCoordinate(from, to){
    		this.from = from;
    		this.to = to;
    	}
    	
    }

    @Override
    public List<Move> getMoves() {
    	List moves = new ArrayList<Move>();
    	for (int i=1; i<66; i++){
   
    		
    		////BLACK 
    		if (board[i] == k){// king
    			
    				if(board[i-9] == null || board[i-9].isUpperCase()){
    				moves.add(new Move(from, i-9));
    				}    			
    				if(board[i-8] == null || board[i-8].isUpperCase()){
    					moves.add(new Move(from, i-8));	
    				}			
    				if(board[i-7] == null || board[i-7].isUpperCase()){
    					moves.add(new Move(from, i-7));
    				}
    				if(board[i-1]) == null || board[i-1].isUpperCase()){
    					moves.add(new Move(from, i-1));
    				}
					if(board[i+1] == null || board[i+1].isUpperCase()){
						moves.add(new Move(from, i+1));
					}
					if(board[i+7] == null || board[i].isUpperCase()){
						moves.add(new Move(from, i+7));
					}
					if(board[i+8] == null || board[i+8].isUpperCase()){
						moves.add(new Move(from, i+8));
					}
					if(board[i+9] == null || board[i+9].isUpperCase()){
						moves.add(new Move(from, i+9));
					}
					
    		}
    			
    		
    		else if(board[i] == q) { //queen
        			for( int j = 1; j<66) {
        				//rock part
        				if(i%8 == j%8) {
        					moves.add( new Move( from, j); //up & down
        				}
        				else if((int)i/8 == (int)j/8) {
        					moves.add( new Move( from, j))//side to side
        				}
        				
        				//bishop part
        	    			for( int j = 1; i<9; j++) {
        	    				if(board[i-9*j] == null || board[i-9*j].isUpperCase()) {
        	    					moves.add(new Move(from, i-9));
        	    				}
        	    				else if(board[i+9*j] == null || board[i+9*j].isUpperCase()) {
        	    					moves.add(new Move(from, i+9));
        	    				}
        	    			}
        	    			for( int j = 1; i<7; j++) {
        	    				if(board[i-7*j] == null || board[i-7*j].isUpperCase()) {
        	    					moves.add(new Move(from, i-7));
        	    				}
        	    				else if(board[i+7*j] == null || board[i+7*j].isUpperCase()) {
        	    					moves.add(new Move(from, i+7));
        	    				}
        	    			}
        	    		
        	    		}	
    			
    			
    			}
    			
    		}
    		else if(board[i] == r) { //rock
    			for( int j = 1; j<66) {
    				if(i%8 == j%8) {
    					moves.add( new Move( from, j); //up & down
    				}
    				else if((int)i/8 == (int)j/8) {
    					moves.add( new Move( from, j))//side to side
    				}
    					
    				
    			}
    		}
    		else if(board[i] == b) { //bishop
    			for( int j=1;i<9; j++) {
    				if(board[i-9*j] == null || board[i-9*j].isUpperCase()) {
    					moves.add(new Move(from, i-9));
    				}
    				else if(board[i+9*j] == null || board[i+9*j].isUpperCase()) {
    					moves.add(new Move(from, i+9));
    				}
    			}
    		
    		}
    		else if(board[i] == n) { //knight
    			if(board[i-17] == null || board[i-17].isUpperCase){
    				moves.add(new Move(from, i-17));
    			}
    			else if(board[i-15] == null || board[i-15].isUpperCase){
    				moves.add(new Move(from, i-15));
    			}
    			else if(board[i-10] == null || board[i-10].isUpperCase){
    				moves.add(new Move(from, i-10));
    			}
    			else if(board[i-6] == null || board[i-6].isUpperCase){
    				moves.add(new Move(from, i-6));
    			}
    			else if(board[i+6] == null || board[i+6].isUpperCase){
    				moves.add(new Move(from, i+6));
    			}
    			else if(board[i+10]==null || board[i+10].isUpperCase){
    				moves.add(new Move(from, i+10));
    			}
    			else if(board[i+15]==null || board[i+15].isUpperCase){
    				moves.add(new Move(from, i+15));
    			}
    			else if(board[i+17]==null || board[i+17].isUpperCase){
    				moves.add(new Move(from, i+17));
    			}
    		}
    		else if(board[i] == p) {
    			if(board[i-8]==null) {
    				moves.add(new Move(from, i-8));
    			}
    		}
    		
    		
    		/////////////////////////////////////white
    		
    		else if(board[i] == K) {
    			if(board[i-9]==null||board[i-9].isLowerCase()){
    				moves.add(new Move(from, i-9));
    				}    			
    				if(board[i-8]==null||board[i-8].isLowerCase()){
    					moves.add(new Move(from, i-8));	
    				}			
    				if(board[i-7]==null||board[i-7].isLowerCase()){
    					moves.add(new Move(from, i-7));
    				}
    				if(board[i-1])==null||board[i-1].isLowerCase()){
    					moves.add(new Move(from, i-1));
    				}
					if(board[i+1]==null||board[i+1].isLowerCase()){
						moves.add(new Move(from, i+1));
					}
					if(board[i+7]==null||board[i].isLowerCase()){
						moves.add(new Move(from, i+7));
					}
					if(board[i+8]==null||board[i+8].isLowerCase()){
						moves.add(new Move(from, i+8));
					}
					if(board[i+9]==null||board[i+9].isLowerCase()){
						moves.add(new Move(from, i+9));
					}
    		}
     		
		
		else if(board[i] == Q) { //queen
    			for( int j = 1; j<66) {
    				//rock part
    				if(i%8 == j%8 && (board[j]==null || board[j].isLowerCase()) {
    					moves.add( new Move( from, j); //up & down
    				}
    				else if((int)i/8==(int)j/8 && ( board[j] == null|| board[j].isLowerCase()) {
    					moves.add( new Move( from, j))//side to side
    				}
    				
    				//bishop part
    	    			for( int j=1;i<9; j++) {
    	    				if(board[i-9*j]==null||board[i-9*j].isLowerCase()) {
    	    					moves.add(new Move(from, i-9));
    	    				}
    	    				else if(board[i+9*j]==null||board[i+9*j].isLowerCase()) {
    	    					moves.add(new Move(from, i+9));
    	    				}
    	    			}
    	    			for( int j=1;i<7; j++) {
    	    				if(board[i-7*j]==null||board[i-7*j].isLowerCase()) {
    	    					moves.add(new Move(from, i-7));
    	    				}
    	    				else if(board[i+7*j]==null||board[i+7*j].isLowerCase()) {
    	    					moves.add(new Move(from, i+7));
    	    				}
    	    			}
    	    		
    	    		}	
			
			
			}
			
		}
		else if(board[i] == r) { //rock
			for( int j = 1; j<66) {
				if(i%8 == j%8) {
					moves.add( new Move( from, j); //up & down
				}
				else if((int)i/8==(int)j/8) {
					moves.add( new Move( from, j))//side to side
				}
					
				
			}
		}
		else if(board[i] == b) { //bishop
			for( int j=1;i<9; j++) {
				if(board[i-9*j]==null||board[i-9*j].isLowerCase()) {
					moves.add(new Move(from, i-9));
				}
				else if(board[i+9*j]==null||board[i+9*j].isLowerCase()) {
					moves.add(new Move(from, i+9));
				}
			}
		
		}
		else if(board[i] == n) { //knight
			if(board[i-17]==null)||if(board[i-17].isLowerCase){
				moves.add(new Move(from, i-17));
			}
			else if(board[i-15]==null)||if(board[i-15].isLowerCase){
				moves.add(new Move(from, i-15));
			}
			else if(board[i-10]==null)||if(board[i-10].isLowerCase){
				moves.add(new Move(from, i-10));
			}
			else if(board[i-6]==null)||if(board[i-6].isLowerCase){
				moves.add(new Move(from, i-6));
			}
			else if(board[i+6]==null)||if(board[i+6].isLowerCase){
				moves.add(new Move(from, i+6));
			}
			else if(board[i+10]==null)||if(board[i+10].isLowerCase){
				moves.add(new Move(from, i+10));
			}
			else if(board[i+15]==null)||if(board[i+15].isLowerCase){
				moves.add(new Move(from, i+15));
			}
			else if(board[i+17]==null)||if(board[i+17].isLowerCase){
				moves.add(new Move(from, i+17));
			}
		}
		else if(board[i] == p) {
			if(board[i+8]==null) {
				moves.add(new Move(from, i+8));
			}
		}
    	}
        return moves;
    }


    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public int getHeuristicValue() {
        return 0;
    }
}