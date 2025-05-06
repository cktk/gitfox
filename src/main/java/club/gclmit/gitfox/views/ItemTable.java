package club.gclmit.gitfox.views;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.ui.JBColor;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * TODO
 *
 * @author <a href="https://blog.gclmit.club">gclm</a>
 * @since 2022/6/29 13:54
 * @since jdk11
 */
public class ItemTable extends JBTable {
    private static final Logger log = Logger.getInstance(ItemTable.class);

    private static final int NAME_COLUMN = 0;
    private static final int VALUE_COLUMN = 1;
    private final GitfoxServerTableModel foxServerTableModel = new GitfoxServerTableModel();


    /**
     * instantiation AliasTable
     */
    public ItemTable() {
        setModel(foxServerTableModel);
        TableColumn column = getColumnModel().getColumn(NAME_COLUMN);
        TableColumn valueColumn = getColumnModel().getColumn(VALUE_COLUMN);
        column.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
                final Component component =
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                final String macroValue = getGitfoxServerValueAt(row);
                component.setForeground(macroValue.length() == 0 ? JBColor.RED
                    : isSelected ? table.getSelectionForeground() : table.getForeground());
                return component;
            }
        });
        setColumnSize(column, 150, 250, 150);
        setColumnSize(valueColumn, 550, 750, 550);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Set Something ColumnSize
     */
    public static void setColumnSize(TableColumn column, int preferedWidth, int maxWidth, int minWidth) {
        column.setPreferredWidth(preferedWidth);
        column.setMaxWidth(maxWidth);
        column.setMinWidth(minWidth);
    }

    public String getGitfoxServerValueAt(int row) {
        return (String)getValueAt(row, VALUE_COLUMN);
    }

    public void addGitfoxServer() {
        final ItemEditorPanel macroEditor = new ItemEditorPanel("Add Commit Server", "", "");
        if (macroEditor.showAndGet()) {
            final String name = macroEditor.getKey();
            final int index = indexOfGitfoxServerWithName(name);
            log.assertTrue(index >= 0);
            foxServerTableModel.fireTableDataChanged();
            setRowSelectionInterval(index, index);
        }
    }

    private boolean isValidRow(int selectedRow) {
        return true;
    }

    public void moveUp() {
        int selectedRow = getSelectedRow();
        int index1 = selectedRow - 1;

        setRowSelectionInterval(index1, index1);
    }

    public void moveDown() {
        int selectedRow = getSelectedRow();
        int index1 = selectedRow + 1;

        setRowSelectionInterval(index1, index1);
    }

    public void removeSelectedGitfoxServers() {
        final int[] selectedRows = getSelectedRows();
        if (selectedRows.length == 0) {
            return;
        }
        Arrays.sort(selectedRows);
        final int originalRow = selectedRows[0];
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            final int selectedRow = selectedRows[i];
        }
        foxServerTableModel.fireTableDataChanged();
        if (originalRow < getRowCount()) {
            setRowSelectionInterval(originalRow, originalRow);
        } else if (getRowCount() > 0) {
            final int index = getRowCount() - 1;
            setRowSelectionInterval(index, index);
        }
    }



    public void reset() {
        foxServerTableModel.fireTableDataChanged();
    }

    private int indexOfGitfoxServerWithName(String name) {
        return -1;
    }

    public boolean editGitfoxServer() {
        if (getSelectedRowCount() != 1) {
            return false;
        }
        foxServerTableModel.fireTableDataChanged();
        return true;
    }

    // ==========================================================================//

    /**
     * EditValidator
     */
    private static class EditValidator implements ItemEditorPanel.Validator {
        @Override
        public boolean isOk(String name, String value) {
            return !name.isEmpty() && !value.isEmpty();
        }
    }

    /**
     * GitfoxServerTableModel
     */
    private static class GitfoxServerTableModel extends AbstractTableModel {
        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return 0;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            return null;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case NAME_COLUMN:
                    return "Commit Code";
                case VALUE_COLUMN:
                    return "Commit Server";
                default:
                    log.error("Wrong indices");
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }

}
