package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Game.Game;

public class ChessGameTest {
	@Test
	//测试chessgame的游戏类型是否为”chess”，是则返回true，否则返回false
	public void testgetgameType() {
		Game game = Game.empty("chess");
		assertEquals("chess",game.getgameType());
	}
	//测试getsize(),能否返回8.
	@Test
	public void testgetSize() {
		Game game = Game.empty("chess");
		assertEquals(8,game.getSize());
	}
}
