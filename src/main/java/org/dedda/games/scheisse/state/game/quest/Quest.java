package org.dedda.games.scheisse.state.game.quest;

import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.level.Level;

import java.util.HashMap;

/**
 * Created by dedda on 5/15/14.
 */
public class Quest {

    public static final int UNTOUCHED = 0;
    public static final int STARTED = 1;
    public static final int FINISHED = 2;

    protected final String name;
    protected final int experience;
    protected final int minLevel;
    protected int progress = UNTOUCHED;
    protected HashMap<String, String> progressData;

    public Quest(String name, int experience, int minLevel){
        this.name = name;
        this.experience = experience;
        this.minLevel = minLevel;
        progressData = new HashMap<String, String>();
    }

    public boolean isAvailable(Player player){
        return Level.getLevel(player.getExperience()) >= minLevel && progress != FINISHED;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

}
