package jcl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JCL {
	private static final Logger logger = Logger.getLogger(JCL.class.getName());
	public static <T, U> U iterate(Collection<T> collection, U u, 
			AccEvaluator<T, U> evaluator){
		U acc = u;
		for(T elem : collection){
			acc = evaluator.eval(elem, acc);
		}
		return acc;
	}
	public static <T> Boolean forAll(Collection<T> collection, 
			Evaluator<T, Boolean> evaluator){
		Boolean result = true;
		for(T elem : collection){
			result = result && evaluator.eval(elem);
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> select(Collection<T> collection,
			Evaluator<T, Boolean> evaluator){
		Collection<T> result;
		try {
			result = collection.getClass().newInstance();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error during creating collection", e);
			result = new ArrayList<T>();
		}
		for(T elem : collection){
			if(evaluator.eval(elem)){
				result.add(elem);
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> reject(Collection<T> collection,
			Evaluator<T, Boolean> evaluator){
		Collection<T> result;
		try {
			result = collection.getClass().newInstance();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error during creating collection", e);
			result = new ArrayList<T>();
		}
		for(T elem : collection){
			if(! evaluator.eval(elem)){
				result.add(elem);
			}
		}
		return result;
	}
	public static <T,U> Collection<U> collect(Collection<T> collection, 
			Evaluator<T, Collection<U>> evaluator){
		//TODO: find equivalent of Bag type
		ArrayList<U> result = new ArrayList<U>();
		for(T elem : collection){
			result.addAll(evaluator.eval(elem));
		}
		return result;
	}
	public static <T> Boolean exist(Collection<T> collection,
			Evaluator<T, Boolean> evaluator){
		Boolean result = false;
		for(T elem : collection){
			result = result || evaluator.eval(elem);
		}
		return result;
	}
}
