package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test

    public void testShouldSecondWin() {
        Player piter = new Player(7, "Piter", 200);
        Player vasiliy = new Player(5, "Vasiliy", 190);
        Game game = new Game();

        game.register(piter);
        game.register(vasiliy);
        int actual = game.round("Vasiliy", "Piter");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testShouldFirstWin() {
        Player piter = new Player(7, "Piter", 200);
        Player vasiliy = new Player(5, "Vasiliy", 210);
        Game game = new Game();

        game.register(piter);
        game.register(vasiliy);
        int actual = game.round("Vasiliy", "Piter");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testShouldNobodyWin() {
        Player piter = new Player(7, "Piter", 210);
        Player vasiliy = new Player(5, "Vasiliy", 210);
        Game game = new Game();

        game.register(piter);
        game.register(vasiliy);
        int actual = game.round("Vasiliy", "Piter");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testWhenFirstNotExist() {
        Player piter = new Player(7, "Piter", 210);
        Game game = new Game();

        game.register(piter);
        Assertions.assertThrows(NotRegisterException.class,
                () -> game.round("Ivan", "Piter")
        );
    }

    @Test

    public void testWhenSecondNotExist() {
        Player piter = new Player(7, "Piter", 210);
        Game game = new Game();

        game.register(piter);
        Assertions.assertThrows(NotRegisterException.class,
                () -> game.round("Piter", "Ivan")
        );
    }

}