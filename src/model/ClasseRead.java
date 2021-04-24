package model;

import database.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClasseRead {

    private String SELECT_CATEGORIA = "SELECT id_categoria, nome FROM tb_categoria;";
    private String SELECT_RECENTE = "SELECT id_produto, codigo, descricao, preco, quantidade, DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto ORDER BY data_formatada DESC;";
    private String SELECT_ANTIGO = "SELECT id_produto, codigo, descricao, preco, quantidade, DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto ORDER BY data_formatada ASC;";
    private String SELECT_FORNECEDOR = "SELECT id_fornecedor,cnpj,nome_empresa,inicio_contrato,fim_contrato FROM tb_fornecedor;";
    private String SELECT_PRODUTO_ID = "SELECT id_produto,codigo,descricao,preco,quantidade, DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto WHERE id_categoria = ?;";
    private String SELECT_PROCURAR_PRODUTO = "SELECT id_produto,codigo,descricao,preco,quantidade,DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto WHERE descricao LIKE ? ORDER BY data_formatada DESC;";
    private String SELECT_PRODUTO = "SELECT id_produto,codigo,descricao,preco,quantidade,DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto ORDER BY data_formatada DESC;";

    public List<Produto> readProdutoPorID(int id) {
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();
            PreparedStatement ps = connection.prepareStatement(SELECT_PRODUTO_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDataEntrada(rs.getString("data_formatada"));

                produtos.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados! " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

    public List<Categoria> readCategoria() {
        List<Categoria> dados = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();
            PreparedStatement ps = connection.prepareStatement(SELECT_CATEGORIA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome"));

                dados.add(c);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Falha ao buscar dados! " + e.getMessage(),"Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return dados;
    }

    public List<Produto> searchProduto(String termo) {
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();
            PreparedStatement ps = connection.prepareStatement(SELECT_PROCURAR_PRODUTO);
            ps.setString(1, "%" + termo + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDataEntrada(rs.getString("data_formatada"));

                produtos.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

    public List<Produto> readPreco(String metodo) {
        List<Produto> produtos = new ArrayList<>();
        String sql;

        try {
            Connection connection = new ConectaDB().Conectar();

            if (metodo.equals("BARATO")) {
                sql = "SELECT id_produto,codigo,descricao,preco,quantidade, DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto WHERE preco = (SELECT MIN(preco) FROM tb_produto);";
            } else {
                sql = "SELECT id_produto,codigo,descricao,preco,quantidade, DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto WHERE preco = (SELECT MAX(preco) FROM tb_produto);";
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDataEntrada(rs.getString("data_formatada"));

                produtos.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

    public List<Produto> readProduto() {
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();
            PreparedStatement ps = connection.prepareStatement(SELECT_PRODUTO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDataEntrada(rs.getString("data_formatada"));

                produtos.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados! " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

    //Mostrar produtos na ordem recente e mais antigo
    public List<Produto> readPorTempo(String tipo) {
        List<Produto> produtos = new ArrayList<>();
        String sql = SELECT_RECENTE;

        try {
            Connection connection = new ConectaDB().Conectar();

            if (tipo.equals("Mais Antigo")) {
                sql = SELECT_ANTIGO;
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDataEntrada(rs.getString("data_formatada"));

                produtos.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha ao buscar dados! " + e.getMessage(),
                    "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

    // Fornecedor
    public List<Fornecedor> readfornecedor() {
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();

            PreparedStatement ps = connection.prepareStatement(SELECT_FORNECEDOR);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId_fornecedor(rs.getInt("id_fornecedor"));
                f.setCnpj(rs.getString("cnpj"));
                f.setNome(rs.getString("nome_empresa"));
                f.setInicio_contrato(rs.getString("inicio_contrato"));
                f.setFim_contrato(rs.getString("fim_contrato"));
                fornecedores.add(f);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha ao buscar os dados! " + e.getMessage(),
                    "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return fornecedores;
    }

    public List<Produto> readFornecedor(int id) {
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection connection = new ConectaDB().Conectar();
            String sql = "SELECT id_produto,codigo,descricao,preco,quantidade, DATE_FORMAT(data_entrada, '%d/%m/%y %H:%i') AS data_formatada FROM tb_produto WHERE id_fornecedor = ? ORDER BY data_formatada ASC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setDataEntrada(rs.getString("data_formatada"));

                produtos.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar dados! " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return produtos;
    }

}
