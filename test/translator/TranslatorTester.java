package translator;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import org.junit.Test;

import a.A;

import com.github.ertwroc.jcl.translator.InvariantJava;
import com.github.ertwroc.jcl.translator.OCLTranslator;

public class TranslatorTester {
	static class T{
		public T() {}
		public void test(){
			System.out.println("TEST - OK");
			System.out.println(getClass().getName());
		}
	}
	public static A createModel(){
		A root = new A();
		return root;
	}
	
	@Test
	public void translatorTest() throws Exception{
		String[] ocl = {"inv: 1 + 2 < 3", "--"};
		OCLTranslator translator = new OCLTranslator(new InvariantJava());
		String[] javaCode = new String[ocl.length];
		ClassPool pool = ClassPool.getDefault();
		
		for(int i = 0; i < ocl.length; i++){
			javaCode[i] = translator.translate(ocl[i]);
			CtClass cc = pool.getAndRename(T.class.getName(), T.class.getName()+i);
			CtMethod testMethod = cc.getDeclaredMethod("test");
			System.out.println(javaCode[i]);
			testMethod.setBody("System.out.println(\"Kamilek jest losiem\");");
			Class<?> clazz = cc.toClass();
			Object o = clazz.newInstance();
			o.getClass().getMethod("test").invoke(o);
		}
	}
}
