package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Board.*;
import P3.Piece.Piece;;

public class BoardTest {
	@Test
	//test 测试构造函数
	public void testBoard() {
		Board board = new Board("go",19);
		
		int[][] newplace = new int[19][19];
		newplace = board.getPlaced();
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++)
				assertEquals(0,newplace[1][1]);
		}
	}
	//测试能够改变二维数组place是否有子
	@Test
	public void testchangePlaced() {
		Board board = new Board("go",19);
		board.changePlaced(0, 0, 1);
		int[][] newplace = new int[19][19];
		newplace = board.getPlaced();
		assertEquals(1,newplace[0][0]);

	}
	//测试设置二维数组Piece[][]，能否赋值
	@Test
	public void testsetPiece() {
		Board board = new Board("go",19);
		Piece pieces = new Piece("a","b");
		board.setPiece(pieces, 0, 1);
		Piece[][] newpieces = new Piece[19][19];
		newpieces = board.getPiece();
		assertEquals(pieces,newpieces[0][1]);
		assertEquals(null,newpieces[0][2]);
	}
	//测试x，y坐标能得到place上是否有子
	@Test
	public void testgetPlaced() {
		Board board = new Board("go",19);
		board.changePlaced(0, 0, 1);
		int[][] newplace = new int[19][19];
		newplace = board.getPlaced();
		assertEquals(1,newplace[0][0]);

	}
	//测试得到piece[][]
	@Test
	public void testgetPiece(){
		
		Board board = new Board("go",19);
		Piece pieces = new Piece("a","b");
		board.setPiece(pieces, 0, 1);
		Piece[][] newpieces = new Piece[19][19];
		newpieces = board.getPiece();
		assertEquals(pieces,newpieces[0][1]);
	}
	//测试能移除Pieces[][]x，y坐标上的piece
	@Test
	public void testremovePiece() {
		
		Board board = new Board("go",19);
		Piece pieces = new Piece("a","b");
		board.setPiece(pieces, 0, 1);
		board.removePiece(0, 1);
		Piece[][] newpieces = new Piece[19][19];
		newpieces = board.getPiece();
		assertEquals(null,newpieces[0][1]);
		
	}
}
