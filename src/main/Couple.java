package main;

public class Couple<T1, T2> {
	private T1 v1;
	private T2 v2;
	
	public Couple(T1 v1, T2 v2){
		this.v1 = v1;
		this.v2 = v2;
	}

	public T1 getV1() {
		return v1;
	}

	public void setV1(T1 v1) {
		this.v1 = v1;
	}

	public T2 getV2() {
		return v2;
	}

	public void setV2(T2 v2) {
		this.v2 = v2;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Couple))
			return false;
		
		Couple c = (Couple) o;
		
		if(!c.getV1().equals(this.v1) || !c.getV2().equals(this.v2))
			return false;
		
		return true;
	}
	
	@Override
	public String toString(){
		return "v1 = " + this.v1 + "; v2 = " + this.v2 + ";";
	}
}
