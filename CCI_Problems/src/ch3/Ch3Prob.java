package ch3;

public class Ch3Prob {

	public static void main(String[] args) {
		DoubleStackedQueue<Integer> redundancey = new DoubleStackedQueue<Integer>();
		
		for(int i = 0; i < 10; i++)
			redundancey.enqueue(i);
		
		for(int i = 0; i < 10; i++)
			System.out.println(redundancey.dequeue());
	}
}
