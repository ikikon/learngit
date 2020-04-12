package P3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import P3.Player.Player;

public class PlayerTest {
	//测试构造函数是否成功
	@Test
	public void testPlayer() {
		Player player = new Player("a");
		assertEquals(player.getName(),"a");
	}
	//测试返回Name
	@Test
	public void testgetName() {
		Player player = new Player("a");
		assertEquals(player.getName(),"a");
	}
//测试成功设置先手
	@Test
	public void testsetFirstHead() {
		Player player = new Player("a");
		player.setFirstHead();
		assertTrue(player.getFirstHead());
	}
	//测试成功设置后手
	@Test
	public void testsetSceondHead() {
		Player player = new Player("a");
		player.setSceondHead();
		assertFalse(player.getFirstHead());
	}
	//测试是否是先手，如果是先手返回true，否则返回false
	@Test
	public void testgetFirstHead() {
		Player player = new Player("a");
		Player player1 = new Player("b");
		player.setFirstHead();
		assertTrue(player.getFirstHead());
		assertFalse(player1.getFirstHead());
	}
}
