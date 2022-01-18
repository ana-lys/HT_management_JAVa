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
        
public class DKDV_frame extends javax.swing.JFrame {
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
    public DKDV_frame() {
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
    columnData.add(rs.getString("Citizen_id"));
    columnData.add(rs.getString("Accompany"));
    }
    RecordTable.addRow(columnData);
    
    }
    } catch (Exception ex){
    JOptionPane.showMessageDialog(null , ex);
    }
    }
     public void upDateDB3(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    String kh =jTfId.getText();
    pst =sqlCon.prepareStatement("select * from hop_dong where ID_KH = '"+kh+"' ");
        System.out.println("select * from hop_dong where ID_KH = '"+kh+"' ");
      rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
        System.out.println(q);
    DefaultTableModel RecordTable = (DefaultTableModel)jTable2.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
        System.out.println(rs.getString("ID_Contract"));  
    columnData.add(rs.getString("ID_Contract"));
    System.out.println(rs.getString("ID_Contract"));
    columnData.add(rs.getString("ID_Room"));
    columnData.add(rs.getString("ID_KH"));
    columnData.add(rs.getString("Date_Checkin"));
    columnData.add(rs.getString("Date_Checkout"));
    if(rs.getString("Date_Payment")!=null)
    columnData.add(rs.getString("Date_Payment"));
    else
    columnData.add("");
    columnData.add(rs.getString("Status"));
    
    }
    RecordTable.addRow(columnData);
    
    }
    } catch (Exception ex){
    JOptionPane.showMessageDialog(null , ex);
    }
    }
      public void upDateDB1(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    pst =sqlCon.prepareStatement("select * from phong");
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable3.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("ID_ROOM"));
    System.out.println(rs.getString("ID_ROOM"));
    columnData.add(rs.getString("ID_SECTOR"));
    columnData.add(rs.getString("ROOM_CLASS"));
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
        jTfName = new javax.swing.JTextField();
        jTfId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBSHOW = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTfPhone = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jBReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTfCitizen = new javax.swing.JTextField();
        jTfAccompany = new javax.swing.JTextField();
        jBSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLPicture = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jCBClass = new javax.swing.JComboBox<>();
        jTfClass = new javax.swing.JTextField();
        jTfSector = new javax.swing.JTextField();
        jTfID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBSearch1 = new javax.swing.JButton();
        jBSHOW1 = new javax.swing.JButton();
        jBReset1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTfFromDate = new javax.swing.JTextField();
        jTfToDate = new javax.swing.JTextField();
        jBSHOW2 = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();

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

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÊN KHÁCH", "ID", "SỐ DT", "CCCD", "NGƯỜI ĐI KÈM"
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
        jTfAccompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfAccompanyActionPerformed(evt);
            }
        });

        jBSearch.setText("SEARCH");
        jBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearchActionPerformed(evt);
            }
        });

        jButton1.setText("PHOTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SỐ HỢP ĐỒNG", "SỐ PHÒNG", "ID KHÁCH HÀNG", "TRẠNG THÁI HỢP ĐỒNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

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

        jTfClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfClass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfClassActionPerformed(evt);
            }
        });

        jTfSector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfSector.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfSectorActionPerformed(evt);
            }
        });

        jTfID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfIDActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("   ID DỊCH VỤ");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("   TÊN LOẠI DỊCH VỤ");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("  ID LOẠI DỊCH VỤ");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jBSearch1.setText("SEARCH");
        jBSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearch1ActionPerformed(evt);
            }
        });

        jBSHOW1.setBackground(new java.awt.Color(153, 204, 255));
        jBSHOW1.setText("SHOW");
        jBSHOW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSHOW1ActionPerformed(evt);
            }
        });

        jBReset1.setText("RESET");
        jBReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReset1ActionPerformed(evt);
            }
        });

        jButton2.setText("PHOTO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PHÒNG", "KHU VỰC", "LOẠI PHÒNG", "MÔ TẢ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("  SỐ LƯỢNG");
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("  NGÀY ĐẶT");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfFromDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfFromDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfFromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfFromDateActionPerformed(evt);
            }
        });

        jTfToDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfToDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfToDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfToDateActionPerformed(evt);
            }
        });

        jBSHOW2.setBackground(new java.awt.Color(153, 204, 255));
        jBSHOW2.setText("SHOW");
        jBSHOW2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSHOW2ActionPerformed(evt);
            }
        });

        jBDelete.setBackground(new java.awt.Color(153, 204, 255));
        jBDelete.setText("DELETE");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jCBClass, 0, 0, Short.MAX_VALUE)
                                .addGap(742, 742, 742))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTfName, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(jTfId)
                                    .addComponent(jTfPhone)
                                    .addComponent(jTfCitizen)
                                    .addComponent(jTfAccompany))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLPicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTfID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTfSector, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTfClass, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTfFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTfToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jBSHOW1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(jBSHOW2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBReset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTfName))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jButton1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTfCitizen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTfAccompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jBSHOW2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTfSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTfClass, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTfFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTfToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBSHOW1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jBReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfIDActionPerformed

    private void jTfSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfSectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfSectorActionPerformed

    private void jTfClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfClassActionPerformed

    private void jCBClassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCBClassPropertyChange
        jTfClass.setText(jCBClass.getModel().getSelectedItem().toString());
    }//GEN-LAST:event_jCBClassPropertyChange

    private void jCBClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBClassActionPerformed

    private void jCBClassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBClassMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBClassMouseReleased

    private void jCBClassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBClassMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBClassMousePressed

    private void jCBClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBClassMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBClassMouseClicked

    private void jCBClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBClassItemStateChanged
        jTfClass.setText(jCBClass.getModel().getSelectedItem().toString());
    }//GEN-LAST:event_jCBClassItemStateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel RecordTable = (DefaultTableModel)jTable2.getModel();

        int selectedrows= jTable2.getSelectedRow();
        RecordTable.getValueAt(selectedrows,0).toString();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTfId.getText().isEmpty()){
            String file ="Resource_Image/"+jTfId.getText()+".jpg";
            jLPicture.setIcon(new ImageIcon(file));
    }//GEN-LAST:event_jButton1ActionPerformed
    }
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
            else if(!jTfCitizen.getText().isEmpty()){
                qr1="Citizen_id";qr2=jTfCitizen.getText();
            }
            else if(!jTfAccompany.getText().isEmpty()){
                qr1="Accompany";qr2=jTfAccompany.getText();
            }

            pst =sqlCon.prepareStatement(" select * from khach_hang where " + qr1 + " like '%"+ qr2 +"%'");

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
                    columnData.add(rs.getString("Citizen_id"));
                    columnData.add(rs.getString("Accompany"));
                }
                RecordTable.addRow(columnData);

            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null , ex);
        }
    }//GEN-LAST:event_jBSearchActionPerformed

    private void jTfAccompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfAccompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfAccompanyActionPerformed

    private void jTfCitizenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfCitizenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfCitizenActionPerformed

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetActionPerformed
        // TODO add your handling code here:
        jTfName.setText("");
        jTfId.setText("");
        jTfPhone.setText("");
        jTfAccompany.setText("");
        jTfCitizen.setText("");

        jLPicture.setIcon(new ImageIcon(""));

    }//GEN-LAST:event_jBResetActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog( frame,"Confirm Exit","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jBExitActionPerformed

    private void jTfPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfPhoneActionPerformed

    private void jBSHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOWActionPerformed
        // TODO add your handling code here:
        upDateDB();
    }//GEN-LAST:event_jBSHOWActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();

        int selectedrows= jTable1.getSelectedRow();

        jTfName.setText(RecordTable.getValueAt(selectedrows, 0).toString());
        jTfId.setText(RecordTable.getValueAt(selectedrows, 1).toString());
        jTfPhone.setText(RecordTable.getValueAt(selectedrows, 2).toString());
        jTfCitizen.setText(RecordTable.getValueAt(selectedrows,3).toString());
        jTfAccompany.setText(RecordTable.getValueAt(selectedrows,4).toString());
        String file ="Resource_Image/"+jTfId.getText()+".jpg";
        jLPicture.setIcon(new ImageIcon(file));
        upDateDB3();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfIdActionPerformed

    private void jTfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfNameActionPerformed

    private void jBSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearch1ActionPerformed
       try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            // process the results
            String qr1="",qr2="",qr3="",qr4="",Date1=jTfFromDate.getText(),Date2=jTfToDate.getText(),Date3="";
            Date3 =  "and ID_Room not in (  SELECT ID_Room FROM hop_dong where ((Date_CheckIn >= '" +Date1+ "') and (Date_CheckIn <= '"+ Date2+"')) or ((Date_CheckOut >= '"+Date1+"') and (Date_CheckOut <='"+Date2+"')) or ((Date_CheckIn <= '"+Date1+"')and  (Date_CheckOut >= '"+Date2+"')))";
              
            if(!jTfID.getText().isEmpty()){
                qr1="ID_Room";qr2=jTfID.getText()+"'";
                 pst =sqlCon.prepareStatement(" select * from phong where " + qr1 + "= '"+ qr2 +qr3);
               
                System.out.println(" select * from phong where " + qr1 + "= '"+ qr2+"'"+ qr3);
            }
           
            else if(!jTfClass.getText().equals("All")){  
            qr3="Room_Class";qr4=jTfClass.getText();
                pst =sqlCon.prepareStatement(" select * from phong where ("+ qr3+ "= '"+ qr4 +"')"+Date3);
                System.out.println(" select * from phong where ("+ qr3+ "= '"+ qr4 +"')"+Date3);
            }
            else if(jTfClass.getText().equals("All")){
            pst =sqlCon.prepareStatement(" select * from phong where Ready ='1' "+Date3);
            System.out.println(" select * from phong where Ready ='1' "+Date3);
            
            }
          
            if(jTfFromDate.getText().isEmpty() || jTfToDate.getText().isEmpty()){
             JOptionPane.showMessageDialog(null ,"PLS fill in the date search box"); 
            }
            else{
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();
            
            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)jTable3.getModel();
            
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
                    if(rs.getString("Description")!=null)
                    columnData.add(rs.getString("Description"));
                    else
                    columnData.add("");
                    
       
                }
                RecordTable.addRow(columnData);

            }}
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null , ex);
        }
    }//GEN-LAST:event_jBSearch1ActionPerformed

    private void jBSHOW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOW1ActionPerformed
        // TODO add your handling code here:
        upDateDB1();
    }//GEN-LAST:event_jBSHOW1ActionPerformed

    private void jBReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReset1ActionPerformed
        // TODO add your handling code here:
        jTfID.setText("");
        jTfSector.setText("");
        jTfClass.setText("");    
    }//GEN-LAST:event_jBReset1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!jTfSector.getText().isEmpty()){
            String file ="Resource_Image/"+jTfSector.getText()+".jpg";
            jLPicture.setIcon(new ImageIcon(file));
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
     
        DefaultTableModel RecordTable = (DefaultTableModel)jTable3.getModel();

        int selectedrows= jTable3.getSelectedRow();
        jCBClass.getModel().setSelectedItem(RecordTable.getValueAt(selectedrows, 2).toString());
        jTfID.setText(RecordTable.getValueAt(selectedrows, 0).toString());
        jTfSector.setText(RecordTable.getValueAt(selectedrows, 1).toString());
        jTfClass.setText(RecordTable.getValueAt(selectedrows, 2).toString());
        String file ="Resource_Image/"+jTfSector.getText()+".jpg";
       // jLPicture.setIcon(new ImageIcon(file));
        
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTfFromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfFromDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfFromDateActionPerformed

    private void jTfToDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfToDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfToDateActionPerformed

    private void jBSHOW2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOW2ActionPerformed
        // TODO add your handling code here:
        upDateDB3();
    }//GEN-LAST:event_jBSHOW2ActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed

        try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            pst =sqlCon.prepareStatement("delete from hop_dong where ID_Contract = '");
            frame = new JFrame("delete");
            if(JOptionPane.showConfirmDialog( frame,"Confirm Delete"," Hop Dong ",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"record updated");
                upDateDB3();
            }
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jBDeleteActionPerformed
       
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
            java.util.logging.Logger.getLogger(DKDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DKDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DKDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DKDV_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DKDV_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBReset;
    private javax.swing.JButton jBReset1;
    private javax.swing.JButton jBSHOW;
    private javax.swing.JButton jBSHOW1;
    private javax.swing.JButton jBSHOW2;
    private javax.swing.JButton jBSearch;
    private javax.swing.JButton jBSearch1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBClass;
    private javax.swing.JLabel jLPicture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTfAccompany;
    private javax.swing.JTextField jTfCitizen;
    private javax.swing.JTextField jTfClass;
    private javax.swing.JTextField jTfFromDate;
    private javax.swing.JTextField jTfID;
    private javax.swing.JTextField jTfId;
    private javax.swing.JTextField jTfName;
    private javax.swing.JTextField jTfPhone;
    private javax.swing.JTextField jTfSector;
    private javax.swing.JTextField jTfToDate;
    // End of variables declaration//GEN-END:variables
}
