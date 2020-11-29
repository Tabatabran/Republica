package view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VisualizarReceitaDespesaView extends javax.swing.JFrame {

    public VisualizarReceitaDespesaView() {
        initComponents();
    }

    public JButton getJbBotaoDireita() {
        return jbBotaoDireita;
    }

    public void setJbBotaoDireita(JButton jbBotaoDireita) {
        this.jbBotaoDireita = jbBotaoDireita;
    }

    public JButton getJbBotaoEsquerda() {
        return jbBotaoEsquerda;
    }

    public void setJbBotaoEsquerda(JButton jbBotaoEsquerda) {
        this.jbBotaoEsquerda = jbBotaoEsquerda;
    }

    public JFormattedTextField getJftDataCadastro() {
        return jftDataCadastro;
    }

    public void setJftDataCadastro(JFormattedTextField jftDataCadastro) {
        this.jftDataCadastro = jftDataCadastro;
    }

    public JFormattedTextField getJftDataVencimento() {
        return jftDataVencimento;
    }

    public void setJftDataVencimento(JFormattedTextField jftDataVencimento) {
        this.jftDataVencimento = jftDataVencimento;
    }

    public JList<String> getJlListaMoradorDireita() {
        return jlListaMoradorDireita;
    }

    public void setJlListaMoradorDireita(JList<String> jlListaMoradorDireita) {
        this.jlListaMoradorDireita = jlListaMoradorDireita;
    }

    public JList<String> getJlListaMoradorEsquerda() {
        return jlListaMoradorEsquerda;
    }

    public void setJlListaMoradorEsquerda(JList<String> jlListaMoradorEsquerda) {
        this.jlListaMoradorEsquerda = jlListaMoradorEsquerda;
    }

    public JRadioButton getJrbAnual() {
        return jrbAnual;
    }

    public void setJrbAnual(JRadioButton jrbAnual) {
        this.jrbAnual = jrbAnual;
    }

    public JRadioButton getJrbDespesa() {
        return jrbDespesa;
    }

    public void setJrbDespesa(JRadioButton jrbDespesa) {
        this.jrbDespesa = jrbDespesa;
    }

    public JRadioButton getJrbIndefinido() {
        return jrbIndefinido;
    }

    public void setJrbIndefinido(JRadioButton jrbIndefinido) {
        this.jrbIndefinido = jrbIndefinido;
    }

    public JRadioButton getJrbMensal() {
        return jrbMensal;
    }

    public void setJrbMensal(JRadioButton jrbMensal) {
        this.jrbMensal = jrbMensal;
    }

    public JRadioButton getJrbReceita() {
        return jrbReceita;
    }

    public void setJrbReceita(JRadioButton jrbReceita) {
        this.jrbReceita = jrbReceita;
    }

    public JRadioButton getJrbSemanal() {
        return jrbSemanal;
    }

    public void setJrbSemanal(JRadioButton jrbSemanal) {
        this.jrbSemanal = jrbSemanal;
    }

    public JTextField getJtDescricaoReceitaDespesa() {
        return jtDescricaoReceitaDespesa;
    }

    public void setJtDescricaoReceitaDespesa(JTextField jtDescricaoReceitaDespesa) {
        this.jtDescricaoReceitaDespesa = jtDescricaoReceitaDespesa;
    }

    public JTextField getJtValor() {
        return jtValor;
    }

    public void setJtValor(JTextField jtValor) {
        this.jtValor = jtValor;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jrbReceita = new javax.swing.JRadioButton();
        jrbDespesa = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jtDescricaoReceitaDespesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jftDataVencimento = new javax.swing.JFormattedTextField();
        jftDataCadastro = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jtValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jrbAnual = new javax.swing.JRadioButton();
        jrbMensal = new javax.swing.JRadioButton();
        jrbSemanal = new javax.swing.JRadioButton();
        jrbIndefinido = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlListaMoradorEsquerda = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlListaMoradorDireita = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jbBotaoDireita = new javax.swing.JButton();
        jbBotaoEsquerda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setEnabled(false);

        jLabel5.setText("Tipo:");

        jrbReceita.setText("Receita");
        jrbReceita.setEnabled(false);

        jrbDespesa.setText("Despesa");
        jrbDespesa.setEnabled(false);

        jLabel1.setText("Descrição da Receita/Despesa:");

        jtDescricaoReceitaDespesa.setEnabled(false);

        jLabel3.setText("Data de Vencimento:");

        jLabel4.setText("Data de Cadastro:");

        try {
            jftDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataVencimento.setEnabled(false);

        jftDataCadastro.setEditable(false);
        try {
            jftDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Valor:");

        jtValor.setEnabled(false);

        jLabel6.setText("Periodicidade:");

        jrbAnual.setText("Anual");
        jrbAnual.setEnabled(false);

        jrbMensal.setText("Mensal");
        jrbMensal.setEnabled(false);

        jrbSemanal.setText("Semanal");
        jrbSemanal.setEnabled(false);

        jrbIndefinido.setText("Indefinido");
        jrbIndefinido.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Responsáveis pela Receita/Despesa"));

        jLabel7.setText("Moradores");

        jlListaMoradorEsquerda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Morador 1", "Morador 2", "Morador 3", "Morador 4", "Morador 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlListaMoradorEsquerda.setEnabled(false);
        jlListaMoradorEsquerda.setFocusable(false);
        jScrollPane3.setViewportView(jlListaMoradorEsquerda);

        jlListaMoradorDireita.setEnabled(false);
        jScrollPane2.setViewportView(jlListaMoradorDireita);

        jLabel8.setText("Responsáveis");

        jbBotaoDireita.setText("→");
        jbBotaoDireita.setEnabled(false);

        jbBotaoEsquerda.setText("←");
        jbBotaoEsquerda.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBotaoEsquerda)
                            .addComponent(jbBotaoDireita, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jbBotaoDireita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBotaoEsquerda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescricaoReceitaDespesa)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jftDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jftDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbAnual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbMensal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbSemanal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbIndefinido))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9))
                            .addComponent(jtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbReceita)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbDespesa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbDespesa)
                    .addComponent(jrbReceita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtDescricaoReceitaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(jtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbSemanal)
                    .addComponent(jrbIndefinido)
                    .addComponent(jrbAnual)
                    .addComponent(jrbMensal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbBotaoDireita;
    private javax.swing.JButton jbBotaoEsquerda;
    private javax.swing.JFormattedTextField jftDataCadastro;
    private javax.swing.JFormattedTextField jftDataVencimento;
    private javax.swing.JList<String> jlListaMoradorDireita;
    private javax.swing.JList<String> jlListaMoradorEsquerda;
    private javax.swing.JRadioButton jrbAnual;
    private javax.swing.JRadioButton jrbDespesa;
    private javax.swing.JRadioButton jrbIndefinido;
    private javax.swing.JRadioButton jrbMensal;
    private javax.swing.JRadioButton jrbReceita;
    private javax.swing.JRadioButton jrbSemanal;
    private javax.swing.JTextField jtDescricaoReceitaDespesa;
    private javax.swing.JTextField jtValor;
    // End of variables declaration//GEN-END:variables
}
