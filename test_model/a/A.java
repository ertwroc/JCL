package a;

import java.util.LinkedList;
import java.util.List;

public class A {
	public B b;
	private C c;
	private List<D> d = new LinkedList<D>();
	
	public A() {}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public List<D> getD() {
		return d;
	}

	public void setD(List<D> d) {
		this.d = d;
	}
	
}
