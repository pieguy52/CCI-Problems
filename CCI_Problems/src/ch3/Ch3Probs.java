package ch3;

import java.util.Stack;

public class Ch3Probs {

	public static void main(String[] args) {
		DoubleStackedQueue<Integer> redundancey = new DoubleStackedQueue<Integer>();
		
		for(int i = 0; i < 10; i++)
			redundancey.enqueue(i);
		
		for(int i = 0; i < 10; i++)
			System.out.println(redundancey.dequeue());
	}
	
	public static class DoubleStackedQueue<T>{
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
			if(rStack.isEmpty())
				lStack.push(item);
			else if(lStack.isEmpty())
				rStack.push(item);
			return;
		}
		
		public T dequeue(){
			T head = null;
			if(rStack.isEmpty()){
				while(!lStack.isEmpty())
					rStack.push(lStack.pop());
				head = rStack.pop();
			}else if(lStack.isEmpty()){
				while(!rStack.isEmpty())
					lStack.push(rStack.pop());
				head = lStack.pop();
			}else
				return null;
			return head;
		}
		
		public T peek(){
			T head = null;
			if(rStack.isEmpty()){
				while(!lStack.isEmpty())
					rStack.push(lStack.pop());
				head = rStack.peek();
			}else if(lStack.isEmpty()){
				while(!rStack.isEmpty())
					lStack.push(rStack.pop());
				head = lStack.peek();
			}else
				return null;
			return head;
		}
	}

}
