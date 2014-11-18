package org.dedda.games.scheisse.gui;

import java.awt.Graphics2D;

/**
 * Created by dedda on 4/18/14.
 */
public interface Drawable {

    /**
     *
     * @param g2d Graphics2D - graphics guiElement for drawing
     */
    abstract void render(Graphics2D g2d);

}
