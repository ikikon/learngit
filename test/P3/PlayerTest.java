package P3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import P3.Player.Player;

public class PlayerTest {
	//���Թ��캯���Ƿ�ɹ�
	@Test
	public void testPlayer() {
		Player player = new Player("a");
		assertEquals(player.getName(),"a");
	}
	//���Է���Name
	@Test
	public void testgetName() {
		Player player = new Player("a");
		assertEquals(player.getName(),"a");
	}
//���Գɹ���������
	@Test
	public void testsetFirstHead() {
		Player player = new Player("a");
		player.setFirstHead();
		assertTrue(player.getFirstHead());
	}
	//���Գɹ����ú���
	@Test
	public void testsetSceondHead() {
		Player player = new Player("a");
		player.setSceondHead();
		assertFalse(player.getFirstHead());
	}
	//�����Ƿ������֣���������ַ���true�����򷵻�false
	@Test
	public void testgetFirstHead() {
		Player player = new Player("a");
		Player player1 = new Player("b");
		player.setFirstHead();
		assertTrue(player.getFirstHead());
		assertFalse(player1.getFirstHead());
	}
}
