package model;

public class ValueCouple<T1, T2> {
	private T1 a;
	private T2 b;
	
	public ValueCouple(T1 v1, T2 v2) {
		this.a = v1;
		this.b = v2;
	}
	
	public T1 getA() {
		return a;
	}
	
	public T2 getB() {
		return b;
	}
}
