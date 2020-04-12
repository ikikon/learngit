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
    // 测试文件能否正确生成图
    //测试了单个单词，一行句子和多行句子的情况。
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //tests 一行句子
    @Test
    public void testGraphPoet() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "Seek to explore new and exciting synergies!";
        assertEquals("Seek to explore strange new life and exciting synergies!",nimoy.poem(input));
    }
    //test 一个单词
    @Test
    public void testGraphPoet_1() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "To!";
        assertEquals("To!",nimoy.poem(input));
    }
    //两行句子
    @Test
    public void testGraphPoet_2() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        final String input = "To explore new and exciting!\nTo out new life?";
        assertEquals("To explore strange new life and exciting\nTo out new life?",nimoy.poem(input));
    }
    
    //测试toString
    @Test
    public void testtoString() throws IOException{
    	final GraphPoet nimoy = new GraphPoet(new File("src/P1/poet/mugar-omni-theater.txt"));
        
        assertEquals("点:[new, worlds, explore, and, to, civilizations, seek, strange, life, out]\n边:to到explore长：1\n" + 
        		"explore到strange长：1\n" + 
        		"strange到new长：1\n" + 
        		"new到worlds长：1\n" + 
        		"to到seek长：1\n" + 
        		"seek到out长：1\n" + 
        		"out到new长：1\n" + 
        		"new到life长：1\n" + 
        		"life到and长：1\n" + 
        		"and到new长：1\n" + 
        		"new到civilizations长：1\n",nimoy.toString());
    }
}
