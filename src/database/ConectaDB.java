package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaDB {

    private Connection conexao;

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://hostname/database?" + "user=your&password=senha&" + "useSSL=false&useTimezone=true&serverTimezone=UTC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao servidor!");
        }
        return conexao;
    }
}
