package ch2;

import java.util.LinkedList;
import java.util.Random;

public class Ch2Probs {
	
	public static LinkedList<Integer> partition(LinkedList<Integer> l, int x){
		LinkedList<Integer> smaller = new LinkedList<Integer>();
		LinkedList<Integer> larger = new LinkedList<Integer>();
		for(Integer node: l){
			if(node < x)
				smaller.add(node);
			else
				larger.add(node);
		}
		smaller.addAll(larger);
		return smaller;
	}
	
	private static void partitionTests() {
		Random rand = new Random();
		LinkedList<Integer> test = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++)
			test.add(rand.nextInt(10));
		test = (partition(test, 5));
		for(Integer node: test)
			System.out.println(node);
	}
	
	public static void main(String[] args){
		partitionTests();
	}
}
