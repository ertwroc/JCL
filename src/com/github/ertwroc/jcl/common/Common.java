package com.github.ertwroc.jcl.common;

import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;

public class Common {
	public static final UMLEnvironmentFactory umlFactory = new UMLEnvironmentFactory();
	public static final UMLEnvironment uml = umlFactory.createEnvironment();
}
