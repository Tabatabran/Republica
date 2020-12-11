package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ManterReceitasDespesasView extends javax.swing.JFrame {

    public ManterReceitasDespesasView() {
        initComponents();
    }

    public JButton getJbBuscar() {
        return jbBuscar;
    }

    public void setJbBuscar(JButton jbBuscar) {
        this.jbBuscar = jbBuscar;
    }

    public JButton getJbCadastrarReceitaDespesa() {
        return jbCadastrarReceitaDespesa;
    }

    public void setJbCadastrarReceitaDespesa(JButton jbCadastrarReceitaDespesa) {
        this.jbCadastrarReceitaDespesa = jbCadastrarReceitaDespesa;
    }

    public JButton getJbEditar() {
        return jbEditar;
    }

    public void setJbEditar(JButton jbEditar) {
        this.jbEditar = jbEditar;
    }

    public JButton getJbRealizarEstorno() {
        return jbRealizarEstorno;
    }

    public void setJbRealizarEstorno(JButton jbRealizarEstorno) {
        this.jbRealizarEstorno = jbRealizarEstorno;
    }

    public JButton getJbVerInformacoes() {
        return jbVerInformacoes;
    }

    public void setJbVerInformacoes(JButton jbVerInformacoes) {
        this.jbVerInformacoes = jbVerInformacoes;
    }

    public JComboBox<String> getJcBuscar() {
        return jcBuscar;
    }

    public void setJcBuscar(JComboBox<String> jcBuscar) {
        this.jcBuscar = jcBuscar;
    }

    public JTextField getJtCampoNome() {
        return jtCampoNome;
    }

    public void setJtCampoNome(JTextField jtCampoNome) {
        this.jtCampoNome = jtCampoNome;
    }

    public JTable getJtTabelaReceitaDespesa() {
        return jtTabelaReceitaDespesa;
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtCampoNome = new javax.swing.JTextField();
        jcBuscar = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaReceitaDespesa = new javax.swing.JTable();
        jbRealizarEstorno = new javax.swing.JButton();
        jbCadastrarReceitaDespesa = new javax.swing.JButton();
        jbVerInformacoes = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa", "Data" }));

        jbBuscar.setText("Buscar");

        jtTabelaReceitaDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Tipo", "Descrição", "Data Cadastro", "Data Vencimento", "Valor", "Periodicidade", "Moradores", "Valor Dividido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabelaReceitaDespesa.setRowHeight(25);
        jScrollPane1.setViewportView(jtTabelaReceitaDespesa);

        jbRealizarEstorno.setText("Realizar Estorno");

        jbCadastrarReceitaDespesa.setText("Cadastrar Nova Receita/Despesa");

        jbVerInformacoes.setText("Ver Informações");

        jbEditar.setText("Editar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtCampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbCadastrarReceitaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbRealizarEstorno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbVerInformacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtCampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrarReceitaDespesa)
                    .addComponent(jbEditar)
                    .addComponent(jbVerInformacoes)
                    .addComponent(jbRealizarEstorno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastrarReceitaDespesa;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbRealizarEstorno;
    private javax.swing.JButton jbVerInformacoes;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JTextField jtCampoNome;
    private javax.swing.JTable jtTabelaReceitaDespesa;
    // End of variables declaration//GEN-END:variables
}
