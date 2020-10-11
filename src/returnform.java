
import All_Classes.Sale;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class returnform extends javax.swing.JInternalFrame {

    public returnform() {
        initComponents();
        
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new ButtonsRenderer());
        jTable1.getColumnModel().getColumn(7).setCellEditor(new ButtonsEditor(jTable1)); 
       
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
    
 class ButtonsRenderer implements TableCellRenderer {
  private final ButtonsPanel panel = new ButtonsPanel();

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
    
    panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-16.png")));

    return panel;
  }
}
 class deleteAction extends AbstractAction {
  private final JTable table;

  protected deleteAction(JTable table) {
    super();
    this.table = table;
  }

  @Override public void actionPerformed(ActionEvent e) {
      int saleid=(int)table.getModel().getValueAt(table.getSelectedRow(),0);
      System.out.println(saleid);
      newReturn frm=new newReturn(returnform.this,saleid,table.getSelectedRow());
      frm.setVisible(true);
  }
}

class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {
  protected final ButtonsPanel panel = new ButtonsPanel();
  protected final JTable table;

  private class EditingStopHandler extends MouseAdapter implements ActionListener {
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
    
    EditingStopHandler handler = new EditingStopHandler();
    for (JButton b: panel.buttons) {
      b.addMouseListener(handler);
      b.addActionListener(handler);
    }
    panel.addMouseListener(handler);
  }

  @Override public Component getTableCellEditorComponent(JTable tbl, Object value, boolean isSelected, int row, int column) {
    panel.setBackground(tbl.getSelectionBackground());
     panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-16.png")));
    return panel;
  }

  @Override public Object getCellEditorValue() {
    return "";
  }
}

     public void addRowTable(Sale s){
      
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();    
           Object rowdata[]=new Object[7];
          
           if(s!=null){
                for (int j = 0; j < s.getBasket().getBasketitems().size(); j++) {
                    rowdata[0]=s.getId();
                    rowdata[1]=s.getBasket().getBasketitems().get(j).getProd().getName();
                    rowdata[2]=s.getBasket().getBasketitems().get(j).getProd().getS_price();
                    rowdata[3]=s.getBasket().getBasketitems().get(j).getAmount();
                    rowdata[4]=s.getBasket().getBasketitems().get(j).getAmount()*s.getBasket().getBasketitems().get(j).getProd().getS_price();
                    rowdata[5]=s.getCashorcredit();
                    rowdata[6]=s.displayDate();
                    model.addRow(rowdata);
                }
           }
           
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSaleid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(65, 105, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 248));
        jLabel1.setText("Return");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 730, 42));

        txtSaleid.setBackground(new java.awt.Color(248, 248, 248));
        txtSaleid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSaleid.setForeground(new java.awt.Color(138, 139, 141));
        txtSaleid.setText("Enter sale id");
        txtSaleid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSaleidMouseClicked(evt);
            }
        });
        txtSaleid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaleidKeyPressed(evt);
            }
        });
        jPanel1.add(txtSaleid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 560, 40));

        jLabel2.setBackground(new java.awt.Color(65, 105, 225));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 248, 248));
        jLabel2.setText("Return");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 42));

        btnStart.setBackground(new java.awt.Color(65, 105, 225));
        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStart.setText("Start");
        btnStart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnStart.setOpaque(true);
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStartMouseExited(evt);
            }
        });
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 130, 40));

        jTable1.setBackground(new java.awt.Color(248, 248, 248));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(149, 158, 163));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Product Name", "Price", "Amount", "Total Price", "Payment", "Date", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(15);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 710, 320));

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

    private void btnStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseClicked
        try {
            int id=Integer.parseInt(txtSaleid.getText());
            addRowTable(SystemClass.getSale(id));
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"ENTER A NUMBER ");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,e);
        }
        
    }//GEN-LAST:event_btnStartMouseClicked

    private void btnStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnStart.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnStartMouseEntered

    private void btnStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnStart.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnStartMouseExited

    private void txtSaleidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSaleidMouseClicked
       txtSaleid.setText("");
    }//GEN-LAST:event_txtSaleidMouseClicked

    private void txtSaleidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleidKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          try {
            int id=Integer.parseInt(txtSaleid.getText());
            addRowTable(SystemClass.getSale(id));
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"ENTER A NUMBER ");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,e);
        } 
       }
    }//GEN-LAST:event_txtSaleidKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSaleid;
    // End of variables declaration//GEN-END:variables
}
