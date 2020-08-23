package com.zidu.desktop.core.UI;

import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

public class PanelMainFormProperties extends JPanel {
    private JScrollPane scrollPane;
    private JTable table;
    public PanelMainFormProperties() {
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setLayout(new GridBagLayout());
        this.add(scrollPane,new GridBagLayoutHelper(0,0,1,1).setFill(GridBagConstraints.BOTH).setWeight(1,1).setAnchor(GridBagConstraints.WEST));
//        this.add(new JPanel(),new GridBagLayoutHelper(0,1,1,1).setWeight(1,1));
    }

    private void initParameter() {
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
    }
}
