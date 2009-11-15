package com.github.ertwroc.jcl.translator;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DerValueCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InitValueCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.MessageExpKind;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLDocumentCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;

import com.github.ertwroc.jcl.exception.UnimplementedException;

public class InvariantJava extends CommonJava {

	@Override
	public String generateBooleanLiteralExpCS(BooleanLiteralExpCS context,
			String booleanSymbol, String symbol) {
		throw new UnimplementedException();
	}

	@Override
	public String generateCSTNode() {
		throw new UnimplementedException();

	}

	@Override
	public String generateCallExpCS(CallExpCS context, String source,
			String accessor, String simpleNameCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateClassifierContextDeclCS(
			ClassifierContextDeclCS context, String pathNameCS,
			String invOrDefCS, List<String> constraints) {
		throw new UnimplementedException();

	}

	@Override
	public String generateCollectionLiteralExpCS(
			CollectionLiteralExpCS context, String collectionType,
			List<String> collectionLiteralParts) {
		throw new UnimplementedException();

	}

	@Override
	public String generateCollectionLiteralPartCS(
			CollectionLiteralPartCS context, String expressionCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateCollectionRangeCS(CollectionRangeCS context,
			String lastExpressionCS, String expressionCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateCollectionTypeCS(CollectionTypeCS context,
			String collectionTypeIdentifier, String typeCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateCollectionTypeIdentifierEnum(
			CollectionTypeIdentifierEnum collectionTypeIdentifierEnum) {
		throw new UnimplementedException();

	}

	@Override
	public String generateContextDeclCS(ContextDeclCS context) {
		throw new UnimplementedException();

	}

	@Override
	public String generateDefCS(DefCS context, String defExpressionCS,
			String simpleNameCS, String invOrDefCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateDefExpressionCS(DefExpressionCS context,
			String operationCS, String variableCS, String expressionCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateDerValueCS(DerValueCS context,
			String initOrDerValueCS, String expressionCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateDotOrArrowEnum(DotOrArrowEnum dotOrArrowEnum) {
		switch (dotOrArrowEnum) {
		case ARROW_LITERAL:
			return "->";
		case DOT_LITERAL:
			return ".";
		case NONE_LITERAL:
			return " ";
		}
		return badValue("DotOrArrowEnum");
	}

	@Override
	public String generateEnumLiteralExpCS(EnumLiteralExpCS context,
			String pathNameCS, String simpleNameCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateFeatureCallExpCS(FeatureCallExpCS context,
			List<String> arguments, String isMarkedPreCS, String source,
			String accessor, String simpleNameCS) {
		if (context instanceof OperationCallExpCS
				&& context.getAccessor() != DotOrArrowEnum.NONE_LITERAL) {// obejscie
			// bledu
			// modelu
			return MessageFormat.format("{0}{1}{2}{3}({4})", source, accessor,
					simpleNameCS, isMarkedPreCS, merge(arguments, ", "));
		} else {
			if (arguments.size() == 0) {
				return MessageFormat.format("{0}{1}{2}{3}", source, accessor,
						simpleNameCS, isMarkedPreCS);
			} else {
				if (context.getAccessor() != DotOrArrowEnum.NONE_LITERAL) {
					return MessageFormat.format("{0}{1}{2}{3}[{4}]", source,
							accessor, simpleNameCS, isMarkedPreCS, merge(
									arguments, ", "));
				} else {
					return MessageFormat.format("{0}{1}{2}{3} {4}", source,
							accessor, simpleNameCS, isMarkedPreCS, merge(
									arguments, ", "));
				}
			}
		}

		// return format("<<fc {0}.{1}({2})>>", source, simpleNameCS,
		// merge(arguments, ", "));
	}

	@Override
	public String generateIfExpCS(IfExpCS context, String thenExpression,
			String elseExpression, String condition) {
		throw new UnimplementedException();

	}

	@Override
	public String generateInitOrDerValueCS(InitOrDerValueCS context,
			String initOrDerValueCS, String expressionCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateInitValueCS(InitValueCS context,
			String initOrDerValueCS, String expressionCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateIntegerLiteralExpCS(IntegerLiteralExpCS context,
			String integerSymbol, String symbol) {
		return format("{0}", integerSymbol);
	}

	@Override
	public String generateInvCS(InvCS context, String expressionCS,
			String simpleNameCS, String invOrDefCS) {
		return format("public void inv_{0}()'{'if(!({1})) throw new InvariantException();'}'", simpleNameCS,
				expressionCS);
	}

	@Override
	public String generateInvOrDefCS(InvOrDefCS context, String simpleNameCS,
			String invOrDefCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateInvalidLiteralExpCS(InvalidLiteralExpCS context,
			String symbol) {
		throw new UnimplementedException();

	}

	@Override
	public String generateIsMarkedPreCS(IsMarkedPreCS context, String re) {
		throw new UnimplementedException();

	}

	@Override
	public String generateIterateExpCS(IterateExpCS context, String variable1,
			String variable2, String body, String source, String accessor,
			String simpleNameCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateIteratorExpCS(IteratorExpCS context,
			String variable1, String variable2, String body, String source,
			String accessor, String simpleNameCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateLetExpCS(LetExpCS context, List<String> variables,
			String inExpression) {
		throw new UnimplementedException();

	}

	@Override
	public String generateLiteralExpCS(LiteralExpCS context) {
		throw new UnimplementedException();

	}

	@Override
	public String generateLoopExpCS(LoopExpCS context, String variable1,
			String variable2, String body, String source, String accessor,
			String simpleNameCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateMessageExpCS(MessageExpCS context, String target,
			String kind, String simpleNameCS, List<String> arguments) {
		throw new UnimplementedException();

	}

	@Override
	public String generateMessageExpKind(MessageExpKind messageExpKind) {
		throw new UnimplementedException();

	}

	@Override
	public String generateNullLiteralExpCS(NullLiteralExpCS context,
			String symbol) {
		throw new UnimplementedException();

	}

	@Override
	public String generateOCLDocumentCS(OCLDocumentCS context,
			List<String> packageDeclarations) {
		throw new UnimplementedException();

	}

	@Override
	public String generateOCLExpressionCS(OCLExpressionCS context) {
		throw new UnimplementedException();

	}

	@Override
	public String generateOCLMessageArgCS(OCLMessageArgCS context,
			String typeCS, String expression) {
		throw new UnimplementedException();

	}

	@Override
	public String generateOperationCS(OperationCS context, String pathNameCS,
			String simpleNameCS, List<String> parameters, String typeCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateOperationCallExpCS(OperationCallExpCS context) {
		throw new UnimplementedException();

	}

	@Override
	public String generateOperationContextDeclCS(
			OperationContextDeclCS context, String operationCS,
			List<String> prePostOrBodyDecls) {
		throw new UnimplementedException();

	}

	@Override
	public String generatePackageDeclarationCS(PackageDeclarationCS context,
			String pathNameCS, List<String> contextDecls,
			String packageDeclarationCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generatePathNameCS(PathNameCS context,
			List<String> sequenceOfNames) {
		throw new UnimplementedException();

	}

	@Override
	public String generatePrePostOrBodyDeclCS(PrePostOrBodyDeclCS context,
			String kind, String simpleNameCS, String expressionCS) {
		switch (context.getKind()) {
		case PRE_LITERAL:
			return format("public void pre_{0}()'{'if(!( {1} )) throw new InvariantException();'}'", simpleNameCS, expressionCS);
		default:
			throw new UnimplementedException();
		}
	}

	@Override
	public String generatePrePostOrBodyEnum(PrePostOrBodyEnum prePostOrBodyEnum) {
		switch (prePostOrBodyEnum) {
		case PRE_LITERAL:
			return "pre";
		case BODY_LITERAL:
			return "body";
		case POST_LITERAL:
			return "post";
		}
		return badValue("PrePostOrBodyEnum");
	}

	@Override
	public String generatePrimitiveLiteralExpCS(PrimitiveLiteralExpCS context,
			String symbol) {
		throw new UnimplementedException();

	}

	@Override
	public String generatePrimitiveTypeCS(PrimitiveTypeCS context,
			String value, String type) {
		throw new UnimplementedException();

	}

	@Override
	public String generatePropertyContextCS(PropertyContextCS context,
			String pathNameCS, String simpleNameCS, String typeCS,
			String initOrDerValueCS) {
		throw new UnimplementedException();

	}

	@Override
	public String generateRealLiteralExpCS(RealLiteralExpCS context,
			String realSymbol, String symbol) {
		throw new UnimplementedException();

	}

	@Override
	public String generateSimpleNameCS(SimpleNameCS context, String value,
			String type) {
		if("=".equals(value)) return "==";
		if (context.getType() == SimpleTypeEnum.SELF_LITERAL) {
			return "this";
		}
		return format("{0}", value);
	}

	@Override
	public String generateSimpleTypeEnum(SimpleTypeEnum simpleTypeEnum) {
		switch (simpleTypeEnum) {
		// case SELF_LITERAL://realizowane w generateSimpleNameCS
		// return "this";
		default:
			return simpleTypeEnum.getLiteral();// TODO
		}

	}

	@Override
	public String generateStateExpCS(StateExpCS context,
			List<String> sequenceOfNames) {
		throw new UnimplementedException();

	}

	@Override
	public String generateStringLiteralExpCS(StringLiteralExpCS context,
			String stringSymbol, String unescapedStringSymbol, String symbol) {
		throw new UnimplementedException();

	}

	@Override
	public String generateTupleLiteralExpCS(TupleLiteralExpCS context,
			List<String> variables) {
		throw new UnimplementedException();

	}

	@Override
	public String generateTupleTypeCS(TupleTypeCS context,
			List<String> variables) {
		throw new UnimplementedException();

	}

	@Override
	public String generateTypeCS(TypeCS context) {
		throw new UnimplementedException();

	}

	@Override
	public String generateUnlimitedNaturalLiteralExpCS(
			UnlimitedNaturalLiteralExpCS context, String integerSymbol,
			String symbol) {
		throw new UnimplementedException();

	}

	@Override
	public String generateVariableCS(VariableCS context, String name,
			String typeCS, String initExpression) {
		throw new UnimplementedException();

	}

	@Override
	public String generateVariableExpCS(VariableExpCS context,
			List<String> arguments, String simpleNameCS, String isMarkedPreCS) {
		return format("{0}", simpleNameCS);
	}

	@Override
	public String translateMessageExpKind(MessageExpKind messageExpKind) {
		throw new UnimplementedException();

	}

}
