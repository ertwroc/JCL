package jcl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public class Property<T> {
	protected T wrapped;

	public Property(T t) {
		this.wrapped = t;
	}

	public <U> Property<U> get(String name, Class<U> clazz) {
		return new Property<U>(getProperty(name, clazz));
	}

	private <U> U getProperty(String name, Class<U> clazz) {
		try {
			Field f = getField(name);
			if (f != null) {
				Object result = f.get(wrapped);
				return clazz.cast(result);
			}
		} catch (IllegalArgumentException e) {
			throw new JCLException(e);
		} catch (IllegalAccessException e) {
			throw new JCLException(e);
		} catch (ClassCastException e) {
			throw new JCLException("Property " + name + " hasn't type "
					+ clazz.getName());
		}

		try {
			Method method = getMethod(name);
			if (method != null) {
				Object result = method.invoke(wrapped);
				return clazz.cast(result);
			}
		} catch (SecurityException e) {
			throw new JCLException(e);
		} catch (IllegalArgumentException e) {
			throw new JCLException(e);
		} catch (IllegalAccessException e) {
			throw new JCLException(e);
		} catch (InvocationTargetException e) {
			throw new JCLException(e);
		} catch (ClassCastException e) {
			throw new JCLException("Property " + name + " hasn't type "
					+ clazz.getName());
		}

		throw new JCLException("Class " + wrapped.getClass().getName()
				+ " don't have accessible property " + name);
	}

	private Method getMethod(String fieldName) {
		try {
			Method method = wrapped.getClass().getMethod(
					"get" + Utils.firstUpper(fieldName));
			return method;
		} catch (SecurityException e) {
			throw new JCLException(e);
		} catch (NoSuchMethodException e) {
			return null;
		}

	}

	private Field getField(String name) {
		try {
			Field f = wrapped.getClass().getField(name);
			return f;
		} catch (NoSuchFieldException e) {
			return null;
		} catch (SecurityException e) {
			throw new JCLException(e);
		}
	}

	public <U> PropertyCollection<U> getCol(String name, Class<U> clazz) {
		Field field = getField(name);
		if(field != null){
			Object o;
			try {
				o = field.get(wrapped);
			} catch (IllegalArgumentException e) {
				throw new JCLException(e);
			} catch (IllegalAccessException e) {
				throw new JCLException(e);
			}
			if(! Collection.class.isInstance(o)){
				throw new JCLException("Property " + name + " isn't collection");
			}
			Type genericType = field.getGenericType();
			if (genericType instanceof ParameterizedType) {
				ParameterizedType aType = (ParameterizedType) genericType;
				Type[] fieldArgTypes = aType.getActualTypeArguments();
				if(fieldArgTypes.length == 1){
					if(clazz.equals(fieldArgTypes[0])){
						return new PropertyCollection<U>((Collection<U>) o);
					}
					throw new JCLException("incompatible types: declared " + clazz.getName() + " and given " + ((Class)fieldArgTypes[0]).getName());
				} else {
					throw new JCLException("Property have to has equal one type param");
				}
			}
		}// /field
		//TODO method
		return null;
	}

	public T getValue() {
		return wrapped;
	}
}
