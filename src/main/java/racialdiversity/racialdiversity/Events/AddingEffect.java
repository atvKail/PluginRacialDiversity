package racialdiversity.racialdiversity.Events;


import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;
import racialdiversity.racialdiversity.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class AddingEffect implements Listener {
    private final FileConfiguration config = main.getPlugin(main.class).config;
    private final List<String> racial = config.getStringList("players:");

    @EventHandler
    public void OnRespawn(PlayerRespawnEvent player){
        Player pl = player.getPlayer();
        AddEffectPlayer(pl);
    }
    private String CheckPlayerInConfig(Player pl) {
        String p = pl.getName();
        for (String v : racial) {
            if (config.getStringList("players:" + v).contains(p)) {
                return v;
            }
        }
        return null;
    }

    public boolean AddEffectPlayer(Player pl){
        String verdict = CheckPlayerInConfig(pl);
        if(verdict != null){
            List<String> effects = config.getStringList("racial:" + verdict + "effects:");
            for (String nameEffect : effects){
                PotionEffect effect = new PotionEffect(PotionEffectType.getByName(nameEffect), 10000, 7);
                pl.addPotionEffect(effect);
            }
            return true;
        }
        return false;
    }
}
