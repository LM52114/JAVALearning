package com.zidu.desktop.core.UI;

import com.zidu.desktop.core.Tools.CoreProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFromMenuBar extends JMenuBar {
    private JMenu menuFile;
    private JMenu menuNewFile;
    private JMenu menuEdita;
    private JMenuItem menuItemNew;
    private JMenuItem menuItemOpen;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemCopy;
    private JMenuItem menuItemPaste;
    private JMenuItem menuItemDelete;
    private JRadioButtonMenuItem radioButtonMenuItem;
    private JCheckBoxMenuItem checkBoxMenuItem;
    private ItemListener menuItemListener;

    public MainFromMenuBar() {
        initParameter();
        initEvent();
    }

    private void initEvent() {
        unEvent();
        menuItemNew.addItemListener(menuItemListener);
        menuItemOpen.addItemListener(menuItemListener);
        menuItemSave.addItemListener(menuItemListener);
    }

    private void unEvent(){
        menuItemNew.removeItemListener(menuItemListener);
        menuItemOpen.removeItemListener(menuItemListener);
        menuItemSave.removeItemListener(menuItemListener);
    }

    private void initParameter() {

        menuFile =new JMenu(CoreProperties.getString("String_MenuFile"));
        menuEdita=new JMenu(CoreProperties.getString("String_MenuEdita"));
        menuNewFile=new JMenu(CoreProperties.getString("String_MenuItemNew"));
        this.add(menuFile);
        this.add(menuEdita);

        menuItemNew=new JMenuItem(CoreProperties.getString("String_MenuItemNew"));
        menuItemOpen=new JMenuItem(CoreProperties.getString("String_MenuItemOpen"));
        menuItemSave=new JMenuItem(CoreProperties.getString("String_MenuItemSave"));
        radioButtonMenuItem=new JRadioButtonMenuItem(CoreProperties.getString("String_MenuItemIsAutoSave"));
        menuNewFile.add(menuItemNew);
        menuFile.add(menuNewFile);
        menuFile.addSeparator();
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.addSeparator();
        menuFile.add(radioButtonMenuItem);

        checkBoxMenuItem=new JCheckBoxMenuItem(CoreProperties.getString("String_MenuItemIsAutoSave"));

        menuItemCopy=new JMenuItem(CoreProperties.getString("String_MenuItemCopy"));
        menuItemPaste=new JMenuItem(CoreProperties.getString("String_MenuItemPaste"));
        menuItemDelete=new JMenuItem(CoreProperties.getString("String_MenuItemDelete"));
        menuEdita.add(menuItemCopy);
        menuEdita.add(menuItemPaste);
        menuEdita.addSeparator();
        menuEdita.add(menuItemDelete);
        menuEdita.addSeparator();
        menuEdita.add(checkBoxMenuItem);

        menuItemListener=new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Component component = (Component) e.getSource();
                if(component==menuItemNew){

                }else if(component==menuItemOpen){

                }else if(component==menuItemSave){

                }
            }
        };
    }
}
