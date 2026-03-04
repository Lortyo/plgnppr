package com.rnno.tesJe.events;

import com.rnno.tesJe.TesJe;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (e.getView().getTitle().equalsIgnoreCase("§8Menu")) {
            e.setCancelled(true);

            if (e.getCurrentItem() == null) {
                return;
            }

            Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem().getType() == Material.DIAMOND) {

                org.bukkit.plugin.java.JavaPlugin plugin = org.bukkit.plugin.java.JavaPlugin.getPlugin(TesJe.class);
                String moneyLine = "coin." + player.getUniqueId();
                int moneyNow = plugin.getConfig().getInt(moneyLine, 0);

                if (moneyNow >= 50) {
                    plugin.getConfig().set(moneyLine, moneyNow - 50);
                    plugin.saveConfig();

                    player.setHealth(20.0);
                    player.sendMessage("§aRestore Health! Coins Remaining: §e" + (moneyNow - 50) + " Coins");
                    player.closeInventory();
                }else {
                    player.sendMessage("§cNot Enough Coins! You need 50 Coins. Your Coins : §e" + moneyNow + " Coins");
                    player.closeInventory();
                }
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                player.closeInventory();
            }
        }
    }
}
