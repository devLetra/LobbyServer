package network.twisty.lobby.commands;

import network.twisty.lobby.enums.Messages;
import network.twisty.lobby.utils.LocationUtil;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLobbyCommand {

    @Command(
            name = "setlobby",
            aliases = {"setspawn"},
            permission = "world.setlobby"
    )

    public void handleSetLobby(
            Context<CommandSender> context
    ) {

        val player = (Player) context.getSender();

        Location lobby = player.getLocation();
        LocationUtil.set(lobby, "lobby");

        Messages.SUCCESS.sendMessage(
                player,
                "§aÁrea inicial do servidor setada com sucesso."
        );

    }
}
