package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.item.Item;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by dedda on 11/29/14.
 */
public class ItemIconCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        long id = (Long)o;
        Item item = Item.itemForId(id);
        JLabel iconLabel = new JLabel(new ImageIcon(item.getSprite().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
        return iconLabel;
    }

}
