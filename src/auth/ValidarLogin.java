package auth;

import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ValidarLogin {

    public int logar(String cpf, String senha) {
        int id = 0;

        try {

            if (cpf.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Connection conexao = new ConectaDB().Conectar();
                String SQL = "SELECT cpf, acesso, id_loja FROM tb_loja WHERE cpf = ? AND acesso = ?;";
                PreparedStatement ps = conexao.prepareStatement(SQL);

                ps.setString(1, cpf);
                ps.setString(2, senha);

                ResultSet resul = ps.executeQuery();

                if (resul.next()) {
                    id = resul.getInt("id_loja");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return id;

    }
}
