package ru.netology.service;

public class NotRegisterException extends RuntimeException {
    public NotRegisterException(String name) {
        super("Игрок с именем " + name + " не найден");
    }

}