package com.shpp.p2p.cs.ssafronyuk.assignment8;

import acm.graphics.GDimension;
import acm.graphics.GRect;

import java.awt.*;

public class GSquare extends GRect {
    private final double maxSize;
    private double minSize;
    private double size;
    private boolean isResize;
    private boolean flag;

    public GSquare(double x, double y, double size) {
        super(x, y, size, size);
        this.size = size;
        this.maxSize = size;
        this.minSize = 1;
        this.isResize = true;
        this.flag = true;
    }

    public void setColor(Color color){
        super.setFilled(true);
        super.setColor(color);
        super.setFillColor(color);
    }

    public void setMinSize(double minSize) {
        this.minSize = minSize;
    }

    public boolean isResize() {
        return isResize;
    }

    public void setResize(boolean resize) {
        isResize = resize;
    }

    public void setSize (double size) {
        if (isResize) {
            this.setSize(size, size);
        }
    }

    public double getMaxSize() {
        return maxSize;
    }

    public void resize(Color color, double var) {
        if (getColor() == color) {
            if (flag) {
                size--;
                if (size <= minSize) flag = false;
            }
            else {
                size++;
                if (size >= maxSize) flag = true;
            }
            setSize(size);
        }
    }
}
