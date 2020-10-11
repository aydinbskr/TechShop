
import All_Classes.Customer;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class customer extends javax.swing.JInternalFrame {

    
    int index=-1;
    Customer c;
    public customer() {
        initComponents();
        
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        addRowTable();
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ButtonsRenderer());
        jTable1.getColumnModel().getColumn(4).setCellEditor(new ButtonsEditor(jTable1)); 
         jTable1.getColumnModel().getColumn(4).setPreferredWidth(28);
         JTableHeader header=jTable1.getTableHeader();
         header.setFont(new java.awt.Font("Segoe UI", 0, 14));
         header.setForeground(new java.awt.Color(115, 110, 107));
         jTable1.setTableHeader(header);
        
       
    }
  class ButtonsPanel extends JPanel {
  public final List<JButton> buttons = Arrays.asList(new JButton(), new JButton());

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
    
    panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-16.png")));
    panel.buttons.get(1).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-16.png")));

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
    DefaultTableModel model=(DefaultTableModel)table.getModel();
    JOptionPane.showMessageDialog(table, "deleting");
   SystemClass.removeCustomer((int)table.getModel().getValueAt(table.getSelectedRow(),0));
    model.removeRow(table.getSelectedRow());
    index=-1;
    c=null;
    table.setModel(model);
   
  }
}
class EditAction extends AbstractAction {
  private final JTable table;

  protected EditAction(JTable table) {
    super();
    this.table = table;
  }

  @Override public void actionPerformed(ActionEvent e) {
     
        
        index=(int)table.getModel().getValueAt(table.getSelectedRow(),0);
        c=SystemClass.searchCustomer(index);
        txtName.setText(c.getName()+","+c.getSurname());
        txtTel.setText(c.getTel());
      
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
    panel.buttons.get(0).setAction(new EditAction(table));
    panel.buttons.get(1).setAction(new deleteAction(table));
    
    EditingStopHandler handler = new EditingStopHandler();
    for (JButton b: panel.buttons) {
      b.addMouseListener(handler);
      b.addActionListener(handler);
    }
    panel.addMouseListener(handler);
  }

  @Override public Component getTableCellEditorComponent(JTable tbl, Object value, boolean isSelected, int row, int column) {
    panel.setBackground(tbl.getSelectionBackground());
     panel.buttons.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-16.png")));
     panel.buttons.get(1).setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-16.png")));
    return panel;
  }

  @Override public Object getCellEditorValue() {
    return "";
  }
}
public void addRowTable(){
   
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.getDataVector().removeAllElements();
    ArrayList<Customer> list=SystemClass.getAllCustomer();
        
           Object rowdata[]=new Object[4];
            for (int i = 0; i < list.size(); i++) {
            rowdata[0]=list.get(i).getId();
            rowdata[1]=list.get(i).getName();
            rowdata[2]=list.get(i).getSurname();
            rowdata[3]=list.get(i).getTel();
    
            model.addRow(rowdata);
            
            } 
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(750, 510));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setBackground(new java.awt.Color(214, 81, 72));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh-2-24.png"))); // NOI18N
        btnRefresh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setIconTextGap(0);
        btnRefresh.setOpaque(true);
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRefreshMouseExited(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 137, 30, 30));

        jLabel1.setBackground(new java.awt.Color(65, 105, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 248));
        jLabel1.setText("Customer Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 750, 42));

        jTextField1.setBackground(new java.awt.Color(248, 248, 248));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(138, 139, 141));
        jTextField1.setText("Enter surname");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 730, 40));

        jTable1.setBackground(new java.awt.Color(248, 248, 248));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(149, 158, 163));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Surname", "Tel", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 730, 260));

        jLabel2.setBackground(new java.awt.Color(65, 105, 225));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 248, 248));
        jLabel2.setText("Customer Management");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 42));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 50, 54));
        jLabel3.setText("Name,Surname");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtName.setBackground(new java.awt.Color(248, 248, 248));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(138, 139, 141));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 40));

        txtTel.setBackground(new java.awt.Color(248, 248, 248));
        txtTel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTel.setForeground(new java.awt.Color(138, 139, 141));
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 210, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 50, 54));
        jLabel4.setText("Tel");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        btnAdd.setBackground(new java.awt.Color(65, 105, 225));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        try {
            String name[]=txtName.getText().split(",");
            String tel=txtTel.getText();
            if(index==-1){
                Customer newc=new Customer(name[0],name[1],tel);
                SystemClass.addCustomer(newc); 
            }
            else{
                c.setName(name[0]);
                c.setSurname(name[1]);
                c.setTel(tel);
                SystemClass.updateCustomer(index,c);
                index=-1;
                c=null;
            }
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,e);
        }
        txtName.setText("");
        txtTel.setText("");
        addRowTable();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnAdd.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        setCursor(Cursor.getDefaultCursor());
        btnAdd.setBackground(new java.awt.Color(65,105,225));
    }//GEN-LAST:event_btnAddMouseExited

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
       jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
             model.getDataVector().removeAllElements();
             model.fireTableDataChanged();
            c=SystemClass.getCustomer(jTextField1.getText());
           
           Object rowdata[]=new Object[4];
           if(c!=null){
              rowdata[0]=c.getId();
              rowdata[1]=c.getName();
              rowdata[2]=c.getSurname();
              rowdata[3]=c.getTel();    
              model.addRow(rowdata);
              c=null; 
           }
     
       }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        addRowTable();

    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseEntered
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        setCursor(cu);
        btnRefresh.setBackground(new java.awt.Color(98,184,95));
    }//GEN-LAST:event_btnRefreshMouseEntered

    private void btnRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseExited
       setCursor(Cursor.getDefaultCursor());
        btnRefresh.setBackground(new java.awt.Color(214,81,72));
    }//GEN-LAST:event_btnRefreshMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
