package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("gmc")
@CommandPermission("matrix.gamemode.creative")
public class GMCCommand extends BaseCommand {

    @Default
    public void onMultiChannelGMCCommand(Player player, @Optional @Flags("other")Player target) {
        if (target == null) {
            player.setGameMode(org.bukkit.GameMode.CREATIVE);
            player.sendMessage("§aYou are now in creative mode.");
            return;
        }
        target.setGameMode(org.bukkit.GameMode.CREATIVE);
        target.sendMessage("§aYou are now in creative mode.");
        player.sendMessage("§aYou have set " + target.getDisplayName() + " to creative mode.");
    }
}
