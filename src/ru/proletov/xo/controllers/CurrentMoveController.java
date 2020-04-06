package ru.proletov.xo.controllers;

import ru.proletov.xo.model.Field;
import ru.proletov.xo.model.Figure;
import ru.proletov.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int figuresCounter = 0;
        for (int x = 0; x < field.getSize(); x++) {
            figuresCounter += countRawFigures(field, x);
        }

        if (figuresCounter == field.getSize() * field.getSize())
            return null;

        if (figuresCounter % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countRawFigures(final Field field, int raw) {
        int figuresCounter = 0;
        for (int y = 0; y < field.getSize(); y++ ) {
            Point currentPoint = new Point(raw, y);
            try {
                Figure currentFigure = field.getFigure(currentPoint);
                if (currentFigure != null) {
                    figuresCounter++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return figuresCounter;
    }
}
