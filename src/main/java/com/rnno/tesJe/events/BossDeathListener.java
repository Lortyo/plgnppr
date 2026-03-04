package com.rnno.tesJe.events;

import com.rnno.tesJe.TesJe;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BossDeathListener implements Listener {
    @EventHandler
    public void onBossDeath(EntityDeathEvent event) {

        if (event.getEntity().getKiller() != null) {
            Player killer = event.getEntity().getKiller();

            JavaPlugin plugin = JavaPlugin.getPlugin(TesJe.class);
            String moneyLine = "coin." + killer.getUniqueId();
            int moneyNow = plugin.getConfig().getInt(moneyLine, 0);

            if (event.getEntity().getType() == EntityType.ZOMBIE && event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("§c§lZombie King")) {
                event.getDrops().clear();
                ItemStack rareSword = new ItemStack(Material.GOLDEN_SWORD);
                ItemMeta meta = rareSword.getItemMeta();
                if (meta != null) {
                    meta.setDisplayName("§b§lKing Sword");
                    rareSword.setItemMeta(meta);
                }
                event.getDrops().add(rareSword);

                Firework fw = (Firework) event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.FIREWORK_ROCKET);
                FireworkMeta fwMeta = fw.getFireworkMeta();
                fwMeta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BALL_LARGE).build());
                fwMeta.setPower(1);
                fw.setFireworkMeta(fwMeta);

                plugin.getConfig().set(moneyLine, moneyNow + 500);
                plugin.saveConfig();
                killer.sendMessage("§aYou get +500 coins for defeating Zombie King!");
            }
            else if (event.getEntity().getType() == EntityType.ZOMBIE ||
                    event.getEntity().getType() == EntityType.SKELETON ||
                    event.getEntity().getType() == EntityType.CREEPER ||
                    event.getEntity().getType() == EntityType.SPIDER) {

                // >>> BERIKAN UANG MONSTER BIASA <<<
                plugin.getConfig().set(moneyLine, moneyNow + 10);
                plugin.saveConfig();
                killer.sendMessage("§a+10 Coins§a.");
            }
        }
    }
}
