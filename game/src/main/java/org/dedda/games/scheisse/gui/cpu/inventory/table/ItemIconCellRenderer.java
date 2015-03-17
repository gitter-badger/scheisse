package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.item.Item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Image;

/**
 * Created by dedda on 11/29/14.
 */
public class ItemIconCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(
            final JTable jTable,
            final Object o,
            final boolean b,
            final boolean b1,
            final int i,
            final int i1) {
        long id = (Long) o;
        Item item = Item.forId(id);
        Image scaledSprite =
                item.getSprite().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(scaledSprite));
        return iconLabel;
    }

}
