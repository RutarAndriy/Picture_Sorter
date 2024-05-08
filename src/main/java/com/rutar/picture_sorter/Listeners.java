package com.rutar.picture_sorter;

import java.awt.*;
import javax.swing.*;
import java.awt.dnd.*;
import java.awt.event.*;
import javax.swing.event.*;

// ............................................................................

public class Listeners {

///////////////////////////////////////////////////////////////////////////////

public static void init() { 

KeyboardFocusManager.getCurrentKeyboardFocusManager()
                    .addKeyEventDispatcher(key_event_dispatcher);

}

///////////////////////////////////////////////////////////////////////////////

public static final ActionListener theme_listener = (ActionEvent ae) -> {
    
    String theme_name = ((JMenuItem)ae.getSource()).getText();
    Utils.set_Theme(theme_name);

};

///////////////////////////////////////////////////////////////////////////////

public static final KeyEventDispatcher key_event_dispatcher = (KeyEvent e) -> {
    
    if (e.getID() != KeyEvent.KEY_PRESSED) { return false; }
    
    int key_code = e.getKeyChar();
    
    if (key_code < 48 || key_code > 57) { return false; }
    else                                { key_code -= 48; }
    
    Processing.number_Pressed(key_code);
    return false;

};

///////////////////////////////////////////////////////////////////////////////

public static final TreeSelectionListener tree_selection_listener
    = (TreeSelectionEvent tse) -> { Processing.tree_Value_Selected(tse); };

///////////////////////////////////////////////////////////////////////////////

public static final DropTargetListener drop_target_listener
              = new DropTargetAdapter() {

@Override
public void drop (DropTargetDropEvent e) {
    Processing.drag_And_Drop_Files(e);
}
           
};

// Кінець класу Listeners /////////////////////////////////////////////////////

}
