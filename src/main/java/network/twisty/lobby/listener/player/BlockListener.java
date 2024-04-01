package network.twisty.lobby.listener.player;

import net.minecraft.server.v1_8_R3.EntityItemFrame;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(!player.hasPermission("world.staff.high")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(!player.hasPermission("world.staff.high")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof ItemFrame || entity instanceof EntityItemFrame) {
            if(event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                if(!player.hasPermission("world.staff.high")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK ||
                event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if(block == null) return;
            if(block.getType() == Material.AIR) return;

            if(block.getType() == Material.TRAP_DOOR) {
                if(!player.hasPermission("world.staff.high")) {
                    event.setCancelled(true);
                }
            } else if(block.getType().toString().contains("FRAME")) {
                if(!player.hasPermission("world.staff.high")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
