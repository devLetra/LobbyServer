package network.twisty.lobby.commands;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import network.twisty.lobby.LobbyPlugin;
import network.twisty.lobby.data.User;
import network.twisty.lobby.utils.ItemsUtil;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class PvPCommand {

    private final LobbyPlugin plugin;

    @Command(
            name = "pvp"
    )

    public void execute(Context<CommandSender> context) {
        final Player player = (Player) context.getSender();
        final User user = plugin.getUserCache().getByUser(player.getName());

        if (!user.isPvp()) {
            player.sendTitle("§a§lBATALHA", "§fVocê entrou no modo de combate");
            player.getInventory().clear();

            player.getInventory().setItem(0, new ItemStack(Material.WOOD_SWORD));
            player.getInventory().setItem(1, new ItemStack(Material.GOLDEN_APPLE));
            player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
            player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
            player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
            player.setGameMode(GameMode.SURVIVAL);
            player.setHealthScale(20);

            user.setPvp(true);
            return;
        }

        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        ItemsUtil.giveItems(player);

        user.setPvp(false);
    }
}
