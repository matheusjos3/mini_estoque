package classes;

import dados.SalvarLoja;
import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class AtualizarStatus {

    public String statusProduto() {
        String id_temp;
        String status;
        int id;
        float capacidadeAtual = 0;
        float capacidade = 0;

        try {
            id_temp = new SalvarLoja().recuperarID();
            id = Integer.parseInt(id_temp);
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT capacidade,(SELECT sum(quantidade) from tb_produto) as qtdAtual FROM tb_loja WHERE id_loja = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                capacidade = rs.getInt(1);
                capacidadeAtual = rs.getInt(2);
            }

            float porcentagem = (capacidadeAtual / capacidade) * 100;
            String valorPorcentagem = String.valueOf(Math.round(porcentagem));
            status = "Capacidade: " + valorPorcentagem + "% usado(s)";

        } catch (Exception e) {
            status = "Houve um erro aqui!";
        }

        return status;
    }

    public String statusValorEstoque() {
        String status;
        float valor = 0;

        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT sum(preco * quantidade) from tb_produto;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                valor = rs.getInt(1);
            }

            String valorMoeda = NumberFormat.getCurrencyInstance().format(valor);
            status = valorMoeda;

        } catch (Exception e) {
            status = "Houve um erro aqui!";
        }

        return status;
    }
}
