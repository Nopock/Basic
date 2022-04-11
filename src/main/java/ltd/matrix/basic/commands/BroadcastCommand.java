package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("bc|broadcast|alert")
@CommandPermission("basic.broadcast")
public class BroadcastCommand extends BaseCommand {
    @Default
    public void onMultiChannelBroadcastCommand(Player player, String message) {
        Bukkit.broadcastMessage(CC.translate("&7[&4Alert&7] &r" + message));
    }
}
