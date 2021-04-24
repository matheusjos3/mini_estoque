package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelFornecedor extends AbstractTableModel {

    List<Fornecedor> dados = new ArrayList<>();
    String[] colunas = {"Identificação", "Cnpj", "Nome da empresa", "Início de contrato", "Fim de contrato"};

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
                return dados.get(row).getId_fornecedor();
            case 1:
                return dados.get(row).getCnpj();
            case 2:
                return dados.get(row).getNome();
            case 3:
                return dados.get(row).getInicio_contrato();
            case 4:
                return dados.get(row).getFim_contrato();
        }

        return null;
    }

    public void addRow() {
        ClasseRead cr = new ClasseRead();
        this.dados = cr.readfornecedor();
        this.fireTableDataChanged();
    }
}
