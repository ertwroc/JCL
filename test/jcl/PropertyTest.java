package jcl;

import static org.junit.Assert.*;

import org.junit.Test;

import a.A;


public class PropertyTest {
	@Test
	public void getTest(){
		A a = new A();
		Property<A> pA = new Property<A>(a);
		assertEquals(a.b, pA.get("b", String.class).getValue());
		assertEquals(a.getC(), pA.get("c", String.class).getValue());
	}
}
