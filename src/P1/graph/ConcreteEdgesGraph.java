/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>
 * PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<L> {

	private final Set<L> vertices = new HashSet<>();
	private final List<Edge<L>> edges = new ArrayList<>();

	// Abstraction function:
	// AF(vertices,edges) = an map contains vertices and edges

	// Representation invariant:
	// all edge's weight>=0,source,target are String,between two vertices only
	// exists one edge
	// Safety from rep exposure:
	// using by private declaration and all field are final and return by Defensive
	// copy

	// constructor
	// construct the Set of vertx and list of edge

	// checkRep
	// weight need be positive
	private void checkRep() {
		for(int i=0;i<edges.size();i++) {
			assert vertices.contains(edges.get(i).getSource());
			assert vertices.contains(edges.get(i).getTarget());
			assert !edges.get(i).getTarget().equals(edges.get(i).getSource());
			assert edges.get(i).getWeight()>0;
		}
		for(L s:vertices) {
			assert s!=null;
		}
	}

	@Override
	public boolean add(L vertex) {
		// throw new RuntimeException("not implemented");
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			checkRep();
			return true;
		} else {
			checkRep();
			return false;
		}
		
	}

	@Override
	public int set(L source, L target, int weight) {
		// throw new RuntimeException("not implemented");
		
		Edge<L> e = null;
		if(source.equals(target))
			throw new RuntimeException("source and target should not be equal");
			if (weight < 0)
				throw new RuntimeException("weight should be postive number!");
			else if (weight >= 0) {
				if (!vertices.contains(source))
					vertices.add(source);
				if (!vertices.contains(target))
					vertices.add(target);
				if (source.equals(target))
					return 0;
				Iterator<Edge<L>> iter = this.edges.iterator();
				if(weight>0) {
					e = new Edge<L>(source, target, weight);
					while (iter.hasNext()) {
						Edge<L> item = iter.next();
						if (item.getSource().equals(source)&& item.getTarget().equals(target)) {
							iter.remove();
							if(weight>0) {
								edges.add(e);
								checkRep();
							}
								
							return weight;
						}
					}
					
				}
				edges.add(e);
				}
			if(weight==0) {
				Iterator<Edge<L>> iter_1 = this.edges.iterator();
				while (iter_1.hasNext()) {
					Edge<L> item = iter_1.next();
					if (item.getSource().equals(source)&& item.getTarget().equals(target)) {
						iter_1.remove();
							
						return weight;
					}
			}
				
			

			checkRep();
		

	}
			return weight;
	}
	@Override
	public boolean remove(L vertex) {
		// throw new RuntimeException("not implemented");
		
			if (vertices.contains(vertex)) {
				Iterator<L> iter = this.vertices.iterator();
				while (iter.hasNext()) {
					if(iter.next().equals(vertex))
						iter.remove();
				}
				/*for (Edge<L> producer : edges) {
					if (vertex == producer.getSource() || vertex == producer.getTarget()) {
						edges.remove(producer);
					}
				}
				vertices.remove(vertex);*/
				
				Iterator<Edge<L>> a = this.edges.iterator();
				while(a.hasNext()) {
					Edge<L> b =a.next();
					if(b.getSource().equals(vertex)||b.getTarget().equals(vertex))
						a.remove();
				}
				
				checkRep();
				return true;
			} else
				return false;
		
	}

	@Override
	public Set<L> vertices() {
		// throw new RuntimeException("not implemented");
		checkRep();
		return new HashSet<L>(vertices);

	}

	@Override
	public Map<L, Integer> sources(L target) {
		// throw new RuntimeException("not implemented");
		
			Map<L, Integer> map = new HashMap<>();
			for (Edge<L> producer : edges) {
				if (target.equals(producer.getTarget())) {
					map.put(producer.getSource(), producer.getWeight());
				}
			}
			checkRep();
			return map;
		
	}

	@Override
	public Map<L, Integer> targets(L source) {
		// throw new RuntimeException("not implemented");
		
			Map<L, Integer> map = new HashMap<>();
			for (Edge<L> producer : edges) {
				if (source.equals(producer.getSource())) {
					map.put(producer.getTarget(), producer.getWeight());
				}
			}
			checkRep();
			return map;
		
	}

	// toString()
	@Override
	public String toString() {

		String string_1 = null;
		
		string_1 = "µã:"+vertices.toString();
		string_1 +="\n";
		string_1 +="±ß:";
		for (Edge<L> producer : edges) {
			string_1 += producer.getSource().toString() +"µ½" +producer.getTarget().toString()+"³¤£º"+Integer.toString(producer.getWeight())+"\n";
		}
		checkRep();
		return string_1;

	}

}

/**
 * specification weight must be positive number and source & target could be L
 * type. Immutable. This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>
 * PS2 instructions: the specification and implementation of this class is up to
 * you.
 */
class Edge<L> {

	// fields
	private final L source;
	private final L target;
	private final int weight;
	// Abstraction function:
	// AF (source,target,weight) = an edge from source to target with weight
	// Representation invariant:
	// weight>=0 and source&target are not equal
	// Safety from rep exposure:
	// using by private

	// constructor
	public Edge(L source_1, L target_1, int weight_1) {
		if (source_1.equals(target_1)) {
			throw new RuntimeException("source and target should not be equal");
		}
		this.source = source_1;
		this.target = target_1;
		this.weight = weight_1;
		checkRep();
	}

	// checkRep
	private void checkRep() {
		assert weight > 0;
		assert source!=null;
		assert target!=null;
		assert source!=target;
	}

	// methods
	public L getSource() {

		L source_1 = this.source;
		checkRep();
		return source_1;
	}

	public L getTarget() {

		L target_1 = this.target;
		checkRep();
		return target_1;
	}

	public int getWeight() {

		int i = this.weight;
		checkRep();
		return i;
	}

	// toString()
	@Override
	public String toString() {

		String finalString = "source:" + source.toString() + " " + "target:" + target.toString() + " " + "weight:"
				+ Integer.toString(weight);
		checkRep();
		return finalString;
	}
}
