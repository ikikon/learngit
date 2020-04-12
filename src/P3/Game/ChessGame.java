package P3.Game;

import P3.Board.Board;
import P3.Piece.Piece;
import P3.Player.Player;

public class ChessGame implements Game {

	// AF游戏类型对应gameType，大小对应size
	// RI gameType!=null,size!=null
	// secure way:using defensive copy and all fields are private
	private final int size = 8;

	private final String gameType = "chess";

	// checkRep()
	public void checkRep() {
		assert gameType != null;
		assert size != 0;
	}

	public String getgameType() {
		String a = gameType;
		checkRep();

		return a;
	}

	public int getSize() {
		int a = size;
		checkRep();
		return a;
	}

}