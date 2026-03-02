package com.rnno.tesJe.events;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WandListener implements Listener {

    @EventHandler
    public void onWandUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().isRightClick()) {
            ItemStack item = event.getItem();

            if (item != null && item.getType() == Material.STICK) {
                if (item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§6Fire Wand")) {

                    if (player.hasCooldown(Material.STICK)) {
                        event.setCancelled(true);
                        return;
                    }

                    player.launchProjectile(Fireball.class);
                    player.setCooldown(Material.STICK, 60);
                    event.setCancelled(true);
                }
            }
        }
    }
}
