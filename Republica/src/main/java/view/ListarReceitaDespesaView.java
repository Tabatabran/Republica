package view;

import javax.swing.JButton;
import javax.swing.JTable;

public class ListarReceitaDespesaView extends javax.swing.JFrame {

    public ListarReceitaDespesaView() {
        initComponents();
    }

    public JButton getJbConfimarPagamentoRecebimento() {
        return jbConfimarPagamentoRecebimento;
    }

    public void setJbConfimarPagamentoRecebimento(JButton jbConfimarPagamentoRecebimento) {
        this.jbConfimarPagamentoRecebimento = jbConfimarPagamentoRecebimento;
    }

    public JButton getJbConsultarResultadoMensal() {
        return jbConsultarResultadoMensal;
    }

    public void setJbConsultarResultadoMensal(JButton jbConsultarResultadoMensal) {
        this.jbConsultarResultadoMensal = jbConsultarResultadoMensal;
    }

    public JTable getJtTabelaReceitaDespesa() {
        return jtTabelaReceitaDespesa;
    }

    public void setJtTabelaReceitaDespesa(JTable jtTabelaReceitaDespesa) {
        this.jtTabelaReceitaDespesa = jtTabelaReceitaDespesa;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaReceitaDespesa = new javax.swing.JTable();
        jbConsultarResultadoMensal = new javax.swing.JButton();
        jbConfimarPagamentoRecebimento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTabelaReceitaDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Descrição", "Data Vencimento", "Valor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabelaReceitaDespesa.setRowHeight(25);
        jScrollPane1.setViewportView(jtTabelaReceitaDespesa);

        jbConsultarResultadoMensal.setText("Consultar Resultado Mensal ");
        jbConsultarResultadoMensal.setActionCommand("Consultar Resultado Mensal da República ");

        jbConfimarPagamentoRecebimento.setText("Confirmar Pagamento/Recebimento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbConsultarResultadoMensal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbConfimarPagamentoRecebimento)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfimarPagamentoRecebimento)
                    .addComponent(jbConsultarResultadoMensal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbConfimarPagamentoRecebimento;
    private javax.swing.JButton jbConsultarResultadoMensal;
    private javax.swing.JTable jtTabelaReceitaDespesa;
    // End of variables declaration//GEN-END:variables
}
