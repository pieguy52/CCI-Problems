package ch3;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class AnimalQueue {
	private int order = 0;
	private LinkedList<Dog> dogQ = new LinkedList<Dog>(); 
	private LinkedList<Cat> catQ = new LinkedList<Cat>();
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog)
			dogQ.addLast((Dog) a);
		else if(a instanceof Cat)
			catQ.addLast((Cat) a);
	}
	
	public Animal dequeueAny(){
		if(dogQ.size() == 0)
			return catQ.removeFirst();
		else if(catQ.size() == 0)
			return dogQ.removeFirst();
		int dogO = dogQ.getFirst().getOrder();
		int catO = catQ.getFirst().getOrder();
		if(dogO < catO)
			return dogQ.removeFirst();
		else 
			return catQ.removeFirst();
	}
	
	public Animal dequeueDog() throws Exception{
		if(dogQ.size() == 0)
			throw new Exception();
		return dogQ.removeFirst();
	}
	
	public int getDogSize(){
		return dogQ.size();
	}
	
	public Animal dequeueCat() throws Exception{
		if(catQ.size() == 0)
			throw new Exception();
		return catQ.removeFirst();
	}
	
	public int getCatSize(){
		return catQ.size();
	}
}
