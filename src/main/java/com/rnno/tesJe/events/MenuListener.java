package com.rnno.tesJe.events;

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
                player.setHealth(20.0);
                player.sendMessage("§aYour Health has been restored");
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                player.closeInventory();
            }
        }
    }
}
