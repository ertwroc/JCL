package com.github.ertwroc.jcl.translator;

import java.util.List;

public abstract class CommonJava extends AbstractOclToStringTranslator{
	String merge(List<String> list, String separator) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				buf.append(separator);
			}
			buf.append(list.get(i));
		}
		return buf.toString();
	}

	protected String badValue(String type) {
		throw new RuntimeException(format("Bad value for type {0}", type));
	}
	
	public static String format(String pattern, Object ... arguments) {
		return java.text.MessageFormat.format(pattern, arguments);
	}
}
