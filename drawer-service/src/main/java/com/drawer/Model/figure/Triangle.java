package com.drawer.Model.figure;

public class Triangle extends AbstractAngled {

    public Triangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height,
            new int[]{
                posX, posY,
                posX + width/2, posY + height,
                posX + width, posY
            }
        );
    }

}
