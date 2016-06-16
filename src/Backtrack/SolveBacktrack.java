package Backtrack;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Game.Board;

public class SolveBacktrack {
	
	List<int []> SL = new ArrayList<int []>();
	List<int []> NSL = new ArrayList<int []>();
	List<int []> DE = new ArrayList<int []>();
	int [] CS = new int [9];
	static Board board = new Board(9, new int [] {2, 4, 0, 8, 1, 3, 6, 5, 7});
	Board goalBoard = new Board(9, new int [] {1, 2, 3, 4, 5, 6, 7, 8, 0});
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board.printBoard();
		setNSL(board);
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
	
	public static void setNSL(Board examineBoard){
		List <int []> newPositions = new ArrayList<int []>();
		int [] newPos = new int[9];
		int tmp;
		for (int i = 0; i < examineBoard.getN(); ++i){
			if (0 == examineBoard.getPositions()[i]){
				System.out.println(i);
				if(i-3 > 0){
					newPositions.add(ChangePlaces(examineBoard, newPos, i, 3, '-'));
				}
				if(i+3 < examineBoard.getN()){
					newPositions.add(ChangePlaces(examineBoard, newPos, i, 3, '+'));
				}
				if(i+1 < examineBoard.getN() && i != 2 && i != 5 && i != 8){
					newPositions.add(ChangePlaces(examineBoard, newPos, i, 1, '+'));
				}
				if(i-1 > 0 && i%3!=0){
					newPositions.add(ChangePlaces(examineBoard, newPos, i, 1, '-'));
				}
				
			}
		}
		
		
	}
	public static void printBoard(int [] arrayT)
	{
		String str = "";
		for(int i = 0; i < 9; ++i)
		{
			str += arrayT[i] + " ";
			if((i+1)%3 == 0 && i != 0) {System.out.println(str);str ="";}
		}
		System.out.println("\n");
	}
	public static int [] copyArray (int [] arrayT)
	{
		int [] arrayC = new int [9];
		for (int i = 0; i<9; i++){
			arrayC[i] = arrayT[i];
		}
		return arrayC;
	}
	
	public static int [] ChangePlaces(Board examineBoard, int [] newPos,int i, int numToChange, char posNeg){
		
		int tmp;
		System.arraycopy( examineBoard.getPositions(), 0, newPos, 0, examineBoard.getN() );
		if(posNeg == '-'){
			tmp = newPos[i-numToChange];
			newPos[i-numToChange] = 0;
		}
		else{
			tmp = newPos[i+numToChange];
			newPos[i+numToChange] = 0;
		}
		newPos[i] = tmp;
		return copyArray(newPos);
	}
}
