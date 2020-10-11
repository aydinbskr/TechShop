
import All_Classes.User;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class systemfrm extends javax.swing.JInternalFrame {
    
    public systemfrm() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        addRowTable();
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new ButtonsRenderer());
        jTable1.getColumnModel().getColumn(5).setCellEditor(new ButtonsEditor(jTable1)); 

        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Cursor cu=new Cursor(Cursor.HAND_CURSOR);
            setCursor(cu);
            btnAdd.setBackground(new java.awt.Color(98,184,95));
         }

         public void mouseExited(java.awt.event.MouseEvent evt) {
          
             setCursor(Cursor.getDefaultCursor());
             btnAdd.setBackground(new java.awt.Color(214,81,72));
        }
        });
       
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
   SystemClass.removeUser(table.getModel().getValueAt(table.getSelectedRow(),2).toString());
    model.removeRow(table.getSelectedRow());
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
        String username=table.getModel().getValueAt(table.getSelectedRow(),2).toString();
        user frm=new user(systemfrm.this,username);
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
    ArrayList<User> list=SystemClass.getAllUser();
        
           Object rowdata[]=new Object[5];
            for (int i = 0; i < list.size(); i++) {
            rowdata[0]=list.get(i).getName();
            rowdata[1]=list.get(i).getSurname();
            rowdata[2]=list.get(i).getUsername();
            rowdata[3]=list.get(i).getPassword();
            rowdata[4]=list.get(i).getAuthority();
    
            model.addRow(rowdata);
            
            } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(750, 510));

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setBackground(new java.awt.Color(214, 81, 72));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus-24.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 7, 80, 30));

        jLabel1.setBackground(new java.awt.Color(65, 105, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 248));
        jLabel1.setText("User Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 42));

        jTable1.setBackground(new java.awt.Color(248, 248, 248));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(149, 158, 163));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname", "Username", "Password", "Authority", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
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
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 690, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        user frm=new user(this,null);
        frm.setVisible(true);
      
        
    }//GEN-LAST:event_btnAddMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
