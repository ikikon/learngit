package P3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import P3.Action.Action;
import P3.Game.*;
import P3.Player.Player;

public class ChessActionTest {
	//�����ܹ���ȷ�������̴�С
	@Test
	public void getSize() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		assertEquals(8,action.getSize());
	}

//�����ܷ���ȷ�������
	@Test
	public void testsetPlayer() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		Player player_11 = new Player("a");
		assertEquals(player_11.getName(),action.getPlayer_1().getName());
	}

	//���Եõ���ǰ�����ֵ����
	@Test
	public void testgetFirstHeadPlayer(){
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("a");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//�����������1Ϊ����
	@Test
	public void testsetsecondHead_1() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setsecondHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("b");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//�����������1Ϊ����
	@Test
	public void testsetfirstHead_1() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("a");
		assertEquals(player_1.getName(),player_2.getName());
	}
	
	//�ܷ�ɹ����ӣ�������Ե��Ӳ����ڶԷ���������������ӣ�ʹ�õĲ����Լ����ӣ������׳��쳣
	@Test	
	public void testeatPiece() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertTrue(action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 0,1,0,6));
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 3,3,0,6);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��һ���������޵�");
		}
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 0,0,3,4);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"�ڶ����������޵�");
		}
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 2,7,3,7);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��һ��λ���ϵ����Ӳ����Լ�������");
		}
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 3,1,4,1);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"�ڶ���λ���ϵ����Ӳ��ǶԷ�����");
		}
	}
	//���Ըı�����
	@Test
	public void testchangeFirstHead() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		action.changeFirstHead();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("b");
		assertEquals(player_1.getName(),player_2.getName());
	}
	
	//�����ƶ����ӣ��ƶ��Ĳ����Լ������ӣ��ƶ������ӣ��ƶ�������Ŀ����Ѿ����ӣ������׳��쳣
	@Test
	public void testmovePiece() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertTrue(action.movePiece(action.getPlayer_1(),0,1,0,5));
		try {
			action.movePiece(action.getPlayer_1(),3,3,0,6);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��һ���������޵�");
		}
		try {
			action.movePiece(action.getPlayer_1(),0,0,3,4);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"�ڶ����������޵�");
		}
		try {
			action.movePiece(action.getPlayer_1(), 2,7,3,5);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"��һ��λ���ϵ����Ӳ����Լ�������");
		}
		
		
	}
	//��������ʼ��δfalse
	@Test
	public void removePiece() {
		
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertFalse(action.removePiece(action.getPlayer_1(), 0, 6));
	}
	//���Է���ʼ��δfalse
	@Test
	public void testplacePiece() {
		
		
		
		
		
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertFalse(action.placePiece(action.getPlayer_1(), 0, 6));
		
	}


	//���Է�����Ϸ����
	@Test
	public void testgetGameType() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		assertEquals("chess",action.getGameType());
	}
	////���Է���x��y������������
	@Test
	public void testgetPieceType() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		
		Player player = new Player("a");
		action.placePiece(player, 0, 1);
		assertEquals("white_pawn",action.getPieceType(0, 1));
	}
	//���Ը���ҵ�����������
	@Test
	public void testcalPieces() {
		Player player = new Player("a");
		Player player2 = new Player("b");
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		
		action.eatPiece(action.getPlayer_1(),action.getPlayer_2(), 0, 1, 0,6);
		assertEquals(16,action.calPieces(player.getName()));
		assertEquals(15,action.calPieces(player2.getName()));
	}
	
}
