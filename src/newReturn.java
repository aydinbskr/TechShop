
import All_Classes.Sale;
import java.awt.Cursor;


public class newReturn extends javax.swing.JFrame {
    returnform frm;
    Sale sale;
    int itemindex;
    public newReturn(returnform f,int saleid,int basketitem) {
        initComponents();
        frm=f;
        sale=SystemClass.getSale(saleid);
        itemindex=basketitem;
        txtProduct.setText(sale.getBasket().getBasketitems().get(basketitem).getProd().getName());
        
        jsAmount.setModel(new javax.swing.SpinnerNumberModel(sale.getBasket().getBasketitems().get(basketitem).getAmount(), 
                            1,sale.getBasket().getBasketitems().get(basketitem).getAmount(), 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jsAmount = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(248, 248, 248));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(55, 50, 54));
        jLabel6.setText("Return");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(211, 211, 211)));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 42));

        txtProduct.setBackground(new java.awt.Color(248, 248, 248));
        txtProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProduct.setForeground(new java.awt.Color(138, 139, 141));
        jPanel1.add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 520, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 50, 54));
        jLabel2.setText("Product");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        btnExit.setBackground(new java.awt.Color(65, 105, 225));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 150, 40));

        jLabel1.setBackground(new java.awt.Color(248, 248, 248));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 50, 54));
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(211, 211, 211)));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 540, 60));

        btnReturn.setBackground(new java.awt.Color(65, 105, 225));
        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReturn.setText("Return");
        btnReturn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnReturn.setOpaque(true);
        btnReturn.setPreferredSize(new java.awt.Dimension(50, 30));
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReturnMouseExited(evt);
            }
        });
        jPanel1.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 50, 54));
        jLabel4.setText("Amount");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jsAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jsAmount.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        jPanel1.add(jsAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 520, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnExit.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnExit.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseClicked
        sale.getBasket().getBasketitems().get(itemindex).setAmount((int)jsAmount.getValue());
        sale.getBasket().updateBasketSum();
        sale.getBasket().getBasketitems().get(itemindex).getProd().increaseAmount((int)jsAmount.getValue());
        frm.addRowTable(sale);
        this.dispose();
        
    }//GEN-LAST:event_btnReturnMouseClicked

    private void btnReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnReturn.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnReturnMouseEntered

    private void btnReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnReturn.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnReturnMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jsAmount;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables
}
