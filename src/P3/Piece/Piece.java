package P3.Piece;

import P3.Position.Position;

public class Piece {

	// AF:该棋子玩家对应gameUser，棋子类型对应type,棋子位置对应position
	// RI gameType!=null,type!=null,position!=null
	// secure way:using defensive copy and all fields are private
	private final String gameUser;
	private final String type;

	private Position piecePosition = new Position(0, 0);
	//checkRep
		public void checkRep() {
			assert gameUser != null;
			assert type != null;
			assert piecePosition!=null;
		}

	public Piece(String user, String type) {
		this.gameUser = user;
		this.type = type;
		checkRep();
	}

	public String getUser() {
		String a = gameUser;
		checkRep();
		return a;

	}

	public String getType() {
		String a = type;
		checkRep();
		return a;
	}

	public int getX() {
		int a = this.piecePosition.getX();
		checkRep();
		return a;
	}

	public int getY() {
		int a = this.piecePosition.getY();
		checkRep();
		return a;
	}

	public void set(int x, int y) {
		this.piecePosition.setPosition(x, y);
		checkRep();
	}

}
