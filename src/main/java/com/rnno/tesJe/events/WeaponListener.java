package com.rnno.tesJe.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class WeaponListener implements Listener {
    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();

            ItemStack weapon = p.getInventory().getItemInMainHand();

            if (weapon.getType() == Material.GOLDEN_SWORD && weapon.hasItemMeta()) {

                if (weapon.getItemMeta().getDisplayName().equals("§e§lThunder Sword")) {

                    e.getEntity().getWorld().strikeLightningEffect(e.getEntity().getLocation());

                    e.setDamage(e.getDamage() + 10.0);
                }
            }
        }
    }
}
