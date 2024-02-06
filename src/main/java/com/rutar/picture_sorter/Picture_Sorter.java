package com.rutar.picture_sorter;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.formdev.flatlaf.ui.*;
import com.rutar.ua_translator.*;
import javax.swing.tree.TreeSelectionModel;

// ............................................................................

public class Picture_Sorter extends JFrame {

public static final String DEFAULT_APP_THEME = "GitHub_Dark";

///////////////////////////////////////////////////////////////////////////////

public Picture_Sorter() {

initComponents();

setMinimumSize(getSize());
setSize(680, 520);
setLocationRelativeTo(null);

Listeners .init();
Processing.init(this);

}

///////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_top = new JPanel();
        btn_processing_mode = new JButton();
        btn_deleting_mode = new JButton();
        sep_01 = new JSeparator();
        btn_undo = new JButton();
        btn_redo = new JButton();
        btn_levelup = new JButton();
        btn_plus = new JButton();
        btn_minus = new JButton();
        btn_center = new JButton();
        btn_view_mode = new JButton();
        panel_center = new JSplitPane();
        sp_left = new JPanel();
        panel_drop = new JPanel() {

            @Override
            public void paintComponent (Graphics g) {

                super.paintComponents(g);

                Utils.draw_Dropable_Background((Graphics2D) g);

            }
        };
        sp_tree = new JScrollPane();
        tree = new JTree();
        tree.addTreeSelectionListener(Listeners.tree_selection_listener);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setRootVisible(false);
        sp_right = new JScrollPane();
        panel_image = new JPanel();
        label_image = new JLabel();
        panel_bottom = new JPanel();
        btn_path_1 = new JToggleButton();
        btn_path_2 = new JToggleButton();
        btn_path_3 = new JToggleButton();
        btn_path_4 = new JToggleButton();
        btn_path_5 = new JToggleButton();
        btn_path_6 = new JToggleButton();
        btn_path_7 = new JToggleButton();
        btn_path_8 = new JToggleButton();
        btn_path_9 = new JToggleButton();
        menu_bar = new JMenuBar();
        menu_file = new JMenu();
        menu_settings = new JMenu();
        menu_theme = new JMenu();
        menu_about = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Picture Sorter");

        btn_processing_mode.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/cut_red.png"))); // NOI18N
        btn_processing_mode.setActionCommand("processing_mode");
        btn_processing_mode.setFocusPainted(false);
        btn_processing_mode.setMargin(new Insets(5, 5, 5, 5));
        btn_processing_mode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_deleting_mode.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/bin_empty.png"))); // NOI18N
        btn_deleting_mode.setToolTipText("");
        btn_deleting_mode.setActionCommand("deleting_mode");
        btn_deleting_mode.setFocusPainted(false);
        btn_deleting_mode.setMargin(new Insets(5, 5, 5, 5));
        btn_deleting_mode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        sep_01.setOrientation(SwingConstants.VERTICAL);

        btn_undo.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/undo.png"))); // NOI18N
        btn_undo.setToolTipText("Відмінити");
        btn_undo.setFocusPainted(false);
        btn_undo.setMargin(new Insets(5, 5, 5, 5));
        btn_undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_redo.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/redo.png"))); // NOI18N
        btn_redo.setToolTipText("Повторити");
        btn_redo.setFocusPainted(false);
        btn_redo.setMargin(new Insets(5, 5, 5, 5));
        btn_redo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_levelup.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/hand_point_090.png"))); // NOI18N
        btn_levelup.setToolTipText("Перейти на рівень вверх");
        btn_levelup.setFocusPainted(false);
        btn_levelup.setMargin(new Insets(5, 5, 5, 5));
        btn_levelup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_plus.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/magnifier_zoom_in.png"))); // NOI18N
        btn_plus.setToolTipText("Збільшити");
        btn_plus.setFocusPainted(false);
        btn_plus.setMargin(new Insets(5, 5, 5, 5));
        btn_plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_minus.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/magnifier_zoom_out.png"))); // NOI18N
        btn_minus.setToolTipText("Зменшити");
        btn_minus.setFocusPainted(false);
        btn_minus.setMargin(new Insets(5, 5, 5, 5));
        btn_minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_center.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/zoom_fit.png"))); // NOI18N
        btn_center.setToolTipText("Центрувати");
        btn_center.setFocusPainted(false);
        btn_center.setMargin(new Insets(5, 5, 5, 5));
        btn_center.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        btn_view_mode.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/arrow_in.png"))); // NOI18N
        btn_view_mode.setActionCommand("view_mode");
        btn_view_mode.setFocusPainted(false);
        btn_view_mode.setMargin(new Insets(5, 5, 5, 5));
        btn_view_mode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });

        GroupLayout panel_topLayout = new GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel_topLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btn_processing_mode)
                .addGap(3, 3, 3)
                .addComponent(btn_deleting_mode)
                .addGap(3, 3, 3)
                .addComponent(sep_01, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_undo)
                .addGap(3, 3, 3)
                .addComponent(btn_redo)
                .addGap(3, 3, 3)
                .addComponent(btn_levelup)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(btn_plus)
                .addGap(3, 3, 3)
                .addComponent(btn_minus)
                .addGap(3, 3, 3)
                .addComponent(btn_center)
                .addGap(3, 3, 3)
                .addComponent(btn_view_mode)
                .addGap(3, 3, 3))
        );
        panel_topLayout.setVerticalGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel_topLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn_levelup)
                    .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_undo)
                        .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_plus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_view_mode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_center, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_minus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_deleting_mode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_processing_mode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sep_01))
                            .addComponent(btn_redo, GroupLayout.Alignment.LEADING))))
                .addGap(3, 3, 3))
        );

        panel_center.setDividerLocation(200);

        sp_left.setMinimumSize(new Dimension(150, 0));
        sp_left.setLayout(new CardLayout());

        panel_drop.setBorder(new FlatScrollPaneBorder());

        GroupLayout panel_dropLayout = new GroupLayout(panel_drop);
        panel_drop.setLayout(panel_dropLayout);
        panel_dropLayout.setHorizontalGroup(panel_dropLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panel_dropLayout.setVerticalGroup(panel_dropLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        sp_left.add(panel_drop, "card_drop");

        tree.setModel(null);
        tree.setCellRenderer(new Icon_Node_Renderer());
        sp_tree.setViewportView(tree);

        sp_left.add(sp_tree, "card4");

        panel_center.setLeftComponent(sp_left);

        sp_right.setMinimumSize(new Dimension(100, 100));

        label_image.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x32/picture_sunset.png"))); // NOI18N
        label_image.setAutoscrolls(true);
        label_image.addMouseListener(Listeners.image_mouse_listener);
        label_image.addMouseMotionListener(Listeners.image_mouse_motion_listener);

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
                .addComponent(label_image)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sp_right.setViewportView(panel_image);

        panel_center.setRightComponent(sp_right);

        panel_bottom.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
        panel_bottom.setLayout(new GridLayout(1, 0, 3, 3));

        btn_path_1.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_1.setActionCommand("path_0");
        btn_path_1.setFocusPainted(false);
        btn_path_1.setMargin(new Insets(5, 5, 5, 5));
        btn_path_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_1);

        btn_path_2.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_2.setActionCommand("path_1");
        btn_path_2.setFocusPainted(false);
        btn_path_2.setMargin(new Insets(5, 5, 5, 5));
        btn_path_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_2);

        btn_path_3.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_3.setActionCommand("path_2");
        btn_path_3.setFocusPainted(false);
        btn_path_3.setMargin(new Insets(5, 5, 5, 5));
        btn_path_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_3);

        btn_path_4.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_4.setActionCommand("path_3");
        btn_path_4.setFocusPainted(false);
        btn_path_4.setMargin(new Insets(5, 5, 5, 5));
        btn_path_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_4);

        btn_path_5.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_5.setActionCommand("path_4");
        btn_path_5.setFocusPainted(false);
        btn_path_5.setMargin(new Insets(5, 5, 5, 5));
        btn_path_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_5);

        btn_path_6.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_6.setActionCommand("path_5");
        btn_path_6.setFocusPainted(false);
        btn_path_6.setMargin(new Insets(5, 5, 5, 5));
        btn_path_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_6);

        btn_path_7.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_7.setActionCommand("path_6");
        btn_path_7.setFocusPainted(false);
        btn_path_7.setMargin(new Insets(5, 5, 5, 5));
        btn_path_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_7);

        btn_path_8.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_8.setActionCommand("path_7");
        btn_path_8.setFocusPainted(false);
        btn_path_8.setMargin(new Insets(5, 5, 5, 5));
        btn_path_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_8);

        btn_path_9.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        btn_path_9.setActionCommand("path_8");
        btn_path_9.setFocusPainted(false);
        btn_path_9.setMargin(new Insets(5, 5, 5, 5));
        btn_path_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_Pressed(evt);
            }
        });
        panel_bottom.add(btn_path_9);

        menu_file.setText("Файл");
        menu_bar.add(menu_file);

        menu_settings.setText("Налаштування");

        menu_theme.setText("Тема");
        Utils.init_Themes_List(menu_theme);
        menu_settings.add(menu_theme);

        menu_bar.add(menu_settings);

        menu_about.setText("Інфо");
        menu_bar.add(menu_about);

        setJMenuBar(menu_bar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel_bottom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_top, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_center, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_top, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_center, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(panel_bottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        setSize(new Dimension(460, 310));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

///////////////////////////////////////////////////////////////////////////////
    
    private void button_Pressed(ActionEvent evt) {//GEN-FIRST:event_button_Pressed
        Processing.button_Pressed(evt);
    }//GEN-LAST:event_button_Pressed

///////////////////////////////////////////////////////////////////////////////

public static void main (String args[]) {

UA_Translator.init();
Utils.set_Theme(DEFAULT_APP_THEME);

EventQueue.invokeLater(() -> { new Picture_Sorter().setVisible(true); });

}

///////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static JButton btn_center;
    protected static JButton btn_deleting_mode;
    protected static JButton btn_levelup;
    protected static JButton btn_minus;
    private JToggleButton btn_path_1;
    private JToggleButton btn_path_2;
    private JToggleButton btn_path_3;
    private JToggleButton btn_path_4;
    private JToggleButton btn_path_5;
    private JToggleButton btn_path_6;
    private JToggleButton btn_path_7;
    private JToggleButton btn_path_8;
    private JToggleButton btn_path_9;
    protected static JButton btn_plus;
    protected static JButton btn_processing_mode;
    protected static JButton btn_redo;
    protected static JButton btn_undo;
    protected static JButton btn_view_mode;
    protected static JLabel label_image;
    private JMenu menu_about;
    private JMenuBar menu_bar;
    private JMenu menu_file;
    private JMenu menu_settings;
    protected static JMenu menu_theme;
    private JPanel panel_bottom;
    private JSplitPane panel_center;
    public static JPanel panel_drop;
    private JPanel panel_image;
    private JPanel panel_top;
    private JSeparator sep_01;
    protected static JPanel sp_left;
    private JScrollPane sp_right;
    private JScrollPane sp_tree;
    protected static JTree tree;
    // End of variables declaration//GEN-END:variables

///////////////////////////////////////////////////////////////////////////////

}
