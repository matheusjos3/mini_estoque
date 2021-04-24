package model;

import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClasseUpdate {

    private String UPDATE_CATEGORIA = "UPDATE tb_categoria SET nome = ? WHERE id_categoria = ?;";
    private String UPDATE_FORNECEDOR = "UPDATE tb_fornecedor SET cnpj = ?, nome_empresa = ?, inicio_contrato = ?, fim_contrato = ? WHERE id_fornecedor = ?;";
    private String UPDATE_PRODUTO = "UPDATE tb_produto SET codigo = ?, descricao = ?, preco = ?, quantidade = ? WHERE id_produto = ?;";

    public void updateProduto(Produto p) {
        try {
            Connection connection = new ConectaDB().Conectar();
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUTO);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getPreco());
            ps.setInt(4, p.getQuantidade());
            ps.setInt(5, p.getId_produto());

            ps.execute();

            connection.close();

            JOptionPane.showMessageDialog(null, "Produto atualizado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! - " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCategoria(Categoria c) {
        try {
            Connection connection = new ConectaDB().Conectar();

            PreparedStatement ps = connection.prepareStatement(UPDATE_CATEGORIA);

            ps.setString(1, c.getNome());
            ps.setInt(2, c.getId_categoria());

            ps.execute();

            connection.close();

            JOptionPane.showMessageDialog(null, "Categoria atualizado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! - " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateFornecedor(Fornecedor f) {
        try {
            Connection connection = new ConectaDB().Conectar();

            PreparedStatement ps = connection.prepareStatement(UPDATE_FORNECEDOR);

            ps.setString(1, f.getCnpj());
            ps.setString(2, f.getNome());
            ps.setString(3, f.getInicio_contrato());
            ps.setString(4, f.getFim_contrato());
            ps.setInt(5, f.getId_fornecedor());

            ps.execute();

            connection.close();

            JOptionPane.showMessageDialog(null, "Fornecedor atualizado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! - " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
