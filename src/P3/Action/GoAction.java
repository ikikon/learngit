package P3.Action;

import P3.Board.Board;
import P3.Game.Game;
import P3.Player.Player;
import P3.Piece.*;

public class GoAction implements Action {
	private Game game = Game.empty("go");
	//AF:棋盘对应Board，玩家对应Player,游戏对应Game
	//RI:player_1!=null,player_2!=null
	//secure way:using defensive copy and all fields are private 
	
	
	private Player player_1 = new Player("");
	private Player player_2 = new Player("");
	private Board board = new Board("go", this.game.getSize());
	//checkRep()
	public void checkRep() {
		assert this.player_1 !=null;
		assert this.player_2 !=null;
		assert this.board !=null;
}
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
	
	public Player getPlayer_1() {
		checkRep();
		return new Player(player_1.getName());
	}
	
	public Player getPlayer_2() {
		checkRep();
		return new Player(player_2.getName());
	}
	
	
	public Board newBoard() {
		
		this.board = new Board("go", this.game.getSize());
		checkRep();
		return new Board("go", this.game.getSize());
	}
	
	
	public void setPlayer(String player_1,String player_2) {
		
		this.player_1 = new Player(player_1);
		this.player_2 = new Player(player_2);
		checkRep();
	}
	
	public void setfirstHead_1() {
		
		player_1.setFirstHead();
		checkRep();
	}
	
	public void setsecondHead_1() {
		
		player_1.setSceondHead();
		checkRep();
	}
	
	public Player getFirstHeadPlayer() {
		if(player_1.getFirstHead()) {
			checkRep();
			return new Player(player_1.getName());
		}
			
		else {
			
			checkRep();
			return new Player(player_2.getName());
		}
			
	}
	
	public void changeFirstHead() {
		if(player_1.getFirstHead()) {
			
			player_1.setSceondHead();
		}else {
			checkRep();
			player_1.setFirstHead();
		}
			
	}
	public void initalBoard() {
		this.board = newBoard();
		for (int j = 0; j < 19; j++)
			for (int i = 0; i < 19; i++) {
				board.changePlaced(i, j, 0);

			}
		checkRep();
	}

	public boolean eatPiece(Player player_1, Player player_2, int x_1, int y_1, int x_2, int y_2) {
		checkRep();
		return false;
	}

	public boolean movePiece(Player player, int x_1, int y_1, int x_2, int y_2) {
		checkRep();
		return false;
	}

	public boolean removePiece(Player player, int x, int y) {
		int[][] placed = board.getPlaced();
		if (placed[x][y] == 0)
			throw new RuntimeException("该位置无棋子");
		else {
			Piece[][] pieces = board.getPiece();
			if (pieces[x][y].getUser() == player.getName())
				throw new RuntimeException("该位置棋子不属于对方");
			else {
				board.removePiece(x, y);
				board.changePlaced(x, y, 0);
				checkRep();
				return true;
			}

		}
	}

	public boolean placePiece(Player player, int x, int y) {
		int[][] placed = board.getPlaced();
		if (placed[x][y] == 1)
			throw new RuntimeException("该位置已经有棋子");
		else {
			Piece piece = new Piece(player.getName(), player.getName());
			board.setPiece(piece, x, y);
			board.changePlaced(x, y, 1);
			checkRep();
			return true;
		}
	}
	
	public String getPieceType(int x,int y) {
		int[][] placed = board.getPlaced();
		if(placed[x][y]==0) {
			checkRep();
			return null;
		}else {
			Piece[][] pieces = board.getPiece();
			String a =pieces[x][y].getUser();
			checkRep();
			return a;
		}
	}
	
	public int calPieces(String player_1) {
		int[][] placed = board.getPlaced();
		Piece[][] pieces = board.getPiece();
		int sum1=0;
		
		for (int j = 0; j < 19; j++)
			for (int i = 0; i < 19; i++) {
				
				if(placed[i][j]==1) {
					if(pieces[i][j].getUser()==player_1)
						sum1++;
					
				}
			}
		checkRep();
		return sum1;
	}
}
