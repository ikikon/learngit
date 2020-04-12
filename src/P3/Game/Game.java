package P3.Game;

import P3.Action.Action;
import P3.Action.ChessAction;
import P3.Action.GoAction;
import P3.Board.Board;
import P3.Piece.Piece;
import P3.Player.Player;

public interface Game {
	/**
	 * ����game�����������ɵ�ǰ��Ϸ
	 * 
	 * @param :��Ϸ������
	 */
	public static Game empty(String game) {

		if (game.equals("go")) {
			return new GoGame();
		} else
			return new ChessGame();
	}

	/**
	 * ������Ϸ����
	 * 
	 * @param :null
	 */
	public String getgameType();

	/**
	 * ������Ϸ���� ��С
	 * 
	 * @param ��null
	 */
	public int getSize();

}
