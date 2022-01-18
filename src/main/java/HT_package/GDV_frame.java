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
public class GDV_frame extends javax.swing.JFrame {
   
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
    public GDV_frame() {
        initComponents();      
    }
// FUNCTION
    public void upDateDB(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    pst =sqlCon.prepareStatement("select * from gia_dich_vu");
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("ID_Service"));
    System.out.println(rs.getString("ID_Service"));
    columnData.add(rs.getString("Description"));
    columnData.add(rs.getString("Service_Price"));
    columnData.add(rs.getString("From_Date"));
    if(rs.getString("To_Date")!=null)
    columnData.add(rs.getString("To_Date"));
    else
    columnData.add("");

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
        jTfID = new javax.swing.JTextField();
        jTfDescription = new javax.swing.JTextField();
        jTfFromDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBAdd = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBSHOW = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTfPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfToDate = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jBReset = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();
        jBSearch = new javax.swing.JButton();
        jTfQuery = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLPicture = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("MÃ DỊCH VỤ");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("MÔ TẢ");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("TỪ NGÀY");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfIDActionPerformed(evt);
            }
        });

        jTfDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfDescriptionActionPerformed(evt);
            }
        });

        jTfFromDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfFromDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfFromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfFromDateActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ DỊCH VỤ", "MÔ TẢ", "GIÁ DỊCH VỤ", "TỪ NGÀY", "ĐẾN NGÀY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jLabel1.setText("GIÁ DỊCH VỤ");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfPriceActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ĐẾN NGÀY");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfToDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfToDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfToDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfToDateActionPerformed(evt);
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

        jBSearch.setText("SEARCH");
        jBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearchActionPerformed(evt);
            }
        });

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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("TRUY VẤN");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTfToDate)
                            .addComponent(jTfFromDate)
                            .addComponent(jTfID)
                            .addComponent(jTfPrice)
                            .addComponent(jTfDescription)
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTfID)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTfFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTfToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTfQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBReset)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTfDescription.getText().isEmpty()){
            String file ="Resource_Image/"+jTfDescription.getText()+".jpg";
            jLPicture.setIcon(new ImageIcon(file));
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void jTfQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfQueryActionPerformed

    private void jBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearchActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            // process the results
            String qr1="",qr2="";
            if(!jTfID.getText().isEmpty()){
                qr1="ID_service";qr2=jTfID.getText();
                
            }
            else if(!jTfDescription.getText().isEmpty()){
                qr1="Description";qr2=jTfDescription.getText();
            }
            else if(!jTfPrice.getText().isEmpty()){
                qr1="Service_Price";qr2=jTfPrice.getText();
            }
            else if(!jTfFromDate.getText().isEmpty()){
                qr1="From_Date";qr2=jTfFromDate.getText();
            }
            else if(!jTfToDate.getText().isEmpty()){
                qr1="To_Date";qr2=jTfToDate.getText();
            }
            else if(jTfToDate.getText().isEmpty()){
              qr1="To_Date";qr2="NULL";
              jTfQuery.setText("now");
            }
            switch (jTfQuery.getText()){
                case "" :
                pst =sqlCon.prepareStatement(" select * from gia_dich_vu where " + qr1 + " like '%"+ qr2 +"%'");
                break;
                case "now":
                pst =sqlCon.prepareStatement(" select * from gia_dich_vu where " + qr1 + " is "+ qr2 );   
                    System.out.println(" select * from gia_dich_vu where " + qr1 + " is "+ qr2 +"");
                break;
                case ">" :
                case "<" :
                case "=" :
                case ">=" :
                case "<=" :
                case "<>" :
                pst =sqlCon.prepareStatement(" select * from gia_dich_vu where " + qr1 +" "+jTfQuery.getText()+" '"+ qr2+"'" );
                break;
                default :
                String q =" select * from gia_dich_vu where " + qr1 +" BETWEEN '"+qr2+"' AND '"+ jTfQuery.getText()+ "'";
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
                    columnData.add(rs.getString("ID_Service"));
                    columnData.add(rs.getString("Description"));
                    columnData.add(rs.getString("Service_Price"));
                    columnData.add(rs.getString("From_Date"));
                    if(rs.getString("To_Date")!=null)
                    columnData.add(rs.getString("To_Date"));
                     else
                    columnData.add("");
              
                }
                RecordTable.addRow(columnData);

            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null , ex);
        }
    }//GEN-LAST:event_jBSearchActionPerformed

    private void jBPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBPrintActionPerformed

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetActionPerformed
        // TODO add your handling code here:
        jTfID.setText("");
        jTfDescription.setText("");
        jTfPrice.setText("");
        jTfToDate.setText("");
        jTfFromDate.setText("");
        jTfQuery.setText("");

    }//GEN-LAST:event_jBResetActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog( frame,"Confirm Exit","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jBExitActionPerformed

    private void jTfToDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfToDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfToDateActionPerformed

    private void jTfPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfPriceActionPerformed

    private void jBSHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOWActionPerformed
        // TODO add your handling code here:
        upDateDB();
    }//GEN-LAST:event_jBSHOWActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            pst =sqlCon.prepareStatement("delete from gia_dich_vu where ID = '"+jTfDescription.getText()+"'");
            frame = new JFrame("delete");
            if(JOptionPane.showConfirmDialog( frame,"Confirm Delete","Khach Hang "+jTfDescription.getText(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"record updated");
                upDateDB();
            }
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            pst =sqlCon.prepareStatement("update gia_dich_vu set ID_Service =?,Description =?,Service_price =?,From_Date =?");
            pst.setString(1,jTfID.getText() );
            pst.setString(3,jTfPrice.getText() );
            pst.setString(4,jTfFromDate.getText() );
            pst.setString(2,jTfDescription.getText());
            if(JOptionPane.showConfirmDialog( frame,"Confirm Update","GÍA DỊCH VỤ "+jTfDescription.getText(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"record updated");
                upDateDB();
            }

        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jBUpdateActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed

        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            if(!jTfID.getText().isEmpty()&&jTfToDate.getText().isEmpty()){
            
                String date="update gia_dich_vu set To_Date = DATE_SUB('"+ jTfFromDate.getText()+"', INTERVAL 1 DAY ) where ( ID_Service = '"+jTfID.getText() +"') and ( To_Date is null ) " ;
                System.out.println(date);
                pst =sqlCon.prepareStatement(date);
                pst.executeUpdate();
                pst =sqlCon.prepareStatement("insert into gia_dich_vu (ID_Service,Description,Service_price,From_Date)value(?,?,?,?)");
                pst.setString(1,jTfID.getText() );
                pst.setString(2,jTfDescription.getText() );
                pst.setString(3,jTfPrice.getText() );
                pst.setString(4,jTfFromDate.getText() );             
        
            }
            else if(!jTfID.getText().isEmpty()&&!jTfToDate.getText().isEmpty()){
                String date="update gia_dich_vu set To_Date = DATE_SUB('"+ jTfFromDate.getText()+"', INTERVAL 1 DAY ) where ( ID_Service = '"+jTfID.getText() +"') and ( To_Date is null ) " ;
                System.out.println(date);
                pst =sqlCon.prepareStatement(date);
                pst.executeUpdate();
                pst =sqlCon.prepareStatement("insert into gia_dich_vu (ID_Service,Description,Service_price,From_Date,To_Date)value(?,?,?,?,?)");
                pst.setString(1,jTfID.getText() );
                pst.setString(2,jTfDescription.getText() );
                pst.setString(3,jTfPrice.getText() );
                pst.setString(4,jTfFromDate.getText() );      
                pst.setString(5,jTfToDate.getText());
            }
            else  {
                pst =sqlCon.prepareStatement("insert into gia_dich_vu (Description,Service_price,From_Date)value(?,?,?)");
            pst.setString(1,jTfDescription.getText() );
            pst.setString(2,jTfPrice.getText() );
            if(!jTfFromDate.getText().isEmpty())
            pst.setString(3,jTfFromDate.getText() );
            else
            pst.setString(3, java.time.LocalDate.now().toString());
  
            }
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Giá Dịch Vụ đã được lưu lại");
            upDateDB();
        
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jBAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();

        int selectedrows= jTable1.getSelectedRow();

        jTfID.setText(RecordTable.getValueAt(selectedrows, 0).toString());
        jTfDescription.setText(RecordTable.getValueAt(selectedrows, 1).toString());
        jTfPrice.setText(RecordTable.getValueAt(selectedrows, 2).toString());
        jTfFromDate.setText(RecordTable.getValueAt(selectedrows, 3).toString());
        jTfToDate.setText(RecordTable.getValueAt(selectedrows,4).toString());
        String file ="Resource_Image/"+jTfDescription.getText()+".jpg";
        jLPicture.setIcon(new ImageIcon(file));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTfFromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfFromDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfFromDateActionPerformed

    private void jTfDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfDescriptionActionPerformed

    private void jTfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfIDActionPerformed
       
        private JFrame frame;    
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
            java.util.logging.Logger.getLogger(GDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDV_frame().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTfDescription;
    private javax.swing.JTextField jTfFromDate;
    private javax.swing.JTextField jTfID;
    private javax.swing.JTextField jTfPrice;
    private javax.swing.JTextField jTfQuery;
    private javax.swing.JTextField jTfToDate;
    // End of variables declaration//GEN-END:variables
}
