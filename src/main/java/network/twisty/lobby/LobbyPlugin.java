package network.twisty.lobby;

import network.twisty.lobby.commands.*;
import network.twisty.lobby.adapter.BungeeAdapter;
import network.twisty.lobby.data.cache.UserCache;
import network.twisty.lobby.listener.player.*;
import network.twisty.lobby.listener.server.AsyncPlayerChatListener;
import network.twisty.lobby.listener.server.FoodLevelListener;
import network.twisty.lobby.listener.server.InventoryClickListener;
import network.twisty.lobby.listener.server.WeatherChangeListener;
import network.twisty.lobby.manager.HideManager;
import network.twisty.lobby.plugin.CustomPlugin;
import network.twisty.lobby.scoreboard.board.Scoreboard;
import lombok.Getter;
import network.twisty.lobby.view.CosmeticView;
import network.twisty.lobby.view.ProfileView;
import network.twisty.lobby.view.ServerView;
import org.bukkit.Bukkit;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;

@Getter
public final class LobbyPlugin extends CustomPlugin {

    private HideManager hideManager;
    private UserCache userCache;
    private Scoreboard scoreboard;

    @Override
    public void onLoad() {
        hideManager = new HideManager(this);
        scoreboard = new Scoreboard(this);
        userCache = new UserCache();
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadRegistry();

        final Messenger messenger = getServer().getMessenger();
        messenger.registerIncomingPluginChannel(this, "BungeeCord", new BungeeAdapter());
        messenger.registerOutgoingPluginChannel(this, "BungeeCord");

        final BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskTimer(this, new BungeeAdapter(), 20L, 20L);
    }


    public void loadRegistry() {
        scoreboard.showScoreboard();

        registerCommands(
                new GameModeCommand(),
                new PvPCommand(this),
                new SetLobbyCommand(),
                new TpCommand(),
                new TpHereCommand()
        );

        registerViews(
                new ProfileView(),
                new ServerView(),
                new CosmeticView()
        );

        registerListener(
                new BlockListener(),
                new PlayerDeathListener(this),
                new PlayerDropItemListener(),
                new PlayerInteractListener(this),
                new PlayerJoinListener(this),
                new PlayerQuitListener(),
                new PlayerRespawnListener(),
                new PlayerVoidListener(),
                new AsyncPlayerChatListener(),
                new FoodLevelListener(),
                new InventoryClickListener(),
                new WeatherChangeListener(),
                new PvPListener(this)
        );
    }

    public static LobbyPlugin getInstance() {
        return getPlugin(LobbyPlugin.class);
    }
}
