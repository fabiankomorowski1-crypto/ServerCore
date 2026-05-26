package fabian.serverCore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    // TODO: Implement chat formatting logic here
    // - Message formatting based on rank (from Vault)
    // - Emotes handling
    // - Color support (including HEX colors with &x&...)
    // - And other chat formatting features

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        // Placeholder for chat formatting
    }
}