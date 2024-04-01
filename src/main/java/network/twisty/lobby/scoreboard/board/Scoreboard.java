package network.twisty.lobby.scoreboard.board;

import network.twisty.lobby.LobbyPlugin;
import network.twisty.lobby.scoreboard.controller.Controller;
import network.twisty.lobby.utils.LuckPermsUtil;
import com.google.common.collect.Lists;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

@RequiredArgsConstructor
public class Scoreboard {

    private final LobbyPlugin plugin;

    public static String getFormattedDate(){
        return new SimpleDateFormat("dd/MM/yyyy")
                .format(GregorianCalendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo")).getTime());
    }

    public void showScoreboard() {
        Assemble assemble = new Assemble(plugin, new AssembleAdapter() {
            @Override
            public String getTitle(Player player) {
                return "§7§l4WORLD";
            }
            @Override
            public List<String> getLines(Player player) { 
                return Lists.newArrayList(
                        "§7" + getFormattedDate() + " §8L #1",
                        "",
                        " §fOnline: §7" + Controller.playersCount(player),
                        " §fCargo: " + LuckPermsUtil.getColoredPrefixFrom(player, false),
                        "",
                        "&7    44world.com     "
                );
            }
        });
    }
}
