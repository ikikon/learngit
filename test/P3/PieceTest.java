package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Piece.Piece;

public class PieceTest {
	//测试构造函数
	@Test
	public void testPiece() {
		Piece piece = new Piece("a","white_pawn");
		assertEquals(piece.getUser(),"a");
	}
	//测试返回name
	@Test
	public void testgetUser() {
		Piece piece = new Piece("a","white_pawn");
		assertEquals(piece.getUser(),"a");
		
	}
	//测试返回Type
	@Test
	public void testgetType() {
		Piece piece = new Piece("a","white_pawn");
		assertEquals(piece.getType(),"white_pawn");
	}
	//测试得到x坐标
	@Test
	public void testgetX() {
		Piece piece = new Piece("a","white_pawn");
		piece.set(0, 1);
		assertEquals(0,piece.getX());
	}
	//测试得到y坐标
	@Test
	public void testgetY() {
		Piece piece = new Piece("a","white_pawn");
		piece.set(0, 1);
		assertEquals(1,piece.getY());
	}
	//测试成功设置x坐标和y坐标
	@Test
	public void testset() {
		Piece piece = new Piece("a","white_pawn");
		piece.set(0, 1);
		assertEquals(1,piece.getY());
		assertEquals(0,piece.getX());
	}
}
