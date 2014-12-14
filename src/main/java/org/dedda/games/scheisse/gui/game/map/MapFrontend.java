package org.dedda.games.scheisse.gui.game.map;

import com.jogamp.opengl.util.texture.Texture;
import org.dedda.games.scheisse.gui.Drawable;
import org.dedda.games.scheisse.state.game.map.Map;
import org.dedda.games.scheisse.state.game.map.soil.Soil;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import javax.media.opengl.GLAutoDrawable;
import java.awt.*;

/**
 * Created by dedda on 7/18/14.
 */
public class MapFrontend implements Drawable {

    public static final Dimension fieldSize = new Dimension(150, 150);
    private Point upperLeftLocation;
    private Map map;
    private Point location;
    private Dimension size;
    private MapPanel mapPanel;

    public MapFrontend(final Map map, final MapPanel mapPanel) {
        this.map = map;
        this.mapPanel = mapPanel;
        this.location = mapPanel.getMapFrontendLocation();
        this.size = mapPanel.getMapFrontendSize();
    }

    public MapFrontend(
            final Point upperLeftLocation,
            final Map map,
            final MapPanel mapPanel) {
        this.upperLeftLocation = upperLeftLocation;
        this.map = map;
        this.mapPanel = mapPanel;
        this.location = mapPanel.getMapFrontendLocation();
        this.size = mapPanel.getMapFrontendSize();
    }

    public void render(final Graphics2D g2d) {
        Color backgroundGreen = new Color(0, 90, 0);
        g2d.setColor(backgroundGreen);
        g2d.fillRect(location.x, location.y, size.width, size.height);
        int fieldsX = map.getSize().width;
        int fieldsY = map.getSize().height;
        for (int x = 0; x < fieldsX; x++) {
            for (int y = 0; y < fieldsY; y++) {
                int locX = x * fieldSize.width;
                int locY = y * fieldSize.height;
                Image image = Soil.getImage(map.getSoil()[x][y]);
                g2d.drawImage(image, locX, locY, fieldSize.width, fieldSize.height, mapPanel);
            }
        }
    }

    public void update() {

    }

    public void render(final GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        //Fill Background
        double x = 0;
        double y = 0;
        double maxX = 0;
        double maxY = 0;
        gl.glBegin(GL2GL3.GL_QUADS);
        {
            gl.glColor3f(0, .5f, 0);
            gl.glVertex2d(x, y);
            gl.glVertex2d(maxX, y);
            gl.glVertex2d(maxX, maxY);
            gl.glVertex2d(x, maxY);
        }
        gl.glEnd();
        int fieldsX = map.getSize().width;
        int fieldsY = map.getSize().height;
        gl.glBegin(GL2GL3.GL_QUADS);
        gl.glEnable(GL.GL_TEXTURE_2D);
        for (int cntX = 0; cntX < fieldsX; cntX++) {
            for (int cntY = 0; cntY < fieldsY; cntY++) {
                //gl.glBindTexture(GL.GL_TEXTURE_2D, );
                double texLocX = cntX * (fieldSize.width);
                double texLocY = cntY * fieldSize.height;
                double texMaxX = 0;
                double texMaxY = 0;
                //Image image = Soil.getImage(map.getSoil()[cntX][cntY]);
                Texture texture = Soil.getTexture(map.getSoil()[cntX][cntY]);
                texture.enable(gl);
                texture.bind(gl);
                {
                    gl.glTexCoord2d(0, 0);
                    gl.glVertex2d(texLocX, texLocY);
                    gl.glTexCoord2d(0, 1);
                    gl.glVertex2d(texMaxX, texLocY);

                }
                //texture.disable(gl);
                //g2d.drawImage(image, locX, locY, fieldSize.width, fieldSize.height, mapPanel);
            }
        }
        gl.glEnd();
    }
}
