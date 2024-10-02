package me.golds.paintBall.listener;

import me.golds.paintBall.manager.GameManager;
import me.golds.paintBall.manager.Paintballgame;
import me.golds.paintBall.queue.PaintBallCommand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballHitListener implements Listener {
    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event){
        if(event.getEntity() instanceof Snowball){
            Snowball snowball = (Snowball) event.getEntity();
            if(snowball.getShooter() instanceof Player){
                Player shooter = (Player) snowball.getShooter();
                if(event.getHitEntity() instanceof Player){
                    Player hitPlayer = (Player) event.getHitEntity();
                    if(hitPlayer != shooter){
                        Paintballgame game = GameManager.getPlayerGame(hitPlayer);
                        if(game != null){
                            game.scorePoint(shooter);
                        }
                    }
                }
            }
        }
    }
}
