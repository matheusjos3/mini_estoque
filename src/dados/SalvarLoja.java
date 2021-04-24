package dados;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SalvarLoja {

    //GUARDA O ID DA LOJA TEMPORARIAMENTE EM UMA PASTA NA RAIZ DO SISTEMA
    public boolean guardarID(int id) {
        File dir = new File("src/dados").getAbsoluteFile();
        File arq = new File(dir, "temp_id.txt");

        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(id);
            printWriter.flush();

            printWriter.close();

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente");
            return false;
        }
    }

    public String recuperarID() {
        String id = "";
        File dir = new File("src/dados/temp_id.txt").getAbsoluteFile();

        try {
            Scanner dados = new Scanner(dir);

            if (dados.hasNext()) {
                id = dados.next();
            }

            dados.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os dados, tente novamente");
        }

        return id;
    }
}
