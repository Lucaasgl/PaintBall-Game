package me.golds.paintBall.queue;

import me.golds.paintBall.PaintBall;
import me.golds.paintBall.listener.PaintBallListener;
import me.golds.paintBall.listener.SnowballHitListener;
import me.golds.paintBall.manager.GameManager;
import me.golds.paintBall.manager.Paintballgame;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintBallCommand implements CommandExecutor {
    private List<Player> queue = new ArrayList<>();

    public PaintBallCommand(PaintBall plugin){

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if(queue.contains(player)){
            player.sendMessage("Você ja ta na fila bobão");
            return true;
        }

        queue.add(player);
        updateActionBar();

        if(queue.size() == 2){
            Paintballgame game = new Paintballgame(queue.get(0), queue.get(1));
            GameManager.addPlayerToGame(queue.get(0), game);
            GameManager.addPlayerToGame(queue.get(1), game);
            queue.clear();
        }

        return true;
    }

    private void updateActionBar(){
        for (Player p : queue){
            p.sendActionBar( queue.size() +"/2");
        }
    }

}

