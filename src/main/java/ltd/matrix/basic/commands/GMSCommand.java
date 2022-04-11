package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("gms")
@CommandPermission("matrix.gamemode.survival")
public class GMSCommand extends BaseCommand {
    @Default
    public void onMultiChannelGMSCommand(Player player, @Optional @Flags("other")Player target) {
        if (target == null) {
            player.setGameMode(org.bukkit.GameMode.SURVIVAL);
            player.sendMessage("§aYour gamemode has been set to survival.");
        } else {
            target.setGameMode(org.bukkit.GameMode.SURVIVAL);
            target.sendMessage("§aYour gamemode has been set to survival.");
            player.sendMessage("§aYou have set " + target.getDisplayName() + "'s gamemode to survival.");
        }
    }
}

