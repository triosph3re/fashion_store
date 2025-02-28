/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThongKeHeThong;

import BUS.ThongKeBUS;
import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import DTO.ThongKeTrongThangDTO;
import GUI.Component.Formater;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phatl
 */
public class ThongKeTongQuan extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeTongQuan
     */
    Formater formater = new Formater();

    public ThongKeTongQuan() {
        initComponents();
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        tblThongKe.setFocusable(false);
        tblThongKe.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        LineChartExample lineChart = new LineChartExample();
        pnlCenter.add(lineChart, BorderLayout.CENTER);
        hienThiDuLieuTable();
        // Lấy số sản phẩm, số khách hàng và số nhân viên từ DAO
        int soSanPham = SanPhamDAO.getInstance().getAllSanPham().size();
        int soKhachHang = KhachHangDAO.getInstance().getAllKhachHang().size();
        int soNhanVien = NhanVienDAO.getInstance().getAllNhanVien().size();

        setupIcon(icon, "././icon/shoe_product.svg");
        setupIcon(icon1, "././icon/stafff.svg");
        setupIcon(icon2, "././icon/customerr.svg");

// Thiết lập thuộc tính cho pnlContent
        setupPnlContent(soluong, txttongsanpham, soSanPham, "Sản phẩm");
        setupPnlContent(soluong1, txttongsanpham1, soKhachHang, "Khách từ trước đến nay");
        setupPnlContent(soluong2, txttongsanpham2, soNhanVien, "Nhân viên đang hoạt động");

// Thiết lập các thuộc tính chung cho các JLabel và JPanel
        setupComponents(jPanel1, icon);
        setupComponents(jPanel2, icon1);
        setupComponents(jPanel3, icon2);

    }
    ThongKeBUS thongKeBUS;

    public void hienThiDuLieuTable() {

        thongKeBUS = new ThongKeBUS();
        String end = LocalDate.now().minusDays(1).toString(); // Ngày hôm qua
        String start = LocalDate.now().minusDays(7).toString(); // Ngày 7 ngày trước
        ArrayList<ThongKeTrongThangDTO> listDoanhThu = thongKeBUS.getThongKeTuNgayDenNgay(start, end);

        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setRowCount(0);
        System.out.println("hello");
        for (ThongKeTrongThangDTO thongKe : listDoanhThu) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Object[] row = {
                dateFormat.format(thongKe.getNgay()),
                formater.FormatVND(thongKe.getChiphi()),
                formater.FormatVND(thongKe.getDoanhthu()),
                formater.FormatVND(thongKe.getLoinhuan())
            };
            model.addRow(row);

            System.out.println(thongKe.getNgay());
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblThongKe.getColumnCount(); i++) {
            tblThongKe.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // Phương thức để thiết lập icon cho JLabel
    private void setupIcon(JLabel icon, String iconPath) {
        icon.setIcon(new FlatSVGIcon(iconPath));
        icon.setPreferredSize(new Dimension(100, 100));
        icon.setBorder(new EmptyBorder(0, 10, 0, 0));
    }
// Phương thức để thiết lập thuộc tính cho pnlContent

    private void setupPnlContent(JLabel soluong, JLabel txttongsanpham, int quantity, String text) {
        pnlContent.setForeground(new Color(96, 125, 139));
        soluong.setText(String.valueOf(quantity));
        soluong.setPreferredSize(new Dimension(250, 30));
        soluong.putClientProperty("FlatLaf.style", "font: 300% $semibold.font");
        txttongsanpham.setText(text);
        txttongsanpham.setPreferredSize(new Dimension(250, 30));
        txttongsanpham.putClientProperty("FlatLaf.style", "font: 150% $medium.font");
        txttongsanpham.setForeground(new Color(96, 125, 139));
    }
// Phương thức để thiết lập các thuộc tính chung cho các JLabel và JPanel

    private void setupComponents(JPanel panel, JLabel icon) {
        panel.add(icon);
        pnlContent.add(soluong);
        pnlContent.add(txttongsanpham);
        panel.add(pnlContent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlContent = new javax.swing.JPanel();
        txttongsanpham = new javax.swing.JLabel();
        soluong = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlContent1 = new javax.swing.JPanel();
        txttongsanpham1 = new javax.swing.JLabel();
        soluong1 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlContent2 = new javax.swing.JPanel();
        txttongsanpham2 = new javax.swing.JLabel();
        soluong2 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlTableThongKe = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout(10, 10));

        pnlTop.setBackground(new java.awt.Color(255, 0, 0));
        pnlTop.setPreferredSize(new java.awt.Dimension(0, 90));
        pnlTop.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttongsanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttongsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlTop.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlContent1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlContent1Layout = new javax.swing.GroupLayout(pnlContent1);
        pnlContent1.setLayout(pnlContent1Layout);
        pnlContent1Layout.setHorizontalGroup(
            pnlContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContent1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(soluong1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttongsanpham1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContent1Layout.setVerticalGroup(
            pnlContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soluong1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttongsanpham1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlTop.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        pnlContent2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlContent2Layout = new javax.swing.GroupLayout(pnlContent2);
        pnlContent2.setLayout(pnlContent2Layout);
        pnlContent2Layout.setHorizontalGroup(
            pnlContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContent2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(soluong2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttongsanpham2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContent2Layout.setVerticalGroup(
            pnlContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soluong2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttongsanpham2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlTop.add(jPanel3);

        add(pnlTop, java.awt.BorderLayout.NORTH);

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setPreferredSize(new java.awt.Dimension(200, 900));
        pnlCenter.setLayout(new java.awt.BorderLayout());
        add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlTableThongKe.setBackground(new java.awt.Color(0, 204, 0));
        pnlTableThongKe.setPreferredSize(new java.awt.Dimension(317, 200));

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ngày", "Chi phí", "Doanh thu", "Lợi nhuận"
            }
        ));
        jScrollPane2.setViewportView(tblThongKe);

        javax.swing.GroupLayout pnlTableThongKeLayout = new javax.swing.GroupLayout(pnlTableThongKe);
        pnlTableThongKe.setLayout(pnlTableThongKeLayout);
        pnlTableThongKeLayout.setHorizontalGroup(
            pnlTableThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        pnlTableThongKeLayout.setVerticalGroup(
            pnlTableThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        add(pnlTableThongKe, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlContent1;
    private javax.swing.JPanel pnlContent2;
    private javax.swing.JPanel pnlTableThongKe;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JLabel soluong;
    private javax.swing.JLabel soluong1;
    private javax.swing.JLabel soluong2;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JLabel txttongsanpham;
    private javax.swing.JLabel txttongsanpham1;
    private javax.swing.JLabel txttongsanpham2;
    // End of variables declaration//GEN-END:variables
}
