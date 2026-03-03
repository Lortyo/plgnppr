package com.rnno.tesJe.commands;

import com.rnno.tesJe.TesJe;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class BossCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location loc = player.getLocation();

            Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            z.setCustomName("§c§lZombie King");
            z.setCustomNameVisible(true);

            z.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
            z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, -1, 1));

            org.bukkit.plugin.java.JavaPlugin plugin = org.bukkit.plugin.java.JavaPlugin.getPlugin(TesJe.class);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (z.isDead()) {
                        this.cancel();
                        return;
                    }
                    z.launchProjectile(Fireball.class);
                }
            }.runTaskTimer(plugin, 0L, 60L);
        }
        return true;
    }
}
