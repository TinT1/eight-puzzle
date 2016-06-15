package Backtrack;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Game.Board;

public class SolveBacktrack {
	
	List<int []> SL = new ArrayList<int []>();
	List<int []> NSL = new ArrayList<int []>();
	List<int []> DE = new ArrayList<int []>();
	int [] CS = new int [8];
	static Board board = new Board(9, new int [] {2, 4, 6, 8, 1, 3, 5, 7});
	Board goalBoard = new Board(9, new int [] {1, 2, 3, 4, 5, 6, 7, 8, 0});
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board.printBoard();
		
	}
	
	
	public List<int []> backtrack(){
		SL.add(board.getPositions());
		NSL.add(board.getPositions());
		CS = board.getPositions();
		
		while (!NSL.isEmpty()){
			if (CS.equals(goalBoard)){
				return SL;
			}
			if(true){//if CS has no children
				while (!SL.isEmpty() && CS == SL.get(0)){
					DE.add(CS);
					SL.remove(0);
					NSL.remove(0);
					CS = NSL.get(0);
				}
				SL.add(CS);
			} else {
				// palce children of CS on NSL
				CS = NSL.get(0);
				SL.add(CS);
			}
		}
		return null;
	}
	
	public List<int []> setNSL(Board examineBoard){
		for (int i = 0; i < examineBoard.getN(); ++i){
			if (0 == examineBoard.getPositions()[i])
			{
				if (i == 0 || i == 2 || i == 6 || i == 8){
					
				}
			}
		}
		return DE;
		
	}
	
}
