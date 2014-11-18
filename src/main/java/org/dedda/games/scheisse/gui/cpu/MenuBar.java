package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.state.game.Game;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dedda on 10/5/14.
 */
public class MenuBar extends JMenuBar {

    private Gui gui;
    private Game game;

    public MenuBar(final Gui gui) {
        this.gui = gui;
        this.game = gui.getGame();
        init();
    }

    private void init() {
        setSize(gui.getWidth(), 20);
        setLocation(0, 0);
        //File menu:
        JMenu fileMenu = new JMenu("File");
        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exit(0);
            }
        });
        fileMenu.add(fileExit);
        //Player menu:
        JMenu playerMenu = new JMenu(game.getPlayer().getName());
        JMenuItem playerStats = new JMenuItem("Statistics");
        playerMenu.add(playerStats);
        add(fileMenu);
        add(playerMenu);
    }

    private void exit(final int exitCode) {
        gui.shutDown(exitCode);
    }

}
