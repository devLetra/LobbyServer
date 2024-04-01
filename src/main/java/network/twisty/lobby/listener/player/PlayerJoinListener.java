package network.twisty.lobby.listener.player;

import lombok.RequiredArgsConstructor;
import network.twisty.lobby.LobbyPlugin;
import network.twisty.lobby.data.User;
import network.twisty.lobby.utils.*;
import lombok.val;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final LobbyPlugin plugin;

    @EventHandler
    public void onPlayerJoin(
            PlayerJoinEvent event
    ) {

        val player = (Player) event.getPlayer();
        event.setJoinMessage("§8" + LuckPermsUtil.getColoredPrefixFrom(player, false) + player.getName() + "" + "§7 conectou-se neste lobby");

        plugin.getUserCache().getUser().put(player.getName(),
                new User(player.getName(), false)
        );

        player.sendTitle("§8§l4WORLD", "§fSeja bem-vindo(a)");
        player.teleport(LocationUtil.get("lobby"));

        TabListUtil.sendTab(
                player,
                "\n" +
                        "§7§l4WORLD §f " +
                        "\n" +
                        " §eSeja bem vindo, §f "+ player.getName() +
                        "\n",
                        "\n" +
                        " §e Discord: §fdiscord.gg/44world" +
                        "\n\n" +
                        "§7  Adquira suas vantagens acessando nosso site:  " +
                        "\n" +
                        "§f  loja.44world.com" +
                        "\n"
        );

        player.setGameMode(GameMode.ADVENTURE);
        ItemsUtil.giveItems(player);



    }
}
