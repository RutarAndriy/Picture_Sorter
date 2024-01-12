package com.rutar.picture_sorter;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Picture_Sorter extends javax.swing.JFrame {

///////////////////////////////////////////////////////////////////////////////

public Picture_Sorter() {

initComponents();

setMinimumSize( getSize() );
setSize(680, 520);
setLocationRelativeTo(null);

}

///////////////////////////////////////////////////////////////////////////////
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        panel_top = new JPanel();
        btn_move_delete = new JToggleButton();
        btn_fold_unfold = new JToggleButton();
        btn_center = new JButton();
        btn_minus = new JButton();
        btn_plus = new JButton();
        panel_center = new JSplitPane();
        sp_1 = new JScrollPane();
        tree = new JTree();
        sp_2 = new JScrollPane();
        panel_image = new JPanel();
        label_image = new JLabel();
        panel_bottom = new JPanel();
        path_01 = new JToggleButton();
        path_02 = new JToggleButton();
        path_03 = new JToggleButton();
        path_04 = new JToggleButton();
        path_05 = new JToggleButton();
        path_06 = new JToggleButton();
        path_07 = new JToggleButton();
        path_08 = new JToggleButton();
        path_09 = new JToggleButton();
        menu_bar = new JMenuBar();
        menu_file = new JMenu();
        menu_about = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btn_move_delete.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/arrow_redo.png"))); // NOI18N
        btn_move_delete.setMargin(new Insets(5, 5, 5, 5));

        btn_fold_unfold.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/arrow_out.png"))); // NOI18N
        btn_fold_unfold.setMargin(new Insets(5, 5, 5, 5));

        btn_center.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/cross.png"))); // NOI18N
        btn_center.setMargin(new Insets(5, 5, 5, 5));
        btn_center.setPreferredSize(btn_fold_unfold.getPreferredSize());

        btn_minus.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/magnifier_zoom_out.png"))); // NOI18N
        btn_minus.setMargin(new Insets(5, 5, 5, 5));
        btn_minus.setPreferredSize(btn_fold_unfold.getPreferredSize());

        btn_plus.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/magnifier_zoom_in.png"))); // NOI18N
        btn_plus.setMargin(new Insets(5, 5, 5, 5));
        btn_plus.setPreferredSize(btn_fold_unfold.getPreferredSize());

        GroupLayout panel_topLayout = new GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel_topLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btn_move_delete)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_plus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_minus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_center, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_fold_unfold)
                .addGap(3, 3, 3))
        );
        panel_topLayout.setVerticalGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn_plus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_minus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_fold_unfold, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_move_delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_center, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );

        panel_center.setDividerLocation(200);

        tree.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
        sp_1.setViewportView(tree);

        panel_center.setLeftComponent(sp_1);

        label_image.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x32/picture_sunset.png"))); // NOI18N

        GroupLayout panel_imageLayout = new GroupLayout(panel_image);
        panel_image.setLayout(panel_imageLayout);
        panel_imageLayout.setHorizontalGroup(panel_imageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_imageLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_image)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_imageLayout.setVerticalGroup(panel_imageLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_imageLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_image, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sp_2.setViewportView(panel_image);

        panel_center.setRightComponent(sp_2);

        panel_bottom.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
        panel_bottom.setLayout(new GridLayout(1, 0, 3, 3));

        path_01.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_01.setMargin(new Insets(5, 5, 5, 5));
        path_01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_01);

        path_02.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_02.setMargin(new Insets(5, 5, 5, 5));
        path_02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_02);

        path_03.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_03.setMargin(new Insets(5, 5, 5, 5));
        path_03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_03);

        path_04.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_04.setMargin(new Insets(5, 5, 5, 5));
        path_04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_04);

        path_05.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_05.setMargin(new Insets(5, 5, 5, 5));
        path_05.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_05);

        path_06.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_06.setMargin(new Insets(5, 5, 5, 5));
        path_06.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_06);

        path_07.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_07.setMargin(new Insets(5, 5, 5, 5));
        path_07.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_07);

        path_08.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_08.setMargin(new Insets(5, 5, 5, 5));
        path_08.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_08);

        path_09.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_09.setMargin(new Insets(5, 5, 5, 5));
        path_09.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_09);

        menu_file.setText("File");
        menu_bar.add(menu_file);

        menu_about.setText("About");
        menu_bar.add(menu_about);

        setJMenuBar(menu_bar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel_bottom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_top, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_center)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_center, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(panel_bottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        setSize(new Dimension(328, 230));
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void set_Path(ActionEvent evt) {//GEN-FIRST:event_set_Path

        JToggleButton btn = (JToggleButton) evt.getSource();
        String name = btn.isSelected() ? "folder" : "plus";
        
        btn.setIcon(new ImageIcon(getClass().getResource(String.format("/com/rutar/picture_sorter/icons/x16/%s.png", name))));
        
    }//GEN-LAST:event_set_Path

///////////////////////////////////////////////////////////////////////////////

public static void main (String args[]) {

//try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
//catch (Exception e) {}

EventQueue.invokeLater(() -> { new Picture_Sorter().setVisible(true); });

}

///////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btn_center;
    private JToggleButton btn_fold_unfold;
    private JButton btn_minus;
    private JToggleButton btn_move_delete;
    private JButton btn_plus;
    private JLabel label_image;
    private JMenu menu_about;
    private JMenuBar menu_bar;
    private JMenu menu_file;
    private JPanel panel_bottom;
    private JSplitPane panel_center;
    private JPanel panel_image;
    private JPanel panel_top;
    private JToggleButton path_01;
    private JToggleButton path_02;
    private JToggleButton path_03;
    private JToggleButton path_04;
    private JToggleButton path_05;
    private JToggleButton path_06;
    private JToggleButton path_07;
    private JToggleButton path_08;
    private JToggleButton path_09;
    private JScrollPane sp_1;
    private JScrollPane sp_2;
    private JTree tree;
    // End of variables declaration//GEN-END:variables
}
