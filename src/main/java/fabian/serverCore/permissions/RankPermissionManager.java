package fabian.serverCore.permissions;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class RankPermissionManager {

    private Permission permission;

    public RankPermissionManager() {
        setupPermission();
    }

    private void setupPermission() {
        RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServicesManager().getRegistration(Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
    }

    public boolean hasRank(Player player, String rank) {
        if (permission == null) return false;
        return permission.playerHas(player, "rank." + rank.toLowerCase());
    }

    public String getPlayerRank(Player player) {
        // TODO: Implement getting player rank from Vault
        return "default";
    }

    public void setPlayerRank(Player player, String rank) {
        // TODO: Implement setting player rank via Vault
    }
}