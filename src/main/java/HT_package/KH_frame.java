/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HT_package;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ana
 */
public class KH_frame extends javax.swing.JFrame {
    private static final String username = "root" ;
    private static final String password = "nepe" ;
    private static final String databaseCon = "jdbc:mysql://127.0.0.1:3306/connector" ;
    Connection sqlCon = null;
    PreparedStatement pst = null;
    ResultSet rs = null ;
    int i,q,id, deleteItem ;
    /**
     * Creates new form NewJFrame
     */
    public KH_frame() {
        initComponents();      
    }
// FUNCTION
    public void upDateDB(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    pst =sqlCon.prepareStatement("select * from khach_hang");
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("Name"));
    System.out.println(rs.getString("Name"));
    columnData.add(rs.getString("ID"));
    columnData.add(rs.getString("Phone"));
    columnData.add(rs.getString("Creditcard"));
    columnData.add(rs.getString("Address"));
    columnData.add(rs.getString("Date_contacted"));
    columnData.add(rs.getString("Citizen_id"));
    columnData.add(rs.getString("Accompany"));
    }
    RecordTable.addRow(columnData);
    
    }
    } catch (Exception ex){
    JOptionPane.showMessageDialog(null , ex);
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTfName = new javax.swing.JTextField();
        jTfId = new javax.swing.JTextField();
        jTfCDN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBAdd = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBSHOW = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTfPhone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfAddress = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jBReset = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTfDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTfCitizen = new javax.swing.JTextField();
        jTfAccompany = new javax.swing.JTextField();
        jBSearch = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTfQuery = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("  TÊN KHÁCH HÀNG");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("  ID                ");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("  CREDIT CARD NUM ");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfNameActionPerformed(evt);
            }
        });

        jTfId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfIdActionPerformed(evt);
            }
        });

        jTfCDN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfCDN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfCDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfCDNActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÊN KHÁCH", "ID", "SỐ DT", "CreCardN", "ĐỊA CHỈ", "NGÀY NHẬN PHÒNG", "CCCD", "NGƯỜI ĐI KÈM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBAdd.setBackground(new java.awt.Color(153, 204, 255));
        jBAdd.setText("ADD");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBUpdate.setBackground(new java.awt.Color(153, 204, 255));
        jBUpdate.setText("UPDATE");
        jBUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateActionPerformed(evt);
            }
        });

        jBDelete.setBackground(new java.awt.Color(153, 204, 255));
        jBDelete.setText("DELETE");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        jBSHOW.setBackground(new java.awt.Color(153, 204, 255));
        jBSHOW.setText("SHOW");
        jBSHOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSHOWActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("  SỐ ĐIỆN THOẠI");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfPhoneActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("  ĐỊA CHỈ");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfAddressActionPerformed(evt);
            }
        });

        jBExit.setBackground(new java.awt.Color(153, 204, 255));
        jBExit.setText("Exit");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jBReset.setText("RESET");
        jBReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetActionPerformed(evt);
            }
        });

        jBPrint.setText("PRINT");
        jBPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrintActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("NGÀY LIÊN HỆ");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfDateActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("  CĂN CƯỚC CÔNG DÂN");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("  SỐ NGƯỜI ĐI KÈM");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfCitizen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfCitizen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfCitizen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfCitizenActionPerformed(evt);
            }
        });

        jTfAccompany.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfAccompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jBSearch.setText("SEARCH");
        jBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearchActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText(" TRUY VẤN");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfQuery.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfQuery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfQueryActionPerformed(evt);
            }
        });

        jButton1.setText("PHOTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfAddress)
                            .addComponent(jTfCDN)
                            .addComponent(jTfName)
                            .addComponent(jTfPhone)
                            .addComponent(jTfId)
                            .addComponent(jTfDate)
                            .addComponent(jTfAccompany)
                            .addComponent(jTfCitizen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTfQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBReset, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLPicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBSHOW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTfName)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTfCDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jBUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTfCitizen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTfAccompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jBReset))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTfQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfIdActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
       try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    pst =sqlCon.prepareStatement("insert into khach_hang (Name,ID,Phone,Creditcard,Address,Date_contacted,Citizen_id,Accompany)value(?,?,?,?,?,?,?,?)");
    pst.setString(1,jTfName.getText() );
    pst.setString(2,jTfId.getText() );
    pst.setString(3,jTfPhone.getText() );
    pst.setString(4,jTfCDN.getText() );
    pst.setString(5,jTfAddress.getText());
    pst.setString(6,jTfDate.getText() );
    pst.setString(7,jTfCitizen.getText() );
    pst.setString(8,jTfAccompany.getText());
    pst.executeUpdate();
    JOptionPane.showMessageDialog(this,"record added");
    upDateDB();
    }//GEN-LAST:event_jBAddActionPerformed
    catch(Exception ex) {
    JOptionPane.showMessageDialog(null, ex);
    }}
    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed
         try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    pst =sqlCon.prepareStatement("update khach_hang set Name =?,Phone =?,Creditcard =?,Address =?,Date_contacted =?,Citizen_id =?,Accompany =? where ID =?");
    pst.setString(1,jTfName.getText() );
    pst.setString(2,jTfPhone.getText() );
    pst.setString(3,jTfCDN.getText() );
    pst.setString(4,jTfAddress.getText());
 
    pst.setString(5,jTfDate.getText() );
    pst.setString(6,jTfCitizen.getText() );
    pst.setString(7,jTfAccompany.getText());
    pst.setString(8,jTfId.getText() );
    pst.executeUpdate();
    JOptionPane.showMessageDialog(this,"record updated");
    upDateDB();
    }                                     
    catch(Exception ex) {
    JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_jBUpdateActionPerformed

    private void jBSHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOWActionPerformed
        // TODO add your handling code here:
        upDateDB();
    }//GEN-LAST:event_jBSHOWActionPerformed

    private void jTfPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfPhoneActionPerformed
private JFrame frame;
    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog( frame,"Confirm Exit","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        System.exit(0);
        }
    }//GEN-LAST:event_jBExitActionPerformed

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetActionPerformed
        // TODO add your handling code here:
        jTfName.setText("");
        jTfId.setText("");
        jTfPhone.setText("");
        jTfAddress.setText("");
        jTfCDN.setText("");
        jTfDate.setText("");
        jTfAccompany.setText("");
        jTfCitizen.setText("");
        jTfQuery.setText("");
        
    }//GEN-LAST:event_jBResetActionPerformed

    private void jTfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfNameActionPerformed

    private void jTfCDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfCDNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfCDNActionPerformed

    private void jTfAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfAddressActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
       
       int selectedrows= jTable1.getSelectedRow();
       
       jTfName.setText(RecordTable.getValueAt(selectedrows, 0).toString());
       jTfId.setText(RecordTable.getValueAt(selectedrows, 1).toString());
       jTfPhone.setText(RecordTable.getValueAt(selectedrows, 2).toString());
       jTfCDN.setText(RecordTable.getValueAt(selectedrows, 3).toString());
       jTfAddress.setText(RecordTable.getValueAt(selectedrows,4).toString());
       jTfDate.setText(RecordTable.getValueAt(selectedrows,5).toString());
       jTfCitizen.setText(RecordTable.getValueAt(selectedrows,6).toString());
       jTfAccompany.setText(RecordTable.getValueAt(selectedrows,7).toString());
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBPrintActionPerformed

    private void jTfDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfDateActionPerformed

    private void jTfCitizenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfCitizenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfCitizenActionPerformed

    private void jBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearchActionPerformed
try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    String qr1="",qr2="";
    if(!jTfId.getText().isEmpty()){
        qr1="ID";qr2=jTfId.getText();
    }
    else if(!jTfName.getText().isEmpty()){
        qr1="Name";qr2=jTfName.getText();
    }
    else if(!jTfPhone.getText().isEmpty()){
        qr1="Phone";qr2=jTfPhone.getText();
    }
    else if(!jTfCDN.getText().isEmpty()){
        qr1="Creditcard";qr2=jTfCDN.getText();
    }
    else if(!jTfAddress.getText().isEmpty()){
        qr1="Address";qr2=jTfAddress.getText();
    }
    else if(!jTfDate.getText().isEmpty()){
        qr1="Date_contacted";qr2=jTfDate.getText();
    }
    else if(!jTfCitizen.getText().isEmpty()){
        qr1="Citizen_id";qr2=jTfCitizen.getText();
    }
    else if(!jTfAccompany.getText().isEmpty()){
        qr1="Accompany";qr2=jTfAccompany.getText();
    }
    switch (jTfQuery.getText()){
        case "" :
    pst =sqlCon.prepareStatement(" select * from khach_hang where " + qr1 + " like '%"+ qr2 +"%'");
    break;
        case ">" :
        case "<" :
        case "=" :
        case ">=" :
        case "<=" :
        case "<>" :            
    pst =sqlCon.prepareStatement(" select * from khach_hang where " + qr1 +" "+jTfQuery.getText()+" '"+ qr2+"'" );
    break;
        default :
    String q =" select * from khach_hang where " + qr1 +" BETWEEN '"+qr2+"' AND '"+ jTfQuery.getText()+ "'";
            System.out.println(q);
    pst =sqlCon.prepareStatement(q );
}
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("Name"));
    System.out.println(rs.getString("Name"));
    columnData.add(rs.getString("ID"));
    columnData.add(rs.getString("Phone"));
    columnData.add(rs.getString("Creditcard"));
    columnData.add(rs.getString("Address"));
    columnData.add(rs.getString("Date_contacted"));
    columnData.add(rs.getString("Citizen_id"));
    columnData.add(rs.getString("Accompany"));
    }
    RecordTable.addRow(columnData);
    
    }
    } catch (Exception ex){
    JOptionPane.showMessageDialog(null , ex);
    }
    }//GEN-LAST:event_jBSearchActionPerformed

    private void jTfQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfQueryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(!jTfId.getText().isEmpty()){
        String file ="Resource_Image/"+jTfId.getText()+".jpg";
        jLPicture.setIcon(new ImageIcon(file));
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(KH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KH_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBPrint;
    private javax.swing.JButton jBReset;
    private javax.swing.JButton jBSHOW;
    private javax.swing.JButton jBSearch;
    private javax.swing.JButton jBUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLPicture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTfAccompany;
    private javax.swing.JTextField jTfAddress;
    private javax.swing.JTextField jTfCDN;
    private javax.swing.JTextField jTfCitizen;
    private javax.swing.JTextField jTfDate;
    private javax.swing.JTextField jTfId;
    private javax.swing.JTextField jTfName;
    private javax.swing.JTextField jTfPhone;
    private javax.swing.JTextField jTfQuery;
    // End of variables declaration//GEN-END:variables
}
