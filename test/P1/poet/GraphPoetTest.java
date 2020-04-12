/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {
    
    // Testing strategy
    // �����ļ��ܷ���ȷ����ͼ
    //�����˵������ʣ�һ�о��ӺͶ��о��ӵ������
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //tests һ�о���
    @Test
    public void testGraphPoet() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "Seek to explore new and exciting synergies!";
        assertEquals("Seek to explore strange new life and exciting synergies!",nimoy.poem(input));
    }
    //test һ������
    @Test
    public void testGraphPoet_1() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "To!";
        assertEquals("To!",nimoy.poem(input));
    }
    //���о���
    @Test
    public void testGraphPoet_2() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "To explore new and exciting!\nTo out new life?";
        assertEquals("To explore strange new life and exciting\nTo out new life?",nimoy.poem(input));
    }
    
    //����toString
    @Test
    public void testtoString() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        
        assertEquals("��:[new, worlds, explore, and, to, civilizations, seek, strange, life, out]\n��:to��explore����1\n" + 
        		"explore��strange����1\n" + 
        		"strange��new����1\n" + 
        		"new��worlds����1\n" + 
        		"to��seek����1\n" + 
        		"seek��out����1\n" + 
        		"out��new����1\n" + 
        		"new��life����1\n" + 
        		"life��and����1\n" + 
        		"and��new����1\n" + 
        		"new��civilizations����1\n",nimoy.toString());
    }
}
