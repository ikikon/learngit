package P3;

import P3.Position.Position;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class PositionTest {
	//测试构造函数是否成功
	@Test
	public void testPosition() {
		Position position_1 = new Position(1,3);
		assertEquals(position_1.getX(),1);
		assertEquals(position_1.getY(),3);
	}
	
	//返回position的Y坐标
	@Test
	public void getX() {
		Position position_1 = new Position(1,1);
		assertEquals(position_1.getX(),1);
	}
	
	//返回position的x坐标
	@Test
	public void getY() {
		Position position_1 = new Position(1,2);
		assertEquals(position_1.getY(),2);
	}
	
	//测试设置position的x和y坐标
	@Test
	public void setPosition() {
		Position position_1 = new Position(1,2);
		position_1.setPosition(3, 4);
		assertEquals(position_1.getX(),3);
		assertEquals(position_1.getY(),4);
		
	}
	
	//重写，判断两个position是否x相等y也相等,，测试相等和不想等
	@Test
	public void equals() {
		Position position_1 = new Position(1,2);
		Position position_2 = new Position(1,2);
		Position position_32 = new Position(1,32);
		assertTrue(position_1.equals(position_2));
		assertFalse(position_1.equals(position_32));
}
}