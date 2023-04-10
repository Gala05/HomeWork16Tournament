package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<Player, Player> players = new HashMap<>();
    //private ArrayList<Player> players;


    public HashMap<Player, Player> getPlayers() {
        return players;
    }

    public Game(HashMap<Player, Player> players) {
        this.players = players;
    }

    public HashMap<Player, Player> findAll() {
        HashMap<Player, Player> all = getPlayers();
        return all;
    }

    public void register(Player player) {
        players.put(player, player);
    }

    public Player findByName(String playerName) {
        for (Player player : players.keySet()) {
            if (player.getPlayerName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(
                "Element with name: " + playerName + " not found"
        );
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        player1 = findByName(playerName1);
        player2 = findByName(playerName2);
        if (player1.getStrength() < player2.getStrength()) {
            return -1;
        } else {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}