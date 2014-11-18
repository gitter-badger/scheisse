package org.dedda.games.scheisse.state.menu;

import org.dedda.games.scheisse.state.State;

/**
 * Created by dedda on 4/19/14.
 */
public abstract class Menu implements State, Runnable {

    protected boolean running = false;

    public abstract int getSelection();

    public boolean isRunning() {
        return running;
    }
}
