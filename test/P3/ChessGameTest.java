package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Game.Game;

public class ChessGameTest {
	@Test
	//����chessgame����Ϸ�����Ƿ�Ϊ��chess�������򷵻�true�����򷵻�false
	public void testgetgameType() {
		Game game = Game.empty("chess");
		assertEquals("chess",game.getgameType());
	}
	//����getsize(),�ܷ񷵻�8.
	@Test
	public void testgetSize() {
		Game game = Game.empty("chess");
		assertEquals(8,game.getSize());
	}
}
