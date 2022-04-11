package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("fly")
@CommandPermission("basic.fly")
public class FlyCommand extends BaseCommand {
    @Default
    public void onMultiChannelFlyCommand(Player player, @Optional @Flags("other")Player target) {
        if (target == null) {
            player.setAllowFlight(!player.getAllowFlight());
            player.sendMessage("§aFly mode is now " + (player.getAllowFlight() ? "§aenabled" : "§cdisabled"));
        } else {
            target.setAllowFlight(!target.getAllowFlight());
            target.sendMessage("§aFly mode is now " + (target.getAllowFlight() ? "§aenabled" : "§cdisabled"));
        }
    }
}
