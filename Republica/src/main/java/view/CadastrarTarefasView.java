package view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTextField;

public class CadastrarTarefasView extends javax.swing.JFrame {

    public CadastrarTarefasView() {
        initComponents();
    }

    public JButton getJbBotaoConfirmar() {
        return jbBotaoConfirmar;
    }

    public void setJbBotaoConfirmar(JButton jbBotaoConfirmar) {
        this.jbBotaoConfirmar = jbBotaoConfirmar;
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

    public JFormattedTextField getJfDataTermino() {
        return jfDataTermino;
    }

    public void setJfDataTermino(JFormattedTextField jfDataTermino) {
        this.jfDataTermino = jfDataTermino;
    }

    public JFormattedTextField getJfDataAgendamento() {
        return jfDataAgendamento;
    }

    public void setJfDataAgendamento(JFormattedTextField jfDataAgendamento) {
        this.jfDataAgendamento = jfDataAgendamento;
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

    public JTextField getJtDescricaoTarefa() {
        return jtDescricaoTarefa;
    }

    public void setJtDescricaoTarefa(JTextField jtDescricaoTarefa) {
        this.jtDescricaoTarefa = jtDescricaoTarefa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtDescricaoTarefa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlListaMoradorEsquerda = new javax.swing.JList<>();
        jbBotaoDireita = new javax.swing.JButton();
        jbBotaoEsquerda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlListaMoradorDireita = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jfDataTermino = new javax.swing.JFormattedTextField();
        jfDataAgendamento = new javax.swing.JFormattedTextField();
        jbBotaoConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descrição da Tarefa:");

        jLabel2.setText("Responsáveis pela tarefa:");

        jlListaMoradorEsquerda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Morador 1", "Morador 2", "Morador 3", "Morador 4", "Morador 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jlListaMoradorEsquerda);

        jbBotaoDireita.setText("→");

        jbBotaoEsquerda.setText("←");

        jScrollPane2.setViewportView(jlListaMoradorDireita);

        jLabel3.setText("Data de agendamento:");

        jLabel4.setText("Data de término:");

        try {
            jfDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jfDataAgendamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jbBotaoConfirmar.setText("Confirmar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescricaoTarefa)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbBotaoEsquerda)
                                    .addComponent(jbBotaoDireita, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jfDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jfDataTermino))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jbBotaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtDescricaoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jbBotaoDireita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBotaoEsquerda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jfDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBotaoConfirmar)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbBotaoConfirmar;
    private javax.swing.JButton jbBotaoDireita;
    private javax.swing.JButton jbBotaoEsquerda;
    private javax.swing.JFormattedTextField jfDataAgendamento;
    private javax.swing.JFormattedTextField jfDataTermino;
    private javax.swing.JList<String> jlListaMoradorDireita;
    private javax.swing.JList<String> jlListaMoradorEsquerda;
    private javax.swing.JTextField jtDescricaoTarefa;
    // End of variables declaration//GEN-END:variables
}
