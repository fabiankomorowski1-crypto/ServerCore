package fabian.serverCore.commands;

import fabian.serverCore.config.ConfigManager;
import fabian.serverCore.config.MessageManager;
import fabian.serverCore.privatemessages.PrivateMessageData;
import fabian.serverCore.socialspy.SocialSpyManager;
import fabian.serverCore.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand extends CommandBase {

    private final MessageManager messageManager;
    private final PrivateMessageData privateMessageData;
    private final SocialSpyManager socialSpyManager;

    public MsgCommand(MessageManager messageManager, PrivateMessageData privateMessageData, SocialSpyManager socialSpyManager) {
        super("msg");
        this.messageManager = messageManager;
        this.privateMessageData = privateMessageData;
        this.socialSpyManager = socialSpyManager;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        // Check usage
        if (args.length < 2) {
            String usage = messageManager.getMessage("msg.usage");
            player.sendMessage(ColorUtil.translateColors(usage));
            return false;
        }

        // Get target player
        String targetName = args[0];
        Player targetPlayer = Bukkit.getPlayer(targetName);

        if (targetPlayer == null) {
            String message = messageManager.getMessage("msg.player_not_found", "{player}", targetName);
            player.sendMessage(ColorUtil.translateColors(message));
            return false;
        }

        // Build message
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            messageBuilder.append(args[i]);
            if (i < args.length - 1) {
                messageBuilder.append(" ");
            }
        }
        String fullMessage = messageBuilder.toString();

        // Send message to target
        String receivedMsg = messageManager.getMessage("msg.received", 
            "{player}", player.getName(), 
            "{message}", fullMessage);
        targetPlayer.sendMessage(ColorUtil.translateColors(receivedMsg));

        // Send confirmation to sender
        String sentMsg = messageManager.getMessage("msg.sent",
            "{player}", targetPlayer.getName(),
            "{message}", fullMessage);
        player.sendMessage(ColorUtil.translateColors(sentMsg));

        // Update last message data
        privateMessageData.setLastMessageFrom(targetPlayer.getUniqueId(), player.getUniqueId(), player.getName());

        // Broadcast to SocialSpy users
        String socialSpyMessage = "&8[&eSocialSpy&8] &e" + player.getName() + " &f-> &e" + targetPlayer.getName() + "&f: " + fullMessage;
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (socialSpyManager.isSocialSpyEnabled(onlinePlayer.getUniqueId()) && 
                !onlinePlayer.getUniqueId().equals(player.getUniqueId()) && 
                !onlinePlayer.getUniqueId().equals(targetPlayer.getUniqueId())) {
                onlinePlayer.sendMessage(ColorUtil.translateColors(socialSpyMessage));
            }
        }

        return true;
    }
}