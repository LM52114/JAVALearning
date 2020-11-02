package com.zidu.desktop.core.Controls.ComboBox;


import javax.swing.*;
import java.awt.*;
import java.awt.image.ComponentColorModel;

public class HComboBoxImageAndName<SubstanceDefaultListCellRenderer> extends HComboBox {
    private SubstanceDefaultListCellRenderer substanceDefaultListCellRenderer;
    private ListCellRenderer listCellRenderer;
    public HComboBoxImageAndName() {
        initParameter();
        initComboBox();
    }

    private void initParameter() {
    }

    private void initComboBox() {
        this.setRenderer(listCellRenderer);
    }

}
