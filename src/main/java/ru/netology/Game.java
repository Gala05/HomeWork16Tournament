package ru.netology;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> findAll() {
        ArrayList<Player> all = getPlayers();
        return all;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : getPlayers()) {
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
//        for (Player player : players) {
//            if (player.getPlayerName().equals(playerName1)) {
//                player1 = player;
//            }
//            if (player.getPlayerName().equals(playerName2)) {
//                player2 = player;
//            }
//        }
//        if (player1 == null) {
//            throw new NotRegisteredException(
//                    "Element with name: " + playerName1 + " not found"
//            );
//        }
//        if (player2 == null) {
//            throw new NotRegisteredException(
//                    "Element with name: " + playerName1 + " not found"
//            );
//        }
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