package org.dedda.games.scheisse.state.game.object;

import java.awt.geom.Point2D;

/**
 * Created by dedda on 4/18/14.
 */
public class PlayerObject extends GameObject {

    public PlayerObject() {
        super(new Point2D.Double(0, 0), null);

        //GuiPlayer guiPlayer = new GuiPlayer();
    }

    @Override
    public boolean equals(final Object object) {
        throw new UnsupportedOperationException("equals method in player guiElement class not implemented yet.");
    }
}
