package ru.proletov.xo.view;

import ru.proletov.xo.controllers.CurrentMoveController;
import ru.proletov.xo.controllers.MoveController;
import ru.proletov.xo.controllers.WinnerController;
import ru.proletov.xo.model.Field;
import ru.proletov.xo.model.Figure;
import ru.proletov.xo.model.Game;
import ru.proletov.xo.model.exceptions.AlreadyOccupiedException;
import ru.proletov.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s", game.getName());
        System.out.println();
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is:\n%s", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("Nobody wins!");
            return false;
            }
        System.out.format("Please enter move point for %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is wrong! Try one more time, please.");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(String coordinateName) {
        System.out.format("Please, input coordinate %s: ",  coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Oh, where it is? Please, try once more!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure currentFigure;
            try {
                currentFigure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(currentFigure != null ? currentFigure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}
