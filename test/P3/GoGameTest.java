package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Game.Game;

public class GoGameTest {
	//测试能够返回游戏类型为“go”
	@Test
	public void testgetgameType() {
		Game game = Game.empty("go");
		assertEquals("go",game.getgameType());
	}
	//测试游戏棋盘大小是否为19
	@Test
	public void testgetSize() {
		Game game = Game.empty("go");
		assertEquals(19,game.getSize());
	}
}
