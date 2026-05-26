package fabian.serverCore.automessages;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoMessageManager {

    private final JavaPlugin plugin;
    private int taskId = -1;

    public AutoMessageManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void startAutoMessages() {
        // TODO: Implement auto messages with configurable interval
        // TODO: Add sound notification when message is sent
    }

    public void stopAutoMessages() {
        if (taskId != -1) {
            Bukkit.getScheduler().cancelTask(taskId);
            taskId = -1;
        }
    }

    public void sendAutoMessage(String message) {
        // TODO: Broadcast auto message to all players
        // TODO: Play sound effect (piknięcie)
    }
}