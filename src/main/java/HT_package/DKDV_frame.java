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
    PreparedStatement pst = null,pst2 =null;
    
    ResultSet rs = null ,rs2 =null;
    int i,q,id, deleteItem ;
    
    /**
     * Creates new form NewJFrame
     */
    public DKDV_frame() {
        initComponents();  
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(120);
    }
// FUNCTION
    public void upDateDB2(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    String date="";
    if(!jTfOrder_Date.getText().isEmpty()) date =jTfOrder_Date.getText();
    else date=java.time.LocalDate.now().toString();
    pst =sqlCon.prepareStatement("select * from gia_dich_vu where To_Date is null or To_Date >= '"+date+"'");
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable3.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("ID_Service"));
    System.out.println(rs.getString("ID_Service"));
    columnData.add(rs.getString("Description"));
    columnData.add(rs.getString("Service_Price"));
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
      public void upDateDB4(){
    try {
    Class.forName("com.mysql.jdbc.Driver") ;  
    sqlCon = DriverManager.getConnection(databaseCon,username,password);
    // process the results  
    String date="";
    if(!jTfOrder_Date.getText().isEmpty()) date =jTfOrder_Date.getText();
    else date=java.time.LocalDate.now().toString();
    pst =sqlCon.prepareStatement("select * from don_dich_vu where ID_Contract ='"+jTfContract.getText()+"'");
    rs = pst.executeQuery();
    ResultSetMetaData stData =rs.getMetaData();
    
    q = stData.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)jTable4.getModel();
    RecordTable.setRowCount(0);
    while(rs.next()){
    Vector columnData = new Vector();
    for(i=1;i<=q;i++){
      
    columnData.add(rs.getString("ID_Service_Order"));
    System.out.println(rs.getString("ID_Service_Order"));
    columnData.add(rs.getString("ID_Contract"));
    columnData.add(rs.getString("ID_Service"));
    columnData.add(rs.getString("Date_Time_order"));
     columnData.add(rs.getString("Multiplier"));
     pst2 =sqlCon.prepareStatement("select Service_Price from gia_dich_vu where ID_Service ='"+rs.getString("ID_Service")+"' and To_Date is null");
    rs2 = pst2.executeQuery();
    rs2.next();
     columnData.add(Integer.valueOf(rs.getString("Multiplier"))*Integer.valueOf(rs2.getString("Service_Price")));

    }
    RecordTable.addRow(columnData);
    
    }
    } catch (Exception ex){
    JOptionPane.showMessageDialog(null , ex);
    }
    }
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
        jLabel8 = new javax.swing.JLabel();
        jTfAccompany = new javax.swing.JTextField();
        jBSearch = new javax.swing.JButton();
        jLPicture = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTfDescription = new javax.swing.JTextField();
        jTfID_Service = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBSearch1 = new javax.swing.JButton();
        jBSHOW1 = new javax.swing.JButton();
        jBReset1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTfOrder_Date = new javax.swing.JTextField();
        jTfMulti = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTfContract = new javax.swing.JTextField();
        jTfID_Room = new javax.swing.JTextField();
        jTfDate_Checkin = new javax.swing.JTextField();
        jBSearch2 = new javax.swing.JButton();
        jBReset2 = new javax.swing.JButton();
        jBSHOW3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTfOrder = new javax.swing.JTextField();

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

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("  SỐ NGƯỜI ĐI KÈM");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

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

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SỐ HỢP ĐỒNG", "SỐ PHÒNG", "ID KHÁCH HÀNG", "NGÀY NHẬP PHÒNG", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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

        jTfDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfDescriptionActionPerformed(evt);
            }
        });

        jTfID_Service.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfID_Service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfID_Service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfID_ServiceActionPerformed(evt);
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

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID LOẠI DV", "TÊN LOẠI DV", "GIÁ TIỀN", "THỜI GIAN HIỆU LỰC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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

        jTfOrder_Date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfOrder_Date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfOrder_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfOrder_DateActionPerformed(evt);
            }
        });

        jTfMulti.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfMulti.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMultiActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("  ID HỢP ĐỒNG");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText(" SỐ PHÒNG");
        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText(" NGÀY NHẬN PHÒNG");
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfContract.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfContract.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfContractActionPerformed(evt);
            }
        });

        jTfID_Room.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfID_Room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfID_Room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfID_RoomActionPerformed(evt);
            }
        });

        jTfDate_Checkin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfDate_Checkin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfDate_Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfDate_CheckinActionPerformed(evt);
            }
        });

        jBSearch2.setText("SEARCH");
        jBSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSearch2ActionPerformed(evt);
            }
        });

        jBReset2.setText("RESET");
        jBReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReset2ActionPerformed(evt);
            }
        });

        jBSHOW3.setBackground(new java.awt.Color(153, 204, 255));
        jBSHOW3.setText("SHOW");
        jBSHOW3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSHOW3ActionPerformed(evt);
            }
        });

        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ĐƠN DV", "ID HỢP ĐỒNG", "ID DỊCH VỤ", "THỜI GIAN", "SỐ LƯỢNG", "THÀNH TIỀN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButton1.setText("REMOVE ORDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ADD ORDER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("  ID ĐƠN DV");
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jTfOrder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTfOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTfOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfOrderActionPerformed(evt);
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTfOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBSHOW1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jBReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jBSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTfMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBReset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTfID_Service, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTfOrder_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(291, 291, 291)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTfID_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTfContract, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTfName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTfId, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTfAccompany, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBSHOW3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTfDate_Checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTfAccompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTfID_Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jTfDate_Checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBSHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBSHOW3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTfOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTfID_Service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jTfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jTfOrder_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jTfMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBSHOW1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTfID_ServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfID_ServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfID_ServiceActionPerformed

    private void jTfDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfDescriptionActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
          // TODO add your handling code here:
        
        DefaultTableModel RecordTable = (DefaultTableModel)jTable2.getModel();

        int selectedrows= jTable2.getSelectedRow();
        jTfContract.setText(RecordTable.getValueAt(selectedrows,0).toString());
        jTfID_Room.setText(RecordTable.getValueAt(selectedrows,1).toString());
        jTfDate_Checkin.setText(RecordTable.getValueAt(selectedrows,3).toString());
        upDateDB4();
       
    }//GEN-LAST:event_jTable2MouseClicked
    
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

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetActionPerformed
        // TODO add your handling code here:
        jTfName.setText("");
        jTfId.setText("");
        jTfPhone.setText("");
        jTfAccompany.setText("");
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
            String Date="";
            if(jTfOrder_Date.getText().isEmpty()) Date=java.time.LocalDate.now().toString();
            else Date=jTfOrder_Date.getText();
         if(!jTfID_Service.getText().isEmpty())  { 
            String IDS="";IDS=jTfID_Service.getText();
        pst =sqlCon.prepareStatement(" select * from gia_dich_vu where ID_Service like '%"+IDS +"%' and ( To_Date is null  or  To_Date >= '"+ Date+"') ");
             System.out.println(" select * from gia_dich_vu where ID_Service like '%"+IDS +"%' and ( To_Date is null  or  To_Date >= '"+ Date+"') ");
         }  
         else if(!jTfDescription.getText().isEmpty())  { 
            String IDS="";IDS=jTfDescription.getText();
        pst =sqlCon.prepareStatement(" select * from gia_dich_vu where Description like '%"+IDS +"%' and ( To_Date is null  or  To_Date >= '"+ Date+"') ");
             System.out.println(" select * from gia_dich_vu where Description like '%"+IDS +"%' and ( To_Date is null  or  To_Date >= '"+ Date+"') ");
         }   
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();

            q = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)jTable3.getModel();
            RecordTable.setRowCount(0);
            while(rs.next()){
                Vector columnData = new Vector();
                for(i=1;i<=q;i++){
                    columnData.add(rs.getString("ID_Service"));
                    columnData.add(rs.getString("Description"));
                    columnData.add(rs.getString("Service_Price"));
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
    }//GEN-LAST:event_jBSearch1ActionPerformed

    private void jBSHOW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOW1ActionPerformed
        // TODO add your handling code here:
        upDateDB2();
    }//GEN-LAST:event_jBSHOW1ActionPerformed

    private void jBReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReset1ActionPerformed
        // TODO add your handling code here:
        jTfID_Service.setText("");
        jTfDescription.setText("");
        jTfOrder_Date.setText("");
        jTfMulti.setText("");
           
    }//GEN-LAST:event_jBReset1ActionPerformed
    
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
     
        DefaultTableModel RecordTable = (DefaultTableModel)jTable3.getModel();

        int selectedrows= jTable3.getSelectedRow();
        jTfID_Service.setText(RecordTable.getValueAt(selectedrows, 0).toString());
        jTfDescription.setText(RecordTable.getValueAt(selectedrows, 1).toString());
        String file ="Resource_Image/"+jTfDescription.getText()+".jpg";
       // jLPicture.setIcon(new ImageIcon(file));
        
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTfOrder_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfOrder_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfOrder_DateActionPerformed

    private void jTfMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMultiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMultiActionPerformed

    private void jTfContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfContractActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfContractActionPerformed

    private void jTfID_RoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfID_RoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfID_RoomActionPerformed

    private void jTfDate_CheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfDate_CheckinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfDate_CheckinActionPerformed

    private void jBSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSearch2ActionPerformed
try {
            Class.forName("com.mysql.jdbc.Driver") ;
            sqlCon = DriverManager.getConnection(databaseCon,username,password);
            // process the results
            String qr1="",qr2="";
            if(!jTfContract.getText().isEmpty()){
                qr1="ID_Contract";qr2=jTfContract.getText();
            }
            else if(!jTfId.getText().isEmpty()){
                qr1="ID_KH";qr2=jTfId.getText();
            }
            else if(!jTfID_Room.getText().isEmpty()){
                qr1="ID_Room";qr2=jTfID_Room.getText();
            }
            else if(!jTfDate_Checkin.getText().isEmpty()){
                qr1="Accompany";qr2=jTfAccompany.getText();
            }

            pst =sqlCon.prepareStatement(" select * from hop_dong where " + qr1 + " like '"+ qr2 +"%' and Status ='OnGoing'");
            System.out.println(" select * from hop_dong where " + qr1 + " like '"+ qr2 +"%'");
            rs = pst.executeQuery();
            ResultSetMetaData stData =rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)jTable2.getModel();
            RecordTable.setRowCount(0);
            while(rs.next()){
                Vector columnData = new Vector();
                for(i=1;i<=q;i++){

                    columnData.add(rs.getString("ID_Contract"));
                    System.out.println(rs.getString("ID_Room"));
                    columnData.add(rs.getString("ID_KH"));
                    columnData.add(rs.getString("Date_Checkin"));
                    columnData.add(rs.getString("Status"));
                }
                RecordTable.addRow(columnData);

            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null , ex);
        }                    
    }//GEN-LAST:event_jBSearch2ActionPerformed

    private void jBReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReset2ActionPerformed
        // TODO add your handling code here:
        jTfContract.setText("");
        jTfID_Room.setText("");
        jTfDate_Checkin.setText("");
    }//GEN-LAST:event_jBReset2ActionPerformed

    private void jBSHOW3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSHOW3ActionPerformed
        // TODO add your handling code here
        upDateDB3();
    }//GEN-LAST:event_jBSHOW3ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        try{
        pst =sqlCon.prepareStatement("INSERT INTO don_dich_vu ( `ID_Contract`, `ID_Service`, `Date_Time_order`, `Multiplier`) VALUES (?, ?, now(), ?)");
                pst.setString(1,jTfContract.getText() );
                pst.setString(2,jTfID_Service.getText() );
                if(jTfMulti.getText().isEmpty())
                pst.setString(3,"1");
                else
                pst.setString(3,jTfMulti.getText() );
                pst.executeUpdate();
                upDateDB4();        
                 }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null , ex);
        }               
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTfOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfOrderActionPerformed
       
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
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBReset;
    private javax.swing.JButton jBReset1;
    private javax.swing.JButton jBReset2;
    private javax.swing.JButton jBSHOW;
    private javax.swing.JButton jBSHOW1;
    private javax.swing.JButton jBSHOW3;
    private javax.swing.JButton jBSearch;
    private javax.swing.JButton jBSearch1;
    private javax.swing.JButton jBSearch2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLPicture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTfAccompany;
    private javax.swing.JTextField jTfContract;
    private javax.swing.JTextField jTfDate_Checkin;
    private javax.swing.JTextField jTfDescription;
    private javax.swing.JTextField jTfID_Room;
    private javax.swing.JTextField jTfID_Service;
    private javax.swing.JTextField jTfId;
    private javax.swing.JTextField jTfMulti;
    private javax.swing.JTextField jTfName;
    private javax.swing.JTextField jTfOrder;
    private javax.swing.JTextField jTfOrder_Date;
    private javax.swing.JTextField jTfPhone;
    // End of variables declaration//GEN-END:variables
}
