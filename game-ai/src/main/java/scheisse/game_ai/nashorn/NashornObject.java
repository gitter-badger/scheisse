package scheisse.game_ai.nashorn;

import javax.script.ScriptException;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornObject {

    private final NashornClass nashornClass;
    private final String varName;

    public NashornObject(final NashornClass nashornClass, final String varName, final String[] constructorParams) {
        this.nashornClass = nashornClass;
        this.varName = varName;
        instanciate(constructorParams);
    }

    private void instanciate(final String[] constructorParams) {
        String execute = "var " + varName + " = new " + nashornClass.getClassName() + "(";
        if (constructorParams.length > 0) {
            for (int i = 0; i < constructorParams.length; i++) {
                execute += "\"" + constructorParams[i] + "\", ";
            }
            execute = execute.substring(0, execute.length()-2);
        }
        execute += ");";
        try {
            nashornClass.getEngine().eval(execute);
            System.out.println("nashorn object " + varName + " instanciated");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public Object getProperty(String propertyName) {
        String execute = varName + "." + propertyName + ";";
        try {
            return nashornClass.getEngine().eval(execute);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }

}
