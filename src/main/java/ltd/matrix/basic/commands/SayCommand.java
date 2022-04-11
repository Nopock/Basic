package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("say")
@CommandPermission("basic.say")
public class SayCommand extends BaseCommand {
    @Default
    public void onMultiChannelSayCommand(Player player, String message) {
        Bukkit.broadcastMessage(CC.translate("&7[&r" + player.getDisplayName() + "&7] &r" + message));
    }

}
