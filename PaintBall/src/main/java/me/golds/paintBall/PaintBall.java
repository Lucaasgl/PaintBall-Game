package me.golds.paintBall;

import me.golds.paintBall.listener.PaintBallListener;
import me.golds.paintBall.listener.SnowballHitListener;
import me.golds.paintBall.queue.PaintBallCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaintBall extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("paintball").setExecutor(new PaintBallCommand(this));
        getServer().getPluginManager().registerEvents(new PaintBallListener(), this);
        getServer().getPluginManager().registerEvents(new SnowballHitListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
