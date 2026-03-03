package com.rnno.tesJe.events;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class BossDeathListener implements Listener {
    @EventHandler
    public void onBossDeath(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.ZOMBIE) {
            if (event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("§c§lZombie King")) {

                event.getDrops().clear();

                ItemStack rareSword = new ItemStack(Material.GOLDEN_SWORD);
                ItemMeta meta = rareSword.getItemMeta();
                if (meta != null) {
                    meta.setDisplayName("§b§lKing Sword");
                    rareSword.setItemMeta(meta);
                }

                event.getDrops().add(rareSword);

                Firework fw =  (Firework) event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.FIREWORK_ROCKET);
                FireworkMeta fwMeta = fw.getFireworkMeta();

                fwMeta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BALL_LARGE).build());
                fwMeta.setPower(1);
                fw.setFireworkMeta(fwMeta);

                event.getEntity().getServer().broadcastMessage("§e§lZombie King Has Been Defeated!");
            }
        }
    }
}
