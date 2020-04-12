package P3.Action;

import P3.Player.*;

import java.io.IOException;

import P3.Board.Board;
import P3.Game.ChessGame;
import P3.Game.Game;
import P3.Game.GoGame;
import P3.Piece.*;

public interface Action {

	public static Action empty(String game, String player_1Name, String player_2Name) {

		if (game.equals("go")) {
			return new GoAction();
		} else
			return new ChessAction();
	}
	/**
     * 设置两个玩家
     * 
     * @param String1，String2
     * 
     */
	public void setPlayer(String player_1,String player_2);
	
	/**
     * 返回该棋盘的大小
     * 
     * @param null
     * 
     */
	public int getSize();
	
	/**
     * 初始化一个Board
     * 
     * @param null
     * 
     */
	public void initalBoard();
	
	
	/**
     * 新建一个Board并返回一个Board
     * 
     * @param null
     * 
     */
	public Board newBoard();
	
	
	
	/**
     * 返回当前的玩家类型
     * 
     * @param null
     * 
     */
	public Player getFirstHeadPlayer();
	
	
	/**
     * 设置玩家1为后手
     * 
     * @param null
     * 
     * 
     */
	public void setsecondHead_1();
	
	
	/**
     * 设置玩家1为先手
     * 
     * @param null
     * 
     */
	public void setfirstHead_1();
	
	
	
	/**
     * 玩家1用在x1,y1上的点吃掉玩家2在x2，y2上的点
   	 *
     * 
     * @param Player player_1, Player player_2, int x_1, int y_1, int x_2, int y_2
     * 
     */
	public boolean eatPiece(Player player_1, Player player_2, int x_1, int y_1, int x_2, int y_2);
	
	
	
	/**
     * 改变当前下棋的玩家为另一个玩家
     * 
     * @param null
     * 
     */
	public void changeFirstHead();
	
	
	
	
	/**
     * 该玩家将x1,y1上的子移动到x2，y2上
     * 
     * @param Player player, int x_1, int y_1, int x_2, int y_2
     * 
     */
	public boolean movePiece(Player player, int x_1, int y_1, int x_2, int y_2);
	
	
	
	/**
     * 该玩家移除另一个玩家在x，y点的子
     * 
     * @param Player player, int x, int y
     * 
     */
	public boolean removePiece(Player player, int x, int y);
	
	
	
	
	/**
     * 该玩家在x，y点放子
     * 
     * @param Player player, int x, int y
     * 
     */
	public boolean placePiece(Player player, int x, int y);
	
	
	
	
	/**
     * 获得游戏类型
     * 
     * @param null
     * 
     */
	public String getGameType();
	
	
	
	/**
     * 获得x，y的棋子类型
     * 
     * @param int x,int y
     * 
     */
	public String getPieceType(int x,int y);
	
	
	
	/**
     * 计算该玩家的棋子数
     * 
     * @param String1
     * 
     */
	public int calPieces(String player_1);
	
	
	
	
	/**
     * 获得先手玩家，玩家1
     * 
     * @param null
     * 
     */
	public Player getPlayer_1();
	
	
	
	/**
     * 获得后手玩家，玩家2
     * 
     * @param null
     * 
     */
	public Player getPlayer_2();

}