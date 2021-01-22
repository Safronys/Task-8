package com.shpp.p2p.cs.ssafronyuk.assignment8;



import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;


public class Assignment8 extends WindowProgram {
    private final static int SIZE_SQUARE = 100;
    private final static int MIN_SIZE_SQUARE = 50;
    private final static double STEP = 1;

    public void run() {
        addSquares();
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent e) {
        GSquare obj = (GSquare) getElementAt(e.getX(), e.getY());
        if (obj == null) return;
        obj.setResize(!obj.isResize());

    }

    public void mouseMoved(MouseEvent e) {
        GSquare obj = (GSquare) getElementAt(e.getX() - SIZE_SQUARE, e.getY());
        GSquare obj1 = (GSquare) getElementAt(e.getX() + SIZE_SQUARE, e.getY());
        GSquare obj2 = (GSquare) getElementAt(e.getX() , e.getY() + SIZE_SQUARE);
        GSquare obj3 = (GSquare) getElementAt(e.getX() , e.getY() - SIZE_SQUARE);
        if (obj != null) {
            obj.resize(Color.BLACK, STEP);
        }
        if (obj1 != null) {
            obj1.resize(Color.BLACK, STEP);
        }
        if (obj2 != null) {
            obj2.resize(Color.BLACK, STEP);
        }
        if (obj3 != null) {
            obj3.resize(Color.BLACK, STEP);
        }


    }

    private void addSquares() {
        int quantityOfX = getWidth() / SIZE_SQUARE;
        int quantityOfY = getHeight() / SIZE_SQUARE;
        double indentX = (getWidth() - quantityOfX * SIZE_SQUARE) / 2.0;
        double indentY = (getHeight() - quantityOfY * SIZE_SQUARE) / 2.0;
        boolean isBlackColor = true;
        for (int i = 0; i < quantityOfY; i++) {
            for (int j = 0; j < quantityOfX; j++) {
                Color color = isBlackColor ? Color.BLACK : Color.WHITE;
                double x = j * SIZE_SQUARE + indentX;
                double y = i * SIZE_SQUARE + indentY;
                GSquare square = new GSquare(x, y, SIZE_SQUARE );
                square.setColor(color);
                square.setMinSize(MIN_SIZE_SQUARE);
                add(square);
                isBlackColor = !isBlackColor;
            }
        }
    }

}
