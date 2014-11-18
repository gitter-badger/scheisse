package org.dedda.games.scheisse.gui.cpu.inventory;

import javax.swing.JComboBox;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 * Created by dedda on 10/7/14.
 */
public class InventoryActionComboBox extends JComboBox {

    public static final String SELL = "sell";
    public static final String DESTROY = "destroy";

    private ArrayList<String> actions = new ArrayList<String>();

    public InventoryActionComboBox() {
        actions.add(SELL);
        actions.add(DESTROY);
        addItem(SELL);
        addItem(DESTROY);
        Dimension maxSize = getPreferredSize();
        setMaximumSize(maxSize);
    }
}
