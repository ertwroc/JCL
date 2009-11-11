package jcl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Property<T> {
	protected T wrapped; 
	public Property(T t) {
		this.wrapped = t;
	}
	public <U> Property<U> get(String name, Class<U> clazz){ 
		try {
			Field f = wrapped.getClass().getField(name);
			Object result = f.get(wrapped);
			return new Property<U>(clazz.cast(result));
		} catch (SecurityException e) {
			throw new JCLException(e);
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
			throw new JCLException(e);
		} catch (IllegalAccessException e) {
			throw new JCLException(e);
		}catch (ClassCastException e) {
			throw new JCLException("Property " + name + " hasn't type " + clazz.getName());
		}
		
		try {
			Method method = wrapped.getClass().getMethod("get" + Utils.firstUpper(name));
			Object result = method.invoke(wrapped);
			return new Property<U>(clazz.cast(result));
		} catch (SecurityException e) {
			throw new JCLException(e);
		} catch (NoSuchMethodException e) {
		} catch (IllegalArgumentException e) {
			throw new JCLException(e);
		} catch (IllegalAccessException e) {
			throw new JCLException(e);
		} catch (InvocationTargetException e) {
			throw new JCLException(e);
		}catch (ClassCastException e) {
			throw new JCLException("Property " + name + " hasn't type " + clazz.getName());
		}
		
		throw new JCLException("Class " + wrapped.getClass().getName() + " don't have accessible property " + name);
	}
	public <U> PropertyCollection<U> getCol(String name, Class<U> clazz){
		return null;
	}
	public T getValue(){
		return wrapped;
	}
}
