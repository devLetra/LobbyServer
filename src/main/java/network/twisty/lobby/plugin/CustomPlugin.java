package network.twisty.lobby.plugin;

import lombok.Getter;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import me.saiintbrisson.minecraft.ViewFrame;
import me.saiintbrisson.minecraft.command.message.MessageHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public abstract class CustomPlugin extends JavaPlugin {

    private final ViewFrame viewFrame = new ViewFrame(this);


    public void registerListener(Listener... listeners) {
        final PluginManager manager = Bukkit.getPluginManager();

        for (Listener listener : listeners) {
            manager.registerEvents(listener, this);
        }
    }

    public void registerCommands(Object... objects) {
        final BukkitFrame frame = new BukkitFrame(this);
        final MessageHolder messageHolder = frame.getMessageHolder();


        frame.registerCommands(objects);
    }


    public void registerViews(View... views) {
        viewFrame.register(views);
    }
}
