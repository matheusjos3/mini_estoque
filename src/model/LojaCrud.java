package model;

import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LojaCrud {

    public boolean create(Loja l) {
        try {

            Connection connection = new ConectaDB().Conectar();
            String sql = "INSERT INTO tb_loja (cpf, nome_loja, nome_proprietario, capacidade, acesso) VALUES(?, ?, ?, ?,?);";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, l.getCpf());
            ps.setString(2, l.getNomeLoja());
            ps.setString(3, l.getNome());
            ps.setInt(4, l.getCapacidadeEstoque());
            ps.setString(5, l.getSenha());

            ps.execute();
            connection.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Loja read(int id) {
        Loja l = new Loja();
        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT nome_loja, capacidade FROM tb_loja WHERE id_loja = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                l.setNomeLoja(rs.getString("nome_loja"));
                l.setCapacidadeEstoque(rs.getInt("capacidade"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro, Houve um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return l;
    }

    public Loja buscarCapacidade(int id) {
        Loja l = new Loja();

        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT capacidade,(SELECT sum(quantidade) from tb_produto) as qtdAtual FROM tb_loja WHERE id_loja = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                l.setCapacidadeAtual(rs.getInt("qtdAtual"));
                l.setCapacidadeEstoque(rs.getInt("capacidade"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro, Houve um erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return l;
    }

    public void updateCapacidade(int capacidade, int id) {
        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "UPDATE tb_loja SET capacidade = ? WHERE id_loja = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, capacidade);
            ps.setInt(2, id);

            ps.execute();

            connection.close();

            JOptionPane.showMessageDialog(null, "Capacidade de estoque atualizado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! - " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
