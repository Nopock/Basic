package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;

@CommandAlias("to|targetoffset")
public class TargetOffSetCommand extends BaseCommand {
    @Default
    public void onMultiChannelTargetOffsetCommand(Player player) {
        player.sendMessage(CC.translate("&8(&4&lFAWE&8) &cUsage: &7/targetoffset &0[&7mask&0]"));
        player.sendMessage(CC.translate("&cDescription: &7Set the targeting mask"));
        player.sendMessage(CC.translate("&cToo few parameters!"));
    }
}
