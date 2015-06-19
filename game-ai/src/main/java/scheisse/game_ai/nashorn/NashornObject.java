package scheisse.game_ai.nashorn;

import javax.script.ScriptException;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornObject {

    private final NashornClass nashornClass;
    public final String varName;

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
            execute = execute.substring(0, execute.length() - 2);
        }
        execute += ");";
        try {
            nashornClass.getEngine().eval(execute);
            System.out.println("nashorn object " + varName + " instanciated");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public final Object getProperty(final String propertyName) {
        String execute = varName + "." + propertyName + ";";
        return runJS(execute);
    }

    public final void setProperty(final String propertyName, final String value) {
        String execute = varName + "." + propertyName + " = \"" + value + "\";";
        runJS(execute);
    }

    private Object runJS(final String jsLine) {
        try {
            return nashornClass.getEngine().eval(jsLine);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }

}
