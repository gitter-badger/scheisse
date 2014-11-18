package org.dedda.games.scheisse.testInstances;

import org.dedda.games.scheisse.gui.game.ArrowSelectable;
import org.dedda.games.scheisse.gui.game.GameGuiComponent;
import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.state.game.Game;

import java.awt.*;

/**
 * Created by dedda on 7/16/14.
 */
public class TestArrowSelectableComponent extends GameGuiComponent implements ArrowSelectable{

    private int up = 0;
    private int down = 0;
    private int left = 0;
    private int right = 0;

    public TestArrowSelectableComponent(Game game, GameWindow gameWindow) {
        super(game, gameWindow);
    }

    @Override
    public void relocate() {

    }

    @Override
    public void resize() {

    }


    @Override
    public void up() {
        up++;
    }

    @Override
    public void left() {
        left++;
    }

    @Override
    public void down() {
        down++;
    }

    @Override
    public void right() {
        right++;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public void paintComponent(Graphics g) {

    }
}
