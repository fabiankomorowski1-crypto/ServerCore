package fabian.serverCore.config;

import org.bukkit.entity.Player;

public class MessageManager {

    private final ConfigManager configManager;

    public MessageManager(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public void sendMessage(Player player, String messageKey) {
        String message = configManager.getMessages().getString(messageKey, "");
        if (!message.isEmpty()) {
            player.sendMessage(formatMessage(message));
        }
    }

    public void sendMessage(Player player, String messageKey, String... replacements) {
        String message = configManager.getMessages().getString(messageKey, "");
        if (!message.isEmpty()) {
            player.sendMessage(formatMessage(message, replacements));
        }
    }

    public String getMessage(String messageKey, String... replacements) {
        String message = configManager.getMessages().getString(messageKey, "");
        return formatMessage(message, replacements);
    }

    public String formatMessage(String message, String... replacements) {
        // TODO: Implement color and replacement logic
        return message;
    }
}