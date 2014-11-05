import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class 计算表达式 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		
		try {
			Double result = (Double)engine.eval("1+20/(4-3)*2");
			System.out.println(result);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Boolean fBoolean = new Boolean(true);
		Boolean.getBoolean("");
	}

}
