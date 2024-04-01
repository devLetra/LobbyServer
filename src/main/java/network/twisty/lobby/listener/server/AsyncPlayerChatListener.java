package network.twisty.lobby.listener.server;

import network.twisty.lobby.enums.Messages;
import network.twisty.lobby.utils.CooldownUtil;
import network.twisty.lobby.utils.LuckPermsUtil;
import lombok.val;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.concurrent.TimeUnit;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onAsyncPlayerChat(
            AsyncPlayerChatEvent event
    ) {

        val player = event.getPlayer();

        if (CooldownUtil.getInstance().isInCooldown("chat")) {
            event.setCancelled(true);
            Messages.ERROR.sendMessage(
                    player,
                    "§cAguarde alguns segundos para falar novamente!"
            );
        }

        if (player.hasPermission("world.chat")) {
            event.setFormat(
                    "\n" +
                            "§f" + LuckPermsUtil.getColoredPrefixFrom(player, false) +
                            "" +
                            player.getName() +
                            "§8 ➟ §f" + event.getMessage().replace("&", "§") +
                            " \n§f"

            );
        } else {
            if (player.hasPermission("world.vip")) {
                event.setFormat(
                        "\n" +
                                "§f" + LuckPermsUtil.getColoredPrefixFrom(player, false) +
                                "" +
                                player.getName() +
                                "§8 ➟ §f" + event.getMessage().replace("&", "§")
                );
            }
            if (!player.hasPermission("world.staff")) {
                CooldownUtil.getInstance().createCooldown(
                        player, "chat", 4, TimeUnit.SECONDS
                );
            }
        }
    }
}
