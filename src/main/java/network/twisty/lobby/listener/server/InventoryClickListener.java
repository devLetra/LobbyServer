package network.twisty.lobby.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void InventoryClickEvent(
            InventoryClickEvent event
    ) {
        event.setCancelled(true);

    }
}
