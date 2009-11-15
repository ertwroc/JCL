package a;

import java.util.LinkedList;

public class B {
	private B parent;
	private LinkedList<C> c = new LinkedList<C>();
	public B getParent() {
		return parent;
	}
	public void setParent(B parent) {
		this.parent = parent;
	}
	public LinkedList<C> getC() {
		return c;
	}
	public void setC(LinkedList<C> c) {
		this.c = c;
	}
	
	
}	
