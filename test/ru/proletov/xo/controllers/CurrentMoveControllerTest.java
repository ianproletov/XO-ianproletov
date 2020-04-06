package ru.proletov.xo.controllers;

import org.junit.Test;
import ru.proletov.xo.model.Field;
import ru.proletov.xo.model.Figure;
import ru.proletov.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void checkSecondMove() {

        CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < 3; i++) {
            Field field = new Field(3);
            try {
                field.setFigure(new Point(0, i), Figure.X);
                assertEquals(Figure.O, currentMoveController.currentMove(field));
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void checkNotEqualFigures() {

        CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < 3; i++) {
            Field field = new Field(3);
            try {
                field.setFigure(new Point(i,1), Figure.X);
                field.setFigure(new Point(i,2), Figure.O);
                field.setFigure(new Point(i,0), Figure.X);
                assertEquals(Figure.O, currentMoveController.currentMove(field));
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void checkAnotherMove() {

        Field field = new Field(3);
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            field.setFigure(new Point(1,1), Figure.X);
            field.setFigure(new Point(2,2), Figure.O);
            field.setFigure(new Point(1,0), Figure.X);
            field.setFigure(new Point(1,2), Figure.O);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        assertEquals(Figure.X, currentMoveController.currentMove(field));

    }

    @Test
    public void fullFieldCheck() {

        Field field = new Field(3);
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            field.setFigure(new Point(0,0), Figure.X);
            field.setFigure(new Point(0,1), Figure.O);
            field.setFigure(new Point(0,2), Figure.X);
            field.setFigure(new Point(1,0), Figure.O);
            field.setFigure(new Point(1,1), Figure.O);
            field.setFigure(new Point(1,2), Figure.X);
            field.setFigure(new Point(2,0), Figure.X);
            field.setFigure(new Point(2,1), Figure.O);
            field.setFigure(new Point(2,2), Figure.X);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        assertNull(currentMoveController.currentMove(field));

    }
}