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
     * �����������
     * 
     * @param String1��String2
     * 
     */
	public void setPlayer(String player_1,String player_2);
	
	/**
     * ���ظ����̵Ĵ�С
     * 
     * @param null
     * 
     */
	public int getSize();
	
	/**
     * ��ʼ��һ��Board
     * 
     * @param null
     * 
     */
	public void initalBoard();
	
	
	/**
     * �½�һ��Board������һ��Board
     * 
     * @param null
     * 
     */
	public Board newBoard();
	
	
	
	/**
     * ���ص�ǰ���������
     * 
     * @param null
     * 
     */
	public Player getFirstHeadPlayer();
	
	
	/**
     * �������1Ϊ����
     * 
     * @param null
     * 
     * 
     */
	public void setsecondHead_1();
	
	
	/**
     * �������1Ϊ����
     * 
     * @param null
     * 
     */
	public void setfirstHead_1();
	
	
	
	/**
     * ���1����x1,y1�ϵĵ�Ե����2��x2��y2�ϵĵ�
   	 *
     * 
     * @param Player player_1, Player player_2, int x_1, int y_1, int x_2, int y_2
     * 
     */
	public boolean eatPiece(Player player_1, Player player_2, int x_1, int y_1, int x_2, int y_2);
	
	
	
	/**
     * �ı䵱ǰ��������Ϊ��һ�����
     * 
     * @param null
     * 
     */
	public void changeFirstHead();
	
	
	
	
	/**
     * ����ҽ�x1,y1�ϵ����ƶ���x2��y2��
     * 
     * @param Player player, int x_1, int y_1, int x_2, int y_2
     * 
     */
	public boolean movePiece(Player player, int x_1, int y_1, int x_2, int y_2);
	
	
	
	/**
     * ������Ƴ���һ�������x��y�����
     * 
     * @param Player player, int x, int y
     * 
     */
	public boolean removePiece(Player player, int x, int y);
	
	
	
	
	/**
     * �������x��y�����
     * 
     * @param Player player, int x, int y
     * 
     */
	public boolean placePiece(Player player, int x, int y);
	
	
	
	
	/**
     * �����Ϸ����
     * 
     * @param null
     * 
     */
	public String getGameType();
	
	
	
	/**
     * ���x��y����������
     * 
     * @param int x,int y
     * 
     */
	public String getPieceType(int x,int y);
	
	
	
	/**
     * �������ҵ�������
     * 
     * @param String1
     * 
     */
	public int calPieces(String player_1);
	
	
	
	
	/**
     * ���������ң����1
     * 
     * @param null
     * 
     */
	public Player getPlayer_1();
	
	
	
	/**
     * ��ú�����ң����2
     * 
     * @param null
     * 
     */
	public Player getPlayer_2();

}