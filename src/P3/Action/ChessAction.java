package P3.Action;

import P3.Board.Board;
import P3.Player.Player;
import P3.Piece.*;
import P3.Game.*;
public class ChessAction implements Action {
	
	
	
		//AF:棋盘对应Board，玩家对应Player,游戏对应Game
		//RI:player_1!=null,player_2!=null
		//secure way:using defensive copy and all fields are private 
		//checkRep()
	public void checkRep() {
		assert this.player_1 !=null;
		assert this.player_2 !=null;
		assert this.board !=null;
}
	private Game game = Game.empty("chess");
	
	private Player player_1 = new Player("");
	private Player player_2 = new Player("");
	private Board board = new Board("chess", this.game.getSize());
	
	
	public int getSize() {
		int a = game.getSize();
		checkRep();
		return a;
	}

	public String getGameType() {
		String a = game.getgameType();
		checkRep();
		return a;
	}

	public Board newBoard() {
		this.board = new Board("chess", this.game.getSize());
		checkRep();
		return new Board("chess", this.game.getSize());
	}

	public void setfirstHead_1() {
		player_1.setFirstHead();
	}

	public void setPlayer(String player_1, String player_2) {
		this.player_1 = new Player(player_1);
		this.player_2 = new Player(player_2);
		checkRep();
	}

	public void setsecondHead_1() {
		player_1.setSceondHead();
		checkRep();
	}

	public Player getFirstHeadPlayer() {
		if (player_1.getFirstHead()) {
			checkRep();
			return new Player(player_1.getName());
		}
			
		else {
			checkRep();
			return new Player(player_2.getName());
			
		}
			
	}

	public void changeFirstHead() {
		if (player_1.getFirstHead()) {
			player_1.setSceondHead();
		} else
			player_1.setFirstHead();
	}

	public Player getPlayer_1() {
		checkRep();
		return new Player(player_1.getName());
	}
	
	public Player getPlayer_2() {
		checkRep();
		return new Player(player_2.getName());
	}

	public void initalBoard() {
		this.board = newBoard();
		for (int j = 0; j <= 1; j++)
			for (int i = 0; i <game.getSize(); i++) {
				board.changePlaced(i, j, 1);

			}
		for (int j = 2; j <= 5; j++) {
			for (int i = 0; i <game.getSize(); i++) {
				board.changePlaced(i, j, 0);
			}
		}

		for (int j = 6; j < game.getSize(); j++) {
			for (int i = 0; i < 8; i++) {
				board.changePlaced(i, j, 1);
			}
		}

		for (int i = 0; i < game.getSize(); i++) {

			Piece piece = new Piece(player_1.getName(), "white_pawn");
			board.setPiece(piece, i, 1);
		}
		for (int i = 0; i <game.getSize(); i++) {

			Piece piece = new Piece(player_2.getName(), "black_pawn");
			board.setPiece(piece, i, 6);
		}

		Piece piece = new Piece(player_1.getName(), "white_rook");
		board.setPiece(piece, 0, 0);
		board.setPiece(piece, 7, 0);
		Piece piecewhite_knight = new Piece(player_1.getName(), "white_knight");
		board.setPiece(piecewhite_knight, 1, 0);
		board.setPiece(piecewhite_knight, 6, 0);
		Piece piecewhite_bishop = new Piece(player_1.getName(), "white_bishop");
		board.setPiece(piecewhite_bishop, 2, 0);
		board.setPiece(piecewhite_bishop, 5, 0);
		Piece piecewhite_king = new Piece(player_1.getName(), "white_king");
		board.setPiece(piecewhite_king, 4, 0);
		Piece piecewhite_queen = new Piece(player_1.getName(), "white_queen");
		board.setPiece(piecewhite_queen, 3, 0);
		Piece pieceblack_rook = new Piece(player_2.getName(), "black_rook");
		board.setPiece(pieceblack_rook, 0, 7);
		board.setPiece(pieceblack_rook, 7, 7);
		Piece pieceblack_knight = new Piece(player_2.getName(), "black_knight");
		board.setPiece(pieceblack_knight, 1, 7);
		board.setPiece(pieceblack_knight, 6, 7);
		Piece pieceblack_bishop = new Piece(player_2.getName(), "black_bishop");
		board.setPiece(pieceblack_bishop, 2, 7);
		board.setPiece(pieceblack_bishop, 5, 7);
		Piece pieceblack_king = new Piece(player_2.getName(), "black_king");
		board.setPiece(pieceblack_king, 4, 7);
		Piece pieceblack_queen = new Piece(player_2.getName(), "black_queen");
		board.setPiece(pieceblack_queen, 3, 7);
		checkRep();
	}

	public boolean eatPiece(Player player_1, Player player_2, int x_1, int y_1, int x_2, int y_2) {
		int[][] placed = board.getPlaced();
		if (placed[x_1][y_1] == 0)
			throw new RuntimeException("第一个坐标上无点");
		if (placed[x_2][y_2] == 0)
			throw new RuntimeException("第二个坐标上无点");
		Piece[][] pieces = board.getPiece();
		Piece piece = pieces[x_1][y_1];
		if (piece.getUser() != player_1.getName()) {
			throw new RuntimeException("第一个位置上的棋子不是自己的棋子");
		}
		Piece piece_2 = pieces[x_2][y_2];
		if (piece_2.getUser() != player_2.getName()) {
			throw new RuntimeException("第二个位置上的棋子不是对方棋子");
		}
		if (x_1 == x_2 && y_1 == y_2) {

			throw new RuntimeException("两个位置相同");
		}
		board.setPiece(piece, x_2, y_2);
		board.changePlaced(x_1, y_1, 0);
		board.removePiece(x_1, y_1);
		checkRep();
		return true;
	}

	public boolean movePiece(Player player, int x_1, int y_1, int x_2, int y_2) {
		int[][] placed = board.getPlaced();
		if (placed[x_1][y_1] == 0)
			throw new RuntimeException("第一个坐标上无点");
		if (placed[x_2][y_2] == 1)
			throw new RuntimeException("第二个坐标上有点");
		Piece[][] pieces = board.getPiece();
		Piece piece = pieces[x_1][y_1];
		if (piece.getUser() != player_1.getName()) {
			throw new RuntimeException("第一个位置上的棋子不是自己的棋子");
		}
		board.setPiece(piece, x_2, y_2);
		board.changePlaced(x_1, y_1, 0);
		board.changePlaced(x_2, y_2, 1);
		checkRep();
		return true;
	}

	public boolean removePiece(Player player, int x, int y) {
		checkRep();
		return false;
	}

	public boolean placePiece(Player player, int x, int y) {
		checkRep();
		return false;
	}

	public String getPieceType(int x, int y) {
		int[][] placed = board.getPlaced();
		if (placed[x][y] == 0) {
			checkRep();
			return null;
		} else {
			Piece[][] pieces = board.getPiece();
			String a = pieces[x][y].getType();
			checkRep();
			return a;
			
		}
	}

	public int calPieces(String player_1) {
		int[][] placed = board.getPlaced();
		Piece[][] pieces = board.getPiece();
		int sum1 = 0;

		for (int j = 0; j < 8; j++)
			for (int i = 0; i < 8; i++) {

				if (placed[i][j] == 1) {
					if (pieces[i][j].getUser() == player_1)
						sum1++;

				}
			}
		checkRep();
		return sum1;
	}

	

}
