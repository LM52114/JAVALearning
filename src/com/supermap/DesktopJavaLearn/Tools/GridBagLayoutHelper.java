package com.supermap.DesktopJavaLearn.Tools;

import java.awt.*;

public class GridBagLayoutHelper extends GridBagConstraints {
    /**
     * default gap between controls
     */
    public static final int CONTROLS_GAP = 5;

    /**
     * default gap between frame border and control
     */
    public static final int FRAME_CONTROL_GAP = 10;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 指定组件起始网格的构造函数
     *
     * @param gridx 水平方向上的起始网格
     * @param gridy 竖直方向上的起始网格
     */
    public GridBagLayoutHelper(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     * 指定组件起始网格与跨度的构造函数
     *
     * @param gridx      水平方向起始网格
     * @param gridy      竖直方向起始网格
     * @param gridwidth  水平方向占据的网格数目
     * @param gridheight 竖直方向占据的网格数目
     */
    public GridBagLayoutHelper(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    public static GridBagLayoutHelper getSwitchConstraints() {
        return new GridBagLayoutHelper(0, 0).setWeight(1, 1).setFill(GridBagConstraints.BOTH).setInsets(10);
    }

    public GridBagLayoutHelper setSize(int gridWidth, int gridHeight) {
        this.gridwidth = gridWidth;
        this.gridheight = gridHeight;
        return this;
    }

    /**
     * 设置组件在网格中的摆放方式
     *
     * @param anchor 组件的摆放方式
     * @return 当前操作对象
     */
    public GridBagLayoutHelper setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * 设置组件在网格中的拉伸方式(针对控件)
     *
     * @param fill 组件的拉伸方式
     * @return 当前操作对象
     */
    public GridBagLayoutHelper setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * 设置网格的拉伸程度（针对网格）
     *
     * @param weightx 水平方向的拉伸程度
     * @param weighty 竖直方向的拉伸程度
     * @return 当前操作对象
     */
    public GridBagLayoutHelper setWeight(double weightx, double weighty) {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     * 统一设置组件与网格四周的间隔
     *
     * @param distance 四周的间隔长度
     * @return 当前操作对象
     */
    public GridBagLayoutHelper setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * 分别设置组件与网格四周的间隔
     *
     * @param top    组件上方与网格的距离
     * @param left   组件左方与网格的距离
     * @param bottom 组件下方与网格的距离
     * @param right  组件右方与网格的距离
     * @return 当前操作对象
     */
    public GridBagLayoutHelper setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * 设置组件拉伸长度
     *
     * @param ipadx 水平方向拉伸的长度
     * @param ipady 竖直方向拉伸的长度
     * @return 当前操作对象
     */
    public GridBagLayoutHelper setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
