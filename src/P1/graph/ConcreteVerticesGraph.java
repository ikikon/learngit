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
public class ConcreteVerticesGraph<L> implements Graph<L> {

	private final List<Vertex<L>> vertices = new ArrayList<>();

	// Abstraction function:
	// AF(vertices) = all vertices contain its sources and targets with weight in a
	// hash map
	// Representation invariant:
	// every edges' weight need be positive
	// Safety from rep exposure:
	// use defensive copy and pirvate type

	//  checkRep
	private void checkRep() {
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = i + 1; j < vertices.size(); j++)
				assert !vertices.get(i).getName().equals(vertices.get(j).getName());
		}
		for (Vertex<L> a : vertices) {
			assert a != null;
		}
	}

	@Override
	public boolean add(L vertex) {
		// throw new RuntimeException("not implemented");
		Vertex<L> input = new Vertex<>(vertex);
		for (Vertex<L> producer : vertices) {
			if (producer.getName().equals(vertex))
				return false;
		}

		vertices.add(input);
		checkRep();
		return true;

	}

	@Override
	public int set(L source, L target, int weight) {
		// throw new RuntimeException("not implemented");
		if (weight < 0)
			throw new RuntimeException("weight should be postive number!");
		if (source.equals(target))
			throw new RuntimeException("source and target should not be equal");
		Vertex<L> source_1 = null;
		Vertex<L> target_1 = null;
		for (Vertex<L> producer : vertices) {
			if (producer.getName().equals(source)) {
				source_1 = producer;
			}
			if (producer.getName().equals(target)) {
				target_1 = producer;
			}
		}

		if (source_1 == null && target_1 == null) {
			Vertex<L> source_2 = new Vertex<L>(source);
			Vertex<L> target_2 = new Vertex<L>(target);
			source_2.setTargetEdge(target, weight);
			target_2.setSourceEdge(source, weight);
			vertices.add(source_2);
			vertices.add(target_2);
			checkRep();
			return weight;
		}

		if (source_1 != null && target_1 == null) {
			Vertex<L> target_2 = new Vertex<L>(target);
			target_2.setSourceEdge(source, weight);
			vertices.add(target_2);
			source_1.setTargetEdge(target, weight);
			checkRep();
			return weight;
		}

		if (source_1 == null && target_1 != null) {
			Vertex<L> source_2 = new Vertex<L>(source);
			source_2.setTargetEdge(target, weight);
			vertices.add(source_2);
			target_1.setSourceEdge(source, weight);
			checkRep();
			return weight;
		}

		if (weight > 0 && source_1 != null && target_1 != null) {

			if (source_1.getTarget().containsKey(target_1.getName()))
				source_1.removeTargetEdge(target);
			source_1.setTargetEdge(target, weight);

			if (source_1.getSource().containsKey(target_1.getName()))
				target_1.removeSourceEdge(source);
			target_1.setSourceEdge(source, weight);
			checkRep();
			return weight;
		}

		if (weight == 0 && source_1 != null && target_1 != null) {
			source_1.removeTargetEdge(target);
			target_1.removeSourceEdge(source);
			checkRep();
			return 0;
		}
		return weight;
	}

	@Override
	public boolean remove(L vertex) {
		// throw new RuntimeException("not implemented");
		int flag = -1;
		Iterator<Vertex<L>> iter = vertices.iterator();
		Vertex<L> a = null;
		while (iter.hasNext()) {
			a = iter.next();
			if (a.getName().equals(vertex)) {
				flag = 1;
				iter.remove();
			}
		}
		if (flag == 1) {

			for (Vertex<L> producer : vertices) {
				if(producer.getSource().containsKey(vertex))
				producer.removeSourceEdge(vertex);
				if(producer.getTarget().containsKey(vertex))
				producer.removeTargetEdge(vertex);
			}
			checkRep();
			return true;
		} else
			return false;

	}

	@Override
	public Set<L> vertices() {
		// throw new RuntimeException("not implemented");
		Set<L> set = new HashSet<>();
		for (Vertex<L> producer : vertices) {
			set.add(producer.getName());
		}
		checkRep();
		return set;

	}

	@Override
	public Map<L, Integer> sources(L target) {
		// throw new RuntimeException("not implemented");
		Map<L, Integer> sources_2 = new HashMap<>();
		Iterator<Vertex<L>> iter = vertices.iterator();
		while (iter.hasNext()) {
			Vertex<L> a = iter.next();
			if (a.getName().equals(target)) {
				Map<L, Integer> sources_1 = a.getSource();
				return sources_1;
			}
		}
		checkRep();
		return sources_2;
	}

	@Override
	public Map<L, Integer> targets(L source) {
		// throw new RuntimeException("not implemented");
		Map<L, Integer> sources_2 = new HashMap<>();
		Iterator<Vertex<L>> iter = vertices.iterator();
		while (iter.hasNext()) {
			Vertex<L> a = iter.next();
			if (a.getName().equals(source)) {
				Map<L, Integer> targets_1 = a.getTarget();
				return targets_1;
			}
		}
		checkRep();
		return sources_2;
	}

	// TODO toString()
	@Override
	public String toString() {
		String finalString="";
		for(Vertex<L> producer:vertices) {
			
		producer.toString();
		finalString+=producer.toString();
	}
		return finalString;
}
}
/**
 * specification Mutable. This class is internal to the rep of
 * ConcreteVerticesGraph. all weight need be positive number;
 * <p>
 * PS2 instructions: the specification and implementation of this class is up to
 * you.
 */
class Vertex<L> {

	// fields
	private final L name;
	private final Map<L, Integer> sources = new HashMap<>();
	private final Map<L, Integer> targets = new HashMap<>();
	// Abstraction function:
	// sources代表所有以name为目标的边及其权值
	// targets代表所有以name为源点的边及其权值
	// Representation invariant:
	// name!=null , sources中所有的权值大于0，target中所有的权值大于0
	// Safety from rep exposure:
	// all fields are pirvate ,and use defensive copy

	// constructor
	public Vertex(L input) {
		this.name = input;

	}

	public L getName() {
		L a = name;
		return a;
	}

	// checkRep
	private void checkRep() {
		Iterator<Map.Entry<L, Integer>> iter_1 = sources.entrySet().iterator();
		while (iter_1.hasNext()) {
			int weight = iter_1.next().getValue();

			assert weight > 0;

		}

		Iterator<Map.Entry<L, Integer>> iter_2 = targets.entrySet().iterator();
		while (iter_2.hasNext()) {
			int weight = iter_2.next().getValue();

			assert weight > 0;

		}
		assert name != null;

	}

	// methods
	public void setTargetEdge(L target, int weight) {
		targets.put(target, weight);
		checkRep();

	}

	public void setSourceEdge(L source, int weight) {
		sources.put(source, weight);
		checkRep();
	}

	public void removeTargetEdge(L target) {
		Iterator<Map.Entry<L, Integer>> iter_1 = targets.entrySet().iterator();
		int flag = 0;
		while (iter_1.hasNext()) {
			if (iter_1.next().getKey().equals(target)) {
				iter_1.remove();
				flag = 1;
			}

		}
		if (flag == 0)
			throw new RuntimeException("不存在对应边");
	}

	public void removeSourceEdge(L source) {
		Iterator<Map.Entry<L, Integer>> iter_1 = sources.entrySet().iterator();
		int flag = 0;
		while (iter_1.hasNext()) {
			if (iter_1.next().getKey().equals(source)) {
				iter_1.remove();
				flag=1;
			}
		}
		if (flag == 0)
			throw new RuntimeException("不存在对应边");
	}

	public Map<L, Integer> getSource() {
		Iterator<Map.Entry<L, Integer>> iter_1 = sources.entrySet().iterator();
		Map<L, Integer> map = new HashMap<L, Integer>();
		while (iter_1.hasNext()) {
			Map.Entry<L, Integer> item = iter_1.next();
			map.put(item.getKey(), item.getValue());
		}
		checkRep();
		return map;
	}

	public Map<L, Integer> getTarget() {
		Iterator<Map.Entry<L, Integer>> iter_1 = targets.entrySet().iterator();
		Map<L, Integer> map = new HashMap<L, Integer>();
		while (iter_1.hasNext()) {
			Map.Entry<L, Integer> item = iter_1.next();
			map.put(item.getKey(), item.getValue());
		}
		checkRep();
		return map;
	}

	//  toString()
	@Override
	public String toString() {
		String finalString = "";
		Iterator<Map.Entry<L, Integer>> iter_1 = sources.entrySet().iterator();
		finalString+="名字："+this.name+"\n";
		while(iter_1.hasNext()) {
			Map.Entry<L, Integer> item = iter_1.next();
			finalString += "源点："+item.getKey()+" "+"长度："+item.getValue()+"\n";
		}
		Iterator<Map.Entry<L, Integer>> iter_2 = targets.entrySet().iterator();
		while(iter_2.hasNext()) {
			Map.Entry<L, Integer> item1 = iter_2.next();
			finalString += "终点："+item1.getKey()+" "+"长度："+item1.getValue()+"\n";
		}
		checkRep();
		return finalString;
	}
}
