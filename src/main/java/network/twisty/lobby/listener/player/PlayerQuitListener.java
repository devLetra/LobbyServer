package network.twisty.lobby.listener.player;

import lombok.val;
import network.twisty.lobby.utils.ItemsUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(
            PlayerQuitEvent event
    ) {

        val player = (Player) event.getPlayer();
        event.setQuitMessage(null);
        player.getInventory().clear();
        ItemsUtil.giveItems(player);

    }
}
