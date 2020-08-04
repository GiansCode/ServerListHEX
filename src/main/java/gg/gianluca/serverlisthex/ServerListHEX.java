package gg.gianluca.serverlisthex;

import com.haroldstudios.hexitextlib.HexResolver;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerListHEX extends JavaPlugin implements Listener {

    private String motd;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        motd = getConfig().getString("motd", "<#34ebe5>Example MOTD");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        motd = "";
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMotd(HexResolver.parseHexString(motd));
    }
}