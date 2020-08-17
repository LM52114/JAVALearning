package com.zidu.DesktopJavaLearn.Dialogs;

import com.zidu.DesktopJavaLearn.Controls.Button.ControlOKAndCancelButton;
import com.zidu.DesktopJavaLearn.Tools.CoreProperties;
import com.zidu.DesktopJavaLearn.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DialogDemonDear extends JDialog {
    public DialogDemonDear() {
        init();
    }

    private void init() {
        JPanel panel = new JPanel();
        this.setTitle(CoreProperties.getString("String_Dear"));
        this.add(panel);
        JLabel labelSex = new JLabel(CoreProperties.getString("String_Sex"));
        JTextField textFieldSex = new JTextField();
        JLabel labelName = new JLabel(CoreProperties.getString("String_Name"));
        final JTextField textFieldName = new JTextField();
        JLabel labelNewName = new JLabel(CoreProperties.getString("String_NewName"));
        String[] newName = {CoreProperties.getString("String_Sex"), CoreProperties.getString("String_Sex"), CoreProperties.getString("String_Sex"), CoreProperties.getString("String_Sex")};
        final JComboBox comboBox = new JComboBox(newName);
        comboBox.setRenderer(new DefaultListCellRenderer());
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                textFieldName.setText(comboBox.getSelectedItem().toString());
            }
        });
        ControlOKAndCancelButton controlOKAndCancelButton = new ControlOKAndCancelButton();


        panel.setLayout(new GridBagLayout());
        panel.add(labelSex, new GridBagLayoutHelper(0, 0, 1, 1).setInsets(10, 10, 0, 0)
                .setFill(GridBagConstraints.HORIZONTAL));
        panel.add(textFieldSex, new GridBagLayoutHelper(1, 0, 1, 1).setInsets(10, 5, 0, 10)
                .setFill(GridBagConstraints.HORIZONTAL).setWeight(1, 0));
        panel.add(labelName, new GridBagLayoutHelper(0, 1, 1, 1).setInsets(5, 10, 0, 0)
                .setFill(GridBagConstraints.HORIZONTAL));
        panel.add(textFieldName, new GridBagLayoutHelper(1, 1, 1, 1).setInsets(5, 5, 0, 10)
                .setFill(GridBagConstraints.HORIZONTAL).setWeight(1, 0));
        panel.add(labelNewName, new GridBagLayoutHelper(0, 2, 1, 1).setInsets(5, 10, 0, 0)
                .setFill(GridBagConstraints.HORIZONTAL));
        panel.add(comboBox, new GridBagLayoutHelper(1, 2, 1, 1).setInsets(5, 5, 0, 10)
                .setFill(GridBagConstraints.HORIZONTAL).setWeight(1, 0));

        panel.add(new JPanel(), new GridBagLayoutHelper(0, 3, 1, 1).setWeight(1, 1));
        panel.add(controlOKAndCancelButton, new GridBagLayoutHelper(1, 4, 1, 1).setInsets(10, 10, 10, 0).setFill(GridBagConstraints.HORIZONTAL).setAnchor(GridBagConstraints.EAST));

        this.setSize(400, 240);
        this.setLocation(500, 300);
    }


}
