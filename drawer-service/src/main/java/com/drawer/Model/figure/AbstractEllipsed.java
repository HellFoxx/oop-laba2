package com.drawer.Model.figure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEllipsed extends AbstractFigure {

    private int radiusX, radiusY;

    public AbstractEllipsed(int posX, int posY, int radiusX, int radiusY) {
        super(posX, posY, radiusX * 2, radiusY * 2);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }
}
