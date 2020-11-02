package com.zidu.desktop.core.UI;

import com.zidu.desktop.core.Controls.Tree.HTree;
import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class PanelMainFormTree extends JPanel {
    private JScrollPane scrollPane;
    private HTree tree;
    private DefaultTreeCellRenderer treeCellRenderer;
    private DefaultCellEditor cellEditor;
    public PanelMainFormTree() {
        this.setPreferredSize(new Dimension(200,1000));
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setLayout(new GridBagLayout());
        this.add(scrollPane,new GridBagLayoutHelper(0,0,1,1).setFill(GridBagConstraints.BOTH).setWeight(1,1).setAnchor(GridBagConstraints.WEST));
//        this.add(new JPanel(),new GridBagLayoutHelper(0,1,1,1).setWeight(1,1));
    }

    private void initParameter() {
        this.setBorder(BorderFactory.createLineBorder(Color.yellow));
        DefaultMutableTreeNode top =new DefaultMutableTreeNode("The Java Series");
        createNodes(top);
        tree=new HTree(top);
        scrollPane=new JScrollPane(tree);
        scrollPane.setBackground(null);
        this.setBackground(null);
        treeCellRenderer=new DefaultTreeCellRenderer();
        tree.setCellRenderer(new DefaultTreeCellRenderer());

        tree.setRootVisible(false);
    }
    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        top.add(category);

        //original Tutorial
        book = new DefaultMutableTreeNode(new BookInfo
                ("The Java Tutorial: A Short Course on the Basics",
                        "tutorial.html"));
        category.add(book);

        //Tutorial Continued
        book = new DefaultMutableTreeNode(new BookInfo
                ("The Java Tutorial Continued: The Rest of the JDK",
                        "tutorialcont.html"));
        category.add(book);

        //Swing Tutorial
        book = new DefaultMutableTreeNode(new BookInfo
                ("The Swing Tutorial: A Guide to Constructing GUIs",
                        "swingtutorial.html"));
        category.add(book);

        //...add more books for programmers...

        category = new DefaultMutableTreeNode("Books for Java Implementers");
        top.add(category);

        //VM
        book = new DefaultMutableTreeNode(new BookInfo
                ("The Java Virtual Machine Specification",
                        "vm.html"));
        category.add(book);

        //Language Spec
        book = new DefaultMutableTreeNode(new BookInfo
                ("The Java Language Specification",
                        "jls.html"));
        category.add(book);
    }
}
