package com.rutar.picture_sorter;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

import static com.rutar.picture_sorter.Picture_Sorter.*;

// ............................................................................

public class Processing {

private static Picture_Sorter app;

private static boolean view_mode_fullsize;
private static boolean processing_mode_copy;

private static final String[] folder_pathes = new String[9];

///////////////////////////////////////////////////////////////////////////////

public static void init (Picture_Sorter application) { app = application; }

///////////////////////////////////////////////////////////////////////////////

public static void button_Pressed (ActionEvent ae) {

String command = ae.getActionCommand();

if      (command.startsWith("path"))
    { set_Path(ae); }
else if (command.equals("view_mode"))
    { set_View_Mode(ae); }
else if (command.endsWith("processing_mode"))
    { set_Processing_Mode(ae); }

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

} 

///////////////////////////////////////////////////////////////////////////////

private static void set_View_Mode (ActionEvent ae) {                               

view_mode_fullsize =! view_mode_fullsize;

btn_view_mode.setIcon(Utils
             .get_Icon(view_mode_fullsize ? "arrow_in" : "arrow_out"));

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

public static void drag_And_Drop_Files (DropTargetDropEvent event) {
    
event.acceptDrop(DnDConstants.ACTION_COPY);
Transferable transferable = event.getTransferable();
DataFlavor[] flavors = transferable.getTransferDataFlavors();

for (DataFlavor flavor : flavors) {

    try {

        if (flavor.isFlavorJavaFileListType()) {

            File[] files = ((java.util.List<File>) transferable
                            .getTransferData(flavor)).toArray(new File[0]);
            
            Files_Tree.create_Files_Tree(files);
            
        }
    }
    
    catch (Exception e) { System.out.println(e); }
    
}

((CardLayout)sp_left.getLayout()).last(sp_left);
panel_drop.setBorder(Utils.get_Border(Listeners.DROP_EXIT));
event.dropComplete(true);
    
}

///////////////////////////////////////////////////////////////////////////////

}