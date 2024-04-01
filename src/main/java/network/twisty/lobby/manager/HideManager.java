package network.twisty.lobby.manager;

import network.twisty.lobby.LobbyPlugin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class HideManager {

    private final LobbyPlugin plugin;

    @Getter
    private final List<Player> players = new ArrayList<>();

    public void hide(Player player) {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayers.hasPermission("world.staff")) {
                player.hidePlayer(onlinePlayers);
            }
        }
        players.add(player);
    }

    public void show(Player player) {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            player.showPlayer(onlinePlayers);
        }
        players.remove(player);
    }
}
