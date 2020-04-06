package ru.proletov.xo.controllers;

import ru.proletov.xo.model.Field;
import ru.proletov.xo.model.Figure;
import ru.proletov.xo.model.exceptions.AlreadyOccupiedException;
import ru.proletov.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                      AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
