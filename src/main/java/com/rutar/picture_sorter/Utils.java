package com.rutar.picture_sorter;

import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.ui.*;
import com.formdev.flatlaf.util.*;
import com.rutar.custom_flat_laf.themes.*;

import static com.rutar.picture_sorter.Listeners.*;
import static com.rutar.picture_sorter.Picture_Sorter.*;

// ............................................................................

public class Utils {

private static final String S_ICON = "/com/rutar/picture_sorter/icons/x16/";
private static final String L_ICON = "/com/rutar/picture_sorter/icons/x32/";

private static final String THEME_PATH = "/com/rutar/picture_sorter/themes/";

// ............................................................................

private static final String[] themes = new String[] { 
      
    "Flat_Light",        "light",
    "Flat_Dark",         "dark",
    "Intellij",          "light",
    "Darcula",           "dark",
//    ":",                 "-",
//    "Rutar_Light",       "light",
//    "Rutar_Dark",        "dark",
    ":",                 "-",
    "Arc",               "light",
    "Gray",              "light",
    ":",                 "-",
    "Cobalt_2",          "dark",
    "Dark_Flat",         "dark",
    "GitHub_Dark",       "dark",
    "Gruvbox_Dark_Hard", "dark",
    "Night_Owl",         "dark"

};

///////////////////////////////////////////////////////////////////////////////

public static Icon get_Icon (String icon_name) {
    return get_Icons(icon_name, S_ICON);
}

public static Icon get_x16_Icon (String icon_name) {
    return get_Icons(icon_name, S_ICON);
}

public static Icon get_x32_Icon (String icon_name) {
    return get_Icons(icon_name, L_ICON);
}

///////////////////////////////////////////////////////////////////////////////

private static Icon get_Icons (String icon_name, String icon_path) {
    
    String full_path = String.format(icon_path + "%s.png", icon_name);    
    URL resource = get_Resource(full_path);
    
    if (resource != null)
        { return new ImageIcon(resource); }
    else 
        { return get_Icon("cross"); }
    
}

///////////////////////////////////////////////////////////////////////////////

public static void init_Themes_List (JMenu menu) {
    
    String theme;
    ButtonGroup group = new ButtonGroup();
    
    for (int z = 0; z < themes.length; z+=2) {
        
        theme = themes[z];
        
        if (theme.equals(":")) { menu.add(new JSeparator()); }
        else {
        
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(theme);
            
            String icon_name = themes[z+1].equals("light")
                             ? "weather_sun" : "weather_clouds";
            
            item.setIcon(get_Icon(icon_name));
            item.addActionListener(theme_listener);
            
            if (theme.equals(DEFAULT_APP_THEME)) { item.setSelected(true); }
            
            menu.add(item);
            group.add(item);
        }
    }    
}

///////////////////////////////////////////////////////////////////////////////

public static void set_Theme (String theme_name) {

    switch (theme_name) {
        
        case "Flat_Light"  -> FlatLightLaf.setup();
        case "Flat_Dark"   -> FlatDarkLaf.setup();
        case "Intellij"    -> FlatIntelliJLaf.setup();
        case "Darcula"     -> FlatDarculaLaf.setup();
        
        case "Rutar_Light" -> Rutar_Light.setup();
        case "Rutar_Dark"  -> Rutar_Dark.setup();
        
        default -> IntelliJTheme.setup(Picture_Sorter.class
                .getResourceAsStream(THEME_PATH + theme_name + ".theme.json"));
        
    }

    if (SystemInfo.isLinux) {
        JFrame .setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
    }

    UIManager.put("TitlePane.noIconLeftGap", 0);
    UIManager.put("TitlePane.titleMargins", new Insets(0, 8, 0, 8));
    
    FlatLaf.updateUI();
    
}

///////////////////////////////////////////////////////////////////////////////

public static Border get_Border (Color color) {

    if (color == null) { return new FlatScrollPaneBorder(); }

    FlatScrollPaneBorder color_border = new FlatScrollPaneBorder();

    color_border.applyStyleProperty("borderColor",        color);
    color_border.applyStyleProperty("focusedBorderColor", color);

    return color_border;

}

///////////////////////////////////////////////////////////////////////////////

public static URL get_Resource (String path) {
    return Utils.class.getResource(path);
}

///////////////////////////////////////////////////////////////////////////////

}