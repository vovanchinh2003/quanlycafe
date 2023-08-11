/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.phuxuan.quanlyquancafe.from_main;

import Dialogchek.sheardatta;
import com.phuxuan.quanlycoffee.dao.Cthoadondao;
import com.phuxuan.quanlycoffee.model.CThoadonmodel;
import com.phuxuan.quanlycoffee.model.Hoadonmodel;
import com.phuxuan.quanlyquancafe.connectJDBC.Databaseee;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author chinh
 */
public class Quanlythongke extends javax.swing.JFrame {

    ArrayList<CThoadonmodel> khachhangmodels = new ArrayList<>();
    private DefaultTableModel tableModel;
    ArrayList<Hoadonmodel> hoadonmodels = new ArrayList<>();

    /**
     * Creates new form Quanlythongke
     */
    public Quanlythongke() throws SQLException, ClassNotFoundException {
        initComponents();
        tinhtongtienn();
        tinhtongsp();
//        layCTHOADON();
        huyhoadon();
        tongnhanvien();
        initTable();
        LoadProductTable();
        pro();
    }

    private void pro() {
//        
        if (sheardatta.nguoiDangNhap.getVaitro().equals("Quản lý")) {

        } else if (sheardatta.nguoiDangNhap.getVaitro().equals("Nhân viên")) {
        }
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Tên sản phẩm", "SLB", "Thành tiền"});
        tablentd.setModel(tableModel);
    }

    private void LoadProductTable() throws SQLException, ClassNotFoundException {
        khachhangmodels = Cthoadondao.getAll();
        tableModel.setRowCount(0);
        for (CThoadonmodel m : khachhangmodels) {
            Object[] object = new Object[]{m.getTentd(), m.getSoluongban(), m.getThanhtien()};
            tableModel.addRow(object);
        }
        tableModel.fireTableDataChanged();
    }

    private void tinhtongtienn() {
        String sql = "select sum(tongtien) as doanhthu,count(makh) as makhh  from hoa_don";
        try {
            Connection conn = Databaseee.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                labledoanhthu.setText(formatter.format(rs.getFloat("doanhthu")));
                lablekh.setText(Integer.toString(rs.getInt("makhh")));
            }
        } catch (SQLException ex) {
        }
    }

    private void tinhtongsp() {
        String sql = "select sum(ct_hoadon.soluongban) as soluongbann from ct_hoadon ";
        try {
            Connection conn = Databaseee.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lablesp.setText(String.valueOf(rs.getInt("soluongbann") + " sp"));
            }
        } catch (SQLException ex) {
        }
    }

    private void tongnhanvien() {
        String sql = "select count(manv) as man from nhan_vien";
        try {
            Connection conn = Databaseee.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                labletongsohd.setText(String.valueOf(rs.getInt("man")));
            }
        } catch (SQLException ex) {
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labletongsohd = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labledoanhthu = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lablekh = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lablesp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablentd = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Thống kê");
        setPreferredSize(new java.awt.Dimension(964, 525));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.CardLayout(10, 10));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel5.setLayout(new java.awt.GridLayout(3, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/phuxuan/quanlycoffee/image/nhanvien.png"))); // NOI18N
        jPanel5.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhân viên");
        jPanel5.add(jLabel2);

        labletongsohd.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labletongsohd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labletongsohd.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel5.add(labletongsohd);

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        jPanel6.setLayout(new java.awt.GridLayout(3, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/phuxuan/quanlycoffee/image/tuitien.png"))); // NOI18N
        jPanel6.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng doanh thu");
        jPanel6.add(jLabel4);

        labledoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labledoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labledoanhthu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(labledoanhthu);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        jPanel7.setLayout(new java.awt.GridLayout(3, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/phuxuan/quanlycoffee/image/khachhang.png"))); // NOI18N
        jPanel7.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tổng khách hàng");
        jPanel7.add(jLabel6);

        lablekh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lablekh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lablekh.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(lablekh);

        jPanel4.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        jPanel8.setLayout(new java.awt.GridLayout(3, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/phuxuan/quanlycoffee/image/cafe1.png"))); // NOI18N
        jPanel8.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tổng sản phẩm bán ra");
        jPanel8.add(jLabel8);

        lablesp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lablesp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lablesp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel8.add(lablesp);

        jPanel4.add(jPanel8);

        jPanel2.add(jPanel4, "card2");

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.CardLayout(50, 20));

        jPanel16.setLayout(new java.awt.GridLayout(1, 0, 95, 0));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Biểu đồ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Xuất excel ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton2);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Gửi mail báo cáo");
        jPanel16.add(jButton3);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Lịch sử dn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton4);

        jPanel10.add(jPanel16, "card2");

        jPanel9.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh thu theo sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel12.setLayout(new java.awt.CardLayout(10, 10));

        jPanel14.setLayout(new java.awt.BorderLayout());

        tablentd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablentd);

        jPanel14.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel14, "card2");

        jPanel11.add(jPanel12);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huỷ đơn theo nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel13.setLayout(new java.awt.CardLayout(10, 10));

        jPanel15.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel15.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel15, "card2");

        jPanel11.add(jPanel13);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel9, "card2");

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel17.setBackground(new java.awt.Color(171, 104, 50));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thống kê");
        jPanel17.add(jLabel9, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel17, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Quanlythongketheobieudo h = new Quanlythongketheobieudo();
        h.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Quanlylichsudangnhap h = new Quanlylichsudangnhap();
        h.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên sản phẩm");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Số lượng bán");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Thành tiền");

            for (int i = 0; i < khachhangmodels.size(); i++) {
                row = sheet.createRow(4 + i);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(khachhangmodels.get(i).getTentd());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(khachhangmodels.get(i).getSoluongban());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(khachhangmodels.get(i).getThanhtien());
            }
            File f = new File("D://danhsach.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
            } catch (Exception e) {
            }
            JOptionPane.showMessageDialog(rootPane, "Xuất file thành công !");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Quanlythongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quanlythongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quanlythongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quanlythongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dangnhap h = new Dangnhap();
                    h.setVisible(true);
                    if (sheardatta.nguoiDangNhap.getVaitro().equals("Quản lý")) {
                        new Quanlythongke().setVisible(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Quanlythongke.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Quanlythongke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labledoanhthu;
    private javax.swing.JLabel lablekh;
    private javax.swing.JLabel lablesp;
    private javax.swing.JLabel labletongsohd;
    private javax.swing.JTable tablentd;
    // End of variables declaration//GEN-END:variables

    private void layCTHOADON() throws SQLException, ClassNotFoundException {
        Connection conn = Databaseee.getConnection();
        try {
            String sqll = "select tentd,sum(ct_hoadon.soluongban) as slban,sum(ct_hoadon.thanhtien) as thanhtien from thuc_don left join ct_hoadon on thuc_don.matd = ct_hoadon.matd group by thuc_don.tentd";
            String[] aray = {"Tên nước", "Số lượng bán", "Thành tiền"};
            DefaultTableModel model = new DefaultTableModel(aray, 0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqll);
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("tentd"));
                vector.add(rs.getInt("slban"));
                vector.add(rs.getFloat("thanhtien"));
                model.addRow(vector);
            }
            tablentd.setModel(model);
        } catch (SQLException e) {
        }
    }

    private void huyhoadon() throws SQLException, ClassNotFoundException {
        Connection conn = Databaseee.getConnection();
        try {
            String sqll = "select hotennv,count(trangthai) as trangthaii from hoa_don left join nhan_vien on hoa_don.manv = nhan_vien.manv where trangthai =N'ĐÃ HUỶ' group by hotennv";
            String[] aray = {"Tên nhân viên", "Số lượng đơn huỷ"};
            DefaultTableModel model = new DefaultTableModel(aray, 0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqll);
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("hotennv"));
                vector.add(rs.getString("trangthaii"));
                model.addRow(vector);
            }
            jTable2.setModel(model);
        } catch (SQLException e) {
        }
    }
}