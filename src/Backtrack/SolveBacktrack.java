package Backtrack;
import java.util.ArrayList;
import java.util.List;
import Game.Board;

public class SolveBacktrack {
	public static List<int []> SL = new ArrayList<int []>();
	public static List<int []> NSL = new ArrayList<int []>();
	public static List<int []> DE = new ArrayList<int []>();
	public static int [] CS = new int [9];
	static Board board = new Board(9, new int [] {2, 4, 0, 8, 1, 3, 6, 5, 7});
	public static Board goalBoard = new Board(9, new int [] {1, 2, 3, 4, 5, 6, 7, 8, 0});
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board.printBoard();
		setNSL(board.getPositions());
	}
	
	
	public static List<int []> backtrack(){
		SL.add(board.getPositions());
		NSL.add(board.getPositions());
		CS = board.getPositions();
		while (!NSL.isEmpty()){
			if (CS.equals(goalBoard)){
				return SL;
			}
			if(hasUniqueChild()){
				while (!SL.isEmpty() && CS == SL.get(0)){
					DE.add(CS);
					SL.remove(0);
					NSL.remove(0);
					CS = NSL.get(0);
				}
				SL.add(CS);
			} else {
				CS = NSL.get(0);
				SL.add(CS);
			}
		}
		return null;
	}
	
	public static List<int[]> setNSL(int[] examineBoard){
		List <int []> newPositions = new ArrayList<int []>();
		int [] newPos = new int[9];
		for (int i = 0; i < examineBoard.length; ++i){
			if (0 == examineBoard[i]){
				System.out.println(i);
				if(i-3 > 0){
					newPositions.add(changePlaces(examineBoard, newPos, i, 3, '-'));
				}
				if(i+3 < examineBoard.length){
					newPositions.add(changePlaces(examineBoard, newPos, i, 3, '+'));
				}
				if(i+1 < examineBoard.length && i != 2 && i != 5 && i != 8){
					newPositions.add(changePlaces(examineBoard, newPos, i, 1, '+'));
				}
				if(i-1 > 0 && i%3!=0){
					newPositions.add(changePlaces(examineBoard, newPos, i, 1, '-'));
				}
				
			}
			
		}
		for(int i=0 ;i <newPositions.size(); i++){
			System.out.println(newPositions.get(i));
		}
		return newPositions;
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
	public static int [] changePlaces(int[] examineBoard, int [] newPos,int i, int numToChange, char posNeg){
		
		int tmp;
		System.arraycopy( examineBoard, 0, newPos, 0, examineBoard.length );
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
	public static Boolean hasUniqueChild(){
		
		List<int []> listCHildren = new ArrayList<int []>();
		listCHildren = setNSL(CS);//mozda treba kopirati
		if(listCHildren.isEmpty())return false;
		for (int i = 0; i < listCHildren.size(); i++ ){
			if(NSL.contains(listCHildren.get(i)) || SL.contains(listCHildren.get(i))
			    || DE.contains(listCHildren.get(i))){
				return false;
			}
		}
		return true;
	}
}

