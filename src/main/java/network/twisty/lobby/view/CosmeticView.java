package network.twisty.lobby.view;

import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import network.twisty.lobby.utils.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CosmeticView extends View {

    public CosmeticView() {
        super(3, "Colecionáveis");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }

    @Override
    protected void onRender(ViewContext context) {
        Player player = context.getPlayer();

        slot(10).onRender(slot -> {
            slot.setItem(new ItemBuilder(Material.BLAZE_POWDER)
                    .name(
                            "§6Partículas"
                    )
                    .lore("§7Escolha uma partícula para utilizar em nossos lobbies.")
                    .build());
        });
        slot(12).onRender(slot -> {
            slot.setItem(new ItemBuilder(Material.LEATHER_CHESTPLATE).armor(Color.ORANGE)
                    .name(
                            "§6Skin e aparência"
                    )
                    .lore("§7Administre e escolha sua aparência.")
                    .build());
        });
        slot(13).onRender(slot -> {
            slot.setItem(new ItemBuilder(Material.BOOK)
                    .name(
                            "§6Mensagens de lobby"
                    )
                    .lore(
                            "§7Escolha uma mensagem que será exibida ao entrar",
                            "§7em um de nossos lobbies."
                    )
                    .build());
        });
    }

}
