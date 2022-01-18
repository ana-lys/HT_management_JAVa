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
public class PH_frame extends javax.swing.JFrame {
   
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
    public PH_frame() {
        initComponents();      
    }
// FUNCTION
    public void upDateDB(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    pst =sqlCon.prepareStatement("select * from phong");
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("ID_ROOM"));
    System.out.println(rs.getString("ID_ROOM"));
    columnData.add(rs.getString("ID_SECTOR"));
    columnData.add(rs.getString("ROOM_CLASS"));
    if(rs.getString("Ready")!=null)
    columnData.add(rs.getString("Ready"));
    else
    columnData.add("");
    if(rs.getString("DESCRIPTION")!=null)
    columnData.add(rs.getString("DESCRIPTION"));
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
        jTfSector = new javax.swing.JTextField();
        jTfDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBAdd = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBSHOW = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTfClass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfDescript = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jBReset = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();
        jBSearch = new javax.swing.JButton();
        jTfQuery = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLPicture = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCBClass = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID PHÒNG");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("KHU VỰC");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("SẴN SÀNG");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTfID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfIDActionPerformed(evt);
            }
        });

        jTfSector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTfSector.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfSectorActionPerformed(evt);
            }
        });

        jTfDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTfDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfDateActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PHONG", "KHU VUC", "LOẠI PHÒNG", "SẴN SÀNG", "MÔ TẢ"
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
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("LOẠI PHÒNG");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTfClass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfClassActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("MÔ TẢ");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfDescript.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTfDescript.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfDescript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfDescriptActionPerformed(evt);
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

        jTfQuery.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("TRUY VẤN");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jCBClass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Queen", "King", "Deluxe", "Classic", "Single" }));
        jCBClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBClassItemStateChanged(evt);
            }
        });
        jCBClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBClassMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBClassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCBClassMouseReleased(evt);
            }
        });
        jCBClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBClassActionPerformed(evt);
            }
        });
        jCBClass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCBClassPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addComponent(jBSHOW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTfDescript)
                    .addComponent(jTfSector)
                    .addComponent(jTfQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(jTfID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jCBClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfClass, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTfDate))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBReset, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTfSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTfClass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTfDescript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jBUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jBPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBReset)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTfSector.getText().isEmpty()){
            String file ="Resource_Image/"+jTfSector.getText()+".jpg";
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
            String qr1="",qr2="",qr3="",qr4="";
            if(!jTfID.getText().isEmpty()){
                qr1="ID_Room";qr2=jTfID.getText()+"'";
               pst =sqlCon.prepareStatement(" select * from phong where " + qr1 + "= '"+ qr2);
               
                System.out.println(" select * from phong where " + qr1 + "= '"+ qr2+"'");
            }
            else if(jTfDate.getText().isEmpty()&&!jTfClass.getText().isEmpty()&&!jTfClass.getText().equals("All")){    
            qr3="Room_Class";
            qr4=jTfClass.getText();
                pst =sqlCon.prepareStatement(" select * from phong where (Ready >= 1 )and ("+ qr3+ "= '"+ qr4 +"')");
                System.out.println(" select * from phong where (Ready >= 1 )and ("+ qr3+ "= '"+ qr4 +"')");
            }
          
            else if(!jTfDate.getText().isEmpty())
            {   qr1="Ready";
                qr2= "1";
                pst =sqlCon.prepareStatement(" select * from phong where " + qr1 + "= "+ qr2  );
            }
            else
            {   qr1="Ready";
            pst =sqlCon.prepareStatement(" select * from phong where " + qr1 + " = '1' "  );
            }
     
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();
            
            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
            
            while( RecordTable.getRowCount() > 0)
            {
            RecordTable.removeRow(0);
            }
            RecordTable.setRowCount(0);
            while(rs.next()){
                Vector columnData = new Vector();
                for(i=1;i<=q;i++){

                    columnData.add(rs.getString("ID_Room"));       
                    columnData.add(rs.getString("ID_Sector"));
                    columnData.add(rs.getString("Room_Class"));
                    columnData.add(rs.getString("Ready"));         
                    columnData.add("");
                    if(rs.getString("Description")!=null)
                    columnData.add(rs.getString("Description"));
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
        jTfSector.setText("");
        jTfClass.setText("");
        jTfDescript.setText("");
        jTfDate.setText("");
        jTfQuery.setText("");

    }//GEN-LAST:event_jBResetActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog( frame,"Confirm Exit","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jBExitActionPerformed

    private void jTfDescriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfDescriptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfDescriptActionPerformed

    private void jTfClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfClassActionPerformed

    private void jBSHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOWActionPerformed
        // TODO add your handling code here:
        upDateDB();
    }//GEN-LAST:event_jBSHOWActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed

        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            pst =sqlCon.prepareStatement("delete from phong where ID_Room = '"+jTfID.getText()+"'");
            frame = new JFrame("delete");
            if(JOptionPane.showConfirmDialog( frame,"Confirm Delete"," Phong "+jTfID.getText(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
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
            if(jTfDescript.getText().isEmpty()){
            pst =sqlCon.prepareStatement("update phong set ID_Room=?,ID_Sector=?,Room_Class =?,Ready= ? where ID_Room =? ");
                System.out.println("update phong set ID_Room=?,ID_Sector=?,Room_Class =?,Ready= ? where ID_Room =? ");
            pst.setString(5,jTfID.getText() );
            pst.setString(1,jTfID.getText() );
            pst.setString(3,jTfClass.getText() );
            pst.setString(4,jTfDate.getText() );
            pst.setString(2,jTfSector.getText());}
            else{
            pst =sqlCon.prepareStatement("update phong set ID_Room=?,ID_Sector=?,Room_Class =?,Ready= ?,Description=? where ID_Room =? ");
            pst.setString(6,jTfID.getText() );
            pst.setString(1,jTfID.getText() );
            pst.setString(3,jTfClass.getText() );
            pst.setString(4,jTfDate.getText() );
            pst.setString(5,jTfDescript.getText() );
            pst.setString(2,jTfSector.getText());}
            
            if(JOptionPane.showConfirmDialog( frame,"Confirm Update","Gia Phong "+jTfID.getText(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
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
            int c=0;
            if(jTfDescript.getText().isEmpty()){
                pst =sqlCon.prepareStatement("insert into phong (ID_Room,ID_Sector,Room_Class)value(?,?,?)");
            }
            else {
                pst =sqlCon.prepareStatement("insert into phong (ID_Room,ID_Sector,Room_Class,Description)value(?,?,?,?)");
              
              pst.setString(4,jTfDescript.getText());
            }
            pst.setString(2,jTfSector.getText() );
            pst.setString(1,jTfID.getText() );
            pst.setString(3,jTfClass.getText() );       
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Phòng đã được lưu lại");
            upDateDB();
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jBAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();

        int selectedrows= jTable1.getSelectedRow();
        jCBClass.getModel().setSelectedItem(RecordTable.getValueAt(selectedrows, 2).toString());
        jTfID.setText(RecordTable.getValueAt(selectedrows, 0).toString());
        jTfSector.setText(RecordTable.getValueAt(selectedrows, 1).toString());
        jTfClass.setText(RecordTable.getValueAt(selectedrows, 2).toString());
        jTfDate.setText(RecordTable.getValueAt(selectedrows, 3).toString());
        jTfDescript.setText(RecordTable.getValueAt(selectedrows,4).toString());
        
        String file ="Resource_Image/"+jTfSector.getText()+".jpg";
        jLPicture.setIcon(new ImageIcon(file));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTfDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfDateActionPerformed

    private void jTfSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfSectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfSectorActionPerformed

    private void jTfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfIDActionPerformed

    private void jCBClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBClassActionPerformed

    private void jCBClassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBClassMouseReleased
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jCBClassMouseReleased

    private void jCBClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBClassMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCBClassMouseClicked

    private void jCBClassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBClassMousePressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jCBClassMousePressed

    private void jCBClassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCBClassPropertyChange
          jTfClass.setText(jCBClass.getModel().getSelectedItem().toString());
    }//GEN-LAST:event_jCBClassPropertyChange

    private void jCBClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBClassItemStateChanged
           jTfClass.setText(jCBClass.getModel().getSelectedItem().toString());
    }//GEN-LAST:event_jCBClassItemStateChanged
       
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
            java.util.logging.Logger.getLogger(PH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PH_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new PH_frame().setVisible(true);
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
    private javax.swing.JComboBox<String> jCBClass;
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
    private javax.swing.JTextField jTfClass;
    private javax.swing.JTextField jTfDate;
    private javax.swing.JTextField jTfDescript;
    private javax.swing.JTextField jTfID;
    private javax.swing.JTextField jTfQuery;
    private javax.swing.JTextField jTfSector;
    // End of variables declaration//GEN-END:variables
}
