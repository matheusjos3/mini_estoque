package classes;

import dados.SalvarLoja;
import javax.swing.JOptionPane;
import model.Loja;
import model.LojaCrud;

public class AlterarCapacidade extends javax.swing.JFrame {

    private int id, capacidade, capacidadeAtual;

    public AlterarCapacidade() {
        initComponents();
        recuperarCapacidade();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        spinnerCapacidade = new javax.swing.JSpinner();
        btnAtualizar = new javax.swing.JButton();
        textCapacidadeAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar capacidade");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconeEstoque.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 96, 96));
        jLabel4.setText("Capacidade de estoque");

        spinnerCapacidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinnerCapacidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));
        spinnerCapacidade.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                spinnerCapacidadeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(255, 153, 51));
        btnAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.setBorder(null);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        textCapacidadeAtual.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        textCapacidadeAtual.setText("Produtos em estoque:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(spinnerCapacidade, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addComponent(textCapacidadeAtual, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textCapacidadeAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int quantidade = (int) spinnerCapacidade.getValue();
        if (quantidade < capacidadeAtual) {
            JOptionPane.showMessageDialog(null, "Valor menor em relação ao estoque atual: " + String.valueOf(capacidadeAtual), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            LojaCrud l = new LojaCrud();
            l.updateCapacidade(quantidade, id);
            recuperarCapacidade();
            spinnerCapacidade.setValue(capacidade);
        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void spinnerCapacidadeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_spinnerCapacidadeAncestorAdded
        spinnerCapacidade.setValue(capacidade);
    }//GEN-LAST:event_spinnerCapacidadeAncestorAdded

    private void recuperarCapacidade() {
        String id_temp = new SalvarLoja().recuperarID();
        id = Integer.parseInt(id_temp);
        Loja l = new LojaCrud().buscarCapacidade(id);
        capacidade = l.getCapacidadeEstoque();
        capacidadeAtual = l.getCapacidadeAtual();
        textCapacidadeAtual.setText("Produtos em estoque: " + capacidadeAtual);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner spinnerCapacidade;
    private javax.swing.JLabel textCapacidadeAtual;
    // End of variables declaration//GEN-END:variables
}
