package ch3;

import java.util.Stack;

@SuppressWarnings("serial")
public class RedundantHeap extends Stack<NodeWithMin> {

	public void push(int value){
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}
	
	public int min(){
		if(this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return peek().min;
	}
}
