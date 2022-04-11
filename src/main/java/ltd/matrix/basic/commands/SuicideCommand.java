package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.entity.Player;

@CommandAlias("suicide")
@CommandPermission("basic.suicide")
public class SuicideCommand extends BaseCommand {

    @Default
    public void onMultiChannelSuicideCommand(Player player) {
        player.setHealth(0);
    }
}
