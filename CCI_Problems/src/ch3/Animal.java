package ch3;

public class Animal {
	private int order;
	protected String name;
	
	public Animal(String n){
		name = n;
	}
	
	public void setOrder(int o){
		order = o;
	}
	
	public int getOrder(){
		return order;
	}
}
