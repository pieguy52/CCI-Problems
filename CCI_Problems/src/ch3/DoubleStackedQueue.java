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
	
	public T dequeue(){
		T head = null;
		while(!lStack.isEmpty())
			rStack.push(lStack.pop());
		head = rStack.pop();
		while(!rStack.isEmpty())
			lStack.push(rStack.pop());
		return head;
	}
	
	public T peek(){
		T head = null;
		while(!lStack.isEmpty())
			rStack.push(lStack.pop());
		head = rStack.peek();
		while(!rStack.isEmpty())
			lStack.push(rStack.pop());
		return head;
	}
}
