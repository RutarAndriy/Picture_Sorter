package com.rutar.picture_sorter;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.dnd.*;
import java.nio.file.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;
import java.awt.datatransfer.*;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.util.*;

import com.rutar.ua_translator.*;
import com.rutar.picture_sorter.Picture_Sorter.*;
import javax.swing.plaf.metal.MetalIconFactory;

// ............................................................................

public class Picture_Sorter extends JFrame {

///////////////////////////////////////////////////////////////////////////////

private final Color drop_enter = new Color(0x6666ff);
private final Color drop_exit  = new Color(0x777777);

private final Cursor cursor_hand = new Cursor(Cursor.HAND_CURSOR);
private final Cursor cursor_move = new Cursor(Cursor.MOVE_CURSOR);

private final String[] folder_pathes = new String[9];

// ............................................................................

public static final String S_ICON = "/com/rutar/picture_sorter/icons/x16/";
public static final String L_ICON = "/com/rutar/picture_sorter/icons/x32/";

public static final String THEME_PATH = "/com/rutar/picture_sorter/themes/";

///////////////////////////////////////////////////////////////////////////////

public Picture_Sorter() {

initComponents();

setMinimumSize( getSize() );
setSize(680, 520);
setLocationRelativeTo(null);

KeyboardFocusManager.getCurrentKeyboardFocusManager()
                    .addKeyEventDispatcher(key_event_dispatcher);

new DropTarget(sp_left, drop_target_listener);

}

///////////////////////////////////////////////////////////////////////////////

private final KeyEventDispatcher key_event_dispatcher = (KeyEvent e) -> {
    
    if (e.getID() != KeyEvent.KEY_PRESSED) { return false; }
    
    int key_code = e.getKeyChar();
    
    if (key_code < 48 || key_code > 57) { return false; }
    else                                { key_code -= 48; }
    
    number_Pressed(key_code);
    return false;

};

///////////////////////////////////////////////////////////////////////////////

private void number_Pressed (int number) {
    
    System.out.println("Number: " + number);
    
}

///////////////////////////////////////////////////////////////////////////////
    
private final DropTargetListener drop_target_listener
        = new DropTargetAdapter() {

@Override
public void drop (DropTargetDropEvent event) {

event.acceptDrop(DnDConstants.ACTION_COPY);
Transferable transferable = event.getTransferable();
DataFlavor[] flavors = transferable.getTransferDataFlavors();

for (DataFlavor flavor : flavors) {

    try {

        if (flavor.isFlavorJavaFileListType()) {

            File[] files = ((java.util.List<File>) transferable
                            .getTransferData(flavor)).toArray(new File[0]);
            
            create_File_Tree(files);
            
        }
    }
    
    catch (Exception e) { System.out.println(e); }
    
}

((CardLayout)sp_left.getLayout()).last(sp_left);
panel_drop.setBorder(get_Border(drop_exit));
event.dropComplete(true);

}

// ............................................................................

@Override
public void dragEnter (DropTargetDragEvent e) {
    panel_drop.setBorder(get_Border(drop_enter));
}

// ............................................................................

@Override
public void dragExit (DropTargetEvent e) {
    panel_drop.setBorder(get_Border(drop_exit));
}
             
};

///////////////////////////////////////////////////////////////////////////////

private void create_File_Tree (File[] files) {
    
Tree_File_Node root = new Tree_File_Node();

for (File file : files) {

    if (file.isFile()) {

        try {
            
            String mimetype = Files.probeContentType(file.toPath());
            
            if (mimetype != null &&
                mimetype.split("/")[0].equals("image")) {
                
                root.add(new Tree_File_Node(file));
                
            }
            
            else { System.out.println(file.getName() + " is not an image"); }
            
        }
        
        catch (Exception e) { continue; }

    }
    
    else { root.add(new Tree_File_Node(file)); }

}

tree.setModel(new DefaultTreeModel(root));
sp_left.updateUI();
    
}

///////////////////////////////////////////////////////////////////////////////

private CompoundBorder get_Border (Color color) {
    
Border inside = new LineBorder(color, 2, true);
Border outside = BorderFactory.createEmptyBorder(7, 7, 7, 7);

return BorderFactory.createCompoundBorder(outside, inside);

}

///////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_top = new JPanel();
        btn_move_delete = new JToggleButton();
        btn_fold_unfold = new JToggleButton();
        btn_center = new JButton();
        btn_minus = new JButton();
        btn_plus = new JButton();
        btn_undo = new JButton();
        btn_redo = new JButton();
        panel_center = new JSplitPane();
        sp_left = new JPanel();
        panel_drop = new JPanel();
        sp_tree = new JScrollPane();
        tree = new JTree();
        sp_right = new JScrollPane();
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
        menu_settings = new JMenu();
        menu_theme = new JMenu();
        menu_about = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Picture Sorter");

        btn_move_delete.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/cut.png"))); // NOI18N
        btn_move_delete.setFocusPainted(false);
        btn_move_delete.setMargin(new Insets(5, 5, 5, 5));
        btn_move_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Processing_Mode(evt);
            }
        });

        btn_fold_unfold.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/arrow_out.png"))); // NOI18N
        btn_fold_unfold.setFocusPainted(false);
        btn_fold_unfold.setMargin(new Insets(5, 5, 5, 5));
        btn_fold_unfold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_View_Mode(evt);
            }
        });

        btn_center.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/distribution_partnerships.png"))); // NOI18N
        btn_center.setFocusPainted(false);
        btn_center.setMargin(new Insets(5, 5, 5, 5));
        btn_center.setPreferredSize(btn_fold_unfold.getPreferredSize());

        btn_minus.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/magnifier_zoom_out.png"))); // NOI18N
        btn_minus.setFocusPainted(false);
        btn_minus.setMargin(new Insets(5, 5, 5, 5));
        btn_minus.setPreferredSize(btn_fold_unfold.getPreferredSize());

        btn_plus.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/magnifier_zoom_in.png"))); // NOI18N
        btn_plus.setFocusPainted(false);
        btn_plus.setMargin(new Insets(5, 5, 5, 5));
        btn_plus.setPreferredSize(btn_fold_unfold.getPreferredSize());

        btn_undo.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/arrow_undo.png"))); // NOI18N
        btn_undo.setFocusPainted(false);
        btn_undo.setMargin(new Insets(5, 5, 5, 5));
        btn_undo.setPreferredSize(btn_fold_unfold.getPreferredSize());

        btn_redo.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/arrow_redo.png"))); // NOI18N
        btn_redo.setFocusPainted(false);
        btn_redo.setMargin(new Insets(5, 5, 5, 5));
        btn_redo.setPreferredSize(btn_fold_unfold.getPreferredSize());

        GroupLayout panel_topLayout = new GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel_topLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btn_move_delete)
                .addGap(3, 3, 3)
                .addComponent(btn_undo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_redo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btn_redo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_undo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_plus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_minus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_topLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_fold_unfold, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_move_delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_center, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );

        panel_center.setDividerLocation(200);

        sp_left.setMinimumSize(new Dimension(150, 0));
        sp_left.setLayout(new CardLayout());

        panel_drop.setBorder(get_Border(drop_exit)
        );

        GroupLayout panel_dropLayout = new GroupLayout(panel_drop);
        panel_drop.setLayout(panel_dropLayout);
        panel_dropLayout.setHorizontalGroup(panel_dropLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panel_dropLayout.setVerticalGroup(panel_dropLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
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
        label_image.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        label_image.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                image_Dragged(evt);
            }
        });
        label_image.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                image_Entered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                image_Exited(evt);
            }
            public void mousePressed(MouseEvent evt) {
                image_Pressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                image_Released(evt);
            }
        });

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

        sp_right.setViewportView(panel_image);

        panel_center.setRightComponent(sp_right);

        panel_bottom.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
        panel_bottom.setLayout(new GridLayout(1, 0, 3, 3));

        path_01.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_01.setActionCommand("path_0");
        path_01.setFocusPainted(false);
        path_01.setMargin(new Insets(5, 5, 5, 5));
        path_01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_01);

        path_02.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_02.setActionCommand("path_1");
        path_02.setFocusPainted(false);
        path_02.setMargin(new Insets(5, 5, 5, 5));
        path_02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_02);

        path_03.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_03.setActionCommand("path_2");
        path_03.setFocusPainted(false);
        path_03.setMargin(new Insets(5, 5, 5, 5));
        path_03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_03);

        path_04.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_04.setActionCommand("path_3");
        path_04.setFocusPainted(false);
        path_04.setMargin(new Insets(5, 5, 5, 5));
        path_04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_04);

        path_05.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_05.setActionCommand("path_4");
        path_05.setFocusPainted(false);
        path_05.setMargin(new Insets(5, 5, 5, 5));
        path_05.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_05);

        path_06.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_06.setActionCommand("path_5");
        path_06.setFocusPainted(false);
        path_06.setMargin(new Insets(5, 5, 5, 5));
        path_06.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_06);

        path_07.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_07.setActionCommand("path_6");
        path_07.setFocusPainted(false);
        path_07.setMargin(new Insets(5, 5, 5, 5));
        path_07.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_07);

        path_08.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_08.setActionCommand("path_7");
        path_08.setFocusPainted(false);
        path_08.setMargin(new Insets(5, 5, 5, 5));
        path_08.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_08);

        path_09.setIcon(new ImageIcon(getClass().getResource("/com/rutar/picture_sorter/icons/x16/plus.png"))); // NOI18N
        path_09.setActionCommand("path_8");
        path_09.setFocusPainted(false);
        path_09.setMargin(new Insets(5, 5, 5, 5));
        path_09.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                set_Path(evt);
            }
        });
        panel_bottom.add(path_09);

        menu_file.setText("File");
        menu_bar.add(menu_file);

        menu_settings.setText("Settings");

        menu_theme.setText("Theme");
        init_Themes_List(menu_theme);
        menu_settings.add(menu_theme);

        menu_bar.add(menu_settings);

        menu_about.setText("About");
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
                .addComponent(panel_center)
                .addGap(3, 3, 3)
                .addComponent(panel_bottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        setSize(new Dimension(328, 230));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void set_Path(ActionEvent evt) {//GEN-FIRST:event_set_Path

        JToggleButton btn = (JToggleButton) evt.getSource();
        int btn_index = Integer.parseInt(btn.getActionCommand().split("_")[1]);
        
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int result = file_chooser.showOpenDialog(this);
        File selected_file = file_chooser.getSelectedFile();
        
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = selected_file.getAbsolutePath();
            folder_pathes[btn_index] = path;
            btn.setToolTipText(path);
        }
        
        else {
            btn.setSelected(false);
            btn.setToolTipText(null);
            folder_pathes[btn_index] = null;
        }
        
        String name = String.format(S_ICON + "%s.png",
                                    btn.isSelected() ? "folder_blue" : "plus");
        
        ImageIcon icon = new ImageIcon(getClass().getResource(name));
        btn.setIcon(icon);
        
    }//GEN-LAST:event_set_Path

///////////////////////////////////////////////////////////////////////////////
    
    private Point origin;
    private JViewport viewport;

    private void image_Released(MouseEvent evt) {//GEN-FIRST:event_image_Released
        label_image.setCursor(cursor_move);
    }//GEN-LAST:event_image_Released

    private void image_Pressed(MouseEvent evt) {//GEN-FIRST:event_image_Pressed
        origin = new Point(evt.getPoint());
        label_image.setCursor(cursor_hand);
    }//GEN-LAST:event_image_Pressed

///////////////////////////////////////////////////////////////////////////////

    private boolean drug_image_out;
    private boolean cursor_on_image;
    
    private void image_Dragged(MouseEvent evt) {//GEN-FIRST:event_image_Dragged
        
    if (origin != null) {
                      
        if (!drug_image_out && !cursor_on_image) { return; }
        
        viewport = (JViewport) SwingUtilities
                   .getAncestorOfClass(JViewport.class, label_image);
        
        if (viewport != null) {
            
            int deltaX = origin.x - evt.getX();
            int deltaY = origin.y - evt.getY();

            Rectangle view = viewport.getViewRect();
            view.x += deltaX;
            view.y += deltaY;

            label_image.scrollRectToVisible(view);
            
        }
    }
    }//GEN-LAST:event_image_Dragged

///////////////////////////////////////////////////////////////////////////////
    
    private void image_Exited(MouseEvent evt) {//GEN-FIRST:event_image_Exited
        cursor_on_image = false;
    }//GEN-LAST:event_image_Exited

    private void image_Entered(MouseEvent evt) {//GEN-FIRST:event_image_Entered
        cursor_on_image = true;
    }//GEN-LAST:event_image_Entered

///////////////////////////////////////////////////////////////////////////////

    private void set_View_Mode(ActionEvent evt) {//GEN-FIRST:event_set_View_Mode

        boolean selected = btn_fold_unfold.isSelected();
        String name = String.format(S_ICON + "%s.png",
                                    selected ? "arrow_in" : "arrow_out");
        
        ImageIcon icon = new ImageIcon(getClass().getResource(name));
        btn_fold_unfold.setIcon(icon);
        
    }//GEN-LAST:event_set_View_Mode

    private void set_Processing_Mode(ActionEvent evt) {//GEN-FIRST:event_set_Processing_Mode
        
        boolean selected = btn_move_delete.isSelected();
        String name = String.format(S_ICON + "%s.png",
                                    selected ? "calendar_copy" : "cut");
        
        ImageIcon icon = new ImageIcon(getClass().getResource(name));
        btn_move_delete.setIcon(icon);

    }//GEN-LAST:event_set_Processing_Mode

///////////////////////////////////////////////////////////////////////////////

private final String[] themes = new String[] { 
      
    "Flat_Light",
    "Flat_Dark",
    "Intellij",
    "Darcula",
    ":",
    "Arc",
    "Gray",
    ":",
    "Cobalt_2",
    "Dark_Flat",
    "GitHub_Dark",
    "Gruvbox_Dark_Hard",
    "Night_Owl"

};

// ............................................................................

private void init_Themes_List (JMenu menu) {
    
    ButtonGroup group = new ButtonGroup();
    
    for (String theme : themes) {
        
        if (theme.equals(":")) { menu.add(new JSeparator()); }
        else {
        
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(theme);

            item.setIcon(MetalIconFactory.getFileChooserHomeFolderIcon());
            item.addActionListener(theme_listener);
            menu.add(item);
            group.add(item);
        }
    }    
}

///////////////////////////////////////////////////////////////////////////////

private ActionListener theme_listener = (ActionEvent ae) -> {
    
    String theme = ((JMenuItem)ae.getSource()).getText();

    switch (theme) {
        case "Flat_Light": FlatLightLaf.setup();    break;
        case "Flat_Dark":  FlatDarkLaf.setup();     break;
        case "Intellij":   FlatIntelliJLaf.setup(); break;
        case "Darcula":    FlatDarculaLaf.setup();  break;
        
        default: IntelliJTheme.setup(Picture_Sorter.class
                .getResourceAsStream(THEME_PATH + theme + ".theme.json"));
    }

    SwingUtilities.updateComponentTreeUI(this);
    
};

///////////////////////////////////////////////////////////////////////////////

public static void main (String args[]) {

UA_Translator.init();
IntelliJTheme.setup(Picture_Sorter.class
             .getResourceAsStream(THEME_PATH + "GitHub_Dark.theme.json"));

if (SystemInfo.isLinux) {
    JFrame .setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
}

UIManager.put("TitlePane.noIconLeftGap", 0);
UIManager.put("TitlePane.centerTitle", true);

EventQueue.invokeLater(() -> { new Picture_Sorter().setVisible(true); });

}

///////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btn_center;
    private JToggleButton btn_fold_unfold;
    private JButton btn_minus;
    private JToggleButton btn_move_delete;
    private JButton btn_plus;
    private JButton btn_redo;
    private JButton btn_undo;
    private JLabel label_image;
    private JMenu menu_about;
    private JMenuBar menu_bar;
    private JMenu menu_file;
    private JMenu menu_settings;
    private JMenu menu_theme;
    private JPanel panel_bottom;
    private JSplitPane panel_center;
    private JPanel panel_drop;
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
    private JPanel sp_left;
    private JScrollPane sp_right;
    private JScrollPane sp_tree;
    private JTree tree;
    // End of variables declaration//GEN-END:variables

///////////////////////////////////////////////////////////////////////////////

class Tree_File_Node extends DefaultMutableTreeNode {

protected File file;
protected Icon icon;

// ............................................................................

public Tree_File_Node() { this(null); }

// ............................................................................

public Tree_File_Node (Object object) {
    
super(object, true);

String icon_name;
file = (File) object;

if (file == null || file.isDirectory()) { icon_name = "folder_blue"; }
else                                    { icon_name = "picture_sunset"; }

icon_name = String.format(S_ICON + "%s.png", icon_name);
icon = new ImageIcon(getClass().getResource(icon_name));

}

// ............................................................................

public File   get_File() { return file; }
public Icon   get_Icon() { return icon; }

public String get_Text() { return file != null ? file.getName() : "/"; }

// ............................................................................

}
}

///////////////////////////////////////////////////////////////////////////////

class Icon_Node_Renderer extends DefaultTreeCellRenderer {

@Override
public Component getTreeCellRendererComponent (JTree tree, Object object,
                                               boolean sel, boolean expanded,
                                               boolean leaf, int row,
                                               boolean hasFocus) {

super.getTreeCellRendererComponent(tree, object, sel,
                                   expanded, leaf, row, hasFocus);

Tree_File_Node node = (Tree_File_Node) object;

setText(node.get_Text());
setIcon(node.get_Icon());

return this;

}
}