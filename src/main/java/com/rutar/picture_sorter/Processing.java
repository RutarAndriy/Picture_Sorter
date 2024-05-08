package com.rutar.picture_sorter;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.dnd.*;
import java.awt.event.*;
import javax.swing.event.*;
import com.rutar.jimageview.*;
import com.rutar.jdroppablepanel.*;

import static com.rutar.picture_sorter.Picture_Sorter.*;

// ............................................................................

public class Processing {

private static Picture_Sorter app;

private static boolean view_mode_fullsize   = true;
private static boolean deleting_mode_unsafe = true;
private static boolean processing_mode_copy = true;

private static final String[] folder_pathes = new String[9];

///////////////////////////////////////////////////////////////////////////////

public static void init (Picture_Sorter application) {
    
app = application;

set_Processing_Mode(null);
set_Deleting_Mode(null);
set_View_Mode(null);

}

///////////////////////////////////////////////////////////////////////////////

public static void button_Pressed (ActionEvent ae) {

String command = ae.getActionCommand();

if      (command.startsWith("path"))
    { set_Path(ae); }
else if (command.equals("view_mode"))
    { set_View_Mode(ae); }
else if (command.endsWith("processing_mode"))
    { set_Processing_Mode(ae); }
else if (command.endsWith("deleting_mode"))
    { set_Deleting_Mode(ae); }

}

///////////////////////////////////////////////////////////////////////////////

public static void number_Pressed (int number) {
    
System.out.println("Number: " + number);
    
}

///////////////////////////////////////////////////////////////////////////////

private static void set_Processing_Mode (ActionEvent ae) {                               

processing_mode_copy =! processing_mode_copy;

btn_processing_mode.setIcon(Utils
                   .get_Icon(processing_mode_copy ? "calendar_copy" :
                                                    "cut_red"));
btn_processing_mode.setToolTipText("Режим обробки: " +
                                  (processing_mode_copy ? "копіювання" :
                                                          "переміщення"));

} 

///////////////////////////////////////////////////////////////////////////////

private static void set_Deleting_Mode (ActionEvent ae) {                               

deleting_mode_unsafe =! deleting_mode_unsafe;

btn_deleting_mode.setIcon(Utils
                 .get_Icon(deleting_mode_unsafe ? "cross" :
                                                  "bin_empty"));
btn_deleting_mode.setToolTipText("Режим видалення: " +
                                (deleting_mode_unsafe ? "повністю" :
                                                        "корзина"));
} 

///////////////////////////////////////////////////////////////////////////////

private static void set_View_Mode (ActionEvent ae) {                               

view_mode_fullsize =! view_mode_fullsize;

btn_view_mode.setIcon(Utils
             .get_Icon(view_mode_fullsize ? "arrow_out" :
                                            "arrow_in"));
btn_view_mode.setToolTipText(view_mode_fullsize ? "Оригінальний розмір" :
                                                  "Режим масштабування");
} 

///////////////////////////////////////////////////////////////////////////////

private static void set_Path (ActionEvent ae) {                       

JToggleButton btn = (JToggleButton) ae.getSource();
int btn_index = Integer.parseInt(btn.getActionCommand().split("_")[1]);

JFileChooser file_chooser = new JFileChooser();
file_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

int result = file_chooser.showOpenDialog(app);
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

btn.setIcon(Utils.get_Icon(btn.isSelected() ? "folder_blue" :
                                              "plus"));

}

///////////////////////////////////////////////////////////////////////////////

public static void tree_Value_Selected (TreeSelectionEvent tse) {                                  
    
Files_Tree_Node selected_node = (Files_Tree_Node)
                tree.getLastSelectedPathComponent();

if (selected_node == null ||
    selected_node.file == null) { return; }

File file = new File(selected_node.file.getAbsolutePath());
image_view.setImage(JImageViewUtils.getImageQuickly(file));

}       

///////////////////////////////////////////////////////////////////////////////

public static void drag_And_Drop_Files (DropTargetDropEvent event) {

File[] droppable_files = JDroppablePanelUtils.getDroppableFiles(event);
Files_Tree.create_Files_Tree(droppable_files);

((CardLayout)sp_left.getLayout()).last(sp_left);
    
}

///////////////////////////////////////////////////////////////////////////////

}