package racialdiversity.racialdiversity.Events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.potion.PotionEffect;
import racialdiversity.racialdiversity.EffectMapping;
import racialdiversity.racialdiversity.main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class AddingEffect implements Listener {
    main plugin = new main();
    FileConfiguration config = plugin.config;

    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent player, Location from, Location to) {
        Player pl = player.getPlayer();
        Object[] args = config.getConfigurationSection("Racial").getKeys(false).toArray();
        try {
            for (int i = 0; i < args.length; i++) {
                if (plugin.GroupPlayers.getList("players:" + args[i]).contains(pl.getName())) {
                    Object[] effects = config.getConfigurationSection("Racial:" + args[i] + ":effect").getKeys(false).toArray();
                    for (Object v : effects) {
                        pl.addPotionEffect(new PotionEffect(EffectMapping.MapEffect.get(v.toString()).getEffectType(),
                                1000, 10, true));
                    }
                }
            }
        } catch (Exception e) {
            pl.sendMessage("Exception");
        }
    }
}
