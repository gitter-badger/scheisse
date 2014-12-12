package org.dedda.games.scheisse.gui.game.map;

import org.dedda.games.scheisse.gui.game.GameGuiComponent;
import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.map.Map;

import javax.media.opengl.GLException;
import java.awt.*;

/**
 * Created by dedda on 7/21/14.
 */
public class MapPanel extends GameGuiComponent {

    private MapFrontend mapFrontend;
    private Map map;
    private Point mapFrontendLocation;
    private Dimension mapFrontendSize;

    public MapPanel(final Game game, final GameWindow gameWindow) {
        super(game, gameWindow);
        this.map = game.getMap();
        relocate();
        resize();
        mapFrontendLocation = new Point(0, 0);
        mapFrontendSize = getSize();
        this.mapFrontend = new MapFrontend(map, this);
        this.gameWindow = gameWindow;
        setBackground(Color.BLACK);
    }

    @Override
    public void relocate() {
        setLocation(gameWindow.getMapLocation());
    }

    @Override
    public void resize() {
        setSize(gameWindow.getMapSize());
    }

    public void update() {
        mapFrontend.update();
    }

    @Override
    public void paintComponent(final Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        mapFrontend.render((Graphics2D)g);
    }

    public MapFrontend getMapFrontend() {
        return mapFrontend;
    }

    public void setMapFrontend(final MapFrontend mapFrontend) {
        this.mapFrontend = mapFrontend;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(final Map map) {
        this.map = map;
    }

    public Point getMapFrontendLocation() {
        return mapFrontendLocation;
    }

    public void setMapFrontendLocation(final Point mapFrontendLocation) {
        this.mapFrontendLocation = mapFrontendLocation;
    }

    public Dimension getMapFrontendSize() {
        return mapFrontendSize;
    }

    public void setMapFrontendSize(final Dimension mapFrontendSize) {
        this.mapFrontendSize = mapFrontendSize;
    }
}
