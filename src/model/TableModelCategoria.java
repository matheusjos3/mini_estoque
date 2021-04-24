package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCategoria extends AbstractTableModel {

    List<Categoria> dados = new ArrayList<>();
    String[] colunas = {"Identificação", "Nome"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dados.get(row).getId_categoria();
            case 1:
                return dados.get(row).getNome();
        }

        return null;
    }

    public void addRow() {
        ClasseRead r = new ClasseRead();
        this.dados = r.readCategoria();
        this.fireTableDataChanged();
    }
}
