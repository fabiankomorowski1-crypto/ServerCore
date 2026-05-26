package fabian.serverCore.utils;

public class ColorUtil {

    /**
     * Translate color codes in text
     * Supports: & format and HEX colors
     */
    public static String translateColors(String text) {
        // TODO: Implement color translation
        return text;
    }

    public static String stripColors(String text) {
        return text.replaceAll("§[0-9a-f]", "").replaceAll("&[0-9a-fk-or]", "");
    }
}