package org.agalma.views;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class DataTable extends AbstractTableModel {

    String[] columns = {"", "", ""};

    Object[][] data = {
            {"Bob", "Programmer", 19000},
            {"Alice", "Programmer", 19000}
    };

    private TableModelListener listener;

    public DataTable(Object[][] data) {
        this.data = data;
    }

    public DataTable() {
        data = new Object[0][0]; // Initialize with an empty 2D array
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Allow editing for all cells
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex); // Notify listeners about the change
    }

    public void setColumnHeaders(String[] headers) {
        this.columns = headers;
        fireTableStructureChanged(); // Notify the table about the new column headers
    }

    public void setData(Object[][] newData) {
        data = newData;
        fireTableDataChanged();
    }

    public void notifyDataChanged() {
        if (listener != null) {
            TableModelEvent event = new TableModelEvent(this);
            listener.tableChanged(event);
        }
    }
}
