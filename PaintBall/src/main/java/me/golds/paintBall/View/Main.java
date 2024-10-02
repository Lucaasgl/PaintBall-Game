package me.golds.paintBall.View;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import me.golds.paintBall.ItemBuilder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class Main implements Listener {

@EventHandler
    public void mainViewPaintBall(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();

        ChestGui gui = new ChestGui(5,"paintball");

        StaticPane pane = new StaticPane(0, 0, 9, 6);

        ItemBuilder playerSkull = new ItemBuilder(Material.PLAYER_HEAD);

        playerSkull.skullOwner(player.getName());
        playerSkull.name("Informações de: "+player.getName());
        playerSkull.lore(
                "Total de Partidas:",
                "Vitórias:",
                "Derrotas:");

        GuiItem playerinfo = new GuiItem(playerSkull.build());

        pane.addItem(playerinfo, 1,1);
        gui.addPane(pane);
        gui.show(player);
    }

}
