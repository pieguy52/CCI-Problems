package ch3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks<T> {
	private ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();
	public int capacity;
	
	public SetOfStacks(){
		this.capacity = 10;
	}
	
	public SetOfStacks(int capacity){
		this.capacity = capacity;
	}
	
	public Stack<T> getLastStack(){
		if(stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(T val){
		Stack<T> last = getLastStack();
		if(last != null && last.size() < capacity){
			last.push(val);
		}else{
			System.out.println("Proof a new stack was made");
			Stack<T> stack = new Stack<T>();
			stack.push(val);
			stacks.add(stack);
		}
	}
	
	public T pop(){
		Stack<T> last = getLastStack();
		if(last == null)
			throw new EmptyStackException();
		T val = last.pop();
		if(last.size() == 0)
			stacks.remove(stacks.size() -1);
		return val;
	}
	
}
