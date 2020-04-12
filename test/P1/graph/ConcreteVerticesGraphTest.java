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
    //  ����tostring�ܹ���ȷ���
    
    //  tests for ConcreteVerticesGraph.toString()
    //
    @Test
    public void testtoString() {
    	ConcreteVerticesGraph<String> map = new ConcreteVerticesGraph<String>();
    	map.set("a", "b", 1);
    	String string_1 = "���֣�a\n�յ㣺b ���ȣ�1\n���֣�b\nԴ�㣺a ���ȣ�1\n";
		assertEquals(string_1,map.toString());
    }
    /*
     * Testing Vertex...
     */
    
    //Testing strategy for Vertex
    //Vertex()���Ե��ܹ���ȷ����
    //getName()���Ե��ܹ���ȷ�õ�����
    //setTargetEdge()���������յ��
    //setSourceEdge()��������Դ���
    //removeSourceEdge()����ɾ��Դ���//�бߵ�������ޱߵ����
    //removeTargetEdge()����ɾ���յ��//�бߵ�������ޱߵ����
    //getSource()���Եõ��յ�hashMap//���յ����������յ�����
    //getTarget()���Եõ�Դ��hashmap//���յ����������յ�����
    //soString()�����ܹ�String��ȷ���
    
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
    		assertEquals(e1.getMessage(),"�����ڶ�Ӧ��");
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
    		assertEquals(e1.getMessage(),"�����ڶ�Ӧ��");
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
    	String e = "���֣�a\nԴ�㣺d ���ȣ�2\n�յ㣺b ���ȣ�1\n�յ㣺c ���ȣ�1\n";
    	assertEquals(e,a.toString());
    }
    
}
