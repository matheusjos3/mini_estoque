package classes;

import javax.swing.JOptionPane;

public class ClasseMSG {

    private final String SUCESSO_REMOVER_FORNECEDOR = "Fornecedor foi removido!";
    private final String SUCESSO_REMOVER_CATEGORIA = "Categoria foi removida!";
    private final String SUCESSO_REMOVER_PRODUTO = "Produto foi removido!";

    private final String ERRO_REMOVER_FORNECEDOR = "Falha ao remover, existe algum produto marcado com esse fornecedor.";
    private final String ERRO_REMOVER_CATEGORIA = "Falha ao remover, existe algum produto marcado com essa categoria.";
    private final String ERRO_REMOVER_PRODUTO = "Falha ao remover, tente novamente.";

    public void mostrarComErro(String origem) {
        if (origem.equals("FORNECEDOR")) {
            JOptionPane.showMessageDialog(null, ERRO_REMOVER_FORNECEDOR, "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (origem.equals("CATEGORIA")) {
            JOptionPane.showMessageDialog(null, ERRO_REMOVER_CATEGORIA, "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        if (origem.equals("PRODUTO")) {
            JOptionPane.showMessageDialog(null, ERRO_REMOVER_PRODUTO, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarComSucesso(String origem) {
        if (origem.equals("FORNECEDOR")) {
            JOptionPane.showMessageDialog(null, SUCESSO_REMOVER_FORNECEDOR, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        if (origem.equals("CATEGORIA")) {
            JOptionPane.showMessageDialog(null, SUCESSO_REMOVER_CATEGORIA, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        if (origem.equals("PRODUTO")) {
            JOptionPane.showMessageDialog(null, SUCESSO_REMOVER_PRODUTO, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
