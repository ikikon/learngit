package P3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import P3.Game.Game;

public class GoGameTest {
	//�����ܹ�������Ϸ����Ϊ��go��
	@Test
	public void testgetgameType() {
		Game game = Game.empty("go");
		assertEquals("go",game.getgameType());
	}
	//������Ϸ���̴�С�Ƿ�Ϊ19
	@Test
	public void testgetSize() {
		Game game = Game.empty("go");
		assertEquals(19,game.getSize());
	}
}
