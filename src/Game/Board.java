package Game;

public class Board {
	
	private int n;
	private int positions [] = null;
	
	public Board(int n, int [] positions){
		this.n = n;
		this.positions = new int [n];
		System.arraycopy(positions, 0, this.positions, 0, positions.length);
		this.positions[8] = 0;
	}
	public int getN(){
		return n;
	}
	public int[] getPositions()
	{
		return this.positions;
	}
	
	public void printBoard()
	{
		String str = "";
		for(int i = 0; i < n; ++i)
		{
			str += this.positions[i] + " ";
			if((i+1)%3 == 0 && i != 0) {System.out.println(str);str ="";}
		}
	}
}
