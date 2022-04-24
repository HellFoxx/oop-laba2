package com.drawer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class FigureDataDto {

    private FigureType figureType;
    private int width, height, posX, posY;

}
