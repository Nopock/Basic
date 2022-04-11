package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Flags;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;

@CommandAlias("tp")
@CommandPermission("basic.tp")
public class TPCommand extends BaseCommand {

    @Default
    public void onMultiChannelTPCommand(Player player, @Flags("other")Player target) {
        player.teleport(target);
        player.sendMessage(CC.translate("&aTeleporting to " + target.getDisplayName() + "&a..."));
    }

}
