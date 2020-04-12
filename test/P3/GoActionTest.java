package P3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;
import P3.Action.Action;
import P3.Board.Board;
import P3.Player.Player;

public class GoActionTest {
	//���Եõ����̴�С
	@Test
	public void getSize() {
		
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		assertEquals(19,action.getSize());
	}
	
	//�����������
	@Test
	public void testsetPlayer() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		Player player_11 = new Player("a");
		assertEquals(player_11.getName(),action.getPlayer_1().getName());
	}
	
	//���Եõ����ֵ����
	@Test
	public void testgetFirstHeadPlayer(){
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("a");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//�����������1Ϊ����
	@Test
	public void testsetsecondHead_1() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.setsecondHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("b");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//�����������1Ϊ����
	@Test
	public void testsetfirstHead_1() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("a");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//����ʼ��Ϊfalse
	@Test
	public void testeatPiece() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertFalse(action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 0, 1, 0, 6));
	}
	//���Ըı�����
	@Test
	public void testchangeFirstHead() {
		
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		action.changeFirstHead();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("b");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//����ʼ��Ϊfalse
	@Test
	public void testmovePiece() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertFalse(action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 0, 1, 0, 5));
	}
	//�������ӣ����ӵ��Ӳ��ǶԷ����ӣ�Ŀ������ӣ������׳��쳣
	@Test
	public void removePiece() {
		Player player_1 = new Player("a");
		Player player_2 = new Player("b");
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		action.placePiece(player_1, 0, 1);
		assertTrue(action.removePiece(player_2,0 , 1));
		try {
			action.removePiece(player_2,0 , 1);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��λ��������");
		}
		try {
			action.placePiece(player_1, 0, 1);
			action.removePiece(player_1,0 , 1);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��λ�����Ӳ����ڶԷ�");
		}
		
		
	}
	//���Է��ӣ�Ŀ������ӣ����׳��쳣
	@Test
	public void testplacePiece() {
		Player player = new Player("a");
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertTrue(action.placePiece(player, 0, 1));
		try {
			action.placePiece(player,0,1);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��λ���Ѿ�������");
		}
	}
	
	
	//���Է�����Ϸ����
	@Test
	public void testgetGameType() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		assertEquals("go",action.getGameType());
	}
	//���Է���x��y������������
	@Test
	public void testgetPieceType() {
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		
		Player player = new Player("a");
		action.placePiece(player, 0, 1);
		assertEquals("a",action.getPieceType(0, 1));
	}
	//���Ը���ҵ���������
	@Test
	public void testcalPieces() {
		Player player = new Player("a");
		Player player2 = new Player("b");
		Action action = Action.empty("go", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		
		action.placePiece(player, 0, 1);
		assertEquals(1,action.calPieces(player.getName()));
		assertEquals(0,action.calPieces(player2.getName()));
	}
	
}
