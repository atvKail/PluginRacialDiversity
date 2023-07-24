package racialdiversity.racialdiversity;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import racialdiversity.racialdiversity.Commands.SetRacial;
import racialdiversity.racialdiversity.Events.AddingEffect;


public final class main extends JavaPlugin {
    public final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        EffectMapping.addingMap();
        config.options().copyDefaults();
        saveDefaultConfig();
        getCommand("racial").setExecutor(new SetRacial());
        getServer().getPluginManager().registerEvents(new AddingEffect(), this);
    }
}
