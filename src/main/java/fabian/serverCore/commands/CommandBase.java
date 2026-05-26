package fabian.serverCore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public abstract class CommandBase implements CommandExecutor {

    protected String commandName;

    public CommandBase(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return execute(sender, args);
    }

    public abstract boolean execute(CommandSender sender, String[] args);
}