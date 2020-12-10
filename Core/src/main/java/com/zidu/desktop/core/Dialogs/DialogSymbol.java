package com.zidu.desktop.core.Dialogs;

import com.zidu.desktop.core.Controls.Dialog.HDialog;
import com.zidu.desktop.core.Controls.Panel.SymbolContainer;
import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DialogSymbol extends HDialog {
    private SymbolContainer symbolPanel;

    public DialogSymbol() {
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setSize(new Dimension(600, 400));
        final JScrollPane scrollPane = new JScrollPane();
//        symbolPanel.setPreferredSize(null);


        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int len = (symbolPanel.getComponent(0).getWidth() + ((FlowLayout) symbolPanel.getLayout()).getHgap());
                int w = symbolPanel.getComponent(0).getHeight() + ((FlowLayout) symbolPanel.getLayout()).getVgap();
                int width = scrollPane.getWidth() - scrollPane.getVerticalScrollBar().getWidth();
                int number = width / len;
                int row = 100 / number + 1;
                int height = w * (row + 1);

                Dimension dimension = new Dimension(width, height);
                symbolPanel.setPreferredSize(dimension);     // 不设置此属性，ui会自动计算并设置
                repaint();
            }
        });
//        scrollPane.setViewportView(symbolPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        final JPanel panel = new JPanel();
        JButton button = new JButton("test");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                scrollPane.setViewportView(symbolPanel);

                int len = ((int) symbolPanel.getComponent(0).getPreferredSize().getWidth() + ((FlowLayout) symbolPanel.getLayout()).getHgap());
                int w = (int) symbolPanel.getComponent(0).getPreferredSize().getHeight() + ((FlowLayout) symbolPanel.getLayout()).getVgap();
                int width = scrollPane.getParent().getWidth() - scrollPane.getVerticalScrollBar().getWidth();
                int number = width / len;
                int row = 100 / number + 1;
                int height = w * (row + 1);

                Dimension dimension = new Dimension(width, height);


                symbolPanel.setPreferredSize(dimension);
                scrollPane.updateUI();
//                DialogSymbol.this.getContentPane().removeAll();
//                DialogSymbol.this.getContentPane().add(scrollPane,new GridBagLayoutHelper(0,0,1,1).setWeight(1,1).setFill(GridBagConstraints.BOTH));
//                DialogSymbol.this.getContentPane().add(panel,new GridBagLayoutHelper(1,0,1,1).setWeight(1,0).setFill(GridBagConstraints.BOTH));
//                DialogSymbol.this.getContentPane().repaint();
            }
        });
        panel.add(button);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.add(scrollPane, new GridBagLayoutHelper(0, 0, 1, 1).setWeight(1, 1).setFill(GridBagConstraints.BOTH));
//        this.getContentPane().add(new SymbolContainer(),new GridBagLayoutHelper(1,0,1,1).setWeight(1,0).setFill(GridBagConstraints.BOTH));
        panel1.add(panel, new GridBagLayoutHelper(0, 1, 1, 1).setWeight(1, 0).setFill(GridBagConstraints.BOTH));


        JPanel panel2 = new JPanel();
        panel2.add(new JButton("hahhsd"));

        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel1, new GridBagLayoutHelper(0, 0, 1, 1).setWeight(1, 1).setFill(GridBagConstraints.BOTH));
        this.getContentPane().add(panel2, new GridBagLayoutHelper(1, 0, 1, 1).setWeight(0, 1).setFill(GridBagConstraints.BOTH));

    }


    private void initParameter() {
        symbolPanel = new SymbolContainer();
    }


    public interface IStar {
        //明星都会签名
        public void sign();
    }
}
