package org.dedda.games.scheisse.state.menu;

import org.dedda.games.scheisse.main.Options;

import java.awt.*;

/**
 * Created by dedda on 5/1/14.
 */
public class MainMenu extends Menu {

    public static final int START_GAME = 1;
    public static final int OPTIONS = 2;
    public static final int EXIT = 3;

    private Graphics2D g2d;
    //private boolean running = false;
    private int selection = 0;

    public MainMenu(Graphics2D g2d) {
        this.g2d = g2d;
    }

    @Override
    public int getSelection() {
        new Thread(this).start();
        //running = true;
        while (selection <= 0) {
            render(g2d);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //selection = EXIT;
        }
        //running = false;
        return selection;
    }

    public void run() {

    }

    public void render(Graphics2D g2d) {
        g2d.setBackground(Color.BLACK);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, Options.getResolution().width, Options.getResolution().height/3);
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(0, Options.getResolution().height/3, Options.getResolution().width, Options.getResolution().height/3);
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 2*Options.getResolution().height/3, Options.getResolution().width, Options.getResolution().height/3);
    }
}
