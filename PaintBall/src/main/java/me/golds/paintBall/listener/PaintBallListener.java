package me.golds.paintBall.listener;

import me.golds.paintBall.PaintBall;
import me.golds.paintBall.manager.Paintballgame;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PaintBallListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(event.getAction().toString().contains("RIGHT_CLICK") && player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL){

            Snowball snowball = player.getWorld().spawn(player.getEyeLocation(), Snowball.class);
            snowball.setVelocity(player.getLocation().getDirection().multiply(1.5));
            snowball.setShooter(player);
        }
    }
}
