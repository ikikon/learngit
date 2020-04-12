package P3.Board;

import P3.Piece.*;

public class Board {
	//AF��Ϸ���Ͷ�ӦgameType����С��Ӧsize��pieces��Ӧ���õ����ӵĶ�ά���飬placed��Ӧ��ά�������Ƿ�����
	//RI gameType!=null,size!=null,Pieces!=null
	//secure way:using defensive copy and all fields are private 
	private String gameType = "";
	private int size;
	private Piece[][] pieces;
	private int[][] placed;
	//checkRep()
	public void checkRep() {
		assert gameType!=null;
		assert size!=0;
		assert pieces!=null;
		assert placed!=null;
	}
	
	public Board(String type, int size) {
		this.gameType = type;
		this.size = size;

		pieces = new Piece[size][size];
		placed = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				placed[i][j] = 0;
		checkRep();
	}

	public void changePlaced(int x, int y, int type) {
		checkRep();
		this.placed[x][y] = type;

	}

	public void setPiece(Piece piece, int x, int y) {
		checkRep();
		pieces[x][y] = piece;
	}

	public int[][] getPlaced() {
		int[][] newplace = new int[this.size][this.size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				newplace[i][j] = placed[i][j];
		
		checkRep();
		return newplace;
	}

	public Piece[][] getPiece(){
		Piece[][] newpieces = new Piece[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				newpieces[i][j] = pieces[i][j];
		
		checkRep();
		return newpieces;
	}
	
	public void removePiece(int x,int y) {
		checkRep();
		pieces[x][y] = null;
	}
	
}
