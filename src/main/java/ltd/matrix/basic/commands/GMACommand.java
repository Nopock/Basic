package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;

@CommandAlias("gma")
@CommandPermission("matrix.gamemode.adventure")
public class GMACommand extends BaseCommand {
    @Default
    public void onMultiChannelGMACommand(Player player, @Optional @Flags("other") Player target) {
        if (target == null) {
            player.setGameMode(org.bukkit.GameMode.ADVENTURE);
            player.sendMessage(CC.translate("&aYour gamemode has been set to &6ADVENTURE&a."));
            return;
        }
        target.setGameMode(org.bukkit.GameMode.ADVENTURE);
        target.sendMessage(CC.translate("&aYour gamemode has been set to &6ADVENTURE&a."));
        player.sendMessage(CC.translate("&aYou have set &6" + target.getDisplayName() + "&a's gamemode to &6ADVENTURE&a."));
    }
}
