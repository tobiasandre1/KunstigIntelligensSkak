package grp6.implementation;

import grp6.interfaces.Move;
import grp6.interfaces.Node;

import java.util.List;

public class GameStateChess implements Node {

    char[] board = new char[65];
    
    private class Move{
    	int from, to;
    	
    	Move(from, to){
    		this.from = from;
    		this.to = to;
    	}
    	
    }

    @Override
    public List<Move> getMoves() {
    	List moves = new ArrayList<Move>();
    	for (int i=1; i<65; i++){
   
    		
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
    			
    			//rock part
				for(j = i+8; j<65; j+=8 ) { // up
					if(board[j]==null)){
    						moves.add(new Move( from, j));
    						}
    					else if (board[j].isUpperCase()) {
    						moves.add(new Move( from, j));
    						break;
    						}
					}
				for(j = i-8; j>0; j-=8 ) { //down
						if(board[j]==null)){
							moves.add(new Move( from, j));
							}
    					else if (board[j].isUpperCase()) {
    						moves.add(new Move( from, j));
    						break;
    						}
					}
						
				
			for(int j = 0; j < 8; j++) { // to the right
				if((i+j)%8 == i%8) { 
						if(board[i+j]==null)){
							moves.add(new Move( from, i+j));
        					}
						else if (board[i+j].isUpperCase()) {
							moves.add(new Move( from, i+j));
							break;
							}
					}
				}
			for(int j = 0; j < 8; j++) { // to the left
				if((i-j)%8 == i%8) {
					if(board[i-j]==null)){
    					moves.add(new Move( from, i-j));
        				}
					else if (board[i-j].isUpperCase()) {
						moves.add(new Move( from, i-j));
						break;
						}
					}
				}// end of rock part
			
			
			// bishop part
			
			for( int j=1;i<9; j++) {
				if(board[i+9*j] == null) { // down the board
					moves.add(new Move(from, i+9));
				}
				else if(board[i+9*j].isUpperCase()) {
					moves.add(new Move(from,i+9));
					break;
				}
				else break;
			}
			for( int j=1;i<9; j++) { // up the board
				if(board[i-9*j] == null) {
					moves.add(new Move(from, i-9));
				}
				else if(board[i-9*j].isUpperCase()) {
					moves.add(new Move(from,i-9));
					break;
				}
				else break;
			} //end of bishop part
			
    	}// end of queen
    			
    		
    		else if(board[i] == r) { //rock
    				for(j = i+8; j<65; j+=8 ) { // up
    					if(board[j]==null)){
        						moves.add(new Move( from, j));
        						}
        					else if (board[j].isUpperCase()) {
        						moves.add(new Move( from, j));
        						break;
        						}
    					}
    				for(j = i-8; j>0; j-=8 ) { //down
    						if(board[j]==null)){
    							moves.add(new Move( from, j));
    							}
        					else if (board[j].isUpperCase()) {
        						moves.add(new Move( from, j));
        						break;
        						}
    					}
    						
    				
    			for(int j = 0; j < 8; j++) { // to the right
    				if((i+j)%8 == i%8) { 
    						if(board[i+j]==null)){
    							moves.add(new Move( from, i+j));
            					}
    						else if (board[i+j].isUpperCase()) {
    							moves.add(new Move( from, i+j));
    							break;
    							}
    					}
    				}
    			for(int j = 0; j < 8; j++) { // to the left
    				if((i-j)%8 == i%8) {
    					if(board[i-j]==null)){
        					moves.add(new Move( from, i-j));
            				}
    					else if (board[i-j].isUpperCase()) {
    						moves.add(new Move( from, i-j));
    						break;
    						}
    					}
    				}
				}// end of rock
				
    	
    		
    		else if(board[i] == b) { //bishop
    			
    			for( int j=1;i<9; j++) {
    				if(board[i+9*j] == null) { // down the board
    					moves.add(new Move(from, i+9));
    				}
    				else if(board[i+9*j].isUpperCase()) {
    					moves.add(new Move(from,i+9));
    					break;
    				}
    				else break;
    			}
    			for( int j=1;i<9; j++) { // up the board
    				if(board[i-9*j] == null) {
    					moves.add(new Move(from, i-9));
    				}
    				else if(board[i-9*j].isUpperCase()) {
    					moves.add(new Move(from,i-9));
    					break;
    				}
    				else break;
    			}
    		} // end of bishop
    		
    		
    		
    		else if(board[i] == n) { // knight
    			if(board[i+17] == null || board[i-17].isUpperCase){
    				moves.add(new Move(from, i-17));
    			}
    			else if(board[i+15] == null || board[i-15].isUpperCase){
    				moves.add(new Move(from, i-15));
    			}
    			else if(board[i+10] == null || board[i-10].isUpperCase){
    				moves.add(new Move(from, i-10));
    			}
    			else if(board[i+6] == null || board[i-6].isUpperCase){
    				moves.add(new Move(from, i-6));
    			}
    			else if(board[i-6] == null || board[i+6].isUpperCase){
    				moves.add(new Move(from, i+6));
    			}
    			else if(board[i-10]==null || board[i+10].isUpperCase){
    				moves.add(new Move(from, i+10));
    			}
    			else if(board[i-15]==null || board[i+15].isUpperCase){
    				moves.add(new Move(from, i+15));
    			}
    			else if(board[i-17]==null || board[i+17].isUpperCase){
    				moves.add(new Move(from, i+17));
    			}
    		} // end of knight
    		
    		
    		else if(board[i] == p) { // pawn
    			if(board[i-8]==null) {
    				moves.add(new Move(from, i-8));
    			}
    			else if(board[i-7].isLowerCase()) {
    				moves.add(new Move(from, i-7));
    			}
    			else if(board[i-9].isLowerCase()) {
    				moves.add(new Move(from, i-9));
    			}
    		} // end of pawn
    		
    		
    		///////////////////////////////////// white
    		
    		if (board[i] == K){// king
    			
				if(board[i-9] == null || board[i-9].isLowerCase()){
				moves.add(new Move(from, i-9));
				}    			
				if(board[i-8] == null || board[i-8].isLowerCase()){
					moves.add(new Move(from, i-8));	
				}			
				if(board[i-7] == null || board[i-7].isLowerCase()){
					moves.add(new Move(from, i-7));
				}
				if(board[i-1]) == null || board[i-1].isLowerCase()){
					moves.add(new Move(from, i-1));
				}
				if(board[i+1] == null || board[i+1].isLowerCase()){
					moves.add(new Move(from, i+1));
				}
				if(board[i+7] == null || board[i].isLowerCase()){
					moves.add(new Move(from, i+7));
				}
				if(board[i+8] == null || board[i+8].isLowerCase()){
					moves.add(new Move(from, i+8));
				}
				if(board[i+9] == null || board[i+9].isLowerCase()){
					moves.add(new Move(from, i+9));
				}
				
		}
			
		
		else if(board[i] == q) { //queen
			
			//rock part
			for(j = i+8; j<65; j+=8 ) { // up
				if(board[j]==null)){
						moves.add(new Move( from, j));
						}
					else if (board[j].isLowerCase()) {
						moves.add(new Move( from, j));
						break;
						}
				}
			for(j = i-8; j>0; j-=8 ) { //down
					if(board[j]==null)){
						moves.add(new Move( from, j));
						}
					else if (board[j].isLowerCase()) {
						moves.add(new Move( from, j));
						break;
						}
				}
					
			
		for(int j = 0; j < 8; j++) { // to the right
			if((i+j)%8 == i%8) { 
					if(board[i+j]==null)){
						moves.add(new Move( from, i+j));
    					}
					else if (board[i+j].isLowerCase()) {
						moves.add(new Move( from, i+j));
						break;
						}
				}
			}
		for(int j = 0; j < 8; j++) { // to the left
			if((i-j)%8 == i%8) {
				if(board[i-j]==null)){
					moves.add(new Move( from, i-j));
    				}
				else if (board[i-j].isLowerCase()) {
					moves.add(new Move( from, i-j));
					break;
					}
				}
			}// end of rock part
		
		
		// bishop part
		
		for( int j=1;i<9; j++) {
			if(board[i+9*j] == null) { // down the board
				moves.add(new Move(from, i+9));
			}
			else if(board[i+9*j].isLowerCase()) {
				moves.add(new Move(from,i+9));
				break;
			}
			else break;
		}
		for( int j=1;i<9; j++) { // up the board
			if(board[i-9*j] == null) {
				moves.add(new Move(from, i-9));
			}
			else if(board[i-9*j].isLowerCase()) {
				moves.add(new Move(from,i-9));
				break;
			}
			else break;
		} //end of bishop part
		
	}// end of queen
			
		
		else if(board[i] == r) { //rock
				for(j = i+8; j<65; j+=8 ) { // up
					if(board[j]==null)){
    						moves.add(new Move( from, j));
    						}
    					else if (board[j].isLowerCase()) {
    						moves.add(new Move( from, j));
    						break;
    						}
					}
				for(j = i-8; j>0; j-=8 ) { //down
						if(board[j]==null)){
							moves.add(new Move( from, j));
							}
    					else if (board[j].isLowerCase()) {
    						moves.add(new Move( from, j));
    						break;
    						}
					}
						
				
			for(int j = 0; j < 8; j++) { // to the right
				if((i+j)%8 == i%8) { 
						if(board[i+j]==null)){
							moves.add(new Move( from, i+j));
        					}
						else if (board[i+j].isLowerCase()) {
							moves.add(new Move( from, i+j));
							break;
							}
					}
				}
			for(int j = 0; j < 8; j++) { // to the left
				if((i-j)%8 == i%8) {
					if(board[i-j]==null)){
    					moves.add(new Move( from, i-j));
        				}
					else if (board[i-j].isLowerCase()) {
						moves.add(new Move( from, i-j));
						break;
						}
					}
				}
			}// end of rock
			
	
		
		else if(board[i] == b) { //bishop
			
			for( int j=1;i<9; j++) {
				if(board[i+9*j] == null) { // down the board
					moves.add(new Move(from, i+9));
				}
				else if(board[i+9*j].isLowerCase()) {
					moves.add(new Move(from,i+9));
					break;
				}
				else break;
			}
			for( int j=1;i<9; j++) { // up the board
				if(board[i-9*j] == null) {
					moves.add(new Move(from, i-9));
				}
				else if(board[i-9*j].isLowerCase()) {
					moves.add(new Move(from,i-9));
					break;
				}
				else break;
			}
		} // end of bishop
		
		
		
		else if(board[i] == n) { // knight
			if(board[i+17] == null || board[i-17].isLowerCase){
				moves.add(new Move(from, i-17));
			}
			else if(board[i+15] == null || board[i-15].isLowerCase){
				moves.add(new Move(from, i-15));
			}
			else if(board[i+10] == null || board[i-10].isLowerCase){
				moves.add(new Move(from, i-10));
			}
			else if(board[i+6] == null || board[i-6].isLowerCase){
				moves.add(new Move(from, i-6));
			}
			else if(board[i-6] == null || board[i+6].isLowerCase){
				moves.add(new Move(from, i+6));
			}
			else if(board[i-10]==null || board[i+10].isLowerCase){
				moves.add(new Move(from, i+10));
			}
			else if(board[i-15]==null || board[i+15].isLowerCase){
				moves.add(new Move(from, i+15));
			}
			else if(board[i-17]==null || board[i+17].isLowerCase){
				moves.add(new Move(from, i+17));
			}
		} // end of knight
		
		
		else if(board[i] == P) { // pawn
			if(board[i-8]==null) {
				moves.add(new Move(from, i+8));
			}
			else if(board[i-7].isLowerCase()) {
				moves.add(new Move(from, i+7));
			}
			else if(board[i-9].isLowerCase()) {
				moves.add(new Move(from, i+9));
			}
		} // end of pawn
    		
    		// end of white
    		
    				}
    
    	
        return moves;
   
        
    }   

}

