package org.dedda.games.scheisse.gui.sprite;

import org.dedda.games.scheisse.gui.GuiElement;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by dedda on 7/17/14.
 */
public class Animation extends Sprite {

    protected Image images[];
    protected int currentImageIndex;

    public Animation(
            final Image images[],
            final Point locationOnObject,
            final GuiElement guiElement,
            final ImageObserver imageObserver) {
        super(images[0], locationOnObject, guiElement, imageObserver);
        this.images = images;
        currentImageIndex = 0;
    }

    public Image next() {
        if (currentImageIndex < images.length) {
            currentImageIndex++;
        } else {
            currentImageIndex = 0;
        }
        setCurrentImage();
        return image;
    }

    @Override
    public void scale(final double dx, final double dy) {
        for (int i = 0; i < images.length; i++) {
            Image image = images[i];
            int width = image.getWidth(imageObserver);
            int height = image.getHeight(imageObserver);
            image = image.getScaledInstance((int)(width * dx), (int)(height * dy), Image.SCALE_SMOOTH);
            images[i] = image;
        }
        locationOnObject.x *= dx;
        locationOnObject.y *= dy;
    }

    @Override
    public Animation getScaledInstance(final double dx, final double dy) {
        Animation animation = new Animation(images, locationOnObject, guiElement, imageObserver);
        animation.scale(dx, dy);
        return animation;
    }

    private void setCurrentImage() {
        image = images[currentImageIndex];
    }

}
