package fabian.serverCore;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerCore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ServerCore v26.1.2 has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ServerCore v26.1.2 has been disabled!");
    }
}