package com.drawer.Model.figure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractAngled extends AbstractFigure {

    private int[] angles;

    public AbstractAngled(int posX, int posY, int width, int height, int[] angles) {
        super(posX, posY, width, height);
        this.angles = angles;
    }

}
