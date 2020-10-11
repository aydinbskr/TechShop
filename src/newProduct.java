
//import Classes.Phone;
import All_Classes.Computer;
import All_Classes.Other;
import All_Classes.Phone;
import All_Classes.Product;
import All_Classes.Tv;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class newProduct extends javax.swing.JFrame {
    products frm;
    String brcode=null;
    public newProduct(products f,String barcode) {
        initComponents();
        frm=f;
        if(barcode!=null){
            brcode=barcode;
            System.out.println("Girildi"+barcode);
            Product p=SystemClass.getProduct(barcode);
            txtName.setText(p.getName());
            txtPprice.setText(String.valueOf(p.getP_price()));
            txtSprice.setText(String.valueOf(p.getS_price()));
            txtAmount.setText(String.valueOf(p.getAmount()));
            cmbCategory.setSelectedItem(p.getCategory());
            txtDescription.setText(p.getDescription());
            txtBarcode.setText(p.getBarkod());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPprice = new javax.swing.JTextField();
        txtSprice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(248, 248, 248));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(55, 50, 54));
        jLabel6.setText("New Product");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(211, 211, 211)));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 42));

        txtName.setBackground(new java.awt.Color(248, 248, 248));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(138, 139, 141));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 520, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 50, 54));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 50, 54));
        jLabel3.setText("Purchase Price");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtPprice.setBackground(new java.awt.Color(248, 248, 248));
        txtPprice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPprice.setForeground(new java.awt.Color(138, 139, 141));
        txtPprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPpriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 520, 40));

        txtSprice.setBackground(new java.awt.Color(248, 248, 248));
        txtSprice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSprice.setForeground(new java.awt.Color(138, 139, 141));
        txtSprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtSprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 520, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 50, 54));
        jLabel4.setText("Category");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 50, 54));
        jLabel5.setText("Sale Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        cmbCategory.setBackground(new java.awt.Color(248, 248, 248));
        cmbCategory.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbCategory.setForeground(new java.awt.Color(138, 139, 141));
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TV", "PHONE", "COMPUTER", "OTHER" }));
        jPanel1.add(cmbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 520, 40));

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
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 130, 40));

        jLabel1.setBackground(new java.awt.Color(248, 248, 248));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 50, 54));
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(211, 211, 211)));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 540, 60));

        btnSave.setBackground(new java.awt.Color(65, 105, 225));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnSave.setOpaque(true);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 130, 40));

        txtAmount.setBackground(new java.awt.Color(248, 248, 248));
        txtAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(138, 139, 141));
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 520, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(55, 50, 54));
        jLabel7.setText("Amount");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(55, 50, 54));
        jLabel8.setText("Description");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        txtDescription.setBackground(new java.awt.Color(248, 248, 248));
        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(138, 139, 141));
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 520, 40));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(55, 50, 54));
        jLabel9.setText("Barcode");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        txtBarcode.setBackground(new java.awt.Color(248, 248, 248));
        txtBarcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBarcode.setForeground(new java.awt.Color(138, 139, 141));
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        jPanel1.add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 520, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPpriceActionPerformed

    private void txtSpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpriceActionPerformed

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

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
      try {  
        String name=txtName.getText();
        double p_price=Double.parseDouble(txtPprice.getText());
        double s_price=Double.parseDouble(txtSprice.getText());
        int amount=Integer.parseInt(txtAmount.getText());
        String category=cmbCategory.getSelectedItem().toString();
        String description=txtDescription.getText();
        String barcode=txtBarcode.getText();
        
        Product p;
           
            if(cmbCategory.getSelectedItem().equals("PHONE")){
                 p=new Phone(barcode,name,p_price,s_price,category,amount,description);
                 if(brcode==null){
                    if(!SystemClass.addProduct(p)){
                        JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                    }
                 }
                else{
                     if(!SystemClass.updateProduct(brcode,p)){
                          JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                     } 
                    brcode=null;
                }
                  
            }
            else if(cmbCategory.getSelectedItem().equals("TV")){
                p=new Tv(barcode,name,p_price,s_price,category,amount,description);
                if(brcode==null){
                    if(!SystemClass.addProduct(p)){
                        JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                    }
                 }
                else{
                    if(!SystemClass.updateProduct(brcode,p)){
                          JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                     } 
                    brcode=null;
                }        
            }
            else if(cmbCategory.getSelectedItem().equals("COMPUTER")){
                p=new Computer(barcode,name,p_price,s_price,category,amount,description);
                if(brcode==null){
                    if(!SystemClass.addProduct(p)){
                        JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                    }
                 }
                else{
                    if(!SystemClass.updateProduct(brcode,p)){
                          JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                     } 
                    brcode=null;
                }        
            }
            else if(cmbCategory.getSelectedItem().equals("OTHER")){
                p=new Other(barcode,name,p_price,s_price,category,amount,description);
                if(brcode==null){
                    if(!SystemClass.addProduct(p)){
                        JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                    }
                 }
                else{
                    if(!SystemClass.updateProduct(brcode,p)){
                          JOptionPane.showMessageDialog(this,"CHANGE BARCODE NUMBER");
                     } 
                    brcode=null;
                }        
            }
       } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,e+"\nENTER PRICE LIKE 65.25 ");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,e);
        }
        
        txtName.setText("");
        txtBarcode.setText("");
        frm.addRowTable();     
        
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnSave.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnSave.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnSaveMouseExited

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarcodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnSave;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPprice;
    private javax.swing.JTextField txtSprice;
    // End of variables declaration//GEN-END:variables
}
