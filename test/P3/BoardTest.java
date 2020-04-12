package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Board.*;
import P3.Piece.Piece;;

public class BoardTest {
	@Test
	//test ���Թ��캯��
	public void testBoard() {
		Board board = new Board("go",19);
		
		int[][] newplace = new int[19][19];
		newplace = board.getPlaced();
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++)
				assertEquals(0,newplace[1][1]);
		}
	}
	//�����ܹ��ı��ά����place�Ƿ�����
	@Test
	public void testchangePlaced() {
		Board board = new Board("go",19);
		board.changePlaced(0, 0, 1);
		int[][] newplace = new int[19][19];
		newplace = board.getPlaced();
		assertEquals(1,newplace[0][0]);

	}
	//�������ö�ά����Piece[][]���ܷ�ֵ
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
	//����x��y�����ܵõ�place���Ƿ�����
	@Test
	public void testgetPlaced() {
		Board board = new Board("go",19);
		board.changePlaced(0, 0, 1);
		int[][] newplace = new int[19][19];
		newplace = board.getPlaced();
		assertEquals(1,newplace[0][0]);

	}
	//���Եõ�piece[][]
	@Test
	public void testgetPiece(){
		
		Board board = new Board("go",19);
		Piece pieces = new Piece("a","b");
		board.setPiece(pieces, 0, 1);
		Piece[][] newpieces = new Piece[19][19];
		newpieces = board.getPiece();
		assertEquals(pieces,newpieces[0][1]);
	}
	//�������Ƴ�Pieces[][]x��y�����ϵ�piece
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
