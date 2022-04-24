package com.drawer.Model.figure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends AbstractAngled {

    public Rectangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height,
            new int[]{
                posX, posY,
                posX + width, posY,
                posX + width, posY + height,
                posX, posY + height
            }
        );
    }
}
