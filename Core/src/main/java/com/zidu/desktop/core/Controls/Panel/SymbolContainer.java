package com.zidu.desktop.core.Controls.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SymbolContainer extends JPanel {
    //记录当前选中的SymbolPanel
    private ArrayList<SymbolPanel> symbolPanels = new ArrayList<SymbolPanel>();
    private boolean toggle = false;//ctrlDown
    private boolean extend = false;//shiftDown
    protected DefaultListSelectionModel selectionModel;

    public DefaultListSelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(DefaultListSelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }


    public SymbolContainer() {
        initParameter();
        initLayout();
        initListener();
    }

    private void initParameter() {
        selectionModel = new DefaultListSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setSelectionModel(selectionModel);
    }

    private void initListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (getComponentAt(e.getPoint()) instanceof SymbolPanel) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if (e.isControlDown()) {
                            extend = false;
                            toggle = true;
                            getSelectionModel().addSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())), getComponentZOrder(getComponentAt(e.getPoint())));
                        } else if (e.isShiftDown()) {
                            toggle = false;
                            extend = true;
                            getSelectionModel().setSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())), getComponentZOrder(getComponentAt(e.getPoint())));
                        } else {
                            extend = false;
                            toggle = false;
                            getSelectionModel().setSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())), getComponentZOrder(getComponentAt(e.getPoint())));
                        }
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        ((SymbolPanel) getComponentAt(e.getPoint())).setUnSelect();
                    }
                }
            }
        });


        SymbolContainer.this.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!toggle) {
                    ClearAllSelection();
                    toggle = false;
                }
                symbolPanels.clear();
                if (!extend) {
                    ((SymbolPanel) getComponent(getSelectionModel().getAnchorSelectionIndex())).setSelect();
                    symbolPanels.add((SymbolPanel) getComponent(getSelectionModel().getAnchorSelectionIndex()));
                } else {
                    for (int i = Math.min(e.getFirstIndex(), e.getLastIndex()); i <= Math.max(e.getFirstIndex(), e.getLastIndex()); i++) {
                        ((SymbolPanel) getComponent(i)).setSelect();
                        symbolPanels.add((SymbolPanel) getComponent(i));
                    }
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_A) {
                    selectAllSymbolPanels();
                }
            }
        });
    }

    private void initLayout() {
        this.setLayout(new FlowLayout());
        for (int i = 0; i < 100; i++) {
            SymbolPanel symbolPanel = new SymbolPanel();
            this.add(symbolPanel);
        }
        this.add(new SymbolPanel("end","end"));
    }

    private void ClearAllSelection() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            this.getComponent(i).setBackground(null);
        }
    }

    private void selectAllSymbolPanels() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            ((SymbolPanel) this.getComponent(i)).setSelect();
        }
    }

    private void setSelectionModel(int selectionModel) {
        this.selectionModel.setSelectionMode(selectionModel);
    }
}

