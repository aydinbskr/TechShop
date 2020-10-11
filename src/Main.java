
import All_Classes.User;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Main extends javax.swing.JFrame {
    User loginuser;
    public Main(User u) {
        initComponents();
        loginuser=u;
        btnExit.setText("  Exit("+loginuser.getUsername()+")");
        btnCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
            btnCustomers.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {
             setCursor(Cursor.getDefaultCursor());
             btnCustomers.setBackground(new java.awt.Color(61,73,87));
        }
        });
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
            btnExit.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {      
             setCursor(Cursor.getDefaultCursor());
             btnExit.setBackground(new java.awt.Color(61,73,87));
        }
        });
         btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
            btnProduct.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {       
             setCursor(Cursor.getDefaultCursor());
             btnProduct.setBackground(new java.awt.Color(61,73,87));
        }
        });
         btnStocks.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
            btnStocks.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {      
             setCursor(Cursor.getDefaultCursor());
             btnStocks.setBackground(new java.awt.Color(61,73,87));
        }
        });
         btnSystem.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
             btnSystem.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {       
             setCursor(Cursor.getDefaultCursor());
              btnSystem.setBackground(new java.awt.Color(61,73,87));
        }
        });
         btnSales.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
             btnSales.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {       
             setCursor(Cursor.getDefaultCursor());
             btnSales.setBackground(new java.awt.Color(61,73,87));
        }
        });
         btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
             btnReturn.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {       
             setCursor(Cursor.getDefaultCursor());
             btnReturn.setBackground(new java.awt.Color(61,73,87));
        }
        });
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
               btnReport.setBackground(new java.awt.Color(98,184,95));
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {       
             setCursor(Cursor.getDefaultCursor());
              btnReport.setBackground(new java.awt.Color(61,73,87));
        }
        });
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        btnCustomers = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        btnProduct = new javax.swing.JLabel();
        btnStocks = new javax.swing.JLabel();
        btnReturn = new javax.swing.JLabel();
        btnReport = new javax.swing.JLabel();
        btnSystem = new javax.swing.JLabel();
        btnSales = new javax.swing.JLabel();
        upPanel = new javax.swing.JPanel();
        lblFilepath = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftPanel.setBackground(new java.awt.Color(61, 73, 87));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCustomers.setBackground(new java.awt.Color(61, 73, 87));
        btnCustomers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/businessman-32.png"))); // NOI18N
        btnCustomers.setText("  Customers");
        btnCustomers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnCustomers.setOpaque(true);
        btnCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomersMouseClicked(evt);
            }
        });
        leftPanel.add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 230, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shop-48.png"))); // NOI18N
        jLabel2.setText("TechShop");
        leftPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnExit.setBackground(new java.awt.Color(61, 73, 87));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power-32.png"))); // NOI18N
        btnExit.setText("  Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        leftPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 230, 50));

        btnProduct.setBackground(new java.awt.Color(61, 73, 87));
        btnProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product-32.png"))); // NOI18N
        btnProduct.setText("  Products");
        btnProduct.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnProduct.setOpaque(true);
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductMouseClicked(evt);
            }
        });
        leftPanel.add(btnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 50));

        btnStocks.setBackground(new java.awt.Color(61, 73, 87));
        btnStocks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnStocks.setForeground(new java.awt.Color(255, 255, 255));
        btnStocks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categorize-32.png"))); // NOI18N
        btnStocks.setText("  Stocks");
        btnStocks.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnStocks.setOpaque(true);
        btnStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStocksMouseClicked(evt);
            }
        });
        leftPanel.add(btnStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 230, 50));

        btnReturn.setBackground(new java.awt.Color(61, 73, 87));
        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-32.png"))); // NOI18N
        btnReturn.setText("  Return Process");
        btnReturn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnReturn.setOpaque(true);
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturnMouseClicked(evt);
            }
        });
        leftPanel.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 230, 50));

        btnReport.setBackground(new java.awt.Color(61, 73, 87));
        btnReport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report-3-32.png"))); // NOI18N
        btnReport.setText("  Sale Reports");
        btnReport.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnReport.setOpaque(true);
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
        });
        leftPanel.add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 230, 50));

        btnSystem.setBackground(new java.awt.Color(61, 73, 87));
        btnSystem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSystem.setForeground(new java.awt.Color(255, 255, 255));
        btnSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings-4-32.png"))); // NOI18N
        btnSystem.setText("  System and Users");
        btnSystem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnSystem.setOpaque(true);
        btnSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSystemMouseClicked(evt);
            }
        });
        leftPanel.add(btnSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 230, 50));

        btnSales.setBackground(new java.awt.Color(61, 73, 87));
        btnSales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSales.setForeground(new java.awt.Color(255, 255, 255));
        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash-receiving-32.png"))); // NOI18N
        btnSales.setText("  Sales");
        btnSales.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnSales.setOpaque(true);
        btnSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalesMouseClicked(evt);
            }
        });
        leftPanel.add(btnSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 50));

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 610));

        upPanel.setBackground(new java.awt.Color(61, 73, 87));

        javax.swing.GroupLayout upPanelLayout = new javax.swing.GroupLayout(upPanel);
        upPanel.setLayout(upPanelLayout);
        upPanelLayout.setHorizontalGroup(
            upPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        upPanelLayout.setVerticalGroup(
            upPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(upPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 750, 60));

        lblFilepath.setBackground(new java.awt.Color(240, 240, 250));
        lblFilepath.setForeground(new java.awt.Color(96, 130, 155));
        lblFilepath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-7-24.png"))); // NOI18N
        lblFilepath.setText("TechShop");
        lblFilepath.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(214, 214, 226)));
        lblFilepath.setOpaque(true);
        getContentPane().add(lblFilepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 750, 40));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 750, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomersMouseClicked
        lblFilepath.setText("TechShop>Customers");
        jDesktopPane1.removeAll();
        customer c=new customer();
         jDesktopPane1.add(c).setVisible(true);
    }//GEN-LAST:event_btnCustomersMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseClicked
       if(!loginuser.getAuthority().equals("LIMITED")){
        lblFilepath.setText("TechShop>Products");
        jDesktopPane1.removeAll();
        products c=new products();
        jDesktopPane1.add(c).setVisible(true);
       }
       else{
           JOptionPane.showMessageDialog(this,"NOT ALLOWED");
       }
    }//GEN-LAST:event_btnProductMouseClicked

    private void btnStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStocksMouseClicked
        lblFilepath.setText("TechShop>Stocks");
        jDesktopPane1.removeAll();
        stock c=new stock();
         jDesktopPane1.add(c).setVisible(true);
    }//GEN-LAST:event_btnStocksMouseClicked

    private void btnReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseClicked
        jDesktopPane1.removeAll();
        returnform c=new returnform();
         jDesktopPane1.add(c).setVisible(true);
    }//GEN-LAST:event_btnReturnMouseClicked

    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        lblFilepath.setText("TechShop>Reports");
        jDesktopPane1.removeAll();
        reports c=new reports();
         jDesktopPane1.add(c).setVisible(true);
    }//GEN-LAST:event_btnReportMouseClicked

    private void btnSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSystemMouseClicked
        if(!loginuser.getAuthority().equals("LIMITED")){
        lblFilepath.setText("TechShop>System and Users");
        jDesktopPane1.removeAll();
        systemfrm c=new systemfrm();
         jDesktopPane1.add(c).setVisible(true);
        }
        else{
           JOptionPane.showMessageDialog(this,"NOT ALLOWED");
       }
    }//GEN-LAST:event_btnSystemMouseClicked

    private void btnSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesMouseClicked
       lblFilepath.setText("TechShop>Sales");
        jDesktopPane1.removeAll();
        sale c=new sale(loginuser);
         jDesktopPane1.add(c).setVisible(true);
    }//GEN-LAST:event_btnSalesMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCustomers;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnProduct;
    private javax.swing.JLabel btnReport;
    private javax.swing.JLabel btnReturn;
    private javax.swing.JLabel btnSales;
    private javax.swing.JLabel btnStocks;
    private javax.swing.JLabel btnSystem;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFilepath;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel upPanel;
    // End of variables declaration//GEN-END:variables
}
