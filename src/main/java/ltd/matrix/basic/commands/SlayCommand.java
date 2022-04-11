package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ltd.matrix.basic.utils.CC;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("slay|kill")
@CommandPermission("basic.slay")
public class SlayCommand extends BaseCommand {

    @Default
    public void onMultiChannelSlayCommand(Player player, @Optional @Flags("other")Player target) {
        if (target == null) {
            player.sendMessage(CC.translate("&aYou have slain yourself."));
            player.setHealth(0);
        } else {
            player.sendMessage(CC.translate("&aYou have slain &e" + target.getDisplayName()));
            target.setHealth(0);
        }
    }
}
