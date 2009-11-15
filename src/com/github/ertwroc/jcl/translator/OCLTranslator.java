package com.github.ertwroc.jcl.translator;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.parser.OCLProblemHandler;

import com.github.ertwroc.jcl.common.Common;
import com.github.ertwroc.jcl.common.UmlOclAnalyzer;
import com.github.ertwroc.jcl.exception.ParseException;

/**
 * Class transforming ocl expression to text using given translator
 * @author ert
 *
 */
public class OCLTranslator {
	
	protected AbstractOclToStringTranslator translator;
	
	public OCLTranslator(AbstractOclToStringTranslator translator) {
		this.translator = translator;
	}
	/**
	 * Translate ocl expression to text
	 * @param ocl expression in ocl
	 * @return result of transformation
	 */
	public String translate(String ocl){
		UmlOclAnalyzer analyzer = new UmlOclAnalyzer(Common.uml, ocl);
		CSTNode node = analyzer.parseConcreteSyntax();
		OCLProblemHandler ph = (OCLProblemHandler)Common.uml.getProblemHandler();
		if(ph.getDiagnostic() != null){
			throw new ParseException(ph.getDiagnostic().toString());
		}
		return translator.translateCSTNode(node);
	}
}
