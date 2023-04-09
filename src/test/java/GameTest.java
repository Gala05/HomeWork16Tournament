import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import java.util.ArrayList;

public class GameTest {
    @Test
    public void getTest() {
        Player player1 = new Player(1, "Name1", 1000);

        Assertions.assertEquals(1, player1.getId());
        Assertions.assertEquals("Name1", player1.getPlayerName());
        Assertions.assertEquals(1000, player1.getStrength());
    }

    @Test
    public void findAllTest() {
        ArrayList<Player> player = new ArrayList<>();
        Game game = new Game(player);
        Player player1 = new Player(1, "Name1", 1000);
        Player player2 = new Player(2, "Name2", 920);
        Player player3 = new Player(3, "Name3", 810);
        Player player4 = new Player(4, "Name4", 780);
        Player player5 = new Player(5, "Name5", 650);
        Player player6 = new Player(6, "Name6", 562);
        Player player7 = new Player(7, "Name7", 458);
        Player player8 = new Player(8, "Name8", 356);
        Player player9 = new Player(9, "Name9", 245);
        Player player10 = new Player(10, "Name10", 100);
        player.add(player1);
        player.add(player2);
        player.add(player3);
        player.add(player4);
        player.add(player5);
        player.add(player6);
        player.add(player7);
        player.add(player8);
        player.add(player9);
        player.add(player10);
        ArrayList<Player> expected = player;
        ArrayList<Player> actual = game.findAll();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdMinTest() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 1000);
        Player player2 = new Player(2, "Name2", 920);
        Player player3 = new Player(3, "Name3", 810);
        Player player4 = new Player(4, "Name4", 780);
        Player player5 = new Player(5, "Name5", 650);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Player expected = player1;
        Player actual = game.findByName("Name1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdMaxTest() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 1000);
        Player player2 = new Player(2, "Name2", 920);
        Player player3 = new Player(3, "Name3", 810);
        Player player4 = new Player(4, "Name4", 780);
        Player player5 = new Player(5, "Name5", 650);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Player expected = player5;
        Player actual = game.findByName("Name5");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdNotExistTest() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 1000);
        Player player2 = new Player(2, "Name2", 920);
        Player player3 = new Player(3, "Name3", 810);
        Player player4 = new Player(4, "Name4", 780);
        Player player5 = new Player(5, "Name5", 650);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findByName("Ytf");
        });
    }

    @Test
    public void roundWhenExistFirstWinTest() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 1000);
        Player player2 = new Player(2, "Name2", 920);

        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Name1", "Name2");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenExistSecondWinTest() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 10);
        Player player2 = new Player(2, "Name2", 920);

        game.register(player1);
        game.register(player2);
        int expected = -1;
        int actual = game.round("Name1", "Name2");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenExistStrengthEqualsTest() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 920);
        Player player2 = new Player(2, "Name2", 920);

        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Name1", "Name2");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenNotExistPlayer1Test() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 820);
        Player player2 = new Player(2, "Name2", 920);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Name3", "Name2");
        });
    }

    @Test
    public void roundWhenNotExistPlayer2Test() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        Player player1 = new Player(1, "Name1", 820);
        Player player2 = new Player(2, "Name2", 920);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Name1", "Name3");
        });
    }
}