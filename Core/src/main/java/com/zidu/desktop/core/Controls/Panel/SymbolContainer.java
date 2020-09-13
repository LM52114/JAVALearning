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
    private ArrayList<SymbolPanel>symbolPanels=new ArrayList<SymbolPanel>();
    private boolean isAnother=false;
    private boolean extend=false;
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
        selectionModel=new DefaultListSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setSelectionModel(selectionModel);
    }

    private void initListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (getComponentAt(e.getPoint()) instanceof SymbolPanel) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if (selectionModel.getSelectionMode() == ListSelectionModel.SINGLE_SELECTION) {
                            getSelectionModel().setSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())),getComponentZOrder(getComponentAt(e.getPoint())));
                        }else {
                            if (e.isControlDown()) {
                                extend=false;
                                isAnother=true;
                                getSelectionModel().addSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())), getComponentZOrder(getComponentAt(e.getPoint())));
                            }else if(e.isShiftDown()){
                                isAnother=false;
                                extend=true;
                                getSelectionModel().setSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())),getComponentZOrder(getComponentAt(e.getPoint())));
                            }else{
                                extend=false;
                                isAnother=false;
                                getSelectionModel().setSelectionInterval(getComponentZOrder(getComponentAt(e.getPoint())),getComponentZOrder(getComponentAt(e.getPoint())));
                            }
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
                if(!isAnother) {
                    ClearAllSelection();
                    isAnother=false;
                }
                if(!extend) {
                    ((SymbolPanel) getComponent(getSelectionModel().getAnchorSelectionIndex())).setSelect();
                }else{
                    for (int i = Math.min(e.getFirstIndex(),e.getLastIndex()); i <=Math.max(e.getFirstIndex(),e.getLastIndex()) ; i++) {
                        ((SymbolPanel) getComponent(i)).setSelect();
                    }
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_A){
                    selectAllSymbolPanels();
                }
            }
        });
    }
    protected void fireSelectionValueChanged(int firstIndex, int lastIndex,
                                             boolean isAdjusting)
    {
        Object[] listeners = listenerList.getListenerList();
        ListSelectionEvent e = null;

        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ListSelectionListener.class) {
                if (e == null) {
                    e = new ListSelectionEvent(this, firstIndex, lastIndex,
                            isAdjusting);
                }
                ((ListSelectionListener)listeners[i+1]).valueChanged(e);
            }
        }
    }

    private void initLayout() {
        this.setLayout(new FlowLayout());
        for (int i = 0; i < 20; i++) {
            SymbolPanel symbolPanel = new SymbolPanel();
            this.add(symbolPanel);
        }
    }

    private void ClearAllSelection() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            this.getComponent(i).setBackground(null);
        }
    }
    private void selectAllSymbolPanels() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            ((SymbolPanel)this.getComponent(i)).setSelect();
        }
    }

    private void setSelectionModel(int selectionModel) {
        this.selectionModel.setSelectionMode(selectionModel);
    }
}

