
import All_Classes.Customer;
import All_Classes.Sale;
import All_Classes.User;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class reports extends javax.swing.JInternalFrame {
    double totalsale,cashsale,creditsale;
    public reports() {
        initComponents();
        
        ArrayList<String> customers=SystemClass.getCustomerList();
        for (String customer : customers) {
            cmbCustomer.addItem(customer);  
        }
        
        ArrayList<User> sellers=SystemClass.getAllUser();
        
        for (User seller : sellers) {
            cmbSeller.addItem(seller.getFullname());  
        }
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
    }
    public void addRowTable(Date s_date,Date e_date,int Customerindex,int userindex){
        try {
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            ArrayList<Sale> list=new ArrayList<>();
            if(Customerindex!=-1 && userindex!=-1){
                System.out.println("ilk if");
               Customer c=SystemClass.getCustomer(Customerindex);
               User seller=SystemClass.getUser(userindex);
               list=SystemClass.getAllSales(s_date,e_date,c, seller); 
            }
            else if(Customerindex==-1 && userindex!=-1){
                System.out.println("ikinci if");
                User seller=SystemClass.getUser(userindex);
                list=SystemClass.getAllSales(s_date,e_date,seller);
            }
            else if(Customerindex!=-1 && userindex==-1){
                System.out.println("ucuncu if");
                Customer c=SystemClass.getCustomer(Customerindex);
                list=SystemClass.getAllSales(s_date,e_date,c);
            }
            else{
                System.out.println("son if");
                list=SystemClass.getAllSales(s_date,e_date); 
            }
            
           Object rowdata[]=new Object[8];
           
           for (int i = 0; i < list.size(); i++) {
                
                for (int j = 0; j < list.get(i).getBasket().getBasketitems().size(); j++) {
                    rowdata[0]=list.get(i).getId();
                    rowdata[1]=list.get(i).getCustomer().getFullname();
                    rowdata[2]=list.get(i).getBasket().getBasketitems().get(j).getProd().getName();
                    rowdata[3]=list.get(i).getBasket().getBasketitems().get(j).getProd().getS_price();
                    rowdata[4]=list.get(i).getBasket().getBasketitems().get(j).getAmount();
                    rowdata[5]=list.get(i).getBasket().getBasketitems().get(j).getAmount()*list.get(i).getBasket().getBasketitems().get(j).getProd().getS_price();
                    totalsale+=(double)rowdata[5];
                    rowdata[6]=list.get(i).getCashorcredit();
                    rowdata[7]=list.get(i).getUser().getFullname();
                    if(list.get(i).getCashorcredit().equals("CASH")){
                       cashsale+=(double)rowdata[5];
                    }
                    else if(list.get(i).getCashorcredit().equals("CREDIT")){
                        creditsale+=(double)rowdata[5];
                    }
                    model.addRow(rowdata);
                }
             
            } 
        } catch (Exception e) {
        }
    
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFinishDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbSeller = new javax.swing.JComboBox<>();
        btnReport = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblCreditsale = new javax.swing.JLabel();
        lblTotalsale = new javax.swing.JLabel();
        lblCashsale = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(750, 510));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(65, 105, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 248));
        jLabel1.setText("Sale Reports");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 42));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 50, 54));
        jLabel2.setText("Start Date(yyyy.MM.dd)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtFinishDate.setBackground(new java.awt.Color(248, 248, 248));
        txtFinishDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFinishDate.setForeground(new java.awt.Color(138, 139, 141));
        txtFinishDate.setText("2020.12.30");
        jPanel1.add(txtFinishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 160, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 50, 54));
        jLabel3.setText("End Date(yyyy.MM.dd)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        txtStartDate.setBackground(new java.awt.Color(248, 248, 248));
        txtStartDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStartDate.setForeground(new java.awt.Color(138, 139, 141));
        txtStartDate.setText("2019.1.1");
        jPanel1.add(txtStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 50, 54));
        jLabel4.setText("Customer Name,Surname");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        cmbCustomer.setBackground(new java.awt.Color(248, 248, 248));
        cmbCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbCustomer.setForeground(new java.awt.Color(138, 139, 141));
        cmbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cmbCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 180, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 50, 54));
        jLabel5.setText("Seller");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        cmbSeller.setBackground(new java.awt.Color(248, 248, 248));
        cmbSeller.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbSeller.setForeground(new java.awt.Color(138, 139, 141));
        cmbSeller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        jPanel1.add(cmbSeller, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 150, 40));

        btnReport.setBackground(new java.awt.Color(65, 105, 225));
        btnReport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReport.setText("Display");
        btnReport.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnReport.setOpaque(true);
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });
        jPanel1.add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 40));

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));

        jLabel6.setBackground(new java.awt.Color(65, 105, 225));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 248, 248));
        jLabel6.setText("Reports Table");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel6.setOpaque(true);

        lblCreditsale.setBackground(new java.awt.Color(98, 184, 95));
        lblCreditsale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCreditsale.setForeground(new java.awt.Color(255, 255, 255));
        lblCreditsale.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCreditsale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credit-card-6-32.png"))); // NOI18N
        lblCreditsale.setText("<html>\n<center>\n<tag>\nCredit Sale\n</tag>\n<br>\n0 TL\n</center>\n<html>");
        lblCreditsale.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblCreditsale.setIconTextGap(50);
        lblCreditsale.setOpaque(true);

        lblTotalsale.setBackground(new java.awt.Color(98, 184, 95));
        lblTotalsale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalsale.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalsale.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalsale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sell-32.png"))); // NOI18N
        lblTotalsale.setText("<html> <center> <tag> Total Sale </tag> <br> <font size=\"5\">0 TL</font> </center> <html>");
        lblTotalsale.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblTotalsale.setIconTextGap(50);
        lblTotalsale.setOpaque(true);

        lblCashsale.setBackground(new java.awt.Color(98, 184, 95));
        lblCashsale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCashsale.setForeground(new java.awt.Color(255, 255, 255));
        lblCashsale.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCashsale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banknotes-32.png"))); // NOI18N
        lblCashsale.setText("<html>\n<center>\n<tag>\nCash Sale\n</tag>\n<br>\n0 TL\n</center>\n<html>");
        lblCashsale.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblCashsale.setIconTextGap(50);
        lblCashsale.setOpaque(true);

        jTable1.setBackground(new java.awt.Color(248, 248, 248));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(149, 158, 163));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer Name", "Product Name", "Price", "Amount", "Total Price", "Payment", "Seller"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setGridColor(new java.awt.Color(232, 232, 230));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(37);
        jTable1.setSelectionBackground(new java.awt.Color(65, 105, 225));
        jTable1.setSelectionForeground(new java.awt.Color(248, 248, 248));
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTotalsale, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCashsale, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(lblCreditsale, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCreditsale, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCashsale, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalsale, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 750, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        
        try {
            totalsale=0;
            cashsale=0;
            creditsale=0;
           Date date1=new SimpleDateFormat("yyyy.MM.dd").parse(txtStartDate.getText());   
            Date date2=new SimpleDateFormat("yyyy.MM.dd").parse(txtFinishDate.getText());
            int c_index=cmbCustomer.getSelectedIndex()-1;
            int u_index=cmbSeller.getSelectedIndex()-1;
            
            addRowTable(date1,date2,c_index,u_index); 
            lblTotalsale.setText("<html><center><tag>Total Sale</tag><br><font size=\"5\">"+totalsale+"TL</font></center></html>");
            lblCashsale.setText("<html><center><tag>Cash Sale</tag><br><font size=\"5\">"+cashsale+"TL</font></center></html>");
            lblCreditsale.setText("<html><center><tag>Credit Sale</tag><br><font size=\"5\">"+creditsale+"TL</font></center></html>");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this,e+"\nEnter date like 2019.12.8");
        }
    }//GEN-LAST:event_btnReportMouseClicked

    private void btnReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnReport.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnReportMouseEntered

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnReport.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnReportMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnReport;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbSeller;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCashsale;
    private javax.swing.JLabel lblCreditsale;
    private javax.swing.JLabel lblTotalsale;
    private javax.swing.JTextField txtFinishDate;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
