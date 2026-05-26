package fabian.serverCore.formatting;

import net.md_5.bungee.api.ChatColor;

public class HexColorSupport {

    /**
     * Convert HEX color format (&x&...) to ChatColor
     * Example: &x&F&F&0&0&0&0 for red color
     */
    public static String convertHexColors(String message) {
        // TODO: Implement HEX color conversion
        return message;
    }

    public static String toHexColor(String hexColor) {
        // TODO: Convert hex string (e.g., "FF0000") to ChatColor
        return ChatColor.of("#" + hexColor).toString();
    }
}