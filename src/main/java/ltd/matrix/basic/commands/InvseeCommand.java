package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Flags;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;

@CommandAlias("invsee")
@CommandPermission("basic.invsee")
public class InvseeCommand extends BaseCommand {

    @Default
    public void onMultiChannelInvseeCommand(Player player, @Flags("other") Player target) {
        player.openInventory(target.getInventory());
        player.sendMessage(CC.translate("&eOpening inventory of &r" + target.getDisplayName()));
    }
}
