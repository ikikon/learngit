package P2;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
public class FriendshipGraphTest {
	
	// Testing strategy
	//测试能否正确加入Vertex
	//加入已经存在的边和未存在的边
	@Test
	public void testAddVertex() {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		assertEquals(rachel.getName(),graph.addVertex(rachel).getName());
		assertEquals(ross.getName(),graph.addVertex(ross).getName());
		assertEquals(ben.getName(),graph.addVertex(ben).getName());
		assertEquals(kramer.getName(),graph.addVertex(kramer).getName());
		try {
			Person Ben = new Person("Ben");
			graph.addVertex(Ben).getName();
		}catch(RuntimeException e1) {
			assertEquals(e1.getMessage(),"the name has already exist!");
		}
		
		
	}
	//测试能够正确加入边,人际网络中应该允许重边
	@Test
	public void testaddEdge() {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		
		assertTrue(graph.addEdge(rachel, ross));
		assertTrue(graph.addEdge(ross, rachel));
		assertTrue(graph.addEdge(ross, ben));
		assertTrue(graph.addEdge(ben, ross));
	
		
	}
	//测试能够正确得到距离
	@Test
	public void testGetDistance() {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		assertEquals(1,graph.getDistance(rachel, ross));
		assertEquals(2,graph.getDistance(rachel, ben));
		assertEquals(0,graph.getDistance(rachel, rachel));
		assertEquals(-1,graph.getDistance(rachel, kramer));
	}
	//测试复杂图是否正确
	@Test
	public void testComplexadjacencyList() {
		FriendshipGraph graph = new FriendshipGraph();
		Person a = new Person("A");
		Person b = new Person("B");
		Person c = new Person("C");
		Person d = new Person("D");
		Person e = new Person("E");
		Person f = new Person("F");
		Person g = new Person("G");
		Person h = new Person("H");
		Person i = new Person("I");
		Person j = new Person("J");
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);
		graph.addVertex(j);
		graph.addEdge(a, b);
		graph.addEdge(a, d);
		graph.addEdge(b, d);
		graph.addEdge(b, c);
		graph.addEdge(d, b);
		graph.addEdge(d, e);
		graph.addEdge(e, i);
		graph.addEdge(i, j);
		graph.addEdge(d, f);
		graph.addEdge(j, f);
		graph.addEdge(h, f);
		graph.addEdge(g, h);
		graph.addEdge(c, g);
		graph.addEdge(f, d);
		graph.addEdge(a, c);
		assertEquals(1, graph.getDistance(a, b));
		assertEquals(1, graph.getDistance(a, d));
		assertEquals(2, graph.getDistance(a, g));
		assertEquals(2, graph.getDistance(b, f));
		assertEquals(1, graph.getDistance(d, f));
		assertEquals(5, graph.getDistance(h, j));
		assertEquals(0, graph.getDistance(i, i));
		assertEquals(3, graph.getDistance(d, j));
		assertEquals(6, graph.getDistance(c, i));
		assertEquals(5, graph.getDistance(f, h));

		
	}
}
