package model;

import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClasseInsert {

    private String INSERT_CATEGORIA = "INSERT INTO tb_categoria (nome) VALUES(?);";
    private String INSERT_FORNECEDOR = "INSERT INTO tb_fornecedor (cnpj,nome_empresa,inicio_contrato,fim_contrato) VALUES(?, ?, ?, ?);";
    private String INSERT_PRODUTO = "INSERT INTO tb_produto (codigo,descricao,preco,quantidade,data_entrada,id_categoria,id_fornecedor) VALUES(?,?,?,?,now(),?,?);";
    
    public void createProduto(Produto p) {

        try {
            Connection connection = new ConectaDB().Conectar();

            PreparedStatement ps = connection.prepareStatement(INSERT_PRODUTO);

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getPreco());
            ps.setInt(4, p.getQuantidade());
            ps.setInt(5, p.getId_categoria());
            ps.setInt(6, p.getId_fornecedor());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Registro adicionado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void createCategoria(Categoria c) {

        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = INSERT_CATEGORIA;

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, c.getNome());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Categoria adicionada", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createFornecedor(Fornecedor f) {

        try {
            Connection connection = new ConectaDB().Conectar();

            PreparedStatement ps = connection.prepareStatement(INSERT_FORNECEDOR);

            ps.setString(1, f.getCnpj());
            ps.setString(2, f.getNome());
            ps.setString(3, f.getInicio_contrato());
            ps.setString(4, f.getFim_contrato());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Fornecedor adicionado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
