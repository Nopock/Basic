package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("heal")
@CommandPermission("basic.heal")
public class HealCommand extends BaseCommand {
    @Default
    public void onMultiChannelHealCommand(Player player, @Optional @Flags("other")Player target) {
        if (target == null) {
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage("§aYou have been healed!");
        } else {
            target.setHealth(20);
            target.setFoodLevel(20);
            target.sendMessage("§aYou have been healed!");
            player.sendMessage("§aYou have healed " + target.getDisplayName() + "!");
        }
    }
}
