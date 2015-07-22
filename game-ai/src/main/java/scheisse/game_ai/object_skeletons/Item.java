package scheisse.game_ai.object_skeletons;

import java.awt.*;

/**
 * Created by dedda on 7/22/15.
 *
 * @author dedda
 */
public interface Item {

    long getId();
    long getPrice();
    String getName();
    long getAttack();
    long getArmor();
    Image getSprite();
    void setSprite(Image image);
    long getMaxStackAmount();
    long getMinLevel();
    int getTypes();
    void setTypes(int types);
    boolean isType(int type);

}
