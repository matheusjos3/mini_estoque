package model;

import classes.ClasseMSG;
import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClasseDelete {

    String DELETE = "DELETE FROM tabela WHERE id = ?;";

    public void delete(String tabela, int id) {

        ClasseMSG classeMSG = new ClasseMSG();

        try {
            String idRef = "id_".concat(tabela).toLowerCase();
            String tabelaRef = "tb_".concat(tabela).toLowerCase();

            String sql = DELETE.replace("tabela", tabelaRef).replace("id", idRef);

            Connection connection = new ConectaDB().Conectar();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);
            ps.execute();

            connection.close();

            classeMSG.mostrarComSucesso(tabela);

        } catch (SQLException e) {
            classeMSG.mostrarComErro(tabela);
        }
    }

}
