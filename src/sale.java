
import All_Classes.Basket;
import All_Classes.BasketItem;
import All_Classes.Customer;
import All_Classes.Sale;
import All_Classes.User;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class sale extends javax.swing.JInternalFrame {

    Basket mybasket=new Basket();
    int row=0;//basket item eklendikce artacak
    int spinnervalue=1;
    DecimalFormat df=new DecimalFormat(".##");
   User loginuser;
    public sale(User u) {
        initComponents();
        loginuser=u;
        cmbCustomer.setModel(new DefaultComboBoxModel(SystemClass.getCustomerList().toArray()));
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new SpinnerRenderer());
        jTable1.getColumnModel().getColumn(2).setCellEditor(new SpinnerEditor());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new ButtonsRenderer());
        jTable1.getColumnModel().getColumn(5).setCellEditor(new ButtonsEditor(jTable1)); 
       
         JTableHeader header=jTable1.getTableHeader();
         header.setFont(new java.awt.Font("Segoe UI", 0, 14));
         header.setForeground(new java.awt.Color(115, 110, 107));
         jTable1.setTableHeader(header);
       
        
    }
 class ButtonsPanel extends JPanel {
  public final List<JButton> buttons = Arrays.asList(new JButton());

  protected ButtonsPanel() {
    super(); 
    setOpaque(true);
    for (JButton b: buttons) {
      b.setFocusable(false);
      b.setRolloverEnabled(false);
      add(b);
    }
  }
}
 class SpinnerPanel extends JPanel {
  public final JSpinner spinner = new JSpinner();

  protected SpinnerPanel() {
    super(); 
    setOpaque(true);
    spinner.setFocusable(false);
    spinner.setModel(new javax.swing.SpinnerNumberModel(1,1,null,1));
    spinner.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
    spinner.setPreferredSize(new Dimension(45,30));
    add(spinner);
  }
}
    
 class ButtonsRenderer implements TableCellRenderer {
  private final ButtonsPanel panel = new ButtonsPanel();

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
    
 
    panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-16.png")));

    return panel;
  }
}
class SpinnerRenderer implements TableCellRenderer {
  private final SpinnerPanel renderer = new SpinnerPanel();

  @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    renderer.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
    renderer.spinner.setValue((Integer)value);
    return renderer;
  }
}
 
class deleteAction extends AbstractAction {
  private final JTable table;

  protected deleteAction(JTable table) {
    super();
    this.table = table;
  }
   ///DELETING
  @Override public void actionPerformed(ActionEvent e) {
    DefaultTableModel model=(DefaultTableModel)table.getModel();
    JOptionPane.showMessageDialog(table, "deleting");
    mybasket.removeItemFromBasket(table.getSelectedRow());
    model.removeRow(table.getSelectedRow());
    System.out.println("basketitems sayı:"+mybasket.getBasketitems().size());
    row--;
    lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl."); 
    table.setModel(model);
  }
}

class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {
  protected final ButtonsPanel panel = new ButtonsPanel();
  protected final JTable table;

  private class deletingStopHandler extends MouseAdapter implements ActionListener {
    @Override public void mousePressed(MouseEvent e) {
      Object o = e.getSource();
      if (o instanceof TableCellEditor) {
        actionPerformed(null);
      } else if (o instanceof JButton) {
        // DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
        ButtonModel m = ((JButton) e.getComponent()).getModel();
        if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
          panel.setBackground(table.getBackground());
          
         
        }
      }
    }

    @Override public void actionPerformed(ActionEvent e) {
      EventQueue.invokeLater(() -> fireEditingStopped());
    }
  }

  protected ButtonsEditor(JTable table) {
    super();
    this.table = table;
    panel.buttons.get(0).setAction(new deleteAction(table));
    
    deletingStopHandler handler = new deletingStopHandler();
    for (JButton b: panel.buttons) {
      b.addMouseListener(handler);
      b.addActionListener(handler);
    }
    panel.addMouseListener(handler);
  }
 
  @Override public Component getTableCellEditorComponent(JTable tbl, Object value, boolean isSelected, int row, int column) {
    panel.setBackground(tbl.getSelectionBackground());
  
     panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-16.png")));
    return panel;
  }

  @Override public Object getCellEditorValue() {
    return "";
  }
}
class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
  private final SpinnerPanel renderer = new SpinnerPanel();
 
  private class SpinnersStopHandler extends MouseAdapter implements ChangeListener {
     
///############ SPINNER CHANCING EVENT ######################
    @Override public void stateChanged(ChangeEvent e) {
      
      if(jTable1.getEditingRow()!=-1){
          int selecteditem=mybasket.basketItemindexOf(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
          System.out.println("\nselected item barcode:"+selecteditem);
          spinnervalue=Integer.parseInt(renderer.spinner.getValue().toString());
          if(spinnervalue>=mybasket.getBasketitems().get(selecteditem).getProd().getAmount()){
             JOptionPane.showMessageDialog(jTable1, "YOU REACHED MAXIMUM PRODUCT AMOUNT"); 
          }
          mybasket.getBasketitems().get(selecteditem).setAmount(spinnervalue);
          
          mybasket.updateBasketSum();//BASKET SUM UPDATE
          System.out.println("BASKET SUM:"+mybasket.getBasketSum());
          double itemPrice=Double.parseDouble(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
          jTable1.setValueAt((double)spinnervalue*itemPrice,jTable1.getSelectedRow(),4);
          System.out.println("Selected row:"+jTable1.getEditingRow());
          for (int i = 0; i < mybasket.getBasketitems().size(); i++) {
           System.out.println("basketitem"+(i+1)+":"+mybasket.getBasketitems().get(i).getAmount()); 
          }
      ///################ BASKET TOTAL
      lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl.");  
      }
      
    }

    
  }
  
  protected SpinnerEditor() {
    super();
    SpinnersStopHandler handler = new SpinnersStopHandler();
    renderer.spinner.addChangeListener(handler);
    
  }
  @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    renderer.setBackground(table.getSelectionBackground());
    renderer.spinner.setValue((Integer)value);
    return renderer;
  }

  @Override public Object getCellEditorValue() {
    return renderer.spinner.getValue();
  }
  
  @Override public boolean stopCellEditing() {
    try {
      renderer.spinner.commitEdit();
    } catch (ParseException ex) {
      Toolkit.getDefaultToolkit().beep();
      return false;
    }
    return super.stopCellEditing();
    
  }
}
    
    public void addRowTable(){
        
         DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
             
           Object rowdata[]=new Object[5];
          
           if(mybasket!=null){
              rowdata[0]=mybasket.getBasketItem().getProd().getBarkod();
              rowdata[1]=mybasket.getBasketItem().getProd().getName();
              rowdata[2]=1; 
              rowdata[3]=mybasket.getBasketItem().getProd().getS_price(); 
              rowdata[4]=mybasket.getBasketItem().getAmount()* mybasket.getBasketItem().getProd().getS_price();
              model.addRow(rowdata);
              
           }
           
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBasket = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCreditCard = new javax.swing.JLabel();
        btnSell = new javax.swing.JLabel();
        btnCustomer = new javax.swing.JLabel();
        btnCash = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JLabel();

        setMaximizable(true);
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(750, 510));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBasket.setBackground(new java.awt.Color(65, 105, 225));
        lblBasket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBasket.setForeground(new java.awt.Color(248, 248, 248));
        lblBasket.setText("Total basket is 0 tl / KDV is 0 tl / General Total Basket is 0 tl.");
        lblBasket.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblBasket.setOpaque(true);
        jPanel1.add(lblBasket, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 730, 42));

        txtBarcode.setBackground(new java.awt.Color(248, 248, 248));
        txtBarcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBarcode.setForeground(new java.awt.Color(138, 139, 141));
        txtBarcode.setText("Enter barkod or name");
        txtBarcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBarcodeMouseClicked(evt);
            }
        });
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
        });
        jPanel1.add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 570, 40));

        jLabel2.setBackground(new java.awt.Color(65, 105, 225));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 248, 248));
        jLabel2.setText("Sale Screen");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 42));

        jTable1.setBackground(new java.awt.Color(248, 248, 248));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(149, 158, 163));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product Name", "Amount", "Price", "Total", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText(""); // NOI18N
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
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 710, 220));

        btnCreditCard.setBackground(new java.awt.Color(65, 105, 225));
        btnCreditCard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCreditCard.setForeground(new java.awt.Color(255, 255, 255));
        btnCreditCard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCreditCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/card-inserting-32.png"))); // NOI18N
        btnCreditCard.setText(" Card");
        btnCreditCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnCreditCard.setOpaque(true);
        btnCreditCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreditCardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreditCardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreditCardMouseExited(evt);
            }
        });
        jPanel1.add(btnCreditCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 130, 40));

        btnSell.setBackground(new java.awt.Color(65, 105, 225));
        btnSell.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSell.setForeground(new java.awt.Color(255, 255, 255));
        btnSell.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSell.setText("Sell");
        btnSell.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnSell.setOpaque(true);
        btnSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSellMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSellMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSellMouseExited(evt);
            }
        });
        jPanel1.add(btnSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 130, 40));

        btnCustomer.setBackground(new java.awt.Color(65, 105, 225));
        btnCustomer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCustomer.setText("New Customer");
        btnCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnCustomer.setOpaque(true);
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustomerMouseExited(evt);
            }
        });
        jPanel1.add(btnCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 150, 40));

        btnCash.setBackground(new java.awt.Color(65, 105, 225));
        btnCash.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCash.setForeground(new java.awt.Color(255, 255, 255));
        btnCash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banknotes-32.png"))); // NOI18N
        btnCash.setText(" Cash");
        btnCash.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnCash.setOpaque(true);
        btnCash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCashMouseExited(evt);
            }
        });
        jPanel1.add(btnCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 130, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 50, 54));
        jLabel3.setText("Select Customer :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        cmbCustomer.setBackground(new java.awt.Color(248, 248, 248));
        cmbCustomer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbCustomer.setForeground(new java.awt.Color(138, 139, 141));
        cmbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GUEST" }));
        jPanel1.add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 560, 40));

        btnClear.setBackground(new java.awt.Color(65, 105, 225));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnClear.setOpaque(true);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearMouseExited(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreditCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreditCardMouseClicked
        try{
        Customer c=SystemClass.getCustomer(cmbCustomer.getSelectedIndex());
        Sale s =new Sale(c,loginuser,"CREDIT",mybasket);
        if(mybasket.getBasketitems().size()>0){
          SystemClass.addSale(s);
          JOptionPane.showMessageDialog(this,s.displayReceipt(),"RECEIPT",1);  
        }
        else{
             JOptionPane.showMessageDialog(this,"THE BASKET IS NULL!");
        }   
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        mybasket=null;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        mybasket=new Basket();
        lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl.");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"SELECT A CUSTOMER PLEASE!");
        }
        
    }//GEN-LAST:event_btnCreditCardMouseClicked

    private void btnCreditCardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreditCardMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnCreditCard.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnCreditCardMouseEntered

    private void btnCreditCardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreditCardMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnCreditCard.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnCreditCardMouseExited
    
    private void btnSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSellMouseClicked
       
        if(SystemClass.getProduct(txtBarcode.getText())!=null){
            int b_item=mybasket.basketItemindexOf(txtBarcode.getText());
            
            if(b_item!=-1){  
                System.out.println("Aynı barkode girildi");
                jTable1.setValueAt(mybasket.getBasketitems().get(b_item).getAmount()+1,b_item,2);
                jTable1.setValueAt((int)jTable1.getValueAt(b_item, 2)*(double)jTable1.getValueAt(b_item, 3),b_item,4);
                mybasket.getBasketitems().get(b_item).setAmount(mybasket.getBasketitems().get(b_item).getAmount()+1);
                System.out.println("Basket item:"+mybasket.getBasketitems().get(b_item).getAmount());
                mybasket.updateBasketSum();//BASKET SUM UPDATE
                
              }
            else{
                int amount=1;
                mybasket.addToBasket(SystemClass.getProduct(txtBarcode.getText()),amount);
                addRowTable();
                row++;    
          }
            
        }
      lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl.");  
    }//GEN-LAST:event_btnSellMouseClicked

    private void btnSellMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSellMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnSell.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnSellMouseEntered

    private void btnSellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSellMouseExited
      setCursor(Cursor.getDefaultCursor());
        btnSell.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnSellMouseExited

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked
        new newCustomer(cmbCustomer).setVisible(true);
    }//GEN-LAST:event_btnCustomerMouseClicked

    private void btnCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnCustomer.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnCustomerMouseEntered

    private void btnCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseExited
       setCursor(Cursor.getDefaultCursor());
        btnCustomer.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnCustomerMouseExited

    private void btnCashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCashMouseClicked
        try {
        Customer c=SystemClass.getCustomer(cmbCustomer.getSelectedIndex());
        Sale s =new Sale(c,loginuser,"CASH",mybasket);
        if(mybasket.getBasketitems().size()>0){
          SystemClass.addSale(s);
          JOptionPane.showMessageDialog(this,s.displayReceipt(),"RECEIPT",1);  
        }
        else{
             JOptionPane.showMessageDialog(this,"THE BASKET IS NULL!");
        }   
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        mybasket=null;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        mybasket=new Basket();
        lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl.");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"SELECT A CUSTOMER PLEASE!");
        }
        
            
    }//GEN-LAST:event_btnCashMouseClicked

    private void btnCashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCashMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnCash.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnCashMouseEntered

    private void btnCashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCashMouseExited
       setCursor(Cursor.getDefaultCursor());
        btnCash.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnCashMouseExited

    private void txtBarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBarcodeMouseClicked
        txtBarcode.setText("");
    }//GEN-LAST:event_txtBarcodeMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
       mybasket.clearBasket();
       mybasket=null;
       model.getDataVector().removeAllElements();
       model.fireTableDataChanged();
       mybasket=new Basket();
        lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl.");
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnClear.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnClear.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnClearMouseExited

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             if(SystemClass.getProduct(txtBarcode.getText())!=null){
            int b_item=mybasket.basketItemindexOf(txtBarcode.getText());
            
            if(b_item!=-1){  
                System.out.println("Aynı barkode girildi");
                jTable1.setValueAt(mybasket.getBasketitems().get(b_item).getAmount()+1,b_item,2);
                jTable1.setValueAt((int)jTable1.getValueAt(b_item, 2)*(double)jTable1.getValueAt(b_item, 3),b_item,4);
                mybasket.getBasketitems().get(b_item).setAmount(mybasket.getBasketitems().get(b_item).getAmount()+1);
                System.out.println("Basket item:"+mybasket.getBasketitems().get(b_item).getAmount());
                mybasket.updateBasketSum();//BASKET SUM UPDATE
                
              }
            else{
                int amount=1;
                mybasket.addToBasket(SystemClass.getProduct(txtBarcode.getText()),amount);
                addRowTable();
                row++;    
          }
            
        }
      lblBasket.setText("Total basket is "+df.format(mybasket.getBasketSum())+" tl / PAY is "
              + ""+df.format((mybasket.getBasketSumwithPay()-mybasket.getBasketSum()))+" tl / General Total Basket is "
                      + ""+df.format(mybasket.getBasketSumwithPay())+" tl.");  
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCash;
    private javax.swing.JLabel btnClear;
    private javax.swing.JLabel btnCreditCard;
    private javax.swing.JLabel btnCustomer;
    private javax.swing.JLabel btnSell;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBasket;
    private javax.swing.JTextField txtBarcode;
    // End of variables declaration//GEN-END:variables
}
