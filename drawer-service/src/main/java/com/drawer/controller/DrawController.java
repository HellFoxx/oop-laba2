package com.drawer.controller;

import com.drawer.Model.figure.*;
import com.drawer.dto.FigureDataDto;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class DrawController {

    @PostMapping("/get/figure")
    public ResponseEntity getFigure(@RequestBody @NonNull FigureDataDto data) {
        AbstractFigure figure;
        switch (data.getFigureType()) {
            case SQARE -> figure = new Square(data.getPosX(), data.getPosY(), data.getWidth());
            case RECTANGLE -> figure = new Rectangle(data.getPosX(), data.getPosY(), data.getWidth(), data.getHeight());
            case CIRCLE -> figure = new Circle(data.getPosX(), data.getPosY(), data.getWidth() / 2);
            case ELLIPSE -> figure = new Ellipse(data.getPosX(), data.getPosY(), data.getWidth() / 2, data.getHeight() / 2);
            case TRIANGLE -> figure = new Triangle(data.getPosX(), data.getPosY(), data.getWidth(), data.getHeight());
            default -> figure = null;
        }
        return ResponseEntity.ok().body(figure);
    }

}
