package fabian.serverCore.privatemessages;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PrivateMessageData {

    private static final long MESSAGE_TIMEOUT = 5 * 60 * 1000; // 5 minutes in milliseconds
    private final Map<UUID, MessageInfo> lastMessageFrom = new HashMap<>();

    public static class MessageInfo {
        public UUID senderUUID;
        public String senderName;
        public long timestamp;

        public MessageInfo(UUID senderUUID, String senderName) {
            this.senderUUID = senderUUID;
            this.senderName = senderName;
            this.timestamp = System.currentTimeMillis();
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - timestamp > MESSAGE_TIMEOUT;
        }
    }

    public void setLastMessageFrom(UUID recipientUUID, UUID senderUUID, String senderName) {
        lastMessageFrom.put(recipientUUID, new MessageInfo(senderUUID, senderName));
    }

    public MessageInfo getLastMessageFrom(UUID recipientUUID) {
        MessageInfo info = lastMessageFrom.get(recipientUUID);
        if (info != null && info.isExpired()) {
            lastMessageFrom.remove(recipientUUID);
            return null;
        }
        return info;
    }

    public void clearLastMessageFrom(UUID recipientUUID) {
        lastMessageFrom.remove(recipientUUID);
    }
}