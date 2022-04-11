package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.entity.Player;

@CommandAlias("more")
@CommandPermission("matrix.more")
public class MoreCommand extends BaseCommand {
    @Default
    public void onMultiChannelMoreCommand(Player player) {
        player.getItemInHand().setAmount(64);
        player.sendMessage("§aYou have set the amount of items in your hand to §664§a.");
    }
}
