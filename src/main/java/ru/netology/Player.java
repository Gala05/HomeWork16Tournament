package ru.netology;

public class Player {
    private int id;
    private String playerName;
    private int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.playerName = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStrength() {
        return strength;
    }
}