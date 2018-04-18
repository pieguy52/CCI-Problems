package ch3;

import java.util.Stack;

public class DoubleStackedQueue<T> {
	private Stack<T> rStack;
	private Stack<T> lStack;
	T data;
	
	public DoubleStackedQueue(){
		rStack = new Stack<T>();
		lStack = new Stack<T>();
	}
	
	public DoubleStackedQueue(T data){
		this.data = data;
		rStack = new Stack<T>();
		lStack = new Stack<T>();
	}
	
	public void enqueue(T item){
		lStack.push(item);
		return;
	}
	
	private void shiftQsRight(){
		while(!lStack.isEmpty())
			rStack.push(lStack.pop());
	}
	
	private void shiftQsLeft(){
		while(!rStack.isEmpty())
			lStack.push(rStack.pop());
	}
	
	public T dequeue(){
		T head = null;
		shiftQsRight();
		head = rStack.pop();
		shiftQsLeft();
		return head;
	}
	
	public T peek(){
		T head = null;
		shiftQsRight();
		head = rStack.peek();
		shiftQsLeft();
		return head;
	}
}
