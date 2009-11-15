package com.github.ertwroc.jcl.translator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.*;

public abstract class AbstractOclToStringTranslator implements IOclToStringTranslator {

	public String translateBooleanLiteralExpCS(BooleanLiteralExpCS node){
		if(node == null){
			return null;
		}
		String booleanSymbolString = translateBoolean(node.getBooleanSymbol());
		String symbolString = translateString(node.getSymbol());
		
		return generateBooleanLiteralExpCS(node, booleanSymbolString, symbolString);
	}

	public String translateCallExpCS(CallExpCS node){
		if(node == null){
			return null;
		}
		if(node instanceof FeatureCallExpCS){
			return translateFeatureCallExpCS((FeatureCallExpCS) node);
		}
		if(node instanceof LoopExpCS){
			return translateLoopExpCS((LoopExpCS) node);
		}
		String sourceString = translateOCLExpressionCS(node.getSource());
		String accessorString = generateDotOrArrowEnum(node.getAccessor());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		
		return generateCallExpCS(node, sourceString, accessorString, simpleNameCSString);
	}

	public String translateClassifierContextDeclCS(ClassifierContextDeclCS node){
		if(node == null){
			return null;
		}
		String pathNameCSString = translatePathNameCS(node.getPathNameCS());
		String invOrDefCSString = translateInvOrDefCS(node.getInvOrDefCS());
		List<String> constraintsString = translateList(node.getConstraints());
		
		return generateClassifierContextDeclCS(node, pathNameCSString, invOrDefCSString, constraintsString);
	}

	public String translateCollectionLiteralExpCS(CollectionLiteralExpCS node){
		if(node == null){
			return null;
		}
		String collectionTypeString = generateCollectionTypeIdentifierEnum(node.getCollectionType());
		List<String> collectionLiteralPartsString = translateList(node.getCollectionLiteralParts());
		
		return generateCollectionLiteralExpCS(node, collectionTypeString, collectionLiteralPartsString);
	}

	public String translateCollectionLiteralPartCS(CollectionLiteralPartCS node){
		if(node == null){
			return null;
		}
		if(node instanceof CollectionRangeCS){
			return translateCollectionRangeCS((CollectionRangeCS) node);
		}
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generateCollectionLiteralPartCS(node, expressionCSString);
	}

	public String translateCollectionRangeCS(CollectionRangeCS node){
		if(node == null){
			return null;
		}
		String lastExpressionCSString = translateOCLExpressionCS(node.getLastExpressionCS());
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generateCollectionRangeCS(node, lastExpressionCSString, expressionCSString);
	}

	public String translateCollectionTypeCS(CollectionTypeCS node){
		if(node == null){
			return null;
		}
		String collectionTypeIdentifierString = generateCollectionTypeIdentifierEnum(node.getCollectionTypeIdentifier());
		String typeCSString = translateTypeCS(node.getTypeCS());
		
		return generateCollectionTypeCS(node, collectionTypeIdentifierString, typeCSString);
	}

	public String translateContextDeclCS(ContextDeclCS node){
		if(node == null){
			return null;
		}
		if(node instanceof ClassifierContextDeclCS){
			return translateClassifierContextDeclCS((ClassifierContextDeclCS) node);
		}
		if(node instanceof OperationContextDeclCS){
			return translateOperationContextDeclCS((OperationContextDeclCS) node);
		}
		if(node instanceof PropertyContextCS){
			return translatePropertyContextCS((PropertyContextCS) node);
		}
		
		
		return generateContextDeclCS(node);
	}

	public String translateCSTNode(CSTNode node){
		if(node == null){
			return null;
		}
		if(node instanceof CollectionLiteralPartCS){
			return translateCollectionLiteralPartCS((CollectionLiteralPartCS) node);
		}
		if(node instanceof ContextDeclCS){
			return translateContextDeclCS((ContextDeclCS) node);
		}
		if(node instanceof DefExpressionCS){
			return translateDefExpressionCS((DefExpressionCS) node);
		}
		if(node instanceof InitOrDerValueCS){
			return translateInitOrDerValueCS((InitOrDerValueCS) node);
		}
		if(node instanceof InvOrDefCS){
			return translateInvOrDefCS((InvOrDefCS) node);
		}
		if(node instanceof IsMarkedPreCS){
			return translateIsMarkedPreCS((IsMarkedPreCS) node);
		}
		if(node instanceof OCLDocumentCS){
			return translateOCLDocumentCS((OCLDocumentCS) node);
		}
		if(node instanceof OCLExpressionCS){
			return translateOCLExpressionCS((OCLExpressionCS) node);
		}
		if(node instanceof OCLMessageArgCS){
			return translateOCLMessageArgCS((OCLMessageArgCS) node);
		}
		if(node instanceof OperationCS){
			return translateOperationCS((OperationCS) node);
		}
		if(node instanceof PackageDeclarationCS){
			return translatePackageDeclarationCS((PackageDeclarationCS) node);
		}
		if(node instanceof PrePostOrBodyDeclCS){
			return translatePrePostOrBodyDeclCS((PrePostOrBodyDeclCS) node);
		}
		if(node instanceof VariableCS){
			return translateVariableCS((VariableCS) node);
		}
		throw new RuntimeException();
	}

	public String translateDefCS(DefCS node){
		if(node == null){
			return null;
		}
		String defExpressionCSString = translateDefExpressionCS(node.getDefExpressionCS());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		String invOrDefCSString = translateInvOrDefCS(node.getInvOrDefCS());
		
		return generateDefCS(node, defExpressionCSString, simpleNameCSString, invOrDefCSString);
	}

	public String translateDefExpressionCS(DefExpressionCS node){
		if(node == null){
			return null;
		}
		String operationCSString = translateOperationCS(node.getOperationCS());
		String variableCSString = translateVariableCS(node.getVariableCS());
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generateDefExpressionCS(node, operationCSString, variableCSString, expressionCSString);
	}

	public String translateDerValueCS(DerValueCS node){
		if(node == null){
			return null;
		}
		String initOrDerValueCSString = translateInitOrDerValueCS(node.getInitOrDerValueCS());
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generateDerValueCS(node, initOrDerValueCSString, expressionCSString);
	}

	public String translateEnumLiteralExpCS(EnumLiteralExpCS node){
		if(node == null){
			return null;
		}
		String pathNameCSString = translatePathNameCS(node.getPathNameCS());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		
		return generateEnumLiteralExpCS(node, pathNameCSString, simpleNameCSString);
	}

	public String translateFeatureCallExpCS(FeatureCallExpCS node){
		if(node == null){
			return null;
		}
		List<String> argumentsString = translateList(node.getArguments());
		String isMarkedPreCSString = translateIsMarkedPreCS(node.getIsMarkedPreCS());
		String sourceString = translateOCLExpressionCS(node.getSource());
		String accessorString = generateDotOrArrowEnum(node.getAccessor());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		
		return generateFeatureCallExpCS(node, argumentsString, isMarkedPreCSString, sourceString, accessorString, simpleNameCSString);
	}

	public String translateIfExpCS(IfExpCS node){
		if(node == null){
			return null;
		}
		String thenExpressionString = translateOCLExpressionCS(node.getThenExpression());
		String elseExpressionString = translateOCLExpressionCS(node.getElseExpression());
		String conditionString = translateOCLExpressionCS(node.getCondition());
		
		return generateIfExpCS(node, thenExpressionString, elseExpressionString, conditionString);
	}

	public String translateInitOrDerValueCS(InitOrDerValueCS node){
		if(node == null){
			return null;
		}
		if(node instanceof DerValueCS){
			return translateDerValueCS((DerValueCS) node);
		}
		if(node instanceof InitValueCS){
			return translateInitValueCS((InitValueCS) node);
		}
		String initOrDerValueCSString = translateInitOrDerValueCS(node.getInitOrDerValueCS());
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generateInitOrDerValueCS(node, initOrDerValueCSString, expressionCSString);
	}

	public String translateInitValueCS(InitValueCS node){
		if(node == null){
			return null;
		}
		String initOrDerValueCSString = translateInitOrDerValueCS(node.getInitOrDerValueCS());
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generateInitValueCS(node, initOrDerValueCSString, expressionCSString);
	}

	public String translateIntegerLiteralExpCS(IntegerLiteralExpCS node){
		if(node == null){
			return null;
		}
		String integerSymbolString = translateInteger(node.getIntegerSymbol());
		String symbolString = translateString(node.getSymbol());
		
		return generateIntegerLiteralExpCS(node, integerSymbolString, symbolString);
	}

	public String translateInvalidLiteralExpCS(InvalidLiteralExpCS node){
		if(node == null){
			return null;
		}
		String symbolString = translateString(node.getSymbol());
		
		return generateInvalidLiteralExpCS(node, symbolString);
	}

	public String translateInvCS(InvCS node){
		if(node == null){
			return null;
		}
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		String invOrDefCSString = translateInvOrDefCS(node.getInvOrDefCS());
		
		return generateInvCS(node, expressionCSString, simpleNameCSString, invOrDefCSString);
	}

	public String translateInvOrDefCS(InvOrDefCS node){
		if(node == null){
			return null;
		}
		if(node instanceof DefCS){
			return translateDefCS((DefCS) node);
		}
		if(node instanceof InvCS){
			return translateInvCS((InvCS) node);
		}
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		String invOrDefCSString = translateInvOrDefCS(node.getInvOrDefCS());
		
		return generateInvOrDefCS(node, simpleNameCSString, invOrDefCSString);
	}

	public String translateIsMarkedPreCS(IsMarkedPreCS node){
		if(node == null){
			return "";
		}
		String reString = translateBoolean(node.isPre());
		
		return generateIsMarkedPreCS(node, reString);
	}

	public String translateIterateExpCS(IterateExpCS node){
		if(node == null){
			return null;
		}
		String variable1String = translateVariableCS(node.getVariable1());
		String variable2String = translateVariableCS(node.getVariable2());
		String bodyString = translateOCLExpressionCS(node.getBody());
		String sourceString = translateOCLExpressionCS(node.getSource());
		String accessorString = generateDotOrArrowEnum(node.getAccessor());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		
		return generateIterateExpCS(node, variable1String, variable2String, bodyString, sourceString, accessorString, simpleNameCSString);
	}

	public String translateIteratorExpCS(IteratorExpCS node){
		if(node == null){
			return null;
		}
		String variable1String = translateVariableCS(node.getVariable1());
		String variable2String = translateVariableCS(node.getVariable2());
		String bodyString = translateOCLExpressionCS(node.getBody());
		String sourceString = translateOCLExpressionCS(node.getSource());
		String accessorString = generateDotOrArrowEnum(node.getAccessor());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		
		return generateIteratorExpCS(node, variable1String, variable2String, bodyString, sourceString, accessorString, simpleNameCSString);
	}

	public String translateLetExpCS(LetExpCS node){
		if(node == null){
			return null;
		}
		List<String> variablesString = translateList(node.getVariables());
		String inExpressionString = translateOCLExpressionCS(node.getInExpression());
		
		return generateLetExpCS(node, variablesString, inExpressionString);
	}

	public String translateLiteralExpCS(LiteralExpCS node){
		if(node == null){
			return null;
		}
		if(node instanceof CollectionLiteralExpCS){
			return translateCollectionLiteralExpCS((CollectionLiteralExpCS) node);
		}
		if(node instanceof EnumLiteralExpCS){
			return translateEnumLiteralExpCS((EnumLiteralExpCS) node);
		}
		if(node instanceof InvalidLiteralExpCS){
			return translateInvalidLiteralExpCS((InvalidLiteralExpCS) node);
		}
		if(node instanceof NullLiteralExpCS){
			return translateNullLiteralExpCS((NullLiteralExpCS) node);
		}
		if(node instanceof PrimitiveLiteralExpCS){
			return translatePrimitiveLiteralExpCS((PrimitiveLiteralExpCS) node);
		}
		if(node instanceof TupleLiteralExpCS){
			return translateTupleLiteralExpCS((TupleLiteralExpCS) node);
		}
		
		
		return generateLiteralExpCS(node);
	}

	public String translateLoopExpCS(LoopExpCS node){
		if(node == null){
			return null;
		}
		if(node instanceof IterateExpCS){
			return translateIterateExpCS((IterateExpCS) node);
		}
		if(node instanceof IteratorExpCS){
			return translateIteratorExpCS((IteratorExpCS) node);
		}
		String variable1String = translateVariableCS(node.getVariable1());
		String variable2String = translateVariableCS(node.getVariable2());
		String bodyString = translateOCLExpressionCS(node.getBody());
		String sourceString = translateOCLExpressionCS(node.getSource());
		String accessorString = generateDotOrArrowEnum(node.getAccessor());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		
		return generateLoopExpCS(node, variable1String, variable2String, bodyString, sourceString, accessorString, simpleNameCSString);
	}

	public String translateMessageExpCS(MessageExpCS node){
		if(node == null){
			return null;
		}
		String targetString = translateOCLExpressionCS(node.getTarget());
		String kindString = generateMessageExpKind(node.getKind());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		List<String> argumentsString = translateList(node.getArguments());
		
		return generateMessageExpCS(node, targetString, kindString, simpleNameCSString, argumentsString);
	}

	public String translateNullLiteralExpCS(NullLiteralExpCS node){
		if(node == null){
			return null;
		}
		String symbolString = translateString(node.getSymbol());
		
		return generateNullLiteralExpCS(node, symbolString);
	}

	public String translateOCLDocumentCS(OCLDocumentCS node){
		if(node == null){
			return null;
		}
		List<String> packageDeclarationsString = translateList(node.getPackageDeclarations());
		
		return generateOCLDocumentCS(node, packageDeclarationsString);
	}

	public String translateOCLExpressionCS(OCLExpressionCS node){
		if(node == null){
			return null;
		}
		if(node instanceof CallExpCS){
			return translateCallExpCS((CallExpCS) node);
		}
		if(node instanceof IfExpCS){
			return translateIfExpCS((IfExpCS) node);
		}
		if(node instanceof LetExpCS){
			return translateLetExpCS((LetExpCS) node);
		}
		if(node instanceof LiteralExpCS){
			return translateLiteralExpCS((LiteralExpCS) node);
		}
		if(node instanceof MessageExpCS){
			return translateMessageExpCS((MessageExpCS) node);
		}
		if(node instanceof SimpleNameCS){
			return translateSimpleNameCS((SimpleNameCS) node);
		}
		if(node instanceof TypeCS){
			return translateTypeCS((TypeCS) node);
		}
		if(node instanceof VariableExpCS){
			return translateVariableExpCS((VariableExpCS) node);
		}
		
		
		return generateOCLExpressionCS(node);
	}

	public String translateOCLMessageArgCS(OCLMessageArgCS node){
		if(node == null){
			return null;
		}
		String typeCSString = translateTypeCS(node.getTypeCS());
		String expressionString = translateOCLExpressionCS(node.getExpression());
		
		return generateOCLMessageArgCS(node, typeCSString, expressionString);
	}

	public String translateOperationCallExpCS(OperationCallExpCS node){
		if(node == null){
			return null;
		}
		
		
		return generateOperationCallExpCS(node);
	}

	public String translateOperationContextDeclCS(OperationContextDeclCS node){
		if(node == null){
			return null;
		}
		String operationCSString = translateOperationCS(node.getOperationCS());
		List<String> prePostOrBodyDeclsString = translateList(node.getPrePostOrBodyDecls());
		
		return generateOperationContextDeclCS(node, operationCSString, prePostOrBodyDeclsString);
	}

	public String translateOperationCS(OperationCS node){
		if(node == null){
			return null;
		}
		String pathNameCSString = translatePathNameCS(node.getPathNameCS());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		List<String> parametersString = translateList(node.getParameters());
		String typeCSString = translateTypeCS(node.getTypeCS());
		
		return generateOperationCS(node, pathNameCSString, simpleNameCSString, parametersString, typeCSString);
	}

	public String translatePackageDeclarationCS(PackageDeclarationCS node){
		if(node == null){
			return null;
		}
		String pathNameCSString = translatePathNameCS(node.getPathNameCS());
		List<String> contextDeclsString = translateList(node.getContextDecls());
		String packageDeclarationCSString = translatePackageDeclarationCS(node.getPackageDeclarationCS());
		
		return generatePackageDeclarationCS(node, pathNameCSString, contextDeclsString, packageDeclarationCSString);
	}

	public String translatePathNameCS(PathNameCS node){
		if(node == null){
			return null;
		}
		List<String> sequenceOfNamesString = translateList(node.getSequenceOfNames());
		
		return generatePathNameCS(node, sequenceOfNamesString);
	}

	public String translatePrePostOrBodyDeclCS(PrePostOrBodyDeclCS node){
		if(node == null){
			return null;
		}
		String kindString = generatePrePostOrBodyEnum(node.getKind());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		String expressionCSString = translateOCLExpressionCS(node.getExpressionCS());
		
		return generatePrePostOrBodyDeclCS(node, kindString, simpleNameCSString, expressionCSString);
	}

	public String translatePrimitiveLiteralExpCS(PrimitiveLiteralExpCS node){
		if(node == null){
			return null;
		}
		if(node instanceof BooleanLiteralExpCS){
			return translateBooleanLiteralExpCS((BooleanLiteralExpCS) node);
		}
		if(node instanceof IntegerLiteralExpCS){
			return translateIntegerLiteralExpCS((IntegerLiteralExpCS) node);
		}
		if(node instanceof RealLiteralExpCS){
			return translateRealLiteralExpCS((RealLiteralExpCS) node);
		}
		if(node instanceof StringLiteralExpCS){
			return translateStringLiteralExpCS((StringLiteralExpCS) node);
		}
		if(node instanceof UnlimitedNaturalLiteralExpCS){
			return translateUnlimitedNaturalLiteralExpCS((UnlimitedNaturalLiteralExpCS) node);
		}
		String symbolString = translateString(node.getSymbol());
		
		return generatePrimitiveLiteralExpCS(node, symbolString);
	}

	public String translatePrimitiveTypeCS(PrimitiveTypeCS node){
		if(node == null){
			return null;
		}
		String valueString = translateString(node.getValue());
		String typeString = generateSimpleTypeEnum(node.getType());
		
		return generatePrimitiveTypeCS(node, valueString, typeString);
	}

	public String translatePropertyContextCS(PropertyContextCS node){
		if(node == null){
			return null;
		}
		String pathNameCSString = translatePathNameCS(node.getPathNameCS());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		String typeCSString = translateTypeCS(node.getTypeCS());
		String initOrDerValueCSString = translateInitOrDerValueCS(node.getInitOrDerValueCS());
		
		return generatePropertyContextCS(node, pathNameCSString, simpleNameCSString, typeCSString, initOrDerValueCSString);
	}

	public String translateRealLiteralExpCS(RealLiteralExpCS node){
		if(node == null){
			return null;
		}
		String realSymbolString = translateDouble(node.getRealSymbol());
		String symbolString = translateString(node.getSymbol());
		
		return generateRealLiteralExpCS(node, realSymbolString, symbolString);
	}

	public String translateSimpleNameCS(SimpleNameCS node){
		if(node == null){
			return null;
		}
		if(node instanceof PrimitiveTypeCS){
			return translatePrimitiveTypeCS((PrimitiveTypeCS) node);
		}
		String valueString = translateString(node.getValue());
		String typeString = generateSimpleTypeEnum(node.getType());
		
		return generateSimpleNameCS(node, valueString, typeString);
	}

	public String translateStateExpCS(StateExpCS node){
		if(node == null){
			return null;
		}
		List<String> sequenceOfNamesString = translateList(node.getSequenceOfNames());
		
		return generateStateExpCS(node, sequenceOfNamesString);
	}

	public String translateStringLiteralExpCS(StringLiteralExpCS node){
		if(node == null){
			return null;
		}
		String stringSymbolString = translateString(node.getStringSymbol());
		String unescapedStringSymbolString = translateString(node.getUnescapedStringSymbol());
		String symbolString = translateString(node.getSymbol());
		
		return generateStringLiteralExpCS(node, stringSymbolString, unescapedStringSymbolString, symbolString);
	}

	public String translateTupleLiteralExpCS(TupleLiteralExpCS node){
		if(node == null){
			return null;
		}
		List<String> variablesString = translateList(node.getVariables());
		
		return generateTupleLiteralExpCS(node, variablesString);
	}

	public String translateTupleTypeCS(TupleTypeCS node){
		if(node == null){
			return null;
		}
		List<String> variablesString = translateList(node.getVariables());
		
		return generateTupleTypeCS(node, variablesString);
	}

	public String translateTypeCS(TypeCS node){
		if(node == null){
			return null;
		}
		if(node instanceof CollectionTypeCS){
			return translateCollectionTypeCS((CollectionTypeCS) node);
		}
		if(node instanceof PathNameCS){
			return translatePathNameCS((PathNameCS) node);
		}
		if(node instanceof PrimitiveTypeCS){
			return translatePrimitiveTypeCS((PrimitiveTypeCS) node);
		}
		if(node instanceof StateExpCS){
			return translateStateExpCS((StateExpCS) node);
		}
		if(node instanceof TupleTypeCS){
			return translateTupleTypeCS((TupleTypeCS) node);
		}
		
		
		return generateTypeCS(node);
	}

	public String translateUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS node){
		if(node == null){
			return null;
		}
		String integerSymbolString = translateInteger(node.getIntegerSymbol());
		String symbolString = translateString(node.getSymbol());
		
		return generateUnlimitedNaturalLiteralExpCS(node, integerSymbolString, symbolString);
	}

	public String translateVariableCS(VariableCS node){
		if(node == null){
			return null;
		}
		String nameString = translateString(node.getName());
		String typeCSString = translateTypeCS(node.getTypeCS());
		String initExpressionString = translateOCLExpressionCS(node.getInitExpression());
		
		return generateVariableCS(node, nameString, typeCSString, initExpressionString);
	}

	public String translateVariableExpCS(VariableExpCS node){
		if(node == null){
			return null;
		}
		List<String> argumentsString = translateList(node.getArguments());
		String simpleNameCSString = translateSimpleNameCS(node.getSimpleNameCS());
		String isMarkedPreCSString = translateIsMarkedPreCS(node.getIsMarkedPreCS());
		
		return generateVariableExpCS(node, argumentsString, simpleNameCSString, isMarkedPreCSString);
	}

	public String translateBoolean(Boolean b){
		return b.toString();
	}
	public String translateInteger(Integer i){
		return i.toString();
	}
	public String translateDouble(Double d){
		return d.toString();
	}
	public String translateString(String s){
		return s;
	}
	public <T extends List<? extends CSTNode>> List<String> translateList(T list){
		List<String> result = new ArrayList<String>();
		for(CSTNode node : list){
			result.add(translateCSTNode(node));
		}
		return result;
	}
	public List<String> translateList(EList<String> list){
		return list;
	}
}