package com.zidu.desktop.core.Dialogs;

import com.zidu.desktop.core.Controls.Dialog.HDialog;
import com.zidu.desktop.core.Controls.Panel.SymbolContainer;

public class DialogSymbol extends HDialog {
    private SymbolContainer symbolPanel;
    public DialogSymbol() {
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setSize(600,400);
        this.getContentPane().add(symbolPanel);
    }

    private void initParameter() {
        symbolPanel=new SymbolContainer();
    }
}
