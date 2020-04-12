package P2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import P1.graph.Graph;
public class FriendshipGraph {
	
	private final Graph<Person> graph = Graph.empty();
	private Set<String> contain = new HashSet<>();
	
	public Person addVertex(Person person) {
		if(!contain.contains(person.getName())) {
			graph.add(person);
			contain.add(person.getName());
			return new Person(person.getName());
		}else
			throw new RuntimeException("the name has already exist!");
	}
	
	public boolean addEdge(Person person_1,Person person_2) {
		if(person_1.getName().equals(person_2.getName())) {
			throw new RuntimeException("the name should not be same");
		}else {
			graph.set(person_1, person_2, 1);
			return true;
		}
	}
	
	public int getDistance(Person person_1,Person person_2) {
		if(person_1.getName().equals(person_2.getName())) {
			return 0;
		}else {
			List<Person> countPerson = new ArrayList<Person>();
			Queue<Person> hasFound = new LinkedList<Person>();
			int distance = -1;
			Map<Person,Integer> next = graph.targets(person_1);
			hasFound.offer(person_1);
			countPerson.add(person_1);
			do {
				Person currentPerson = hasFound.peek();
				distance++;
				int size = hasFound.size();
				while(size-->0) {
					currentPerson = hasFound.poll();
					next = graph.targets(currentPerson);
					for(Map.Entry<Person, Integer> entry : next.entrySet()) {
						if(!countPerson.contains(entry.getKey())){
							hasFound.offer(entry.getKey());
							countPerson.add(entry.getKey());
							if(entry.getKey().equals(person_2)) {
								distance++;
								return distance;
							}
						}
					}
					
				}
			}while(!hasFound.isEmpty());
			return -1;
		}
	}
	
	
	public static void main(String args[]) {
		
		  FriendshipGraph graph = new FriendshipGraph(); 
		  Person rachel = new Person("Rachel"); 
		  Person ross = new Person("Ross"); 
		  Person ben = new Person("Ben"); 
		  Person kramer = new Person("Kramer"); 
		  graph.addVertex(rachel);
		  graph.addVertex(ross); 
		  graph.addVertex(ben); graph.addVertex(kramer);
		  graph.addEdge(rachel, ross); 
		  graph.addEdge(ross, rachel); 
		  graph.addEdge(ross,ben); 
		  graph.addEdge(ben, ross);  
		  System.out.println(graph.getDistance(rachel,ross)); 
		  System.out.println(graph.getDistance(rachel, ben));
		  System.out.println(graph.getDistance(rachel, rachel));
		  System.out.println(graph.getDistance(rachel, kramer));
		 
	}
}
