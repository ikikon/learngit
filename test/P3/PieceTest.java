package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Piece.Piece;

public class PieceTest {
	//���Թ��캯��
	@Test
	public void testPiece() {
		Piece piece = new Piece("a","white_pawn");
		assertEquals(piece.getUser(),"a");
	}
	//���Է���name
	@Test
	public void testgetUser() {
		Piece piece = new Piece("a","white_pawn");
		assertEquals(piece.getUser(),"a");
		
	}
	//���Է���Type
	@Test
	public void testgetType() {
		Piece piece = new Piece("a","white_pawn");
		assertEquals(piece.getType(),"white_pawn");
	}
	//���Եõ�x����
	@Test
	public void testgetX() {
		Piece piece = new Piece("a","white_pawn");
		piece.set(0, 1);
		assertEquals(0,piece.getX());
	}
	//���Եõ�y����
	@Test
	public void testgetY() {
		Piece piece = new Piece("a","white_pawn");
		piece.set(0, 1);
		assertEquals(1,piece.getY());
	}
	//���Գɹ�����x�����y����
	@Test
	public void testset() {
		Piece piece = new Piece("a","white_pawn");
		piece.set(0, 1);
		assertEquals(1,piece.getY());
		assertEquals(0,piece.getX());
	}
}
