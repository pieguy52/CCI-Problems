package ch3;

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
	
	public static void redundantHeapTests() {
		RedundantHeap redundancey = new RedundantHeap();
		for(int i = 10; i > 0; i--)
			redundancey.push(i);
		while(!redundancey.isEmpty())
			System.out.println(redundancey.pop().value);
	}
	
	public static void SetOfStacksTests(){
		SetOfStacks<Integer> sS = new SetOfStacks<Integer>(5);
		for(int i = 0; i < 10; i++)
			sS.push(i);
		
		for(int i = 0; i< 10; i++)
			System.out.println(sS.pop());
	}
	
	public static void main(String[] args) {
		//queueViaStackTests();
		//sortStackTests();
		//redundantHeapTests();
		SetOfStacksTests();
	}
}
