package com.rutar.picture_sorter;

import java.awt.*;
import javax.swing.*;
import java.awt.dnd.*;
import java.awt.event.*;

import static com.rutar.picture_sorter.Picture_Sorter.*;

// ............................................................................

public class Listeners {

public static final Color DROP_ENTER = new Color(0x6666ff);
public static final Color DROP_EXIT  = new Color(0x777777);

private static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
private static final Cursor CURSOR_MOVE = new Cursor(Cursor.MOVE_CURSOR);

// ............................................................................

private static DropTarget drop_target;

///////////////////////////////////////////////////////////////////////////////

public static void init() { 

KeyboardFocusManager.getCurrentKeyboardFocusManager()
                    .addKeyEventDispatcher(key_event_dispatcher);

drop_target = new DropTarget(sp_left, drop_target_listener);

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

private static final DropTargetListener drop_target_listener
               = new DropTargetAdapter() {

@Override
public void drop (DropTargetDropEvent e) { Processing.drag_And_Drop_Files(e); }

// ............................................................................

@Override
public void dragEnter (DropTargetDragEvent e) {
    panel_drop.setBorder(Utils.get_Border(DROP_ENTER));
}

// ............................................................................

@Override
public void dragExit (DropTargetEvent e) {
    panel_drop.setBorder(Utils.get_Border(DROP_EXIT));
}
             
};

///////////////////////////////////////////////////////////////////////////////

private static Point origin;
private static JViewport viewport;

private static boolean drug_image_out;
private static boolean cursor_on_image;

// ............................................................................

public static MouseMotionListener image_mouse_motion_listener
        = new MouseMotionAdapter() {

@Override
public void mouseDragged (MouseEvent me) {

    if (origin != null) {
                      
        if (!drug_image_out && !cursor_on_image) { return; }
        
        viewport = (JViewport) SwingUtilities
                   .getAncestorOfClass(JViewport.class, label_image);
        
        if (viewport != null) {
            
            int deltaX = origin.x - me.getX();
            int deltaY = origin.y - me.getY();

            Rectangle view = viewport.getViewRect();
            view.x += deltaX;
            view.y += deltaY;

            label_image.scrollRectToVisible(view);
            
        }
    }
}
};

// ............................................................................

public static MouseListener image_mouse_listener
        = new MouseAdapter() {

@Override
public void mouseEntered (MouseEvent me) { cursor_on_image = true; }

@Override
public void mouseExited (MouseEvent me) { cursor_on_image = false; }

// ............................................................................

@Override
public void mousePressed (MouseEvent me) {
    origin = new Point(me.getPoint());
    label_image.setCursor(CURSOR_HAND);
}

// ............................................................................

@Override
public void mouseReleased (MouseEvent me) {
    label_image.setCursor(CURSOR_MOVE);
}

};

///////////////////////////////////////////////////////////////////////////////

}