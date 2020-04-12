/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
	// Testing strategy
    //empty()
    //no inputs, only output is empty graph
    //observe with vertices()
	//测试两种不同的不可变类型的图：string 和 int
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        //  you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    //  other tests for instance methods of Graph
    @Test 
	public void testAdd() {
		Graph<String> map = emptyInstance();
		assertTrue(map.add("a"));
		assertTrue(map.add("b"));
		assertTrue(map.add("d"));
		assertFalse(map.add("a"));
	}
	
	//cover a vertex with the same source and target
	//cover test weight > 0
	//cover test weight = 0
	@Test
	public void testSet() {
		try {
			Graph<String> map = emptyInstance();
			map.set("a", "a", 1);
			fail("should get illegal exception");

		} catch (RuntimeException e1) {
			assertEquals(e1.getMessage(), "source and target should not be equal");
		}
		
		Graph<String> map_1 = emptyInstance();
		assertEquals(1,map_1.set("a", "b", 1));
		assertEquals(3,map_1.set("c", "d", 3));
		assertEquals(2,map_1.set("a", "b", 2));
		assertEquals(4,map_1.set("a", "b", 4));
		assertEquals(0,map_1.set("a", "b", 0));
		
	}
	//cover test weight<0
	@Test
	public void testSet_1() {
		
        try {
			Graph<String> map = emptyInstance();
			map.set("a", "b", -1);
			fail("should get illegal exception");

		} catch (RuntimeException e1) {
			assertEquals(e1.getMessage(), "weight should be postive number!");
		}
	}
	
	// cover remove the exist and not exist vertex
	@Test
	public void testRemove() {
		Graph<String> map = emptyInstance();
		assertTrue(map.add("a"));
		assertTrue(map.add("b"));
		assertFalse(map.remove("c"));
		map.set("a", "b", 1);
		map.set("a", "c", 1);
		map.set("b", "c", 1);
		assertTrue(map.remove("a"));
		Set<String> set_1 = new HashSet<String>();
		set_1.add("b");
		set_1.add("c");
		assertEquals(set_1,map.vertices());
		Map<String,Integer> map_1 = new HashMap<>();
		map_1.put("b", 1);
		assertEquals(map_1,map.sources("c"));
	}
	
	// cover test exist vertex and not exist vertex
	@Test
	public void testVertices() {
		Graph<String> map = emptyInstance();
		map.add("a");
		map.add("b");
		Set<String> set_1 = new HashSet<String>();
		set_1.add("a");
		set_1.add("b");
		assertEquals(set_1,map.vertices());
		set_1.add("c");
		assertNotEquals(set_1,map.vertices());
	}
	
	// cover test exist vertex and not exist vertex
	@Test
	public void testSources() {
		Graph<String> map = emptyInstance();
		Map<String,Integer> a = new HashMap<>();
		
		map.set("a", "b", 1);
		map.set("a", "c", 2);
		map.set("b", "c", 3);
		map.set("d", "c", 4);
		map.set("e", "c", 5);
		
		a.put("a", 2);
		a.put("b", 3);
		a.put("d", 4);
		a.put("e", 5);
		assertEquals(map.sources("c"),a);
	}
}
