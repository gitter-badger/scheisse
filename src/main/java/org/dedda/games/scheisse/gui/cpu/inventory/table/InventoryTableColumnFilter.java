package org.dedda.games.scheisse.gui.cpu.inventory.table;

/**
 * Created by dedda on 11/18/14.
 */
public class InventoryTableColumnFilter {

    public static final String[] COLUMNS = new String[]{
            "ITEM_NAME",
            "ITEM_VALUE"
    };

    private String[] columns;

    public InventoryTableColumnFilter(String[] columns) {
        this.columns = columns;
    }

    public boolean showColumn(String column) {
        for (String current : columns) {
            if (current.equals(column)) {
                return true;
            }
        }
        return false;
    }

}
