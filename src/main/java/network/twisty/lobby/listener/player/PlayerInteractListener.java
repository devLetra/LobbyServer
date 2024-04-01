package network.twisty.lobby.listener.player;

import lombok.RequiredArgsConstructor;
import network.twisty.lobby.LobbyPlugin;
import network.twisty.lobby.view.CosmeticView;
import network.twisty.lobby.view.ProfileView;
import network.twisty.lobby.view.ServerView;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class PlayerInteractListener implements Listener {

    private final LobbyPlugin plugin;


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final ItemStack item = event.getItem();

        if (item == null || item.getType() == Material.AIR) return;
        if (!item.hasItemMeta()) return;

        if (item.getItemMeta().getDisplayName().equals("§aEsconder jogadores")) {
            event.setCancelled(true);

            player.getInventory().setItem(8,
                    new ItemBuilder(Material.getMaterial(351))
                            .name("§7Mostrar jogadores")
                            .durability((short) 1)
                            .build());

            plugin.getHideManager().hide(player);
            player.sendMessage("§aYAY! Agora você não irá mais ver os jogadores onlines.");
            return;
        }

        if (item.getItemMeta().getDisplayName().equals("§7Mostrar jogadores")) {
            event.setCancelled(true);

            player.getInventory().setItem(8,
                    new ItemBuilder(Material.getMaterial(351))
                            .name("§aEsconder jogadores")
                            .durability((short) 10)
                            .build());

            plugin.getHideManager().show(player);
            player.sendMessage("§aYAY! Agora você pode visualizar os jogadores onlines.");
            return;
        }

        if (item.getType() == Material.BOOK) {
            event.setCancelled(true);
            plugin.getViewFrame().open(ServerView.class, player);
            return;
        }

        if (item.getType() == Material.BOW) {
            player.chat("/pvp");
            event.setCancelled(true);
            return;
        }
        if (item.getType() == Material.SKULL_ITEM) {
            plugin.getViewFrame().open(ProfileView.class, player);
            event.setCancelled(true);
        }

        if (item.getType() == Material.BLAZE_POWDER) {
            plugin.getViewFrame().open(CosmeticView.class, player);
            event.setCancelled(true);
        }
    }
}
