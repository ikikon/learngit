/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import P1.graph.Graph;

/**
 * A graph-based poetry generator.
 * 
 * <p>GraphPoet is initialized with a corpus of text, which it uses to derive a
 * word affinity graph.
 * Vertices in the graph are words. Words are defined as non-empty
 * case-insensitive strings of non-space non-newline characters. They are
 * delimited in the corpus by spaces, newlines, or the ends of the file.
 * Edges in the graph count adjacencies: the number of times "w1" is followed by
 * "w2" in the corpus is the weight of the edge from w1 to w2.
 * 
 * <p>For example, given this corpus:
 * <pre>    Hello, HELLO, hello, goodbye!    </pre>
 * <p>the graph would contain two edges:
 * <ul><li> ("hello,") -> ("hello,")   with weight 2
 *     <li> ("hello,") -> ("goodbye!") with weight 1 </ul>
 * <p>where the vertices represent case-insensitive {@code "hello,"} and
 * {@code "goodbye!"}.
 * 
 * <p>Given an input string, GraphPoet generates a poem by attempting to
 * insert a bridge word between every adjacent pair of words in the input.
 * The bridge word between input words "w1" and "w2" will be some "b" such that
 * w1 -> b -> w2 is a two-edge-long path with maximum-weight weight among all
 * the two-edge-long paths from w1 to w2 in the affinity graph.
 * If there are no such paths, no bridge word is inserted.
 * In the output poem, input words retain their original case, while bridge
 * words are lower case. The whitespace between every word in the poem is a
 * single space.
 * 
 * <p>For example, given this corpus:
 * <pre>    This is a test of the Mugar Omni Theater sound system.    </pre>
 * <p>on this input:
 * <pre>    Test the system.    </pre>
 * <p>the output poem would be:
 * <pre>    Test of the system.    </pre>
 * 
 * <p>PS2 instructions: this is a required ADT class, and you MUST NOT weaken
 * the required specifications. However, you MAY strengthen the specifications
 * and you MAY add additional methods.
 * You MUST use Graph in your rep, but otherwise the implementation of this
 * class is up to you.
 */
public class GraphPoet {
    
    private final Graph<String> graph = Graph.empty();
    
    // Abstraction function:
    //  每个单词对应一个点，两个相邻的单词对应一条有向边
    // Representation invariant:
    //   graph!=null;//语料库不能为空
    // Safety from rep exposure:																			
    //   All fields are private
    
    /**
     * Create a new poet with the graph from corpus (as described above).
     * 
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
        //throw new RuntimeException("not implemented");
    
    	
    	BufferedReader reader = null;
    	try{
    		reader = new BufferedReader(new FileReader(corpus));
    		String tempString = new String();
    		//int line= 1;
    		while((tempString = reader.readLine())!=null) {
    			tempString = tempString.toLowerCase();
    			String[] buff_1 =tempString.split(" ");
    			String[] buff = new String[buff_1.length];
    			for(int i=0;i<buff_1.length;i++) {
    				String a= buff_1[i];
    				a = a.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×.!?。]", "");
    				buff[i] = a;
    			}
    				
    			int size = buff.length;
    			
    			for(int i=0;i<size;i++) {
    				graph.add(buff[i]);
    			}
    			for(int j=0;j<size-1;j++) {
    				int flag=0;
    				Map<String,Integer> map = graph.targets(buff[j]);
    				for(Map.Entry<String,Integer> entry:map.entrySet()) {
    					if(entry.getKey().equals(buff[j+1])) {
    						int i=entry.getValue();
        					graph.set(buff[j], buff[j+1], i+1);
        					flag=1;
    					}
    						
    				}
    				if(flag==0)
    					graph.set(buff[j], buff[j+1], 1);
    			}
    			
    			
    		}
    		reader.close();
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}finally {
    		if(reader!=null) {
    			try {
    				reader.close();
    			}catch(IOException e1) {
    				
    			}
    		}
    	}
    	checkRep();
    }
    
    // checkRep
    public void checkRep() {
    	assert graph.vertices().size()>0;
    }
    /**
     * Generate a poem.
     * 
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    public String poem(String input) {
        //throw new RuntimeException("not implemented");
    	
    	
    	
    	String[] buff_1 =input.split(" ");
		String[] buff = new String[buff_1.length];
		for(int i=0;i<buff_1.length;i++) {
			String a= buff_1[i];
			a = a.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×.!?。]", "");
			buff[i] = a;
		}
    	
    	
    	
    	String finallString = "";
    	for(int i=0;i<buff.length-1;i++) {
    		finallString += buff[i] +" "+wordInsert(buff[i],buff[i+1]);
    	}
    	finallString+=buff_1[buff_1.length-1];
    	checkRep();
    	return finallString;
    }
    /**
     * insert a word.
     * 
     * @param Stirng1 and String2
     * @return  insertable string
     */
    public String wordInsert(String s1,String s2) {
    	Map<String,Integer> targets = graph.targets(s1.toLowerCase());
    	List<String> words = new ArrayList<>();
    	List<Integer> weights = new ArrayList<>();
    	for(String key : targets.keySet()) {
    		Map<String,Integer> targets2 = graph.targets(key);
    		for(String key2: targets2.keySet()) {
    			if(key2.equals(s2.toLowerCase())) {
    				words.add(key);
    				weights.add(targets.get(key));
    				break;
    			}
    		}
    	}
    	
    	if(words.size()==0) {
    		return "";
    	}else {
    		int max = 0;
    		int dex = 0;
    		for(int i =0;i<weights.size();i++) {
    			if(weights.get(i)>max) {
    				max = weights.get(i);
    				dex = i;
    			}
    		}
    		checkRep();
    		return new String(words.get(dex)+" ");
    	}

    }
    
    //  toString()
    @Override
    public String toString() {
    	String a =graph.toString();
    	return a;
    }
}
