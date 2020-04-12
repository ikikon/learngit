/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {

	/*
	 * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
	 */
	@Override
	public Graph<String> emptyInstance() {
		return new ConcreteEdgesGraph<String>();
	}

	/*
	 * Testing ConcreteEdgesGraph...
	 */

	// Testing strategy for ConcreteEdgesGraph.toString()
	// 测试图能否正常输出

	
	
	//tests for ConcreteEdgesGraph.toString()
	
	@Test
	public void testToString() {
		ConcreteEdgesGraph<String> map = new ConcreteEdgesGraph<String>();
		map.set("a", "b", 1);
		String string_1 = "点:"+"[a,"+" b]";
		string_1 +="\n";
		string_1 +="边:"+"a"+"到"+"b"+"长："+"1\n";
		assertEquals(string_1,map.toString());
		}
	
	/*
	 * Testing Edge...
	 */

	// * Testing strategy for Edge
	/*
	 * Edge():source!=target , source=target , weight >0 , weight<=0
	 * getWeight(): weight>0
	 * getSource(): String 
	 * getTarget(): String 
	 * toString(): String 
	 */
	
	//covers test source!=target
	@Test
	public void testEdge() {
		Edge<String> e = new Edge<String>("a", "b", 1);
		assertEquals("a", e.getSource());
		assertEquals("b", e.getTarget());
		assertEquals(1, e.getWeight());
	}

	//covers test source= target
	@Test
	public void testEdge_1() {
		try {
			Edge<String> f = new Edge<String>("a", "a", 1);
			fail("should get illegal exception");

		} catch (RuntimeException e1) {
			assertEquals(e1.getMessage(), "source and target should not be equal");
		}

	}

	// covers test weight =1
		@Test
		public void testgetWeight() {
			Edge<String> p1 = new Edge<String>("a", "b", 1);
			
			assertEquals(1, p1.getWeight());
			
		}
	
	// covers test String type
	@Test
	public void testgetSource() {

		Edge<String> p1 = new Edge<String>("a", "b", 1);
		assertEquals("a", p1.getSource());
	}

	// covers test String type
	@Test
	public void testgetTarget() {
		Edge<String> p1 = new Edge<String>("a", "b", 1);
		assertEquals("b", p1.getTarget());
	}

	
	// covers test weight =-1 throw assertion error
	@Test(expected=AssertionError.class)
    public void testgetWeight_1() {
		Edge<String> p2 = new Edge<String>("a", "b", -1);
        assert false; 
    }
	
	// covers test Edge.toString
	@Test
	public void testtoString() {
		Edge<String> p1 = new Edge<String>("a", "b", 1);
		assertEquals("source:a target:b weight:1", p1.toString());
	}
}
