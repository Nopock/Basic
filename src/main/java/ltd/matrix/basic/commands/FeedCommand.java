package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("feed")
@CommandPermission("basic.feed")
public class FeedCommand extends BaseCommand {
    @Default
    public void onMultiChannelFeedCommand(Player player, @Optional @Flags("other") Player target) {
        if (target == null) {
            player.setFoodLevel(20);
            player.sendMessage("§aYou have been fed.");
        } else {
            target.setFoodLevel(20);
            target.sendMessage("§aYou have been fed.");
            player.sendMessage("§aYou have fed " + target.getDisplayName() + ".");
        }
    }
}
