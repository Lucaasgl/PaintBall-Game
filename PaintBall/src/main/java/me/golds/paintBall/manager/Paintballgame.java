package me.golds.paintBall.manager;

import me.golds.paintBall.queue.PaintBallCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Paintballgame {
    private Player player1;
    private Player player2;
    private int score1 = 0;
    private int score2 = 0;
    private Scoreboard scoreboard;
    private Objective objective;

    public Paintballgame(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        this.scoreboard = manager.getNewScoreboard();
        this.objective = scoreboard.registerNewObjective("Paintball", "hehe", "Paintball");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

    }


    public void scorePoint(Player player){
        if(player.equals(player1)){
            score1++;
        } else if (player.equals(player2)) {
            score2++;
        }

        updateScoreBoard();

        resetPlayer();

        if(score1 >= 5 || score2 >=5){
            endGame();
        }
    }

    private void resetPlayer(){
        player1.teleport(new Location(player1.getWorld(), -14, 101, 0));
        player2.teleport(new Location(player1.getWorld(), 15, 101, 0));
    }

    private void updateScoreBoard(){
        objective.getScore(player1.getName()).setScore(score1);
        objective.getScore(player2.getName()).setScore(score2);

    }

    private void endGame(){
        String winner = (score1 >= 5) ? player1.getName() : player2.getName();
        Bukkit.broadcastMessage("kkk o "+winner+" ganho");

        GameManager.removePlayerFromGame(player1);
        GameManager.removePlayerFromGame(player2);
    }
}
