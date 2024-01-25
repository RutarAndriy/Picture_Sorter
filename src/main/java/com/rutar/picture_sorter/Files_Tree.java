package com.rutar.picture_sorter;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.nio.file.*;
import javax.swing.tree.*;

import static com.rutar.picture_sorter.Picture_Sorter.*;

// ............................................................................

public class Files_Tree {

///////////////////////////////////////////////////////////////////////////////

public static void create_Files_Tree (File[] files) {
    
Files_Tree_Node root = new Files_Tree_Node();

for (File file : files) {

    if (file.isFile()) {

        try {
            
            String mimetype = Files.probeContentType(file.toPath());
            
            if (mimetype != null &&
                mimetype.split("/")[0].equals("image")) {
                
                root.add(new Files_Tree_Node(file));
                
            }
            
            else { System.out.println(file.getName() + " is not an image"); }
            
        }
        
        catch (Exception e) { }

    }
    
    else { root.add(new Files_Tree_Node(file)); }

}

tree.setModel(new DefaultTreeModel(root));
    
}

///////////////////////////////////////////////////////////////////////////////

}

///////////////////////////////////////////////////////////////////////////////
//

class Files_Tree_Node extends DefaultMutableTreeNode {

protected File file;
protected Icon icon;

// ............................................................................

public Files_Tree_Node() { this(null); }

// ............................................................................

public Files_Tree_Node (Object object) {
    
super(object, true);

String icon_name;
file = (File) object;

if (file == null || file.isDirectory()) { icon_name = "folder_blue"; }
else                                    { icon_name = "picture_sunset"; }

icon = Utils.get_Icon(icon_name);

}

// ............................................................................

public File   get_File() { return file; }
public Icon   get_Icon() { return icon; }

public String get_Text() { return file != null ? file.getName() : "/"; }

// ............................................................................

}

class Icon_Node_Renderer extends DefaultTreeCellRenderer {

@Override
public Component getTreeCellRendererComponent (JTree tree, Object object,
                                               boolean sel, boolean expanded,
                                               boolean leaf, int row,
                                               boolean hasFocus) {

super.getTreeCellRendererComponent(tree, object, sel,
                                   expanded, leaf, row, hasFocus);

Files_Tree_Node node = (Files_Tree_Node) object;

setText(node.get_Text());
setIcon(node.get_Icon());

return this;

}
}