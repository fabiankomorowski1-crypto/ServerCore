package fabian.serverCore.socialspy;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SocialSpyManager {

    private final Set<UUID> socialSpyEnabled = new HashSet<>();

    public void toggleSocialSpy(UUID playerUUID) {
        if (socialSpyEnabled.contains(playerUUID)) {
            socialSpyEnabled.remove(playerUUID);
        } else {
            socialSpyEnabled.add(playerUUID);
        }
    }

    public boolean isSocialSpyEnabled(UUID playerUUID) {
        return socialSpyEnabled.contains(playerUUID);
    }

    public void setSocialSpyEnabled(UUID playerUUID, boolean enabled) {
        if (enabled) {
            socialSpyEnabled.add(playerUUID);
        } else {
            socialSpyEnabled.remove(playerUUID);
        }
    }

    public void resetSocialSpy(UUID playerUUID) {
        socialSpyEnabled.remove(playerUUID);
    }
}