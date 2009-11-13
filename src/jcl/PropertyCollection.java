package jcl;

import java.util.Collection;

public class PropertyCollection<U> {
	protected Collection<U> collection;
	public PropertyCollection(Collection<U> collection) {
		this.collection = collection;
	}
	public Collection<U> getCollection() {
		return collection;
	}
	public <T, V> void iterate(Property<T> iterator, Property<V> init, OCLExpr<U, T> expr){
		//wart = init
		//iter po iterator
			//wart += expr(iter)
		// /iter
	}
}
