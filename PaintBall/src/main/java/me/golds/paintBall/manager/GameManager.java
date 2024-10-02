package me.golds.paintBall.manager;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
    private static Map<Player, Paintballgame> playerGames = new HashMap<>();

    public static void addPlayerToGame(Player player, Paintballgame game){
        playerGames.put(player, game);
    }

    public static Paintballgame getPlayerGame(Player player){
        return playerGames.get(player);
    }

    public static void removePlayerFromGame(Player player){
        playerGames.remove(player);
    }
}
