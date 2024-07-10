package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String name = switch (position) {
            case 1-> "Пусть бегут неуклюже";
            case  2-> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(name);
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(2);
    }
}
