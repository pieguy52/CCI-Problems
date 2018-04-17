package ch2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Ch2Probs {
	
	public static <T> LinkedList<T> removeDuplicates(LinkedList<T> l){
		LinkedList<T> newL = new LinkedList<T>();
		HashSet<T> duplicates = new HashSet<T>();
		
		for(T t: l)
			duplicates.add(t);
		
		for(T t: duplicates)
			newL.add(t);
		
		return newL;
	}
	
	public static void removeDuplicatesTests(){
		LinkedList<Integer> test = new LinkedList<Integer>();
		Random rand = new Random();
		for(int i = 0; i < 10; i++){
			int r = rand.nextInt(10);
			test.add(r);
			test.add(r);
		}
		
		System.out.println("Original list:");
		for(Integer i: test)
			System.out.print(i + "->"); 
		
		test = removeDuplicates(test);
		System.out.println("\nDuplicates removed");
		for(Integer i: test)
			System.out.print(i + "->");
	}
	
	public static <T> LinkedList<T> removeKLast(LinkedList<T> l, int k){
		LinkedList<T> newL = new LinkedList<T>();
		int size = 0;
		for(T t: l)
			size++;
		for(T t: l){
			if(size-k != 0)
				newL.add(t);
			size--;
		}
		return newL;
	}
	
	public static void removeKLastTests(){
		LinkedList<Integer> test = new LinkedList<Integer>();
		int testSize = 10;
		Random rand = new Random();
		int k = rand.nextInt(testSize);
		for(int i = 0; i < testSize; i++)
			test.add(i);
		test = removeKLast(test, k);
		System.out.printf("Removing %dth element from end.\n", k);
		for(Integer i: test)
			System.out.println(i);
	}
	
	public static LinkedList<Integer> partition(LinkedList<Integer> l, int x){
		if(l.isEmpty())
			return l;
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
		int partition = rand.nextInt(10);
		test = (partition(test, partition));
		System.out.println("Partition: " + partition);
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
	
	public static <T> boolean palindrome(LinkedList<T> l){
		Stack<T> check = new Stack<T>();
		for(T t: l){
			if(!check.isEmpty() && t.equals(check.peek()))
				check.pop();
			else
				check.push(t);
		}
		return check.isEmpty();
	}
	
	public static void palindromeTests(){
		LinkedList<Character> test1 = new LinkedList<Character>();
		String s1 = "noxinnixon";
		for(char c : s1.toCharArray())
			test1.add(c);
		System.out.println(palindrome(test1));
		
		LinkedList<Character> test2 = new LinkedList<Character>();
		String s2 = "pieeeip";
		for(char c : s2.toCharArray())
			test2.add(c);
		System.out.println(palindrome(test2));
		
		LinkedList<Character> test3 = new LinkedList<Character>();
		String s3 = "aaaa";
		for(char c : s3.toCharArray())
			test3.add(c);
		System.out.println(palindrome(test3));
	}
	
	public static void main(String[] args){
		//removeDuplicatesTests();
		//removeKLastTests();
		//partitionTests();
		//sumListsTests();
		palindromeTests();
	}
}
