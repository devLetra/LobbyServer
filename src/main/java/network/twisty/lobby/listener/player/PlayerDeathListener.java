package network.twisty.lobby.listener.player;

import lombok.RequiredArgsConstructor;
import network.twisty.lobby.LobbyPlugin;
import network.twisty.lobby.data.User;
import network.twisty.lobby.utils.ItemsUtil;
import network.twisty.lobby.utils.LocationUtil;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

@RequiredArgsConstructor
public class PlayerDeathListener implements Listener {

    private final LobbyPlugin plugin;

    @EventHandler
    public void onPlayerDeath(
            PlayerDeathEvent event
    ) {
        Player player = event.getEntity();
        event.setDeathMessage(null);
        event.getDrops().clear();
        event.setDroppedExp(0);
        player.getInventory().clear();
    }


    @EventHandler
    public void on(PlayerRespawnEvent event) {
        Location lobby = LocationUtil.get("lobby");
        Player player = event.getPlayer();
        final User user = plugin.getUserCache().getByUser(player.getName());

        event.setRespawnLocation(lobby);
        user.setPvp(false);

        ItemsUtil.giveItems(event.getPlayer());
    }
}
