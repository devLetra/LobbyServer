package network.twisty.lobby.utils;

import network.twisty.lobby.LobbyPlugin;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ItemsUtil {

    public static void giveItems(
            Player player
    ) {
        if (LobbyPlugin.getInstance().getHideManager().getPlayers().contains(player)) {
            player.getInventory().setItem(
                    8,
                    new ItemBuilder(
                            Material.getMaterial(351)
                    ).name(
                            "§7Mostrar jogadores"
                    ).durability((short) 1).build()
            );
        } else {
            player.getInventory().setItem(
                    8,
                    new ItemBuilder(
                            Material.getMaterial(351)
                    ).name(
                            "§aEsconder jogadores"
                    ).durability((short) 10).build()
            );

        }
        player.getInventory().setItem(
                3,
                new ItemBuilder(Material.BOOK)
                        .name("§aServidores")
                        .lore("§7Selecione um modo de jogo para se divertir")
                        .build()
        );


        player.getInventory().setItem(
                0,
                new ItemBuilder(Material.BOW)
                        .name("§cCombate")
                        .lore("§7Se divirta tirando em um belo pvp.")
                        .build()
        );

        player.getInventory().setItem(
                5,
                new ItemBuilder(Material.SKULL_ITEM)
                        .skull(player.getName())
                        .name("§ePerfil")
                        .lore("§7Clique para ver o seu perfil")
                        .build()
        );

        player.getInventory().setItem(
                4,
                new ItemBuilder(Material.BLAZE_POWDER)
                        .name("§6Colecionáveis")
                        .lore("§7Clique para visualizar alguns cosméticos")
                        .build()
        );

        player.getInventory().setChestplate(
                new network.twisty.lobby.utils.ItemBuilder(Material.LEATHER_CHESTPLATE)
                        .armor(Color.GRAY)
                        .name("§7Moletom World")
                        .lore("§8É lindo né?!")
                        .build()
        );

        player.getInventory().setBoots(
                new network.twisty.lobby.utils.ItemBuilder(Material.LEATHER_BOOTS)
                        .armor(Color.AQUA)
                        .name("§bAir Jordan")
                        .lore("§7Wow, como você está estiloso!")
                        .build()
        );

    }

}
