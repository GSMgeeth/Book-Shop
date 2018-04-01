/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//check push
import bookshop.Batch;
import bookshop.Category;
import bookshop.Database;
import bookshop.SqlConnection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geeth Sandaru
 */
public class BatchWindow extends javax.swing.JFrame {

    /**
     * Creates new form BatchWindow
     */
    public BatchWindow() {
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
        jXTableBatchMng = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        btnBatchDel = new javax.swing.JButton();
        btnBatchAdd = new javax.swing.JButton();
        txtBatchSellingPrice = new javax.swing.JTextField();
        btnBatchUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBatchClear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBatchBuyingPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Price Batch Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jXTableBatchMng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch ID", "Buying price", "Selling price", "Creator ID"
            }
        ));
        jXTableBatchMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableBatchMngMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jXTableBatchMng);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBatchDel.setText("Delete");
        btnBatchDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchDelActionPerformed(evt);
            }
        });

        btnBatchAdd.setText("Add");
        btnBatchAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchAddActionPerformed(evt);
            }
        });

        txtBatchSellingPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBatchUpdate.setText("Update");
        btnBatchUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Selling Price");

        btnBatchClear.setText("Clear");
        btnBatchClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchClearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Buying Price");

        txtBatchBuyingPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBatchSellingPrice)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(btnBatchAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBatchUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBatchClear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBatchDel))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBatchBuyingPrice)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBatchBuyingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBatchSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatchAdd)
                    .addComponent(btnBatchUpdate)
                    .addComponent(btnBatchDel)
                    .addComponent(btnBatchClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jXTableBatchMngMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableBatchMngMouseReleased
        DefaultTableModel batchTbl = (DefaultTableModel)jXTableBatchMng.getModel();
        
        if (jXTableBatchMng.getSelectedRow() != -1)
        {
            txtBatchBuyingPrice.setText(batchTbl.getValueAt(jXTableBatchMng.getSelectedRow(), 1).toString());
            txtBatchSellingPrice.setText(batchTbl.getValueAt(jXTableBatchMng.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jXTableBatchMngMouseReleased

    private void btnBatchDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchDelActionPerformed
        try
        {
            DefaultTableModel batchTbl = (DefaultTableModel)jXTableBatchMng.getModel();
            ResultSet rsBatch = SqlConnection.getData("SELECT DISTINCT batch_id AS batch_id FROM grn_copy");
            int checker = 0;
            
            if (jXTableBatchMng.getSelectedRow() != -1)
            {
                int batchId = Integer.parseInt(batchTbl.getValueAt(jXTableBatchMng.getSelectedRow(), 0).toString());
                
                while (rsBatch.next())
                {
                    if (batchId == rsBatch.getInt("batch_id"))
                    {
                        CannotDeleteBatchDialog cdbd = new CannotDeleteBatchDialog(this, rootPaneCheckingEnabled);
                        cdbd.setVisible(true);
                        checker = 1;
                        break;
                    }
                }
                
                if (checker == 0)
                {
                    Database db = new Database();
                    Batch batch = new Batch();
                    
                    batch.setId(batchId);
                    db.deleteBatch(batch);
                    refBatch();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBatchDelActionPerformed

    private void btnBatchAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchAddActionPerformed
        try
        {
            Database db = new Database();
            Batch batch = new Batch();
            
            float buyingPrice = Float.parseFloat(txtBatchBuyingPrice.getText());
            float sellingPrice = Float.parseFloat(txtBatchSellingPrice.getText());
            batch.setBuyingPrice(buyingPrice);
            batch.setSellingPrice(sellingPrice);
            batch.setUserId(2);
            
            db.saveBatch(batch);
            
            refBatch();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBatchAddActionPerformed

    private void btnBatchUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchUpdateActionPerformed
        try
        {
            Database db = new Database();
            Batch batch = new Batch();
            DefaultTableModel batchTbl = (DefaultTableModel)jXTableBatchMng.getModel();
            
            if (jXTableBatchMng.getSelectedRow() != -1)
            {
                int batchId = Integer.parseInt(batchTbl.getValueAt(jXTableBatchMng.getSelectedRow(), 0).toString());
                int userId = Integer.parseInt(batchTbl.getValueAt(jXTableBatchMng.getSelectedRow(), 3).toString());
                batch.setId(batchId);
                batch.setUserId(userId);
            }
            
            float buyingPrice = Float.parseFloat(txtBatchBuyingPrice.getText());
            float sellingPrice = Float.parseFloat(txtBatchSellingPrice.getText());
            batch.setBuyingPrice(buyingPrice);
            batch.setSellingPrice(sellingPrice);
            
            db.updateBatch(batch);
            
            refBatch();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBatchUpdateActionPerformed

    private void btnBatchClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchClearActionPerformed
        txtBatchSellingPrice.setText("");
        txtBatchBuyingPrice.setText("");
    }//GEN-LAST:event_btnBatchClearActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated
    
    private void first()
    {
        refBatch();
    }
    
    private void refBatch()
    {
        DefaultTableModel batchTbl = (DefaultTableModel)jXTableBatchMng.getModel();
        Vector rawData = new Vector();
        
        try
        {
            ResultSet rsBatch = SqlConnection.getData("SELECT batch_id, buying_price, selling_price, user_id FROM batch");
        
            batchTbl.setRowCount(0);

            while (rsBatch.next())
            {
                rawData.add(rsBatch.getInt("batch_id"));
                rawData.add(rsBatch.getFloat("buying_price"));
                rawData.add(rsBatch.getFloat("selling_price"));
                rawData.add(rsBatch.getInt("user_id"));
                batchTbl.addRow(rawData);
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
            java.util.logging.Logger.getLogger(BatchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatchWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatchAdd;
    private javax.swing.JButton btnBatchClear;
    private javax.swing.JButton btnBatchDel;
    private javax.swing.JButton btnBatchUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXTable jXTableBatchMng;
    private javax.swing.JTextField txtBatchBuyingPrice;
    private javax.swing.JTextField txtBatchSellingPrice;
    // End of variables declaration//GEN-END:variables
}
