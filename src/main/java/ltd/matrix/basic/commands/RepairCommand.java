package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

@CommandAlias("repair")
public class RepairCommand extends BaseCommand {
    @Default
    public void onMultiChannelRepairCommand(Player player) {
        player.sendMessage(CC.translate("&6You're held item has been repaired."));
        player.getItemInHand().setDurability((short) 0);
    }
}
