package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelProduto extends AbstractTableModel {

    List<Produto> dados = new ArrayList<>();
    String[] colunas = {"Identificação", "Código", "Descrição", "Preço", "Quantidade", "Data Entrada"};

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
                return dados.get(row).getId_produto();
            case 1:
                return dados.get(row).getCodigo();
            case 2:
                return dados.get(row).getDescricao();
            case 3:
                return dados.get(row).getPreco();
            case 4:
                return dados.get(row).getQuantidade();
            case 5:
                return dados.get(row).getDataEntrada();
        }

        return null;
    }

    /*
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                dados.get(rowIndex).setCodigo((String) aValue);
                break;
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setPreco(Double.parseDouble((String) aValue));
                break;
            case 3:
                dados.get(rowIndex).setMarca((String) aValue);
                break;
            case 4:
                dados.get(rowIndex).setFabricante((String) aValue);
                break;
            case 5:
                dados.get(rowIndex).setQuantidade(Integer.parseInt((String) aValue));
                break;
        }
        
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
     */
    public void addRow() {
        ClasseRead r = new ClasseRead();
        this.dados = r.readProduto();
        this.fireTableDataChanged();
    }

    public void addSearchRow(String termo) {
        ClasseRead s = new ClasseRead();
        this.dados = s.searchProduto(termo);
        this.fireTableDataChanged();
    }

    public void addFornecedorRow(int id) {
        ClasseRead r = new ClasseRead();
        this.dados = r.readFornecedor(id);
        this.fireTableDataChanged();
    }

    public void addPrecoRow(String metodo) {
        ClasseRead r = new ClasseRead();
        this.dados = r.readPreco(metodo);
        this.fireTableDataChanged();
    }

    public void addCategoriaRow(int id) {
        ClasseRead r = new ClasseRead();
        this.dados = r.readProdutoPorID(id);
        this.fireTableDataChanged();
    }

    public void addRowPorTempo(String metodo) {
        ClasseRead cr = new ClasseRead();
        this.dados = cr.readPorTempo(metodo);
        this.fireTableDataChanged();
    }
}
