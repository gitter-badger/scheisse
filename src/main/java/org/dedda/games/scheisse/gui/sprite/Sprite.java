package org.dedda.games.scheisse.gui.sprite;

import org.dedda.games.scheisse.gui.Drawable;
import org.dedda.games.scheisse.gui.GuiElement;

import java.awt.*;
import java.awt.image.ImageObserver;

import static java.awt.Image.SCALE_SMOOTH;

/**
 * Created by dedda on 7/17/14.
 */
public class Sprite implements Drawable {

    protected Image image;
    protected Point locationOnObject;
    protected GuiElement guiElement;
    protected ImageObserver imageObserver;

    public Sprite(
            final Image image,
            final Point locationOnObject,
            final GuiElement guiElement,
            final ImageObserver imageObserver) {
        this.image = image;
        this.locationOnObject = locationOnObject;
        this.guiElement = guiElement;
        this.imageObserver = imageObserver;
    }

    public void render(final Graphics2D g2d) {
        int x = guiElement.getLocationOnImage().x + locationOnObject.x;
        int y = guiElement.getLocationOnImage().y + locationOnObject.y;
        g2d.drawImage(image, x, y + locationOnObject.y, imageObserver);
    }

    public void scale(final double dx, final double dy) {
        locationOnObject.x *= dx;
        locationOnObject.y *= dy;
        int width = image.getWidth(imageObserver);
        int height = image.getHeight(imageObserver);
        image = image.getScaledInstance((int)(width * dx), (int)(height * dy), SCALE_SMOOTH);
    }

    public Sprite getScaledInstance(final double dx, final double dy) {
        Sprite sprite = new Sprite(image, locationOnObject, guiElement, imageObserver);
        sprite.scale(dx, dy);
        return sprite;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(final Image image) {
        this.image = image;
    }

    public Point getLocationOnObject() {
        return locationOnObject;
    }

    public void setLocationOnObject(final Point locationOnObject) {
        this.locationOnObject = locationOnObject;
    }

    public GuiElement getGuiElement() {
        return guiElement;
    }

    public void setGuiElement(final GuiElement guiElement) {
        this.guiElement = guiElement;
    }
}
