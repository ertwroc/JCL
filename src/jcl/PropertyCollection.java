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
}
