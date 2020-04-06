package ru.proletov.xo.controllers;

import org.junit.Test;
import ru.proletov.xo.model.Field;
import ru.proletov.xo.model.Figure;
import ru.proletov.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getHorizontalWinner() {
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            try {
                field.setFigure(new Point(0, i), inputWinner);
                field.setFigure(new Point(1, i), inputWinner);
                field.setFigure(new Point(2, i), inputWinner);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

            final Figure actualWinner = winnerController.getWinner(field);

            assertEquals(inputWinner, actualWinner);
        }
    }

    @Test
    public void getNotHorizontalWinner() {
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            try {
                field.setFigure(new Point(0, i), inputWinner);
                field.setFigure(new Point(1, i), Figure.O);
                field.setFigure(new Point(2, i), inputWinner);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

            final Figure actualWinner = winnerController.getWinner(field);

            assertNull(actualWinner);
        }
    }

    @Test
    public void getVerticalWinner() {
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            try {
                field.setFigure(new Point(i, 0), inputWinner);
                field.setFigure(new Point(i, 1), inputWinner);
                field.setFigure(new Point(i, 2), inputWinner);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

            final Figure actualWinner = winnerController.getWinner(field);

            assertEquals(inputWinner, actualWinner);
        }
    }

    @Test
    public void getNotVerticalWinner() {
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            try {
                field.setFigure(new Point(i, 0), inputWinner);
                field.setFigure(new Point(i, 1), inputWinner);
                field.setFigure(new Point(i, 2), Figure.O);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

            final Figure actualWinner = winnerController.getWinner(field);

            assertNull(actualWinner);
        }
    }

    @Test
    public void getDiagonal1Winner() {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;


        try {
            field.setFigure(new Point(0, 0), inputWinner);
            field.setFigure(new Point(1, 1), inputWinner);
            field.setFigure(new Point(2, 2), inputWinner);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        final Figure actualWinner = winnerController.getWinner(field);

        assertEquals(inputWinner, actualWinner);
    }

    @Test
    public void getDiagonal1NotWinner() {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;


        try {
            field.setFigure(new Point(0, 0), inputWinner);
            field.setFigure(new Point(1, 1), inputWinner);
            field.setFigure(new Point(2, 2), null);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        final Figure actualWinner = winnerController.getWinner(field);

        assertNull(actualWinner);
    }

    @Test
    public void getDiagonal2Winner() {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;


        try {
            field.setFigure(new Point(2, 0), inputWinner);
            field.setFigure(new Point(1, 1), inputWinner);
            field.setFigure(new Point(0, 2), inputWinner);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        final Figure actualWinner = winnerController.getWinner(field);

        assertEquals(inputWinner, actualWinner);
    }

    @Test
    public void getDiagonal2NotWinner() {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        final Figure inputWinner = Figure.X;


        try {
            field.setFigure(new Point(2, 0), inputWinner);
            field.setFigure(new Point(1, 1), null);
            field.setFigure(new Point(0, 2), inputWinner);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        final Figure actualWinner = winnerController.getWinner(field);

        assertNull(actualWinner);
    }
}