/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import bookshop.Category;
import bookshop.Database;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import bookshop.SqlConnection;
import java.util.Vector;

/**
 *
 * @author Geeth Sandaru
 */
public class CategoryWindow extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public CategoryWindow() {
        initComponents();
        first();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jXTableCategory = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        btnCatDel = new javax.swing.JButton();
        btnCatAdd = new javax.swing.JButton();
        txtCatName = new javax.swing.JTextField();
        btnCatUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCatClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Category Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category ID", "Name"
            }
        ));
        jXTableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableCategoryMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jXTableCategory);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCatDel.setText("Delete");
        btnCatDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatDelActionPerformed(evt);
            }
        });

        btnCatAdd.setText("Add");
        btnCatAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatAddActionPerformed(evt);
            }
        });

        txtCatName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCatUpdate.setText("Update");
        btnCatUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Category Name");

        btnCatClear.setText("Clear");
        btnCatClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCatName)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCatAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCatUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCatClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCatDel))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCatName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCatAdd)
                    .addComponent(btnCatUpdate)
                    .addComponent(btnCatDel)
                    .addComponent(btnCatClear))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXTableCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableCategoryMouseReleased
        DefaultTableModel catTbl = (DefaultTableModel)jXTableCategory.getModel();
        
        if (jXTableCategory.getSelectedRow() != -1)
        {
            txtCatName.setText(catTbl.getValueAt(jXTableCategory.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_jXTableCategoryMouseReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void btnCatAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatAddActionPerformed
        try
        {
            Database db = new Database();
            Category cat = new Category();
            
            String catName = txtCatName.getText();
            cat.setName(catName);
            
            db.saveCatogory(cat);
            
            refCat();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCatAddActionPerformed

    private void btnCatUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatUpdateActionPerformed
        try
        {
            Database db = new Database();
            Category cat = new Category();
            DefaultTableModel catTbl = (DefaultTableModel)jXTableCategory.getModel();
            
            if (jXTableCategory.getSelectedRow() != -1)
            {
                int catId = Integer.parseInt(catTbl.getValueAt(jXTableCategory.getSelectedRow(), 0).toString());
                cat.setId(catId);
            }
            
            String catName = txtCatName.getText();
            cat.setName(catName);
            
            db.updateCatogory(cat);
            
            refCat();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCatUpdateActionPerformed

    private void btnCatDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatDelActionPerformed
        try
        {
            DefaultTableModel catTbl = (DefaultTableModel)jXTableCategory.getModel();
            ResultSet rsCat = SqlConnection.getData("SELECT cat_id AS cat_id FROM book");
            int checker = 0;
            
            if (jXTableCategory.getSelectedRow() != -1)
            {
                int catId = Integer.parseInt(catTbl.getValueAt(jXTableCategory.getSelectedRow(), 0).toString());
                
                while (rsCat.next())
                {
                    if (catId == rsCat.getInt("cat_id"))
                    {
                        CannotDeleteCategoryDialog cdcd = new CannotDeleteCategoryDialog(this, rootPaneCheckingEnabled);
                        cdcd.setVisible(true);
                        checker = 1;
                        break;
                    }
                }
                
                if (checker == 0)
                {
                    Database db = new Database();
                    Category cat = new Category();
                    
                    cat.setId(catId);
                    db.deleteCategory(cat);
                    refCat();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCatDelActionPerformed

    private void btnCatClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatClearActionPerformed
        txtCatName.setText("");
    }//GEN-LAST:event_btnCatClearActionPerformed
    
    private void first() {
        refCat();
    }
    
    private void refCat()
    {
        DefaultTableModel catTbl = (DefaultTableModel)jXTableCategory.getModel();
        Vector rawData = new Vector();
        
        try
        {
            ResultSet rsCat = SqlConnection.getData("SELECT cat_id, cat_name FROM category");
        
            catTbl.setRowCount(0);

            while (rsCat.next())
            {
                rawData.add(rsCat.getInt("cat_id"));
                rawData.add(rsCat.getString("cat_name"));
                catTbl.addRow(rawData);
                rawData = new Vector();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CategoryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatAdd;
    private javax.swing.JButton btnCatClear;
    private javax.swing.JButton btnCatDel;
    private javax.swing.JButton btnCatUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXTable jXTableCategory;
    private javax.swing.JTextField txtCatName;
    // End of variables declaration//GEN-END:variables
}
