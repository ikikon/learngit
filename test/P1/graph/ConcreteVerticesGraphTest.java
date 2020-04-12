/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph<String>();
    }
    
    /*
     * Testing ConcreteVerticesGraph...
     */
    
    // Testing strategy for ConcreteVerticesGraph.toString()
    //  测试tostring能够正确输出
    
    //  tests for ConcreteVerticesGraph.toString()
    //
    @Test
    public void testtoString() {
    	ConcreteVerticesGraph<String> map = new ConcreteVerticesGraph<String>();
    	map.set("a", "b", 1);
    	String string_1 = "名字：a\n终点：b 长度：1\n名字：b\n源点：a 长度：1\n";
		assertEquals(string_1,map.toString());
    }
    /*
     * Testing Vertex...
     */
    
    //Testing strategy for Vertex
    //Vertex()测试点能够正确构造
    //getName()测试点能够正确得到名字
    //setTargetEdge()测试设置终点边
    //setSourceEdge()测试设置源点边
    //removeSourceEdge()测试删除源点边//有边的情况，无边的情况
    //removeTargetEdge()测试删除终点边//有边的情况，无边的情况
    //getSource()测试得到终点hashMap//有终点的情况，无终点的情况
    //getTarget()测试得到源点hashmap//有终点的情况，无终点的情况
    //soString()测试能够String正确输出
    
    //  tests for operations of Vertex
    
    @Test 
    public void testVertex(){
    	Vertex<String> a = new Vertex<String>("a");
    	assertEquals(a.getName(),"a");
    
    }
    
    @Test
    public void testGetName() {
    	Vertex<String> a = new Vertex<String>("a");
    	assertEquals(a.getName(),"a");
    }
    
    @Test
    public void testRemoveSource(){
    	Vertex<String> a = new Vertex<String>("a");
    	a.setSourceEdge("b", 1);
    	a.setSourceEdge("c", 1);
    	a.removeSourceEdge("b");
    	Map<String,Integer> map1 = new HashMap<String,Integer>();
    	map1.put("c", 1);
    	assertEquals(map1,a.getSource());
    	try {
    		a.removeSourceEdge("d");
    	}catch(RuntimeException e1){
    		assertEquals(e1.getMessage(),"不存在对应边");
    	}
    }
    @Test
    public void testSetTargetEdge() {
    	Vertex<String> a = new Vertex<String>("a");
    	a.setSourceEdge("b", 1);
    	a.setSourceEdge("c", 2);
    	Map<String,Integer> map1 = new HashMap<String,Integer>();
    	map1.put("c", 2);
    	map1.put("b",1);
    	assertEquals(map1,a.getSource());
    	
    }
    @Test
    public void testSetSourceEdge() {
    	Vertex<String> a = new Vertex<String>("a");
    	a.setTargetEdge("b", 1);
    	a.setTargetEdge("c", 2);
    	Map<String,Integer> map1 = new HashMap<String,Integer>();
    	map1.put("c", 2);
    	map1.put("b",1);
    	assertEquals(map1,a.getTarget());
    }
    
    @Test 
    public void testRemoveTarget() {
    	Vertex<String> a = new Vertex<String>("a");
    	a.setTargetEdge("b", 1);
    	a.setTargetEdge("c", 1);
    	a.removeTargetEdge("b");
    	Map<String,Integer> map1 = new HashMap<String,Integer>();
    	map1.put("c", 1);
    	assertEquals(map1,a.getTarget());
    	try {
    		a.removeTargetEdge("d");
    	}catch(RuntimeException e1){
    		assertEquals(e1.getMessage(),"不存在对应边");
    	}
    }
    
    @Test
    public void getSource() {
    	Vertex<String> a = new Vertex<String>("a");
    	Vertex<String> d = new Vertex<String>("d");
    	a.setSourceEdge("b", 1);
    	a.setSourceEdge("c", 1);
    	Map<String,Integer> map1 = new HashMap<String,Integer>();
    	Map<String,Integer> map2 = new HashMap<String,Integer>();
    	map1.put("b", 1);
    	map1.put("c",1);
    	assertEquals(map1,a.getSource());
    	assertEquals(map2,d.getSource());
    }
    @Test
    public void getTarget() {
    	Vertex<String> a = new Vertex<String>("a");
    	Vertex<String> d = new Vertex<String>("d");
    	a.setTargetEdge("b", 1);
    	a.setTargetEdge("c", 1);
    	Map<String,Integer> map1 = new HashMap<String,Integer>();
    	Map<String,Integer> map2 = new HashMap<String,Integer>();
    	map1.put("b", 1);
    	map1.put("c",1);
    	assertEquals(map1,a.getTarget());
    	assertEquals(map2,d.getTarget());
    }
    @Test
    public void testVertextoString() {
    	Vertex<String> a = new Vertex<String>("a");
    	a.setTargetEdge("b", 1);
    	a.setTargetEdge("c", 1);
    	a.setSourceEdge("d", 2);
    	String e = "名字：a\n源点：d 长度：2\n终点：b 长度：1\n终点：c 长度：1\n";
    	assertEquals(e,a.toString());
    }
    
}
