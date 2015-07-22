package scheisse.game_ai.object_skeletons;

/**
 * Created by dedda on 7/22/15.
 *
 * @author dedda
 */
public interface User {

    long getId();
    String getName();
    String getEmail();
    long getExperience();
    void setName(String name);
    void setEmail(String email);
    void setExperience(long experience);
    Inventory getInventory();

}
