package scheisse.game_ai.nashorn;

/**
 * Created by sgoeppentin on 18.06.15.
 *
 * @author dedda
 */
public class NashornToJavaConnector {

    public final Object getProperty(final String metric, final String property) {
        if (metric.equals("utils.test") && property.equals("ping")) {
            return true;
        }
        return null;
    }

    public final Object push(final String metric, final Object object) {
        return null;
    }

}
