package combobox;

import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Fornecedor;

public class ClasseComboBox {

    public List<Categoria> comboCategoria() {
        List<Categoria> itens = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT id_categoria, nome FROM tb_categoria ORDER BY nome ASC ;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome"));
                itens.add(c);
            }

            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return itens;
    }

    public List<Fornecedor> comboFornecedor() {
        List<Fornecedor> itens = new ArrayList<>();
        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT id_fornecedor,nome_empresa FROM tb_fornecedor ORDER BY nome_empresa ASC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId_fornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome_empresa"));
                itens.add(f);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return itens;
    }
}
