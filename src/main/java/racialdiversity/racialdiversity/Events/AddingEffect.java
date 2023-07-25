package racialdiversity.racialdiversity.Events;


import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import racialdiversity.racialdiversity.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class AddingEffect implements Listener {
    private final Plugin plugin = main.getPlugin(main.class);
    private final FileConfiguration config = plugin.getConfig();
    private final List<String> race = config.getStringList("info");

    @EventHandler
    public void OnRespawn(PlayerRespawnEvent player){
        Player pl = player.getPlayer();
        AddEffectPlayer(pl);
    }
    private String CheckPlayerInConfig(Player pl) {
        String p = pl.getName();
        for (String v : race) {
            if (config.getStringList("players." + v).contains(p)) {
                return v;
            }
        }
        return null;
    }

    public boolean AddEffectPlayer(Player pl){
        String verdict = CheckPlayerInConfig(pl);
        if(verdict != null){
            List<String> effects = config.getStringList("race." + verdict + ".effects");
            for (String nameEffect : effects){
                if (PotionEffectType.getByName(nameEffect) == null){
                    pl.sendMessage(ChatColor.RED + "add effect - ERROR, Racial plugin");
                    return false;
                }
                PotionEffect effect = new PotionEffect(
                        PotionEffectType.getByName(nameEffect), 10000000, 1, false, false);
                pl.addPotionEffect(effect);
            }
            return true;
        }
        return false;
    }
}
