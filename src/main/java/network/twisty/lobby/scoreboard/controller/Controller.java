package network.twisty.lobby.scoreboard.controller;

import network.twisty.lobby.adapter.BungeeAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Controller {

    public static int playersCount(Player player) {
        return Bukkit.getOnlinePlayers().size();
    }

    public static int  playerCountTheBridge (Player player) {
        int playerCountTheBridge = BungeeAdapter.getServerCount("thebridge");
        return playerCountTheBridge;
    }
    public static int  playerCountBedWars (Player player) {
        int playerCountBedWars = BungeeAdapter.getServerCount("bedwars");
        return playerCountBedWars;
    }
}
