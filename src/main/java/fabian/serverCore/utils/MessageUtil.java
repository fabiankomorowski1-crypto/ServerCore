package fabian.serverCore.utils;

import org.bukkit.entity.Player;

public class MessageUtil {

    public static void send(Player player, String message) {
        player.sendMessage(ColorUtil.translateColors(message));
    }

    public static void send(Player player, String message, String... placeholders) {
        String formatted = message;
        for (int i = 0; i < placeholders.length; i += 2) {
            if (i + 1 < placeholders.length) {
                formatted = formatted.replace(placeholders[i], placeholders[i + 1]);
            }
        }
        send(player, formatted);
    }

    public static void broadcast(String message) {
        for (Player player : org.bukkit.Bukkit.getOnlinePlayers()) {
            send(player, message);
        }
    }
}