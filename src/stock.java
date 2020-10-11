
import All_Classes.Computer;
import All_Classes.Phone;
import All_Classes.Product;
import All_Classes.Tv;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class stock extends javax.swing.JInternalFrame {

    public stock() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);

        addRowTable();
        
         JTableHeader header=jTable1.getTableHeader();
         header.setFont(new java.awt.Font("Segoe UI", 0, 14));
         header.setForeground(new java.awt.Color(115, 110, 107));
         jTable1.setTableHeader(header);
    }

    public void addRowTable(){
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.getDataVector().removeAllElements();
        ArrayList<Product> list=SystemClass.getAllProduct();
        DecimalFormat df=new DecimalFormat(".##");
           int tv_amount=0,ph_amount=0,c_amount=0,o_amount=0;
           double tv_price=0,ph_price=0,c_price=0,o_price=0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) instanceof Tv){        
                    tv_amount+=list.get(i).getAmount();
                    tv_price+=list.get(i).getAmount()*list.get(i).getP_price();
                }
                else if(list.get(i) instanceof Phone){        
                    ph_amount+=list.get(i).getAmount();
                    ph_price+=list.get(i).getAmount()*list.get(i).getP_price();
                }
                else if(list.get(i) instanceof Computer){        
                    c_amount+=list.get(i).getAmount();
                    c_price+=list.get(i).getAmount()*list.get(i).getP_price();
                }
                else{        
                    o_amount+=list.get(i).getAmount();
                    o_price+=list.get(i).getAmount()*list.get(i).getP_price();
                }
 
            } 
            Object rowdata[]=new Object[3];

             rowdata[0]="TV";
             rowdata[1]=tv_amount;
             rowdata[2]=tv_price;
             model.addRow(rowdata);
             rowdata[0]="PHONE";
             rowdata[1]=ph_amount;
             rowdata[2]=ph_price;
             model.addRow(rowdata);
             rowdata[0]="COMPUTER";
             rowdata[1]=c_amount;
             rowdata[2]=c_price;
             model.addRow(rowdata);
             rowdata[0]="OTHER";
             rowdata[1]=o_amount;
             rowdata[2]=o_price;
             model.addRow(rowdata);
            
            lblTotalProduct.setText("<html><div align=\"right\"> <font size=\"5\">"+(tv_amount+ph_amount+c_amount+o_amount)+"</font><br> <tag> Saved Product </tag></div> <html>");
            lblTotalPprice.setText("<html><div align=\"right\"> <font size=\"5\">"+df.format(tv_price+ph_price+c_price+o_price)+" TL</font><br> <tag> Purchase Price </tag></div> <html>");
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTotalProduct = new javax.swing.JLabel();
        lblTotalPprice = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(65, 105, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 248));
        jLabel1.setText("Stocks");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 42));

        jTable1.setBackground(new java.awt.Color(248, 248, 248));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(149, 158, 163));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Name", "Product Amount", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 280));

        lblTotalProduct.setBackground(new java.awt.Color(98, 184, 95));
        lblTotalProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalProduct.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filled-box-48.png"))); // NOI18N
        lblTotalProduct.setText("<html><div align=\"right\"> <font size=\"5\">0</font><br> <tag> Saved Product </tag></div> <html>");
        lblTotalProduct.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblTotalProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblTotalProduct.setIconTextGap(140);
        lblTotalProduct.setOpaque(true);
        jPanel1.add(lblTotalProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 310, 130));

        lblTotalPprice.setBackground(new java.awt.Color(98, 184, 95));
        lblTotalPprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalPprice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPprice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalPprice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sell-48 (1).png"))); // NOI18N
        lblTotalPprice.setText("<html><div align=\"right\"> <font size=\"5\">0 TL</font><br> <tag> Purchase Price </tag></div> <html>");
        lblTotalPprice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblTotalPprice.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblTotalPprice.setIconTextGap(140);
        lblTotalPprice.setOpaque(true);
        jPanel1.add(lblTotalPprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 310, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTotalPprice;
    private javax.swing.JLabel lblTotalProduct;
    // End of variables declaration//GEN-END:variables
}
