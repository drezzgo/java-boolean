package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends javax.swing.JFrame {

    public Frame() {
        initComponents();
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public void setPanelPrincipal(JPanel PanelPrincipal) {
        this.PanelPrincipal = PanelPrincipal;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(JButton btnClear) {
        this.btnClear = btnClear;
    }

    public JButton getBtnSimplificar() {
        return btnSimplificar;
    }

    public void setBtnSimplificar(JButton btnSimplificar) {
        this.btnSimplificar = btnSimplificar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextField getTxtExpresion() {
        return txtExpresion;
    }

    public void setTxtExpresion(JTextField txtExpresion) {
        this.txtExpresion = txtExpresion;
    }

    public JTextArea getTxtaExpresionSimplificada() {
        return txtaExpresionSimplificada;
    }

    public void setTxtaExpresionSimplificada(JTextArea txtaExpresionSimplificada) {
        this.txtaExpresionSimplificada = txtaExpresionSimplificada;
    }

    public JTextArea getTxtaTablaDeVerdad() {
        return txtaTablaDeVerdad;
    }

    public void setTxtaTablaDeVerdad(JTextArea txtaTablaDeVerdad) {
        this.txtaTablaDeVerdad = txtaTablaDeVerdad;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtExpresion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaExpresionSimplificada = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaTablaDeVerdad = new javax.swing.JTextArea();
        btnClear = new javax.swing.JButton();
        btnSimplificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setText("SIMPLIFICADOR DE EXPRESIONES BOOLEANAS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese la Expresion a simplificar : ");

        txtExpresion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setText("Expresion Simplificada.");

        txtaExpresionSimplificada.setColumns(20);
        txtaExpresionSimplificada.setRows(5);
        jScrollPane1.setViewportView(txtaExpresionSimplificada);

        jLabel4.setText("Tabla de verdad - SALIDA");

        txtaTablaDeVerdad.setColumns(20);
        txtaTablaDeVerdad.setRows(5);
        jScrollPane2.setViewportView(txtaTablaDeVerdad);

        btnClear.setText("clear");

        btnSimplificar.setText("Simplificar");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClear))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel1))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnSimplificar)))
                        .addGap(0, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimplificar))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnClear))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSimplificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtExpresion;
    private javax.swing.JTextArea txtaExpresionSimplificada;
    private javax.swing.JTextArea txtaTablaDeVerdad;
    // End of variables declaration//GEN-END:variables
}
