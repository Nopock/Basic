package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;

@CommandAlias("rename")
@CommandPermission("basic.rename")
public class RenameCommand extends BaseCommand {
    @Default
    public void onMultiChannelRenameCommand(Player player,String newName) {
        if (player.hasPermission("basic.rename.color")) {
            player.getItemInHand().getItemMeta().setDisplayName(CC.translate(newName));
            return;
        }
        player.getItemInHand().getItemMeta().setDisplayName(newName);
    }
}
