package network.twisty.lobby.view;

import network.twisty.lobby.adapter.BungeeAdapter;
import network.twisty.lobby.enums.Messages;
import network.twisty.lobby.utils.ItemBuilder;
import network.twisty.lobby.utils.Heads;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;

public class ServerView extends View {
    public ServerView() {
        super(4, "Menu Principal");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }

    @Override
    protected void onRender(ViewContext context) {

        int playerCountTheBridge = BungeeAdapter.getServerCount("thebridge");
        slot(13).onRender(slot -> {
            slot.setItem(
                    new ItemBuilder(
                            Heads.THEBRIDGE
                    ).name(
                            "§bThe Bridge"
                    ).lore(
                            "§7Algumas novidades sobre o",
                            "§7servidor.",
                            "",
                            "§8 ► §fSistema de times;",
                            "§8 ► §fCaixas;",
                            "§8 ► §fentre outros modos;",
                            "",
                            "§aClique para se conectar §7(" + playerCountTheBridge + "§7)"
            ).build());
        }).onClick((handler -> {
            BungeeAdapter.sendServer(context.getPlayer(), "thebridge");

        }));

        slot(31).onRender(slot -> {
            slot.setItem(
                    new ItemBuilder(
                            Heads.DISCORD
                    ).name(
                            "§9Discord"
                    ).lore(
                            "§7Fique por dentro de tudo",
                            "§7através do nosso discord:",
                            "",
                            "§8 ➟ §fdiscord.gg/44world",
                            ""
                    ).build()
            );
        }).onClick((handler -> {
            Messages.SUCCESS.sendMessage(
                    context.getPlayer(),
                    "§8➟ §fdiscord.gg/44world"
            );
            context.getPlayer().closeInventory();
        }));

    }
}
