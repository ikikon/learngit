package P3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import P3.Action.Action;
import P3.Game.*;
import P3.Player.Player;

public class ChessActionTest {
	//测试能够正确返回棋盘大小
	@Test
	public void getSize() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		assertEquals(8,action.getSize());
	}

//测试能否正确设置玩家
	@Test
	public void testsetPlayer() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		Player player_11 = new Player("a");
		assertEquals(player_11.getName(),action.getPlayer_1().getName());
	}

	//测试得到当前是先手的玩家
	@Test
	public void testgetFirstHeadPlayer(){
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("a");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//测试设置玩家1为后手
	@Test
	public void testsetsecondHead_1() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setsecondHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("b");
		assertEquals(player_1.getName(),player_2.getName());
	}
	//测试设置玩家1为先手
	@Test
	public void testsetfirstHead_1() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.setfirstHead_1();
		Player player_2 = action.getFirstHeadPlayer();
		Player player_1 = new Player("a");
		assertEquals(player_1.getName(),player_2.getName());
	}
	
	//能否成功吃子，如果被吃的子不属于对方，输入的坐标无子，使用的不是自己的子，都会抛出异常
	@Test	
	public void testeatPiece() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertTrue(action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 0,1,0,6));
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 3,3,0,6);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第一个坐标上无点");
		}
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 0,0,3,4);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第二个坐标上无点");
		}
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 2,7,3,7);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第一个位置上的棋子不是自己的棋子");
		}
		try {
			action.eatPiece(action.getPlayer_1(), action.getPlayer_2(), 3,1,4,1);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第二个位置上的棋子不是对方棋子");
		}
	}
	//测试改变先手
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
	
	//测试移动棋子，移动的不是自己的棋子，移动点无子，移动的棋子目标点已经有子，都会抛出异常
	@Test
	public void testmovePiece() {
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertTrue(action.movePiece(action.getPlayer_1(),0,1,0,5));
		try {
			action.movePiece(action.getPlayer_1(),3,3,0,6);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第一个坐标上无点");
		}
		try {
			action.movePiece(action.getPlayer_1(),0,0,3,4);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第二个坐标上无点");
		}
		try {
			action.movePiece(action.getPlayer_1(), 2,7,3,5);
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"第一个位置上的棋子不是自己的棋子");
		}
		
		
	}
	//测试提子始终未false
	@Test
	public void removePiece() {
		
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertFalse(action.removePiece(action.getPlayer_1(), 0, 6));
	}
	//测试放子始终未false
	@Test
	public void testplacePiece() {
		
		
		
		
		
		
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		assertFalse(action.placePiece(action.getPlayer_1(), 0, 6));
		
	}


	//测试返回游戏类型
	@Test
	public void testgetGameType() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		assertEquals("chess",action.getGameType());
	}
	////测试返回x，y处的棋子类型
	@Test
	public void testgetPieceType() {
		Action action = Action.empty("chess", "a", "b");
		action.setPlayer("a", "b");
		action.initalBoard();
		
		Player player = new Player("a");
		action.placePiece(player, 0, 1);
		assertEquals("white_pawn",action.getPieceType(0, 1));
	}
	//测试该玩家的棋子总数。
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
