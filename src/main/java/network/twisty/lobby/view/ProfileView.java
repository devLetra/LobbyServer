package network.twisty.lobby.view;

import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import network.twisty.lobby.utils.ItemBuilder;
import network.twisty.lobby.utils.LuckPermsUtil;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileView extends View {


    public ProfileView() {
        super(3, "Meu perfil");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }

    @Override
    protected void onRender(ViewContext context) {
        final Player player = context.getPlayer();

        long firstPlayed = player.getFirstPlayed();
        Date firstDate = new Date(firstPlayed);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedFirstDate = dateFormat.format(firstDate);

        long lastPlayed = player.getLastPlayed();
        Date date = new Date(lastPlayed);
        DateFormat dateLastFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateLastFormat.format(date);


        slot(11).onRender(slot -> {
            slot.setItem(new ItemBuilder(Material.SKULL_ITEM).skullOwner(player.getName())
                    .name(
                            "§aInformações pessoais"
                    )
                    .lore(
                            "§fGrupo: " + LuckPermsUtil.getColoredPrefixFrom(player, false),
                            "",
                            "§fCadastrado em: §7" + formattedFirstDate,
                            "§fÚltimo login: §7" + formattedDate
                    )
                    .build());
        });
        }
    }

