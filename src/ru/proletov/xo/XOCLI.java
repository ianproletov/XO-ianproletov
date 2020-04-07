package ru.proletov.xo;

import ru.proletov.xo.model.Field;
import ru.proletov.xo.model.Figure;
import ru.proletov.xo.model.Game;
import ru.proletov.xo.model.Player;
import ru.proletov.xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Ian";
        final String name2 = "Ksyusha-Hryusha";
        final Player player1 = new Player(name1, Figure.X);
        final Player player2 = new Player(name2, Figure.O);

        final Player[] players = {player1, player2};

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}
