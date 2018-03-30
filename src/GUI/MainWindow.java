package GUI;
//push check
import Others.Comman;
import Others.DataValidater;
import bookshop.Book;
import bookshop.Book_copy;
import bookshop.Credit;
import bookshop.Customer;
import bookshop.Database;
import bookshop.Grn;
import bookshop.Grn_copy;
import bookshop.ImageWriter;
import bookshop.Invoice;
import bookshop.Invoice_copy;
import bookshop.User;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import bookshop.SqlConnection;
import bookshop.Supplier;
import bookshop.UserType;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends javax.swing.JFrame {

    private String batch_id = "batch not selected";
    private String selling_price = "batch not selected";
    
    private enum FormType {
        SAVE, UPDATE
    }
    private Database database;
    private FormType userFormType = FormType.SAVE;

    public MainWindow() {
        initComponents();
        showDateAndTime();
        first();
        database = new Database();
    }

    private void showDateAndTime() {
        new Timer(1000, e -> {
            Date today = new Date();
            String date = new SimpleDateFormat("yyyy/MM/dd").format(today);
            String time = new SimpleDateFormat("hh:mm:ss a").format(today);
            String title = "  GM Book Shop  [Corrent User: Prabath  Data :" + date + "  Time: " + time + "]";
            lblTitle.setText(title);
        }).start();
    }

    private void setUpFormForSaveUser(){
        try {
            int nextPK = Comman.getNextPK("user", "id");
            txtUserId.setText(Integer.toString(nextPK));
        } catch (Exception e) {
        }

    }

    private void clearUserForm() {
        txtUserId.setText("");
        txtUserPassword.setText("");
        txtUserNIC.setText("");
        txtUserUsername.setText("");
        txtUserAddress.setText("");
        txtUserRealName.setText("");
        DataValidater.setLookToDefault(txtUserPassword);
        DataValidater.setLookToDefault(txtUserNIC);
        DataValidater.setLookToDefault(txtUserUsername);
        DataValidater.setLookToDefault(txtUserAddress);
        DataValidater.setLookToDefault(txtUserRealName);
    }

    private void saveUser() {
        setUpFormForSaveUser();
        boolean validated
                = DataValidater.validateString(txtUserUsername, 30)
                && DataValidater.validateString(txtUserNIC, 10)
                && DataValidater.validateString(txtUserAddress, 100)
                && DataValidater.validateString(txtUserRealName, 50);
        if (validated) {
            User user = new User();
            user.setId(Integer.parseInt(txtUserId.getText()));
            try {
                database.saveUser(user);
            } catch (Exception e) {
                showMessage("SQL Error", e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            showMessage("Validation Error", "Please fill form with correct data.", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void showMessage(String title, String message, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBooksSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbBooksSearchBy = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnManageCategories = new javax.swing.JButton();
        btnManageBatches = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtAreaBookDes = new javax.swing.JTextArea();
        cmbBookCat = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btnNewBook = new javax.swing.JButton();
        txtBookImg = new javax.swing.JTextField();
        btnBookClear = new javax.swing.JButton();
        btnBookUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTableBook = new org.jdesktop.swingx.JXTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        btnNewSup = new javax.swing.JButton();
        btnSupUpdate = new javax.swing.JButton();
        btnSupActive = new javax.swing.JButton();
        btnSupActive1 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtSupId = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtSupName = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtSupTel = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtSupAddress = new javax.swing.JTextField();
        txtSupEmail = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtSupCompany = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jXTableSup = new org.jdesktop.swingx.JXTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        btnNewCustomer = new javax.swing.JButton();
        btnCustomerUpdate = new javax.swing.JButton();
        btnCustomerActive = new javax.swing.JButton();
        btnCustomerClear = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtCustomerId = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtCustomerTel = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtCustomerCompany = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jXTableCustomer = new org.jdesktop.swingx.JXTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnNewUser = new javax.swing.JButton();
        btnUserUpdate = new javax.swing.JButton();
        btnUserActive = new javax.swing.JButton();
        btnUserActive1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUserPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtUserNIC = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        lblUserImage = new javax.swing.JLabel();
        btnOpenUserImage = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtUserRealName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbUserType = new javax.swing.JComboBox<>();
        txtUserAddress = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTableUser = new org.jdesktop.swingx.JXTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jXTableViewInv = new org.jdesktop.swingx.JXTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jXTableViewInvCopy = new org.jdesktop.swingx.JXTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jXTableViewGrn = new org.jdesktop.swingx.JXTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        jXTableViewGrnCopy = new org.jdesktop.swingx.JXTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jXTableViewGrnCopyIsbn = new org.jdesktop.swingx.JXTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton14 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTableInv = new org.jdesktop.swingx.JXTable();
        jPanel26 = new javax.swing.JPanel();
        cmbBkName = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbISBN = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lblUPriceInv = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        txtDiscountInv = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lblNetPaymentInv = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblGrossPaymentInv = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        cbCredit = new javax.swing.JCheckBox();
        cmbCustomer = new javax.swing.JComboBox<>();
        jPanel38 = new javax.swing.JPanel();
        txtPaid = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        lblToPay = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lblGrossPayment = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        lblNetPayment = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtVeh = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jXTableBatch = new org.jdesktop.swingx.JXTable();
        jSeparator1 = new javax.swing.JSeparator();
        cmbSup = new javax.swing.JComboBox<>();
        cbCreditGrn = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        txtQty = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblPayment = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmbName = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jXTableGrn = new org.jdesktop.swingx.JXTable();
        jPanel40 = new javax.swing.JPanel();
        txtPaidGrn = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        lblToPayGrn = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        btnIsbnNewISBN = new javax.swing.JButton();
        btnIsbnClear = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtIsbnBookId = new javax.swing.JLabel();
        lblIsbnISBN = new javax.swing.JLabel();
        txtIsbnISBN = new javax.swing.JTextField();
        lblIsbnISBN1 = new javax.swing.JLabel();
        txtIsbnName = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jXTableIsbnNewBooks = new org.jdesktop.swingx.JXTable();
        jPanel39 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        btnInvCreditUpdate = new javax.swing.JButton();
        btnInvCreditClear = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtInvId = new javax.swing.JLabel();
        lblIsbnISBN2 = new javax.swing.JLabel();
        txtInvCreditInstallment = new javax.swing.JTextField();
        lblIsbnISBN3 = new javax.swing.JLabel();
        txtInvCreditCompany = new javax.swing.JTextField();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jXTableInvCredit = new org.jdesktop.swingx.JXTable();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        btnGrnCreditUpdate = new javax.swing.JButton();
        btnGrnCreditClear = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtGrnId = new javax.swing.JLabel();
        lblIsbnISBN4 = new javax.swing.JLabel();
        txtGrnCreditInstallment = new javax.swing.JTextField();
        lblIsbnISBN5 = new javax.swing.JLabel();
        txtGrnCreditCompany = new javax.swing.JTextField();
        jPanel54 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jXTableGrnCredit = new org.jdesktop.swingx.JXTable();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setText("Search ");

        jLabel3.setText("By");

        cmbBooksSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME" }));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnManageCategories.setText("Manage Categories");
        btnManageCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCategoriesActionPerformed(evt);
            }
        });

        btnManageBatches.setText("Manage Batches");
        btnManageBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBatchesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnManageBatches, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addGap(324, 324, 324))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnManageCategories)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageBatches)
                .addGap(0, 92, Short.MAX_VALUE))
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAreaBookDes.setColumns(20);
        txtAreaBookDes.setRows(5);
        jScrollPane10.setViewportView(txtAreaBookDes);

        cmbBookCat.setEditable(true);

        jLabel14.setText("Name");

        jLabel39.setText("Image");

        jLabel38.setText("Category");

        jLabel37.setText("Description");

        btnNewBook.setText("New");
        btnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookActionPerformed(evt);
            }
        });

        btnBookClear.setText("Clear");
        btnBookClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookClearActionPerformed(evt);
            }
        });

        btnBookUpdate.setText("Update");
        btnBookUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBookName)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(cmbBookCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBookImg)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(btnNewBook, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBookUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBookClear)))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBookCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBookClear)
                .addGap(27, 27, 27)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewBook)
                    .addComponent(btnBookUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Description", "Category"
            }
        ));
        jXTableBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableBookMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jXTableBook);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBooksSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBooksSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBooksSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbBooksSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Books[Products]", jPanel3);

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        btnNewSup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewSup.setForeground(new java.awt.Color(0, 153, 153));
        btnNewSup.setText("New Supplier");
        btnNewSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSupActionPerformed(evt);
            }
        });

        btnSupUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSupUpdate.setForeground(new java.awt.Color(0, 153, 0));
        btnSupUpdate.setText("Update");
        btnSupUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupUpdateActionPerformed(evt);
            }
        });

        btnSupActive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSupActive.setForeground(new java.awt.Color(153, 0, 0));
        btnSupActive.setText("Active");

        btnSupActive1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSupActive1.setForeground(new java.awt.Color(0, 51, 51));
        btnSupActive1.setText("Clear");
        btnSupActive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActive1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewSup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnSupActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupActive1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewSup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSupUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSupActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSupActive1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("  Id");
        jLabel21.setOpaque(true);
        jLabel21.setPreferredSize(new java.awt.Dimension(54, 20));

        txtSupId.setText(" ");
        txtSupId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtSupId.setOpaque(true);
        txtSupId.setPreferredSize(new java.awt.Dimension(54, 25));

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setText(" Name");
        jLabel23.setOpaque(true);
        jLabel23.setPreferredSize(new java.awt.Dimension(54, 20));

        txtSupName.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel25.setBackground(new java.awt.Color(153, 153, 153));
        jLabel25.setText(" Company");
        jLabel25.setOpaque(true);
        jLabel25.setPreferredSize(new java.awt.Dimension(54, 20));

        jLabel28.setBackground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("  Telephone");
        jLabel28.setOpaque(true);
        jLabel28.setPreferredSize(new java.awt.Dimension(54, 20));

        txtSupTel.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel31.setBackground(new java.awt.Color(153, 153, 153));
        jLabel31.setText(" Address");
        jLabel31.setOpaque(true);
        jLabel31.setPreferredSize(new java.awt.Dimension(54, 20));

        txtSupAddress.setPreferredSize(new java.awt.Dimension(6, 25));

        txtSupEmail.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel36.setBackground(new java.awt.Color(153, 153, 153));
        jLabel36.setText("  E-mail");
        jLabel36.setOpaque(true);
        jLabel36.setPreferredSize(new java.awt.Dimension(54, 20));

        txtSupCompany.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSupTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSupAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSupEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSupId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSupCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSupName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupTel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company", "Agent", "Telephone", "Email"
            }
        ));
        jXTableSup.setColumnControlVisible(true);
        jXTableSup.setRowHeight(25);
        jXTableSup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableSupMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jXTableSup);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1403, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Suppliers", jPanel6);

        jPanel42.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        btnNewCustomer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewCustomer.setForeground(new java.awt.Color(0, 153, 153));
        btnNewCustomer.setText("New Customer");
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });

        btnCustomerUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCustomerUpdate.setForeground(new java.awt.Color(0, 153, 0));
        btnCustomerUpdate.setText("Update");
        btnCustomerUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerUpdateActionPerformed(evt);
            }
        });

        btnCustomerActive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCustomerActive.setForeground(new java.awt.Color(153, 0, 0));
        btnCustomerActive.setText("Active");

        btnCustomerClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCustomerClear.setForeground(new java.awt.Color(0, 51, 51));
        btnCustomerClear.setText("Clear");
        btnCustomerClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCustomerUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnCustomerActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomerClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCustomerUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCustomerActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCustomerClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel47.setBackground(new java.awt.Color(153, 153, 153));
        jLabel47.setText("  Id");
        jLabel47.setOpaque(true);
        jLabel47.setPreferredSize(new java.awt.Dimension(54, 20));

        txtCustomerId.setText(" ");
        txtCustomerId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCustomerId.setOpaque(true);
        txtCustomerId.setPreferredSize(new java.awt.Dimension(54, 25));

        jLabel48.setBackground(new java.awt.Color(153, 153, 153));
        jLabel48.setText(" Name");
        jLabel48.setOpaque(true);
        jLabel48.setPreferredSize(new java.awt.Dimension(54, 20));

        txtCustomerName.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel49.setBackground(new java.awt.Color(153, 153, 153));
        jLabel49.setText(" Company");
        jLabel49.setOpaque(true);
        jLabel49.setPreferredSize(new java.awt.Dimension(54, 20));

        jLabel50.setBackground(new java.awt.Color(153, 153, 153));
        jLabel50.setText("  Telephone");
        jLabel50.setOpaque(true);
        jLabel50.setPreferredSize(new java.awt.Dimension(54, 20));

        txtCustomerTel.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel51.setBackground(new java.awt.Color(153, 153, 153));
        jLabel51.setText(" Address");
        jLabel51.setOpaque(true);
        jLabel51.setPreferredSize(new java.awt.Dimension(54, 20));

        txtCustomerAddress.setPreferredSize(new java.awt.Dimension(6, 25));

        txtCustomerEmail.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel52.setBackground(new java.awt.Color(153, 153, 153));
        jLabel52.setText("  E-mail");
        jLabel52.setOpaque(true);
        jLabel52.setPreferredSize(new java.awt.Dimension(54, 20));

        txtCustomerCompany.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCustomerId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCustomerTel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel45.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company", "Agent", "Telephone", "Email"
            }
        ));
        jXTableCustomer.setColumnControlVisible(true);
        jXTableCustomer.setRowHeight(25);
        jXTableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableCustomerMouseReleased(evt);
            }
        });
        jScrollPane15.setViewportView(jXTableCustomer);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("fff", jPanel41);

        jTabbedPane1.addTab("Customers", jTabbedPane2);
        jTabbedPane2.getAccessibleContext().setAccessibleName("");

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        btnNewUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewUser.setForeground(new java.awt.Color(0, 153, 153));
        btnNewUser.setText("New User");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });

        btnUserUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUserUpdate.setForeground(new java.awt.Color(0, 153, 0));
        btnUserUpdate.setText("Update");
        btnUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserUpdateActionPerformed(evt);
            }
        });

        btnUserActive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUserActive.setForeground(new java.awt.Color(153, 0, 0));
        btnUserActive.setText("Active");

        btnUserActive1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUserActive1.setForeground(new java.awt.Color(0, 0, 51));
        btnUserActive1.setText("Clear");
        btnUserActive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActive1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUserActive1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUserUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUserActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUserActive1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("  Id");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(54, 20));

        txtUserId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtUserId.setOpaque(true);
        txtUserId.setPreferredSize(new java.awt.Dimension(54, 25));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("  Username");
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(54, 20));

        txtUserUsername.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("  Password");
        jLabel6.setOpaque(true);
        jLabel6.setPreferredSize(new java.awt.Dimension(54, 20));

        txtUserPassword.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("  NIC");
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(54, 20));

        txtUserNIC.setPreferredSize(new java.awt.Dimension(6, 25));

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Image"));

        lblUserImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnOpenUserImage.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnOpenUserImage.setText("Open An Image");
        btnOpenUserImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenUserImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserImage, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnOpenUserImage)
                .addGap(42, 42, 42))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnOpenUserImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("  Name");
        jLabel9.setOpaque(true);
        jLabel9.setPreferredSize(new java.awt.Dimension(54, 20));

        txtUserRealName.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("  Type");
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(54, 20));

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Normal_User", "Guest" }));
        cmbUserType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUserTypeItemStateChanged(evt);
            }
        });

        txtUserAddress.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("  Address");
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(54, 20));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserNIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserRealName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUserId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUserUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUserNIC, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUserRealName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUserAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username", "Nic", "Type", "Register Date"
            }
        ));
        jXTableUser.setColumnControlVisible(true);
        jXTableUser.setRowHeight(25);
        jXTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableUserMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jXTableUser);
        if (jXTableUser.getColumnModel().getColumnCount() > 0) {
            jXTableUser.getColumnModel().getColumn(4).setHeaderValue("Supplier");
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", jPanel2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1403, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Settings", jPanel7);

        jXTableViewInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Date", "Time", "Customer", "Discount", "Total Price", "User"
            }
        ));
        jXTableViewInv.setColumnControlVisible(true);
        jXTableViewInv.setRowHeight(25);
        jXTableViewInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableViewInvMouseReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jXTableViewInv);

        jXTableViewInvCopy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                   ISBN"
            }
        ));
        jXTableViewInvCopy.setColumnControlVisible(true);
        jXTableViewInvCopy.setRowHeight(25);
        jScrollPane12.setViewportView(jXTableViewInvCopy);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addComponent(jScrollPane12)))
        );

        jTabbedPane1.addTab("View Invoices", jPanel13);

        jXTableViewGrn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Date", "Time", "Supplier", "Vehicle No", "Discount", "Total Price", "User ID"
            }
        ));
        jXTableViewGrn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableViewGrnMouseReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jXTableViewGrn);

        jXTableViewGrnCopy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book", "Buying Price", "Quantity"
            }
        ));
        jXTableViewGrnCopy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableViewGrnCopyMouseReleased(evt);
            }
        });
        jScrollPane13.setViewportView(jXTableViewGrnCopy);
        if (jXTableViewGrnCopy.getColumnModel().getColumnCount() > 0) {
            jXTableViewGrnCopy.getColumnModel().getColumn(1).setHeaderValue("Buying Price");
            jXTableViewGrnCopy.getColumnModel().getColumn(2).setHeaderValue("Quantity");
        }

        jXTableViewGrnCopyIsbn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                     ISBN"
            }
        ));
        jScrollPane14.setViewportView(jXTableViewGrnCopyIsbn);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addComponent(jScrollPane14)
                    .addComponent(jScrollPane13)))
        );

        jTabbedPane1.addTab("View GRNs", jPanel17);

        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("To    :");

        jTextField2.setText("12/12/2017");

        jButton6.setText("GRN Report");

        jLabel15.setText("From :");

        jTextField1.setText("12/10/2017");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("To    :");

        jTextField3.setText("12/12/2017");

        jButton7.setText("Invoice Report");

        jLabel35.setText("From :");

        jTextField4.setText("12/10/2017");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton11.setText("Daily Invoice Report");

        jButton10.setText("Weekly Invoice Report");

        jButton9.setText("Monthly Invoice Report");

        jButton12.setText("Weekly GRN Report");

        jButton13.setText("Daily GRN Report");

        jButton8.setText("Monthly GRN Report");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)))
                .addContainerGap())
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane9.setViewportView(jTextArea1);

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton14.setText("Print");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane9)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton14))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sale Reports", jPanel18);

        jXTableInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Name", "Unit Price"
            }
        ));
        jXTableInv.setColumnControlVisible(true);
        jScrollPane3.setViewportView(jXTableInv);

        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbBkName.setEditable(true);

        jLabel4.setText("Name");

        jLabel8.setText("ISBN");

        jLabel12.setText("Unit price");

        cmbISBN.setEditable(true);
        cmbISBN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbISBNItemStateChanged(evt);
            }
        });
        cmbISBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbISBNMouseReleased(evt);
            }
        });

        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblUPriceInv.setText("0.00");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUPriceInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbISBN, 0, 370, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbBkName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUPriceInv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDiscountInv.setText("0");
        txtDiscountInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountInvActionPerformed(evt);
            }
        });
        txtDiscountInv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountInvKeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Create Invoice");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblNetPaymentInv.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNetPaymentInv.setText("0.00");

        jLabel16.setText("Discount (%)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Gross Payment (Rs.)");

        lblGrossPaymentInv.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblGrossPaymentInv.setText("0.00");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Net Payment (Rs.)");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNetPaymentInv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiscountInv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGrossPaymentInv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNetPaymentInv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiscountInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrossPaymentInv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel40.setText("Customer");

        cbCredit.setText("Credit");

        cmbCustomer.setEditable(true);
        cmbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerItemStateChanged(evt);
            }
        });
        cmbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbCustomerMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCustomer, 0, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cbCredit)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCredit))
                .addContainerGap())
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPaid.setText("0");
        txtPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidActionPerformed(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });

        jLabel41.setText("Paid (Rs.)");

        lblToPay.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblToPay.setText("0.00");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel42.setText("To Pay (Rs.)");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 424, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Create Invoice", jPanel4);

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGrossPayment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblGrossPayment.setText("0.00");

        jLabel29.setText("Discount (%)");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Create GRN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Net Payment (Rs.)");

        lblNetPayment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNetPayment.setText("0.00");

        txtDiscount.setText("0");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel30.setText("Gross Payment (Rs.)");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNetPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGrossPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNetPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrossPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setText("Select the batch");

        jLabel32.setText("Supplier");

        txtVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehActionPerformed(evt);
            }
        });

        jLabel34.setText("Delivered vehicle number");

        jButton5.setText("Create Batch");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jXTableBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch ID", "Buying price", "Selling price"
            }
        ));
        jXTableBatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableBatchMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jXTableBatch);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cmbSup.setEditable(true);

        cbCreditGrn.setText("Credit");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVeh)
                            .addComponent(cmbSup, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cbCreditGrn)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cmbSup, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbCreditGrn))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtVeh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtQty.setText("0");
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
        });

        jLabel22.setText("Name");

        jButton3.setText("Add to Cart");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblPayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPayment.setText("Rs. 0.00");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Payment for ISBN");

        jLabel24.setText("Quantity");

        cmbName.setEditable(true);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbName, 0, 242, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtQty))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(cmbName)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTableGrn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Batch ID", "Quantity", "Total price"
            }
        ));
        jXTableGrn.setColumnControlVisible(true);
        jScrollPane6.setViewportView(jXTableGrn);

        jPanel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPaidGrn.setText("0");
        txtPaidGrn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidGrnActionPerformed(evt);
            }
        });
        txtPaidGrn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidGrnKeyReleased(evt);
            }
        });

        jLabel45.setText("Paid (Rs.)");

        lblToPayGrn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblToPayGrn.setText("0.00");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel46.setText("To Pay (Rs.)");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPaidGrn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblToPayGrn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaidGrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblToPayGrn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Create GRN", jPanel5);

        jPanel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        btnIsbnNewISBN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIsbnNewISBN.setForeground(new java.awt.Color(0, 153, 153));
        btnIsbnNewISBN.setText("Save");
        btnIsbnNewISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsbnNewISBNActionPerformed(evt);
            }
        });

        btnIsbnClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIsbnClear.setForeground(new java.awt.Color(0, 0, 51));
        btnIsbnClear.setText("Clear");
        btnIsbnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsbnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIsbnNewISBN)
                .addGap(18, 18, 18)
                .addComponent(btnIsbnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(btnIsbnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(btnIsbnNewISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("  Book Id");
        jLabel13.setOpaque(true);
        jLabel13.setPreferredSize(new java.awt.Dimension(54, 20));

        txtIsbnBookId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtIsbnBookId.setOpaque(true);
        txtIsbnBookId.setPreferredSize(new java.awt.Dimension(54, 25));

        lblIsbnISBN.setBackground(new java.awt.Color(153, 153, 153));
        lblIsbnISBN.setText("  ISBN");
        lblIsbnISBN.setOpaque(true);
        lblIsbnISBN.setPreferredSize(new java.awt.Dimension(54, 20));

        txtIsbnISBN.setPreferredSize(new java.awt.Dimension(6, 25));

        lblIsbnISBN1.setBackground(new java.awt.Color(153, 153, 153));
        lblIsbnISBN1.setText("  Name");
        lblIsbnISBN1.setOpaque(true);
        lblIsbnISBN1.setPreferredSize(new java.awt.Dimension(54, 20));

        txtIsbnName.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(lblIsbnISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIsbnISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIsbnBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 258, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addComponent(lblIsbnISBN1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIsbnName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIsbnBookId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIsbnISBN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIsbnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIsbnISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIsbnISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableIsbnNewBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Batch ID", "Quantity", "Buying price", "Selling price", "Supplier", "GRN ID"
            }
        ));
        jXTableIsbnNewBooks.setColumnControlVisible(true);
        jXTableIsbnNewBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableIsbnNewBooksMouseReleased(evt);
            }
        });
        jScrollPane11.setViewportView(jXTableIsbnNewBooks);
        if (jXTableIsbnNewBooks.getColumnModel().getColumnCount() > 0) {
            jXTableIsbnNewBooks.getColumnModel().getColumn(7).setHeaderValue("GRN ID");
        }

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("New ISBN", jPanel32);

        jPanel46.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        btnInvCreditUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInvCreditUpdate.setForeground(new java.awt.Color(0, 153, 153));
        btnInvCreditUpdate.setText("Update");
        btnInvCreditUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvCreditUpdateActionPerformed(evt);
            }
        });

        btnInvCreditClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInvCreditClear.setForeground(new java.awt.Color(0, 0, 51));
        btnInvCreditClear.setText("Clear");
        btnInvCreditClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvCreditClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInvCreditUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnInvCreditClear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(btnInvCreditClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(btnInvCreditUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel43.setBackground(new java.awt.Color(153, 153, 153));
        jLabel43.setText("  Invoice Id");
        jLabel43.setOpaque(true);
        jLabel43.setPreferredSize(new java.awt.Dimension(54, 20));

        txtInvId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtInvId.setOpaque(true);
        txtInvId.setPreferredSize(new java.awt.Dimension(54, 25));

        lblIsbnISBN2.setBackground(new java.awt.Color(153, 153, 153));
        lblIsbnISBN2.setText("  Installment");
        lblIsbnISBN2.setOpaque(true);
        lblIsbnISBN2.setPreferredSize(new java.awt.Dimension(54, 20));

        txtInvCreditInstallment.setPreferredSize(new java.awt.Dimension(6, 25));
        txtInvCreditInstallment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvCreditInstallmentActionPerformed(evt);
            }
        });

        lblIsbnISBN3.setBackground(new java.awt.Color(153, 153, 153));
        lblIsbnISBN3.setText("  Customer");
        lblIsbnISBN3.setOpaque(true);
        lblIsbnISBN3.setPreferredSize(new java.awt.Dimension(54, 20));

        txtInvCreditCompany.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(lblIsbnISBN2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInvCreditInstallment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInvId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 258, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(lblIsbnISBN3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInvCreditCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtInvId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIsbnISBN3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInvCreditCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIsbnISBN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInvCreditInstallment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableInvCredit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Date", "Time", "Customer", "Total Price", "Paid", "User"
            }
        ));
        jXTableInvCredit.setColumnControlVisible(true);
        jXTableInvCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableInvCreditMouseReleased(evt);
            }
        });
        jScrollPane16.setViewportView(jXTableInvCredit);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Invoice Credits", jPanel39);

        jPanel51.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        btnGrnCreditUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrnCreditUpdate.setForeground(new java.awt.Color(0, 153, 153));
        btnGrnCreditUpdate.setText("Update");
        btnGrnCreditUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrnCreditUpdateActionPerformed(evt);
            }
        });

        btnGrnCreditClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrnCreditClear.setForeground(new java.awt.Color(0, 0, 51));
        btnGrnCreditClear.setText("Clear");
        btnGrnCreditClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrnCreditClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGrnCreditUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnGrnCreditClear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(btnGrnCreditClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(btnGrnCreditUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel44.setBackground(new java.awt.Color(153, 153, 153));
        jLabel44.setText("  Grn Id");
        jLabel44.setOpaque(true);
        jLabel44.setPreferredSize(new java.awt.Dimension(54, 20));

        txtGrnId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtGrnId.setOpaque(true);
        txtGrnId.setPreferredSize(new java.awt.Dimension(54, 25));

        lblIsbnISBN4.setBackground(new java.awt.Color(153, 153, 153));
        lblIsbnISBN4.setText("  Installment");
        lblIsbnISBN4.setOpaque(true);
        lblIsbnISBN4.setPreferredSize(new java.awt.Dimension(54, 20));

        txtGrnCreditInstallment.setPreferredSize(new java.awt.Dimension(6, 25));

        lblIsbnISBN5.setBackground(new java.awt.Color(153, 153, 153));
        lblIsbnISBN5.setText("  Supplier");
        lblIsbnISBN5.setOpaque(true);
        lblIsbnISBN5.setPreferredSize(new java.awt.Dimension(54, 20));

        txtGrnCreditCompany.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(lblIsbnISBN4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrnCreditInstallment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrnId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 258, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                        .addComponent(lblIsbnISBN5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrnCreditCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGrnId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIsbnISBN5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGrnCreditCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIsbnISBN4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGrnCreditInstallment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel54.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jXTableGrnCredit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Date", "Time", "Supplier", "Total price", "Paid", "User"
            }
        ));
        jXTableGrnCredit.setColumnControlVisible(true);
        jXTableGrnCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableGrnCreditMouseReleased(evt);
            }
        });
        jScrollPane17.setViewportView(jXTableGrnCredit);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("GRN Credits", jPanel50);

        lblTitle.setForeground(new java.awt.Color(0, 51, 153));
        lblTitle.setText("  GM Book Shop  [Corrent User: Prabath  Data :2017/11/11  Time: 04:10 pm]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage b_image = null;

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        refCat();
        refBatch();
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel myModel = (DefaultTableModel)jXTableGrn.getModel();
        Vector rawData = new Vector();

        rawData.add(cmbName.getSelectedItem());
        rawData.add(batch_id);
        rawData.add(txtQty.getText());

        int qty = Integer.parseInt(txtQty.getText());
        float uPrice = Float.parseFloat(selling_price);
        float price = qty * uPrice;

        rawData.add(price);

        myModel.addRow(rawData);

        float currenetNetPrice = Float.parseFloat(lblNetPayment.getText());
        float newNetPrice = currenetNetPrice + price;
        lblNetPayment.setText(Float.toString(newNetPrice));
        calcGrossPayment();
        calcToPayGrn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        calcPaymentGRN();
    }//GEN-LAST:event_txtQtyKeyReleased

    private void jXTableBatchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableBatchMouseReleased
        DefaultTableModel myModel = (DefaultTableModel)jXTableBatch.getModel();

        if (jXTableBatch.getSelectedRow() != -1)
        {
            batch_id = myModel.getValueAt(jXTableBatch.getSelectedRow(), 0).toString();
            selling_price = myModel.getValueAt(jXTableBatch.getSelectedRow(), 1).toString();

            calcPaymentGRN();
        }
    }//GEN-LAST:event_jXTableBatchMouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new BatchWindow().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehActionPerformed

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        calcGrossPayment();
        calcToPayGrn();
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        DefaultTableModel grnTbl = (DefaultTableModel)jXTableGrn.getModel();
        Grn_copy grnCopy = new Grn_copy();
        Grn grn = new Grn();
        Credit crd = new Credit();
        Database db = new Database();

        int sup = cmbSup.getSelectedIndex() + 1;
        String veh = txtVeh.getText();

        grn.setSup_id(sup);
        grn.setVeh_no(veh);

        Date DateAndTime = new Date();
        grn.setDateAndTime(DateAndTime);
        float discount = Float.parseFloat(txtDiscount.getText());
        grn.setDiscount(discount);
        grn.setUser_id(1);

        int rawCount = grnTbl.getRowCount();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(grn.getDateAndTime());
        String time = new SimpleDateFormat("hh:mm:ss").format(grn.getDateAndTime());

        try
        {
            db.saveGRN(grn);
            ResultSet rs = SqlConnection.getData("SELECT grn_id AS grn_id FROM grn WHERE date='" + date + "' AND time='" + time + "' AND user_id='" + grn.getUser_id() + "'");
            int grn_id;

            while (rs.next())
            {
                grn_id = rs.getInt("grn_id");
                crd.setGrn_id(grn_id);

                for (int i = 0; i < rawCount; i++)
                {
                    grnCopy.setGrn_id(grn_id);
                    grnCopy.setBatch_id(Integer.parseInt(grnTbl.getValueAt(i, 1).toString()));
                    grnCopy.setQty(Integer.parseInt(grnTbl.getValueAt(i, 2).toString()));
                    String bName = grnTbl.getValueAt(i, 0).toString();

                    ResultSet rsBookId = SqlConnection.getData("SELECT book_id AS bId FROM book WHERE name='" + bName + "'");

                    while (rsBookId.next())
                    {
                        int book_id = rsBookId.getInt("bId");
                        grnCopy.setBook_id(book_id);
                    }

                    db.saveGRNCopy(grnCopy);
                    
                    ResultSet rsCopyId = SqlConnection.getData("SELECT MAX(grn_copy_id) AS grn_copy_id FROM grn_copy");
                    ResultSet rsQty = SqlConnection.getData("SELECT quantity AS qty FROM grn_copy WHERE grn_copy_id=(SELECT MAX(grn_copy_id) AS grn_copy_id FROM grn_copy)");
                    
                    while (rsCopyId.next() && rsQty.next())
                    {
                        int grn_id_new = rsCopyId.getInt("grn_copy_id");
                        int to_add = rsQty.getInt("qty");
                        
                        db.saveNewBook(grn_id_new, to_add);
                        refNew();
                        refGrn();
                    }
                }
            }
            
            grnTbl.setRowCount(0);
            
            if (cbCreditGrn.isSelected())
            {
                float paid = Float.parseFloat(txtPaidGrn.getText());
                crd.setPaid(paid);

                db.saveCreditGrn(crd);
            }
        }
        catch (Exception ex)
        {
            ex.getMessage();
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel invTbl = (DefaultTableModel)jXTableInv.getModel();
        Invoice_copy invCopy = new Invoice_copy();
        Invoice inv = new Invoice();
        Credit crd = new Credit();
        Database db = new Database();
        int inv_id;
        
        Date DateAndTime = new Date();
        inv.setDateAndTime(DateAndTime);
        float discount = Float.parseFloat(txtDiscountInv.getText());
        String customer = cmbCustomer.getSelectedItem().toString();
        inv.setDiscount(discount);
        inv.setUser_id(1);

        int rawCount = invTbl.getRowCount();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(inv.getDateAndTime());
        String time = new SimpleDateFormat("hh:mm:ss").format(inv.getDateAndTime());
        
        if (!customer.equals("guest"))
        {
            try
            {
                ResultSet rsCusId = SqlConnection.getData("SELECT cus_id AS cus_id FROM customer WHERE company='" + customer + "'");

                while (rsCusId.next())
                {
                    int cusId = rsCusId.getInt("cus_id");
                    inv.setCus_id(cusId);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            inv.setCus_id(0);
        }

        try
        {
            db.saveInvoice(inv);
            ResultSet rs = SqlConnection.getData("SELECT inv_id AS inv_id FROM invoice WHERE date='" + date + "' AND time='" + time + "' AND user_id='" + inv.getUser_id() + "'");

            while (rs.next())
            {
                inv_id = rs.getInt("inv_id");
                crd.setInv_id(inv_id);

                for (int i = 0; i < rawCount; i++)
                {
                    String ISBN = invTbl.getValueAt(i, 0).toString();
                    invCopy.setISBN(ISBN);
                    invCopy.setInv_id(inv_id);

                    db.saveInvoiceCopy(invCopy);
                    db.updateISBNAvailability(ISBN);
                    refISBN();
                    refInv();
                }
            }
            
            invTbl.setRowCount(0);
            
            if (cbCredit.isSelected())
            {
                float paid = Float.parseFloat(txtPaid.getText());
                crd.setPaid(paid);

                db.saveCreditInv(crd);
                refInvCredit();
            }
        }
        catch (Exception ex)
        {
            ex.getMessage();
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDiscountInvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountInvKeyReleased
        calcGrossPaymentInvoice();
        calcToPayInv();
    }//GEN-LAST:event_txtDiscountInvKeyReleased

    private void txtDiscountInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountInvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel myModel = (DefaultTableModel)jXTableInv.getModel();
        Vector rawData = new Vector();

        rawData.add(cmbISBN.getSelectedItem());

        try {
            ResultSet rs = SqlConnection.getData("SELECT book_id AS bId FROM book_copy WHERE ISBN='" + cmbISBN.getSelectedItem() + "'");

            while (rs.next()) {
                int book_id = rs.getInt("bId");
                ResultSet rsName = SqlConnection.getData("SELECT name AS bName FROM book WHERE book_id=" + book_id);

                while (rsName.next()) {
                    String name = rsName.getString("bName");
                    rawData.add(name);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        rawData.add(lblUPriceInv.getText());

        myModel.addRow(rawData);

        float currenetNetPrice = Float.parseFloat(lblNetPaymentInv.getText());
        float newNetPrice = currenetNetPrice + Float.parseFloat(lblUPriceInv.getText());
        lblNetPaymentInv.setText(Float.toString(newNetPrice));
        calcGrossPaymentInvoice();
        calcToPayInv();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbISBNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbISBNMouseReleased

    }//GEN-LAST:event_cmbISBNMouseReleased

    private void cmbISBNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbISBNItemStateChanged
        try
        {
            if (cmbISBN.getItemCount() != 0)
            {
                String ISBN = cmbISBN.getSelectedItem().toString();
                ResultSet rs = SqlConnection.getData("SELECT book_id as book_id FROM book_copy where ISBN='" + ISBN + "';");
                ResultSet rsId = SqlConnection.getData("SELECT book_id AS bId FROM book_copy WHERE ISBN='" + cmbISBN.getSelectedItem() + "'");
                float uPrice;

                while (rs.next())
                {
                    int book_id = rs.getInt("book_id");
                    ResultSet rs_batch_id = SqlConnection.getData("SELECT batch_id as batch_id FROM grn_copy where book_id='" + book_id + "';");

                    while (rs_batch_id.next())
                    {
                        int batch_id = rs_batch_id.getInt("batch_id");
                        rs = SqlConnection.getData("SELECT selling_price as uPrice FROM batch where batch_id='" + batch_id + "';");
                    }

                    while (rs.next())
                    {
                        uPrice = rs.getFloat("uPrice");
                        lblUPriceInv.setText(Float.toString(uPrice));
                    }
                }

                while (rsId.next())
                {
                    int book_id = rsId.getInt("bId");
                    ResultSet rsName = SqlConnection.getData("SELECT name AS bName FROM book WHERE book_id=" + book_id);

                    while (rsName.next())
                    {
                        String name = rsName.getString("bName");
                        cmbBkName.setSelectedItem(name);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        try {

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cmbISBNItemStateChanged

    private void jXTableUserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableUserMouseReleased

        txtUserUsername.setText("");
        txtUserNIC.setText("");
        txtUserPassword.setText("");

        DefaultTableModel userTbl = (DefaultTableModel)jXTableUser.getModel();

        if (jXTableUser.getSelectedRow() != -1)
        {
            String name = userTbl.getValueAt(jXTableUser.getSelectedRow(), 0).toString();
            String username = userTbl.getValueAt(jXTableUser.getSelectedRow(), 1).toString();
            String type = userTbl.getValueAt(jXTableUser.getSelectedRow(), 3).toString();

            try {
                ResultSet rsUser = SqlConnection.getData("SELECT user_id, address FROM user WHERE username = '" + username + "'");

                while (rsUser.next())
                {
                    int user_id = rsUser.getInt("user_id");
                    String address = rsUser.getString("address");

                    txtUserId.setText(Integer.toString(user_id));
                    txtUserRealName.setText(name);
                    txtUserAddress.setText(address);
                    cmbUserType.setSelectedItem(type);
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jXTableUserMouseReleased

    private void cmbUserTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUserTypeItemStateChanged

    }//GEN-LAST:event_cmbUserTypeItemStateChanged

    private void btnOpenUserImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenUserImageActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setMultiSelectionEnabled(false);
        fc.setFileFilter(new FileNameExtensionFilter("Image File", ImageIO.getReaderFileSuffixes()));
        fc.showDialog(this, "Open Image");
        File imageFile = fc.getSelectedFile();
        if (null != imageFile) {
            try {
                b_image = ImageIO.read(imageFile);
                ImageIcon image = new ImageIcon(imageFile.getPath());
                image = new ImageIcon(image.getImage().getScaledInstance(lblUserImage.getWidth(), lblUserImage.getHeight(), Image.SCALE_SMOOTH));
                lblUserImage.setIcon(image);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnOpenUserImageActionPerformed

    private void btnUserActive1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActive1ActionPerformed
        txtUserId.setText((""));
        txtUserUsername.setText((""));
        txtUserPassword.setText((""));
        txtUserNIC.setText((""));
        txtUserRealName.setText((""));
        txtUserAddress.setText((""));
    }//GEN-LAST:event_btnUserActive1ActionPerformed

    private void btnUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdateActionPerformed

        Database db = new Database();
        User user = new User();

        try {
            if (b_image != null)
            ImageWriter.saveUserImage(b_image, "userImage01");

            user.setId(Integer.parseInt(txtUserId.getText()));
            user.setName(txtUserRealName.getText());
            user.setAddress(txtUserAddress.getText());
            user.setType(UserType.valueOf(cmbUserType.getSelectedItem().toString().toUpperCase()));

            db.updateUser(user);
            
            refUser();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnUserUpdateActionPerformed

    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed

        String username = txtUserUsername.getText();
        int i = 0;
        try {
            ResultSet rsCheck = SqlConnection.getData("SELECT * FROM user WHERE username='" + username + "'");
            while (rsCheck.next()) {
                i++;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if (i == 0) {
            Database db = new Database();
            User user = new User();
            Date DateAndTime = new Date();

            try {
                if (b_image != null)
                ImageWriter.saveUserImage(b_image, "userImage01");

                user.setUsername(txtUserUsername.getText());
                user.setNic(txtUserNIC.getText());
                user.setName(txtUserRealName.getText());
                user.setrDateAndTime(DateAndTime);
                user.setAddress(txtUserAddress.getText());
                user.setType(UserType.valueOf(cmbUserType.getSelectedItem().toString().toUpperCase()));
                user.setImage("UserImage/Address");
                user.setPassword(txtUserPassword.getText());

                db.saveUser(user);
                
                refUser();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnNewUserActionPerformed

    private void jXTableSupMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableSupMouseReleased

        txtSupCompany.setText("");

        DefaultTableModel supTbl = (DefaultTableModel)jXTableSup.getModel();

        if (jXTableSup.getSelectedRow() != -1)
        {
            String company = supTbl.getValueAt(jXTableSup.getSelectedRow(), 0).toString();
            String name = supTbl.getValueAt(jXTableSup.getSelectedRow(), 1).toString();
            String tel = supTbl.getValueAt(jXTableSup.getSelectedRow(), 2).toString();
            String email = supTbl.getValueAt(jXTableSup.getSelectedRow(), 3).toString();

            try {
                ResultSet rsSup = SqlConnection.getData("SELECT sup_id, address FROM supplier WHERE company = '" + company + "'");

                while (rsSup.next())
                {
                    int sup_id = rsSup.getInt("sup_id");
                    String address = rsSup.getString("address");

                    txtSupId.setText(Integer.toString(sup_id));
                    txtSupAddress.setText(address);
                    txtSupName.setText(name);
                    txtSupTel.setText(tel);
                    txtSupEmail.setText(email);
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jXTableSupMouseReleased

    private void btnSupActive1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActive1ActionPerformed
        txtSupId.setText((""));
        txtSupCompany.setText((""));
        txtSupName.setText((""));
        txtSupTel.setText((""));
        txtSupAddress.setText((""));
        txtSupEmail.setText((""));
    }//GEN-LAST:event_btnSupActive1ActionPerformed

    private void btnSupUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupUpdateActionPerformed
        Database db = new Database();
        Supplier sup = new Supplier();

        try {
            sup.setId(Integer.parseInt(txtSupId.getText()));
            sup.setName(txtSupName.getText());
            sup.setEmail(txtSupEmail.getText());
            sup.setTel(txtSupTel.getText());
            sup.setAddress(txtSupAddress.getText());

            db.updateSupplier(sup);
            
            refSup();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSupUpdateActionPerformed

    private void btnNewSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSupActionPerformed

        String company = txtSupCompany.getText();
        int i = 0;
        try {
            ResultSet rsCheck = SqlConnection.getData("SELECT * FROM supplier WHERE company='" + company + "'");
            while (rsCheck.next()) {
                i++;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if (i == 0) {

            Database db = new Database();
            Supplier sup = new Supplier();
            Date DateAndTime = new Date();

            try {
                sup.setCompany(txtSupCompany.getText());
                sup.setName(txtSupName.getText());
                sup.setTel(txtSupTel.getText());
                sup.setDateAndTime(DateAndTime);
                sup.setAddress(txtSupAddress.getText());
                sup.setEmail(txtSupEmail.getText());
                sup.setUser_id(2);

                db.saveSupplier(sup);
                
                refSup();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnNewSupActionPerformed

    private void btnIsbnNewISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsbnNewISBNActionPerformed
        
        Database db = new Database();
        Book_copy copy = new Book_copy();
        
        int book_id = Integer.parseInt(txtIsbnBookId.getText());
        String ISBN = txtIsbnISBN.getText();
        int grn_id = 0;
        int batch_id;
        
        DefaultTableModel newTbl = (DefaultTableModel)jXTableIsbnNewBooks.getModel();
        
        if (jXTableIsbnNewBooks.getSelectedRow() != -1)
        {
            grn_id = Integer.parseInt(newTbl.getValueAt(jXTableIsbnNewBooks.getSelectedRow(), 7).toString());
            copy.setGrn(grn_id);
        }
        
        int i = 0;
        try {
            ResultSet rsCheck = SqlConnection.getData("SELECT * FROM book_copy WHERE ISBN='" + ISBN + "'");
            while (rsCheck.next()) {
                i++;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if (i == 0) {

            try {
                copy.setBook_Id(book_id);
                copy.setIsbn(ISBN);

                db.saveISBN(copy);
                
                batch_id = Integer.parseInt(newTbl.getValueAt(jXTableIsbnNewBooks.getSelectedRow(), 2).toString());
                ResultSet rsGrnCopyId = SqlConnection.getData("SELECT grn_copy_id AS grn_copy_id FROM grn_copy WHERE grn_id=" + grn_id + " AND book_id=" + book_id + " AND batch_id=" + batch_id);
                
                while (rsGrnCopyId.next())
                {
                    int grnCopyId = rsGrnCopyId.getInt("grn_copy_id");
                    ResultSet rsCopyId = SqlConnection.getData("SELECT to_add AS to_add FROM new_book WHERE grn_copy_id=" + grnCopyId);
                    
                    while (rsCopyId.next())
                    {
                        int to_add = rsCopyId.getInt("to_add");
                        to_add--;
                        
                        db.updateNewBook(grnCopyId, to_add);
                        refNew();
                        refISBN();
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_btnIsbnNewISBNActionPerformed

    private void btnIsbnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsbnClearActionPerformed
        txtIsbnBookId.setText("");
        txtIsbnISBN.setText("");
        txtIsbnName.setText("");
    }//GEN-LAST:event_btnIsbnClearActionPerformed

    private void jXTableIsbnNewBooksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableIsbnNewBooksMouseReleased
        
        DefaultTableModel newTbl = (DefaultTableModel)jXTableIsbnNewBooks.getModel();
        
        if (jXTableIsbnNewBooks.getSelectedRow() != -1)
        {
            txtIsbnBookId.setText(newTbl.getValueAt(jXTableIsbnNewBooks.getSelectedRow(), 0).toString());
            txtIsbnName.setText(newTbl.getValueAt(jXTableIsbnNewBooks.getSelectedRow(), 1).toString());
        }
        
    }//GEN-LAST:event_jXTableIsbnNewBooksMouseReleased

    private void jXTableBookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableBookMouseReleased
        DefaultTableModel bkTbl = (DefaultTableModel)jXTableBook.getModel();
        
        if (jXTableBook.getSelectedRow() != -1)
        {
            txtBookName.setText(bkTbl.getValueAt(jXTableBook.getSelectedRow(), 1).toString());
            txtAreaBookDes.setText(bkTbl.getValueAt(jXTableBook.getSelectedRow(), 2).toString());
            cmbBookCat.setSelectedItem(bkTbl.getValueAt(jXTableBook.getSelectedRow(), 3));
        }
    }//GEN-LAST:event_jXTableBookMouseReleased

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookActionPerformed
        Book book = new Book();
        Database db = new Database();
        
        String bkName = txtBookName.getText();
        book.setName(bkName);
        String bkDes = txtAreaBookDes.getText();
        book.setDescription(bkDes);
        String bkCatName = cmbBookCat.getSelectedItem().toString();
        
        try
        {
            ResultSet rsCatId = SqlConnection.getData("SELECT cat_id AS cat_id FROM category WHERE cat_name='" + bkCatName + "'");
        
            while (rsCatId.next())
            {
                int bkCatId = rsCatId.getInt("cat_id");
                book.setCategory_id(bkCatId);
            }
            
            book.setImage("loc/img");
            
            db.saveBook(book);
            refBook();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnNewBookActionPerformed

    private void btnBookClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookClearActionPerformed
        txtBookName.setText("");
        txtAreaBookDes.setText("");
        txtBookImg.setText("");
        cmbBookCat.setSelectedIndex(0);
    }//GEN-LAST:event_btnBookClearActionPerformed

    private void btnBookUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookUpdateActionPerformed
        DefaultTableModel bkTbl = (DefaultTableModel)jXTableBook.getModel();
        Database db = new Database();
        Book bk = new Book();
        
        if (jXTableBook.getSelectedRow() != -1)
        {
            try
            {
                int bkId = Integer.parseInt(bkTbl.getValueAt(jXTableBook.getSelectedRow(), 0).toString());
                String bkNm = txtBookName.getText();
                String bkDes = txtAreaBookDes.getText();
                String bkCat = cmbBookCat.getSelectedItem().toString();
                String bkImg = "loc/img";
                
                bk.setId(bkId);
                bk.setName(bkNm);
                bk.setDescription(bkDes);
                bk.setImage(bkImg);
                
                ResultSet rsBkCat = SqlConnection.getData("SELECT cat_id AS cat_id FROM category WHERE cat_name='" + bkCat + "'");
                
                while (rsBkCat.next())
                {
                    int bkCatId = rsBkCat.getInt("cat_id");
                    bk.setCategory_id(bkCatId);
                }
                
                db.updateBook(bk);
                
                refBook();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBookUpdateActionPerformed

    private void btnManageCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCategoriesActionPerformed
        new CategoryWindow().setVisible(true);
    }//GEN-LAST:event_btnManageCategoriesActionPerformed

    private void btnManageBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBatchesActionPerformed
        new BatchWindow().setVisible(true);
    }//GEN-LAST:event_btnManageBatchesActionPerformed

    private void jXTableViewInvMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableViewInvMouseReleased
        try
        {
            DefaultTableModel invTbl = (DefaultTableModel)jXTableViewInv.getModel();
            
            if (jXTableViewInv.getSelectedRow() != -1)
            {
                DefaultTableModel invCpyTbl = (DefaultTableModel)jXTableViewInvCopy.getModel();
                
                invCpyTbl.setRowCount(0);
                
                int invId = Integer.parseInt(invTbl.getValueAt(jXTableViewInv.getSelectedRow(), 0).toString());
                
                ResultSet rsInvCpy = SqlConnection.getData("SELECT ISBN AS ISBN FROM invoice_copy WHERE inv_id=" + invId );
                Vector rawData = new Vector();
                
                while (rsInvCpy.next())
                {
                    rawData.add(rsInvCpy.getString("ISBN"));
                    invCpyTbl.addRow(rawData);
                    
                    rawData = new Vector();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jXTableViewInvMouseReleased

    private void jXTableViewGrnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableViewGrnMouseReleased
        try
        {
            DefaultTableModel grnTbl = (DefaultTableModel)jXTableViewGrn.getModel();
            
            if (jXTableViewGrn.getSelectedRow() != -1)
            {
                DefaultTableModel grnCpyTbl = (DefaultTableModel)jXTableViewGrnCopy.getModel();
                
                grnCpyTbl.setRowCount(0);
                
                int grnId = Integer.parseInt(grnTbl.getValueAt(jXTableViewGrn.getSelectedRow(), 0).toString());
                
                ResultSet rsGrnCpy = SqlConnection.getData("SELECT book_id,batch_id,quantity FROM grn_copy WHERE grn_id=" + grnId );
                Vector rawData = new Vector();
                
                while (rsGrnCpy.next())
                {
                    ResultSet rsBk = SqlConnection.getData("SELECT name AS name FROM book WHERE book_id=" + rsGrnCpy.getInt("book_id"));
                    
                    while (rsBk.next())
                    {
                        rawData.add(rsBk.getString("name"));
                    }
                    
                    ResultSet rsBtc = SqlConnection.getData("SELECT buying_price AS bPrice FROM batch WHERE batch_id=" + rsGrnCpy.getInt("batch_id"));
                    
                    while (rsBtc.next())
                    {
                        rawData.add(rsBtc.getFloat("bPrice"));
                    }
                    
                    rawData.add(rsGrnCpy.getInt("quantity"));
                    
                    grnCpyTbl.addRow(rawData);
                    rawData = new Vector();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jXTableViewGrnMouseReleased

    private void jXTableViewGrnCopyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableViewGrnCopyMouseReleased
        try
        {
            DefaultTableModel grnTbl = (DefaultTableModel)jXTableViewGrn.getModel();
            
            if (jXTableViewGrn.getSelectedRow() != -1)
            {
                int grnId = Integer.parseInt(grnTbl.getValueAt(jXTableViewGrn.getSelectedRow(), 0).toString());
                DefaultTableModel grnCpyTbl = (DefaultTableModel)jXTableViewGrnCopy.getModel();
                
                if (jXTableViewGrnCopy.getSelectedRow() != -1)
                {
                    String bkName = grnCpyTbl.getValueAt(jXTableViewGrnCopy.getSelectedRow(), 0).toString();
                    DefaultTableModel grnIsbn = (DefaultTableModel)jXTableViewGrnCopyIsbn.getModel();
                    grnIsbn.setRowCount(0);
                    Vector rawData = new Vector();
                    
                    ResultSet rsBkId = SqlConnection.getData("SELECT book_id AS book_id FROM book WHERE name='" + bkName + "'");
                    
                    while (rsBkId.next())
                    {
                        int bkId = rsBkId.getInt("book_id");
                        ResultSet rsIsbn = SqlConnection.getData("SELECT ISBN AS ISBN FROM book_copy WHERE grn_id=" + grnId + " AND book_id=" + bkId);
                        
                        while (rsIsbn.next())
                        {
                            rawData.add(rsIsbn.getString("ISBN"));
                            
                            grnIsbn.addRow(rawData);
                            rawData = new Vector();
                        }
                    }
                    
                    
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jXTableViewGrnCopyMouseReleased

    private void cmbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerItemStateChanged

    private void cmbCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCustomerMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerMouseReleased

    private void txtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        calcToPayInv();
    }//GEN-LAST:event_txtPaidKeyReleased

    private void txtPaidGrnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidGrnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidGrnActionPerformed

    private void txtPaidGrnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidGrnKeyReleased
        calcToPayGrn();
    }//GEN-LAST:event_txtPaidGrnKeyReleased

    private void jXTableCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableCustomerMouseReleased
        
        txtCustomerCompany.setText("");

        DefaultTableModel cusTbl = (DefaultTableModel)jXTableCustomer.getModel();

        if (jXTableCustomer.getSelectedRow() != -1)
        {
            String company = cusTbl.getValueAt(jXTableCustomer.getSelectedRow(), 0).toString();
            String name = cusTbl.getValueAt(jXTableCustomer.getSelectedRow(), 1).toString();
            String tel = cusTbl.getValueAt(jXTableCustomer.getSelectedRow(), 2).toString();
            String email = cusTbl.getValueAt(jXTableCustomer.getSelectedRow(), 3).toString();

            try {
                ResultSet rsCus = SqlConnection.getData("SELECT cus_id, address FROM customer WHERE company = '" + company + "'");

                while (rsCus.next())
                {
                    int cus_id = rsCus.getInt("cus_id");
                    String address = rsCus.getString("address");

                    txtCustomerId.setText(Integer.toString(cus_id));
                    txtCustomerAddress.setText(address);
                    txtCustomerName.setText(name);
                    txtCustomerTel.setText(tel);
                    txtCustomerEmail.setText(email);
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jXTableCustomerMouseReleased

    private void btnCustomerClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerClearActionPerformed
        txtCustomerId.setText((""));
        txtCustomerCompany.setText((""));
        txtCustomerName.setText((""));
        txtCustomerTel.setText((""));
        txtCustomerAddress.setText((""));
        txtCustomerEmail.setText((""));
    }//GEN-LAST:event_btnCustomerClearActionPerformed

    private void btnCustomerUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerUpdateActionPerformed
        
        Database db = new Database();
        Customer cus = new Customer();

        try {
            cus.setId(Integer.parseInt(txtCustomerId.getText()));
            cus.setName(txtCustomerName.getText());
            cus.setEmail(txtCustomerEmail.getText());
            cus.setTel(txtCustomerTel.getText());
            cus.setAddress(txtCustomerAddress.getText());

            db.updateCustomer(cus);
            
            refCus();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCustomerUpdateActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        
        String company = txtCustomerCompany.getText();
        int i = 0;
        try {
            ResultSet rsCheck = SqlConnection.getData("SELECT * FROM customer WHERE company='" + company + "'");
            while (rsCheck.next()) {
                i++;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if (i == 0) {

            Database db = new Database();
            Customer cus = new Customer();
            Date DateAndTime = new Date();

            try {
                cus.setCompany(txtCustomerCompany.getText());
                cus.setName(txtCustomerName.getText());
                cus.setTel(txtCustomerTel.getText());
                cus.setDateAndTime(DateAndTime);
                cus.setAddress(txtCustomerAddress.getText());
                cus.setEmail(txtCustomerEmail.getText());
                cus.setUser_id(2);

                db.saveCustomer(cus);
                
                refCus();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void btnInvCreditUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvCreditUpdateActionPerformed
        int inv_id = Integer.parseInt(txtInvId.getText().toString());
        float paid = Float.parseFloat(txtInvCreditInstallment.getText().toString());
        
        DefaultTableModel invCrdTbl = (DefaultTableModel)jXTableInvCredit.getModel();
        
        Credit invCrd = new Credit();
        Database db = new Database();
        
        try
        {
            if (jXTableInvCredit.getSelectedRow() != -1)
            {
                float paidAlrdy = Float.parseFloat(invCrdTbl.getValueAt(jXTableInvCredit.getSelectedRow(), 5).toString());
                paid = paid + paidAlrdy;
                
                invCrd.setInv_id(inv_id);
                invCrd.setPaid(paid);

                db.updateCreditInv(invCrd);
                refInvCredit();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnInvCreditUpdateActionPerformed

    private void btnInvCreditClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvCreditClearActionPerformed
        txtInvId.setText("");
        txtInvCreditCompany.setText("");
        txtInvCreditInstallment.setText("");
    }//GEN-LAST:event_btnInvCreditClearActionPerformed

    private void jXTableInvCreditMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableInvCreditMouseReleased
        txtInvId.setText("");
        txtInvCreditCompany.setText("");

        DefaultTableModel invCrdTbl = (DefaultTableModel)jXTableInvCredit.getModel();

        if (jXTableInvCredit.getSelectedRow() != -1)
        {
            String inv_id = invCrdTbl.getValueAt(jXTableInvCredit.getSelectedRow(), 0).toString();
            String company = invCrdTbl.getValueAt(jXTableInvCredit.getSelectedRow(), 3).toString();
            
            txtInvId.setText(inv_id);
            txtInvCreditCompany.setText(company);
        }
    }//GEN-LAST:event_jXTableInvCreditMouseReleased

    private void btnGrnCreditUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrnCreditUpdateActionPerformed
        int grn_id = Integer.parseInt(txtGrnId.getText().toString());
        float paid = Float.parseFloat(txtGrnCreditInstallment.getText().toString());
        
        DefaultTableModel grnCrdTbl = (DefaultTableModel)jXTableGrnCredit.getModel();
        
        Credit grnCrd = new Credit();
        Database db = new Database();
        
        try
        {
            if (jXTableGrnCredit.getSelectedRow() != -1)
            {
                float paidAlrdy = Float.parseFloat(grnCrdTbl.getValueAt(jXTableGrnCredit.getSelectedRow(), 5).toString());
                paid = paid + paidAlrdy;
                
                grnCrd.setGrn_id(grn_id);
                grnCrd.setPaid(paid);

                db.updateCreditGrn(grnCrd);
                refGrnCredit();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGrnCreditUpdateActionPerformed

    private void btnGrnCreditClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrnCreditClearActionPerformed
        txtGrnId.setText("");
        txtGrnCreditCompany.setText("");
        txtGrnCreditInstallment.setText("");
    }//GEN-LAST:event_btnGrnCreditClearActionPerformed

    private void jXTableGrnCreditMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableGrnCreditMouseReleased
        txtGrnId.setText("");
        txtGrnCreditCompany.setText("");

        DefaultTableModel grnCrdTbl = (DefaultTableModel)jXTableGrnCredit.getModel();

        if (jXTableGrnCredit.getSelectedRow() != -1)
        {
            String grn_id = grnCrdTbl.getValueAt(jXTableGrnCredit.getSelectedRow(), 0).toString();
            String company = grnCrdTbl.getValueAt(jXTableGrnCredit.getSelectedRow(), 3).toString();
            
            txtGrnId.setText(grn_id);
            txtGrnCreditCompany.setText(company);
        }
    }//GEN-LAST:event_jXTableGrnCreditMouseReleased

    private void txtInvCreditInstallmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvCreditInstallmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvCreditInstallmentActionPerformed

    
    private void first() {
        
        refNew();
        refBook();
        refISBN();
        refCat();
        refBatch();
        refSup();
        refCus();
        refUser();
        refInv();
        refGrn();
        refInvCredit();
        refGrnCredit();
    }
    
    private void refNew()
    {
        try
        {
            ResultSet rsNew = SqlConnection.getData("SELECT grn_copy_id, to_add FROM new_book");
            DefaultTableModel newTbl = (DefaultTableModel)jXTableIsbnNewBooks.getModel();
            Vector rawDataNew = new Vector();
            
            newTbl.setRowCount(0);
            
            while (rsNew.next())
            {
                if (rsNew.getInt("to_add") != 0)
                {
                    int book_id;
                    int batch_id;
                    int grn_id;
                    ResultSet rsBkName;
                    ResultSet rsByPrice;
                    ResultSet rsGrnSupId;
                    ResultSet rsGrnSup;

                    ResultSet rsGrnId = SqlConnection.getData("SELECT grn_id,batch_id,book_id FROM grn_copy WHERE grn_copy_id=" + rsNew.getInt("grn_copy_id"));

                    while (rsGrnId.next())
                    {
                        book_id = rsGrnId.getInt("book_id");
                        rawDataNew.add(book_id);
                        rsBkName = SqlConnection.getData("SELECT name AS name FROM book WHERE book_id=" + book_id);

                        while (rsBkName.next())
                        {
                            rawDataNew.add(rsBkName.getString("name"));
                        }

                        batch_id = rsGrnId.getInt("batch_id");
                        rawDataNew.add(batch_id);
                        rawDataNew.add(rsNew.getInt("to_add"));
                        rsByPrice = SqlConnection.getData("SELECT buying_price, selling_price FROM batch WHERE batch_id=" + batch_id);

                        while (rsByPrice.next())
                        {
                            rawDataNew.add(rsByPrice.getFloat("buying_price"));
                            rawDataNew.add(rsByPrice.getFloat("selling_price"));
                        }

                        grn_id = rsGrnId.getInt("grn_id");
                        rsGrnSupId = SqlConnection.getData("SELECT sup_id as sup_id FROM grn WHERE grn_id=" + grn_id);

                        while (rsGrnSupId.next())
                        {
                            rsGrnSup = SqlConnection.getData("SELECT company as company FROM supplier WHERE sup_id=" + rsGrnSupId.getInt("sup_id"));

                            while (rsGrnSup.next())
                            {
                                rawDataNew.add(rsGrnSup.getString("company"));
                            }
                        }

                        rawDataNew.add(grn_id);
                    }

                    newTbl.addRow(rawDataNew);

                    rawDataNew = new Vector();
                }
            }
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    private void refBook()
    {
        try
        {
            ResultSet rsBk = SqlConnection.getData("SELECT book_id, name, description, cat_id FROM book");
            DefaultTableModel bkTbl = (DefaultTableModel)jXTableBook.getModel();
            Vector rawData = new Vector();
            
            cmbBkName.removeAllItems();
            cmbName.removeAllItems();
            bkTbl.setRowCount(0);
            
            while (rsBk.next())
            {
                cmbBkName.addItem(rsBk.getString("name"));
                cmbName.addItem(rsBk.getString("name"));
                
                rawData.add(rsBk.getInt("book_id"));
                rawData.add(rsBk.getString("name"));
                rawData.add(rsBk.getString("description"));
                
                int catId = rsBk.getInt("cat_id");
                ResultSet rsCat = SqlConnection.getData("SELECT cat_name AS cat_name FROM category WHERE cat_id=" + catId);
                
                while (rsCat.next())
                {
                    rawData.add(rsCat.getString("cat_name"));
                }
                
                bkTbl.addRow(rawData);
                rawData = new Vector();
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refCat()
    {
        try
        {
            ResultSet rsCatName = SqlConnection.getData("SELECT cat_name AS cat_name FROM category");
        
            cmbBookCat.removeAllItems();

            while (rsCatName.next())
            {
                cmbBookCat.addItem(rsCatName.getString("cat_name"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refISBN()
    {
        try
        {
            ResultSet rsISBN = SqlConnection.getData("SELECT ISBN,availability FROM book_copy");
            
            cmbISBN.removeAllItems();
            
            while (rsISBN.next())
            {
                if (rsISBN.getInt("availability") == 1)
                {
                    cmbISBN.addItem(rsISBN.getString("ISBN"));
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refInv()
    {
        DefaultTableModel InvTbl = (DefaultTableModel)jXTableViewInv.getModel();
        Vector rawData = new Vector();
        
        try
        {
            ResultSet rsInv = SqlConnection.getData("SELECT * FROM invoice");
            rsInv.afterLast();
            
            InvTbl.setRowCount(0);
            
            while (rsInv.previous())
            {
                rawData.add(rsInv.getInt("inv_id"));
                rawData.add(rsInv.getDate("date"));
                rawData.add(rsInv.getTime("time"));
                
                int cus_id = rsInv.getInt("cus_id");
                
                if (cus_id != 0)
                {
                    ResultSet rsCustomer = SqlConnection.getData("SELECT company AS company FROM customer WHERE cus_id=" + cus_id);
                
                    while (rsCustomer.next())
                    {
                        rawData.add(rsCustomer.getString("company"));
                    }
                }
                else
                {
                    rawData.add("Guest");
                }
                
                rawData.add(rsInv.getFloat("discount"));
                rawData.add(InvTotal(rsInv.getInt("inv_id")));
                
                int user_id = rsInv.getInt("user_id");
                
                ResultSet rsUser = SqlConnection.getData("SELECT name AS name FROM user WHERE user_id=" + user_id);
                
                while (rsUser.next())
                {
                    rawData.add(rsUser.getString("name"));
                }
                
                InvTbl.addRow(rawData);
                rawData = new Vector();
                
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refGrn()
    {
        DefaultTableModel GrnTbl = (DefaultTableModel)jXTableViewGrn.getModel();
        Vector rawData = new Vector();
        
        try
        {
            ResultSet rsGrn = SqlConnection.getData("SELECT * FROM grn");
            rsGrn.afterLast();
            
            GrnTbl.setRowCount(0);
            
            while (rsGrn.previous())
            {
                rawData.add(rsGrn.getInt("grn_id"));
                rawData.add(rsGrn.getDate("date"));
                rawData.add(rsGrn.getTime("time"));
                
                int supId = rsGrn.getInt("sup_id");
                ResultSet rsSup = SqlConnection.getData("SELECT company AS sup FROM supplier WHERE sup_id=" + supId);
                
                while (rsSup.next())
                {
                    rawData.add(rsSup.getString("sup"));
                }
                rawData.add(rsGrn.getString("Veh_no"));
                rawData.add(rsGrn.getFloat("discount"));
                rawData.add(GrnTotal(rsGrn.getInt("grn_id")));
                
                int user_id = rsGrn.getInt("user_id");
                ResultSet rsUser = SqlConnection.getData("SELECT name AS name FROM user WHERE user_id=" + user_id);
                
                while (rsUser.next())
                {
                    rawData.add(rsUser.getString("name"));
                }
                
                GrnTbl.addRow(rawData);
                rawData = new Vector();
                
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refBatch()
    {
        try
        {
            ResultSet rsBatch = SqlConnection.getData("SELECT batch_id, buying_price, selling_price FROM batch");
            DefaultTableModel batchTbl = (DefaultTableModel)jXTableBatch.getModel();
            Vector rawData = new Vector();
            
            batchTbl.setRowCount(0);
            
            while (rsBatch.next())
            {
                rawData.add(rsBatch.getInt("batch_id"));
                rawData.add(rsBatch.getFloat("buying_price"));
                rawData.add(rsBatch.getFloat("selling_price"));
                batchTbl.addRow(rawData);
                rawData = new Vector();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private float InvTotal(int inv_id)
    {
        float discount = 0.0f;
        float totalPrice = 0.0f;
        String isbn;
        
        try
        {
            ResultSet rsDis = SqlConnection.getData("SELECT discount AS discount FROM invoice WHERE inv_id=" + inv_id);
            ResultSet rsInvCpy = SqlConnection.getData("SELECT ISBN AS ISBN FROM invoice_copy WHERE inv_id=" + inv_id);
            
            while (rsDis.next())
            {
                discount = rsDis.getFloat("discount");
            }
            
            while (rsInvCpy.next())
            {
                isbn = rsInvCpy.getString("ISBN");
                
                ResultSet rsBkIdGrnId = SqlConnection.getData("SELECT book_id, grn_id FROM book_copy WHERE ISBN='" + isbn + "'");
                
                while (rsBkIdGrnId.next())
                {
                    int bkId = rsBkIdGrnId.getInt("book_id");
                    int grn_id = rsBkIdGrnId.getInt("grn_id");
                    
                    ResultSet rsBatchId = SqlConnection.getData("SELECT batch_id AS batch_id FROM grn_copy WHERE grn_id=" + grn_id + " AND book_id=" + bkId);
                    
                    while (rsBatchId.next())
                    {
                        int batch_id = rsBatchId.getInt("batch_id");
                        
                        ResultSet rsSellingPrice = SqlConnection.getData("SELECT selling_price AS selling_price FROM batch WHERE batch_id=" + batch_id);
                        
                        while (rsSellingPrice.next())
                        {
                            float sellingPrice = rsSellingPrice.getFloat("selling_price");
                            totalPrice = totalPrice + sellingPrice;
                        }
                    }
                }
            }
            
            totalPrice = totalPrice - totalPrice * discount / 100;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return totalPrice;
    }
    
    private float GrnTotal(int grn_id)
    {
        float discount = 0.0f;
        float totalPrice = 0.0f;
        int qty;
        int batch_id;
        
        try
        {
            ResultSet rsDis = SqlConnection.getData("SELECT discount AS discount FROM grn WHERE grn_id=" + grn_id);
            ResultSet rsGrnCpy = SqlConnection.getData("SELECT batch_id,quantity FROM grn_copy WHERE grn_id=" + grn_id);
            
            while (rsDis.next())
            {
                discount = rsDis.getFloat("discount");
            }
            
            while (rsGrnCpy.next())
            {
                qty = rsGrnCpy.getInt("quantity");
                batch_id = rsGrnCpy.getInt("batch_id");
                
                ResultSet rsBuyingPrice = SqlConnection.getData("SELECT buying_price AS buying_price FROM batch WHERE batch_id=" + batch_id);
                
                while (rsBuyingPrice.next())
                {
                    totalPrice = totalPrice + rsBuyingPrice.getFloat("buying_price") * qty;
                }
            }
            
            totalPrice = totalPrice - totalPrice * discount / 100;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return totalPrice;
    }
    
    private void refInvCredit()
    {
        try
        {
            ResultSet rsInvCrd = SqlConnection.getData("SELECT inv_id, paid FROM credit_inv");
            DefaultTableModel invCrdTbl = (DefaultTableModel)jXTableInvCredit.getModel();
            Vector rawDataInvCrd = new Vector();
            
            invCrdTbl.setRowCount(0);
            
            while (rsInvCrd.next())
            {
                int inv_id = rsInvCrd.getInt("inv_id");
                rawDataInvCrd.add(inv_id);
                float paid = rsInvCrd.getFloat("paid");
                int user_id;
                int cus_id;
                ResultSet rsUserName;
                ResultSet rsCusName;

                ResultSet rsInvDetails = SqlConnection.getData("SELECT date,time,user_id,cus_id FROM invoice WHERE inv_id=" + inv_id);

                while (rsInvDetails.next())
                {
                    user_id = rsInvDetails.getInt("user_id");
                    cus_id = rsInvDetails.getInt("cus_id");
                    rawDataInvCrd.add(rsInvDetails.getDate("date"));
                    rawDataInvCrd.add(rsInvDetails.getTime("time"));
                    
                    rsCusName = SqlConnection.getData("SELECT company AS company FROM customer WHERE cus_id=" + cus_id);

                    while (rsCusName.next())
                    {
                        rawDataInvCrd.add(rsCusName.getString("company"));
                    }
                    
                    rawDataInvCrd.add(InvTotal(inv_id));
                    
                    rawDataInvCrd.add(paid);
                    
                    rsUserName = SqlConnection.getData("SELECT name AS name FROM user WHERE user_id=" + user_id);

                    while (rsUserName.next())
                    {
                        rawDataInvCrd.add(rsUserName.getString("name"));
                    }
                }

                invCrdTbl.addRow(rawDataInvCrd);

                rawDataInvCrd = new Vector();
            }
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refGrnCredit()
    {
        try
        {
            ResultSet rsGrnCrd = SqlConnection.getData("SELECT grn_id, paid FROM credit_grn");
            DefaultTableModel grnCrdTbl = (DefaultTableModel)jXTableGrnCredit.getModel();
            Vector rawDataGrnCrd = new Vector();
            
            grnCrdTbl.setRowCount(0);
            
            while (rsGrnCrd.next())
            {
                int grn_id = rsGrnCrd.getInt("grn_id");
                rawDataGrnCrd.add(grn_id);
                float paid = rsGrnCrd.getFloat("paid");
                int user_id;
                int sup_id;
                ResultSet rsUserName;
                ResultSet rsSupName;

                ResultSet rsInvDetails = SqlConnection.getData("SELECT date,time,user_id,sup_id FROM grn WHERE grn_id=" + grn_id);

                while (rsInvDetails.next())
                {
                    user_id = rsInvDetails.getInt("user_id");
                    sup_id = rsInvDetails.getInt("sup_id");
                    rawDataGrnCrd.add(rsInvDetails.getDate("date"));
                    rawDataGrnCrd.add(rsInvDetails.getTime("time"));
                    
                    rsSupName = SqlConnection.getData("SELECT company AS company FROM supplier WHERE sup_id=" + sup_id);

                    while (rsSupName.next())
                    {
                        rawDataGrnCrd.add(rsSupName.getString("company"));
                    }
                    
                    rawDataGrnCrd.add(GrnTotal(grn_id));
                    
                    rawDataGrnCrd.add(paid);
                    
                    rsUserName = SqlConnection.getData("SELECT name AS name FROM user WHERE user_id=" + user_id);

                    while (rsUserName.next())
                    {
                        rawDataGrnCrd.add(rsUserName.getString("name"));
                    }
                }

                grnCrdTbl.addRow(rawDataGrnCrd);

                rawDataGrnCrd = new Vector();
            }
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refSup()
    {
        try
        {
            ResultSet rsSup = SqlConnection.getData("SELECT company, agent_name, telephone, email FROM supplier");
            ResultSet rsSupp = SqlConnection.getData("SELECT company FROM supplier");
            DefaultTableModel supTbl = (DefaultTableModel)jXTableSup.getModel();
            Vector rawDataSup = new Vector();
            
            supTbl.setRowCount(0);
            cmbSup.removeAllItems();
            
            while (rsSup.next())
            {
                rawDataSup.add(rsSup.getString("company"));
                rawDataSup.add(rsSup.getString("agent_name"));
                rawDataSup.add(rsSup.getString("telephone"));
                rawDataSup.add(rsSup.getString("email"));
                supTbl.addRow(rawDataSup);
                rawDataSup = new Vector();
            }
            
            while (rsSupp.next())
            {
                cmbSup.addItem(rsSupp.getString("company"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refCus()
    {
        try
        {
            ResultSet rsCus = SqlConnection.getData("SELECT company, agent_name, telephone, email FROM customer");
            ResultSet rsCust = SqlConnection.getData("SELECT company FROM customer");
            DefaultTableModel cusTbl = (DefaultTableModel)jXTableCustomer.getModel();
            Vector rawDataCus = new Vector();
            
            cusTbl.setRowCount(0);
            cmbCustomer.removeAllItems();
            
            cmbCustomer.addItem("Guest");
            
            while (rsCus.next())
            {
                rawDataCus.add(rsCus.getString("company"));
                rawDataCus.add(rsCus.getString("agent_name"));
                rawDataCus.add(rsCus.getString("telephone"));
                rawDataCus.add(rsCus.getString("email"));
                cusTbl.addRow(rawDataCus);
                rawDataCus = new Vector();
            }
            
            while (rsCust.next())
            {
                cmbCustomer.addItem(rsCust.getString("company"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void refUser()
    {
        try
        {
            ResultSet rsUser = SqlConnection.getData("SELECT name, username, nic, reg_date, type FROM user");
            DefaultTableModel userTbl = (DefaultTableModel)jXTableUser.getModel();
            Vector rawDataUser = new Vector();
            
            userTbl.setRowCount(0);
            
            while (rsUser.next())
            {
                rawDataUser.add(rsUser.getString("name"));
                rawDataUser.add(rsUser.getString("username"));
                rawDataUser.add(rsUser.getString("nic"));
                rawDataUser.add(rsUser.getString("type"));
                rawDataUser.add(rsUser.getString("reg_date"));
                userTbl.addRow(rawDataUser);
                rawDataUser = new Vector();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void calcPaymentGRN() {
        try
        {
            float uPrice = Float.parseFloat(selling_price);
            int qty = Integer.parseInt(txtQty.getText());
            
            lblPayment.setText("Rs. " + Float.toString(uPrice * qty));
        }
        catch (NumberFormatException ex)
        {
            lblPayment.setText("Invalid input!");
        }
    }
    
    private void calcGrossPayment() {
        try
        {
            float net = Float.parseFloat(lblNetPayment.getText());
            float dis = Float.parseFloat(txtDiscount.getText());
            
            float gross = net - (net / 100) * dis;
            
            lblGrossPayment.setText(Float.toString(gross));
        }
        catch (NumberFormatException ex)
        {
            lblGrossPayment.setText("Invalid input!");
        }
    }
    
    private void calcToPayInv() {
        try
        {
            float toPay = Float.parseFloat(lblGrossPaymentInv.getText()) - Float.parseFloat(txtPaid.getText());
            lblToPay.setText(Float.toString(toPay));
        }
        catch (NumberFormatException ex)
        {
            lblToPay.setText("Invalid input!");
        }
    }
    
    private void calcToPayGrn()
    {
        try
        {
            float toPay = Float.parseFloat(lblGrossPayment.getText()) - Float.parseFloat(txtPaidGrn.getText());
            lblToPayGrn.setText(Float.toString(toPay));
        }
        catch (NumberFormatException ex)
        {
            lblToPayGrn.setText("Invalid input!");
        }
    }
    
    private void calcGrossPaymentInvoice() {
        try
        {
            float net = Float.parseFloat(lblNetPaymentInv.getText());
            float dis = Float.parseFloat(txtDiscountInv.getText());
            
            float gross = net - (net / 100) * dis;
            
            lblGrossPaymentInv.setText(Float.toString(gross));
        }
        catch (NumberFormatException ex)
        {
            lblGrossPaymentInv.setText("Invalid input!");
        }
    }
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookClear;
    private javax.swing.JButton btnBookUpdate;
    private javax.swing.JButton btnCustomerActive;
    private javax.swing.JButton btnCustomerClear;
    private javax.swing.JButton btnCustomerUpdate;
    private javax.swing.JButton btnGrnCreditClear;
    private javax.swing.JButton btnGrnCreditUpdate;
    private javax.swing.JButton btnInvCreditClear;
    private javax.swing.JButton btnInvCreditUpdate;
    private javax.swing.JButton btnIsbnClear;
    private javax.swing.JButton btnIsbnNewISBN;
    private javax.swing.JButton btnManageBatches;
    private javax.swing.JButton btnManageCategories;
    private javax.swing.JButton btnNewBook;
    private javax.swing.JButton btnNewCustomer;
    private javax.swing.JButton btnNewSup;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JButton btnOpenUserImage;
    private javax.swing.JButton btnSupActive;
    private javax.swing.JButton btnSupActive1;
    private javax.swing.JButton btnSupUpdate;
    private javax.swing.JButton btnUserActive;
    private javax.swing.JButton btnUserActive1;
    private javax.swing.JButton btnUserUpdate;
    private javax.swing.JCheckBox cbCredit;
    private javax.swing.JCheckBox cbCreditGrn;
    private javax.swing.JComboBox<String> cmbBkName;
    private javax.swing.JComboBox<String> cmbBookCat;
    private javax.swing.JComboBox<String> cmbBooksSearchBy;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbISBN;
    private javax.swing.JComboBox<String> cmbName;
    private javax.swing.JComboBox<String> cmbSup;
    private javax.swing.JComboBox<String> cmbUserType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private org.jdesktop.swingx.JXTable jXTableBatch;
    private org.jdesktop.swingx.JXTable jXTableBook;
    private org.jdesktop.swingx.JXTable jXTableCustomer;
    private org.jdesktop.swingx.JXTable jXTableGrn;
    private org.jdesktop.swingx.JXTable jXTableGrnCredit;
    private org.jdesktop.swingx.JXTable jXTableInv;
    private org.jdesktop.swingx.JXTable jXTableInvCredit;
    private org.jdesktop.swingx.JXTable jXTableIsbnNewBooks;
    private org.jdesktop.swingx.JXTable jXTableSup;
    private org.jdesktop.swingx.JXTable jXTableUser;
    private org.jdesktop.swingx.JXTable jXTableViewGrn;
    private org.jdesktop.swingx.JXTable jXTableViewGrnCopy;
    private org.jdesktop.swingx.JXTable jXTableViewGrnCopyIsbn;
    private org.jdesktop.swingx.JXTable jXTableViewInv;
    private org.jdesktop.swingx.JXTable jXTableViewInvCopy;
    private javax.swing.JLabel lblGrossPayment;
    private javax.swing.JLabel lblGrossPaymentInv;
    private javax.swing.JLabel lblIsbnISBN;
    private javax.swing.JLabel lblIsbnISBN1;
    private javax.swing.JLabel lblIsbnISBN2;
    private javax.swing.JLabel lblIsbnISBN3;
    private javax.swing.JLabel lblIsbnISBN4;
    private javax.swing.JLabel lblIsbnISBN5;
    private javax.swing.JLabel lblNetPayment;
    private javax.swing.JLabel lblNetPaymentInv;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblToPay;
    private javax.swing.JLabel lblToPayGrn;
    private javax.swing.JLabel lblUPriceInv;
    private javax.swing.JLabel lblUserImage;
    private javax.swing.JTextArea txtAreaBookDes;
    private javax.swing.JTextField txtBookImg;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtBooksSearch;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerCompany;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JLabel txtCustomerId;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerTel;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDiscountInv;
    private javax.swing.JTextField txtGrnCreditCompany;
    private javax.swing.JTextField txtGrnCreditInstallment;
    private javax.swing.JLabel txtGrnId;
    private javax.swing.JTextField txtInvCreditCompany;
    private javax.swing.JTextField txtInvCreditInstallment;
    private javax.swing.JLabel txtInvId;
    private javax.swing.JLabel txtIsbnBookId;
    private javax.swing.JTextField txtIsbnISBN;
    private javax.swing.JTextField txtIsbnName;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtPaidGrn;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSupAddress;
    private javax.swing.JTextField txtSupCompany;
    private javax.swing.JTextField txtSupEmail;
    private javax.swing.JLabel txtSupId;
    private javax.swing.JTextField txtSupName;
    private javax.swing.JTextField txtSupTel;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JLabel txtUserId;
    private javax.swing.JTextField txtUserNIC;
    private javax.swing.JPasswordField txtUserPassword;
    private javax.swing.JTextField txtUserRealName;
    private javax.swing.JTextField txtUserUsername;
    private javax.swing.JTextField txtVeh;
    // End of variables declaration//GEN-END:variables
}
