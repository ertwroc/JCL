package a;

import java.util.LinkedList;
import java.util.List;

public class A {
	public String b;
	private String c;
	public List<String> d = new LinkedList<String>();
	private List<String> e = new LinkedList<String>();
	
	public A() {
		this.b = "bval";
		this.c = "cval";
	}
	
	public String getC() {
		return c;
	}

	public List<String> getE() {
		return e;
	}
	
}
