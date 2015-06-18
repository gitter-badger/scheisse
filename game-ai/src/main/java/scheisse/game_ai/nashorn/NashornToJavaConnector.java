package scheisse.game_ai.nashorn;

/**
 * Created by sgoeppentin on 18.06.15.
 *
 * @author dedda
 */
public class NashornToJavaConnector {

    public Object getProperty(final String metric, final String property) {
        if (metric.equals("utils.test") && property.equals("ping")) {
            return true;
        }
        return null;
    }

}
