package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("raw")
@CommandPermission("basic.raw")
public class RawCommand extends BaseCommand {
    @Default
    public void onMultiChannelRawCommand(Player player, String message) {
        Bukkit.broadcastMessage(CC.translate(message));
    }
}
