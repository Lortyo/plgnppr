package com.rnno.tesJe;

import com.rnno.tesJe.commands.HelloCommand;
import com.rnno.tesJe.events.BlockBreakListener;
import com.rnno.tesJe.events.DamageListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TesJe extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Halo! Plugin TesAja berhasil aktif!");
        getCommand("hello").setExecutor(new HelloCommand());
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin TesAja dimatikan. Bye-bye!");    }
}
