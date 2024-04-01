package network.twisty.lobby.listener.player;

import lombok.RequiredArgsConstructor;
import network.twisty.lobby.LobbyPlugin;
import network.twisty.lobby.data.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@RequiredArgsConstructor
public class PvPListener implements Listener {

    private final LobbyPlugin plugin;


    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player player = (Player) event.getEntity();
            Player enemy = (Player) event.getDamager();

            final User user = plugin.getUserCache().getByUser(player.getName());
            final User uTarget = plugin.getUserCache().getByUser(enemy.getName());

            if (user.isPvp() && uTarget.isPvp()) {
            } else {
                enemy.sendMessage("§cOPS! Um de vocês dois, ou os dois não estão em modo de batalha.");
                event.setCancelled(true);
            }
        }
    }
}