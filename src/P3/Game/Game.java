package P3.Game;

import P3.Action.Action;
import P3.Action.ChessAction;
import P3.Action.GoAction;
import P3.Board.Board;
import P3.Piece.Piece;
import P3.Player.Player;

public interface Game {
	/**
	 * 输入game的名字来生成当前游戏
	 * 
	 * @param :游戏的名字
	 */
	public static Game empty(String game) {

		if (game.equals("go")) {
			return new GoGame();
		} else
			return new ChessGame();
	}

	/**
	 * 返回游戏类型
	 * 
	 * @param :null
	 */
	public String getgameType();

	/**
	 * 返回游戏棋盘 大小
	 * 
	 * @param ：null
	 */
	public int getSize();

}
