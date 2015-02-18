package org.dedda.games.scheisse.state;

import java.awt.Graphics2D;

/**
 * Interface for implementing different
 * {@link org.dedda.games.scheisse.state.State}s in the gui.
 *
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public interface State {

    /**
     * Method for rendering everything in this {@link State}.
     *
     * Every {@link State} must implement this method to render objects and
     * images to the canvas. Rendering logic must be implemented in this
     * {@link #render(java.awt.Graphics2D)} or methods calles by
     * {@link #render(java.awt.Graphics2D)}.
     *
     * @param g2d {@link Graphics2D} object to draw on
     */
    void render(final Graphics2D g2d);

}
