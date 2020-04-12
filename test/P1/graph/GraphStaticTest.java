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
 * Tests for static methods of Graph.
 * 
 * To facilitate testing multiple implementations of Graph, instance methods are
 * tested in GraphInstanceTest.
 */
public class GraphStaticTest {
    
    // Testing strategy
    //empty()
    //no inputs, only output is empty graph
    //observe with vertices()
	//测试两种不同的不可变类型的图：string 和 int
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEmptyVerticesEmpty() {
        assertEquals("expected empty() graph to have no vertices",
                Collections.emptySet(), Graph.empty().vertices());
    }
    
    // test other vertex label types in Problem 3.2
    //测试integer类型
    @Test 
    public void testIntegerVerticesEmpty() {
    	Graph<Integer> graph = Graph.empty();
    	assertTrue(graph.add(1));
    	assertEquals(1,graph.set(1, 2, 1));
    	assertEquals(3,graph.set(1, 3, 3));
    	Set<Integer> set_1 = new HashSet<>();
    	assertTrue(graph.remove(3));
    	set_1.add(1);
    	set_1.add(2);
    	assertEquals(set_1,graph.vertices());
    	Map<Integer,Integer> a = new HashMap<>();
    	a.put(1, 1);
    	assertEquals(a,graph.sources(2));
    	a.remove(1);
    	a.put(2, 1);
    	assertEquals(a,graph.targets(1));
    }
    
    @Test 
    public void testStringVerticesEmpty() {
    	Graph<String> graph = Graph.empty();
    	assertTrue(graph.add("1"));
    	assertEquals(1,graph.set("1", "2", 1));
    	assertEquals(3,graph.set("1", "3", 3));
    	Set<String> set_1 = new HashSet<>();
    	assertTrue(graph.remove("3"));
    	set_1.add("1");
    	set_1.add("2");
    	assertEquals(set_1,graph.vertices());
    	Map<String,Integer> a = new HashMap<>();
    	a.put("1", 1);
    	assertEquals(a,graph.sources("2"));
    	a.remove("1");
    	a.put("2", 1);
    	assertEquals(a,graph.targets("1"));
    }
    
}
