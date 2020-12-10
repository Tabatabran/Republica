package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastrarReceitaDespesaView extends javax.swing.JFrame {

    public CadastrarReceitaDespesaView() {
        initComponents();
        
    }

    public ButtonGroup getButtonGroupPeridiocidade() {
        return buttonGroupPeridiocidade;
    }

    public ButtonGroup getButtonGroupTipo() {
        return buttonGroupTipo;
    }

    public JButton getJbBotaoDireita() {
        return jbBotaoDireita;
    }

    public JButton getJbBotaoEsquerda() {
        return jbBotaoEsquerda;
    }

    public JButton getJbConfirmar() {
        return jbConfirmar;
    }

    public JFormattedTextField getJftDataCadastro() {
        return jftDataCadastro;
    }

    public JFormattedTextField getJftDataVencimento() {
        return jftDataVencimento;
    }

    public JList<String> getJlListaMoradorDireita() {
        return jlListaMoradorDireita;
    }

    public JList<String> getJlListaMoradorEsquerda() {
        return jlListaMoradorEsquerda;
    }

    public JRadioButton getJrbAnual() {
        return jrbAnual;
    }

    public JRadioButton getJrbDespesa() {
        return jrbDespesa;
    }

    public JRadioButton getJrbIndefinido() {
        return jrbIndefinido;
    }

    public JRadioButton getJrbMensal() {
        return jrbMensal;
    }

    public JRadioButton getJrbReceita() {
        return jrbReceita;
    }

    public JRadioButton getJrbSemanal() {
        return jrbSemanal;
    }

    public JTextField getJtDescricaoReceitaDespesa() {
        return jtDescricaoReceitaDespesa;
    }

    public JTextField getJtValor() {
        return jtValor;
    }

    public JLabel getjLabelValorParcela() {
        return jLabelValorParcela;
    }

    public JTextField getJtValorParcela() {
        return jtValorParcela;
    }

    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        buttonGroupPeridiocidade = new javax.swing.ButtonGroup();
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
        jbConfirmar = new javax.swing.JButton();
        jtValorParcela = new javax.swing.JTextField();
        jLabelValorParcela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Tipo:");

        buttonGroupTipo.add(jrbReceita);
        jrbReceita.setText("Receita");

        buttonGroupTipo.add(jrbDespesa);
        jrbDespesa.setText("Despesa");

        jLabel1.setText("Descrição da Receita/Despesa:");

        jLabel3.setText("Data de Vencimento:");

        jLabel4.setText("Data de Cadastro:");

        try {
            jftDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jftDataCadastro.setEditable(false);
        try {
            jftDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Valor:");

        jLabel6.setText("Periodicidade:");

        buttonGroupPeridiocidade.add(jrbAnual);
        jrbAnual.setText("Anual");

        buttonGroupPeridiocidade.add(jrbMensal);
        jrbMensal.setText("Mensal");

        buttonGroupPeridiocidade.add(jrbSemanal);
        jrbSemanal.setText("Semanal");

        buttonGroupPeridiocidade.add(jrbIndefinido);
        jrbIndefinido.setText("Indefinido");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Responsáveis pela Receita/Despesa"));

        jLabel7.setText("Moradores");

        jlListaMoradorEsquerda.setToolTipText("");
        jScrollPane3.setViewportView(jlListaMoradorEsquerda);

        jScrollPane2.setViewportView(jlListaMoradorDireita);

        jLabel8.setText("Responsáveis");

        jbBotaoDireita.setText("→");

        jbBotaoEsquerda.setText("←");

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

        jbConfirmar.setText("Confirmar");

        jLabelValorParcela.setText("Valor parcela:");

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
                                .addComponent(jLabel9)
                                .addGap(190, 190, 190)
                                .addComponent(jLabelValorParcela))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtValor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jftDataVencimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jftDataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jtValorParcela)))))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbConfirmar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelValorParcela)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPeridiocidade;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelValorParcela;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbBotaoDireita;
    private javax.swing.JButton jbBotaoEsquerda;
    private javax.swing.JButton jbConfirmar;
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
    private javax.swing.JTextField jtValorParcela;
    // End of variables declaration//GEN-END:variables
}
