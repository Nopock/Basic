package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Flags;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;

@CommandAlias("tphere")
@CommandPermission("basic.tp")
public class TPHereCommand extends BaseCommand {

    @Default
    public void onMultiChannelTPHereCommand(Player player, @Flags("other")Player target) {
        target.teleport(player);
        player.sendMessage(CC.translate("&aTeleporting " + target.getDisplayName() + " &ato you..."));
    }
}
