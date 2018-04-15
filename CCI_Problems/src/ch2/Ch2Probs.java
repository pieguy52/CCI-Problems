package ch2;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

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
	
	public static void partitionTests() {
		Random rand = new Random();
		LinkedList<Integer> test = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++)
			test.add(rand.nextInt(10));
		test = (partition(test, 5));
		for(Integer node: test)
			System.out.println(node);
	}
	
	public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2){
		LinkedList<Integer> sum = new LinkedList<Integer>();
		int length = (l1.size() < l2.size()) ? l2.size() : l1.size();
		int val1, val2, carryOver = 0;
		for(int i = 0; i < length; i++){
			val1 = (l1.size() > i) ? l1.get(i) : 0;
			val2 = (l2.size() > i) ? l2.get(i) : 0;
			sum.add((val1+val2+carryOver) % 10); 
			carryOver = ((val1+val2+carryOver) >= 10) ? 1 : 0;
		}
		if(carryOver == 1)
			sum.add(carryOver);
		return sum;
	}
	
	public static void sumListsTests(){
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.add(9);
		l2.add(9);
		l2.add(9);
		l2.add(9);
		LinkedList<Integer> sum = sumLists(l1, l2);
		for(Integer s : sum)
			System.out.println(s);
	}
	
	public static boolean palindrome(LinkedList<Object> l){
		Stack<Object> check = new Stack<Object>();
		for(Object o: l){
			if(!check.isEmpty() && o.equals(check.peek()))
				check.pop();
			else
				check.push(o);
		}
		return check.isEmpty();
	}
	
	public static void palindromeTests(){
		LinkedList<Object> test = new LinkedList<Object>();
		test.add('n');
		test.add('o');
		test.add('x');
		test.add('i');
		test.add('n');
		test.add('n');
		test.add('i');
		test.add('x');
		test.add('o');
		test.add('n');
		System.out.println(palindrome(test));
	}
	
	public static void main(String[] args){
		//partitionTests();
		//sumListsTests();
		palindromeTests();
	}
}
