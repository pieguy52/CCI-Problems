package ch3;

import java.util.Random;
import java.util.Stack;

public class Ch3Prob {

	public static void queueViaStackTests(){
		DoubleStackedQueue<Integer> redundancey = new DoubleStackedQueue<Integer>();
		for(int i = 0; i < 10; i++)
			redundancey.enqueue(i);
		for(int i = 0; i < 10; i++)
			System.out.println(redundancey.dequeue());
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> t = new Stack<Integer>();
		int temp = 0;
		while(!s.isEmpty()){
			temp = s.pop();
			while(!t.isEmpty() && t.peek() > temp)
				s.push(t.pop());
			t.push(temp);
		}
		while(!t.isEmpty())
			s.push(t.pop());
		return s;
	}
	
	public static void sortStackTests(){
		Stack<Integer> test = new Stack<Integer>();
		for(int i = 0; i < 10; i++){
			test.push(i);
		}
		
		test = sortStack(test);
		while(!test.isEmpty())
			System.out.println(test.pop());
	}
	
	public static void minStackTests() {
		Random rand = new Random();
		StackWithMin test1 = new StackWithMin();
		for(int i = 10; i > 0; i--)
			test1.push(rand.nextInt(10));
		
		while(!test1.isEmpty()){
			NodeWithMin n = test1.pop();
			System.out.println(n.min + " " + n.value);
		}
		System.out.println();
		StackWithMin test2 = new StackWithMin();
		for(int i = 0; i < 10; i++)
			test2.push(rand.nextInt(10));
		
		while(!test2.isEmpty()){
			NodeWithMin n = test2.pop();
			System.out.println(n.min + " " + n.value);
		}
	}
	
	public static void setOfStacksTests(){
		SetOfStacks<Integer> sS = new SetOfStacks<Integer>(5);
		for(int i = 0; i < 10; i++)
			sS.push(i);
		
		for(int i = 0; i< 10; i++)
			System.out.println(sS.pop());
	}
	
	public static void animalQTests(){
		AnimalQueue aQ = new AnimalQueue();
		
		for(int i = 0; i < 10; i++){
			if(i%2 == 0){
				Dog d = new Dog(Integer.toString(i));
				aQ.enqueue(d);
			}else{
				Cat c = new Cat(Integer.toString(i));
				aQ.enqueue(c);
			}
		}
		
		for(int i = 0; i < 10; i++)
			System.out.println(aQ.dequeueAny().name);
	}
	
	public static void main(String[] args) {
		//queueViaStackTests();
		//sortStackTests();
		//minStackTests();
		//setOfStacksTests();
		//animalQTests();
	}
}
