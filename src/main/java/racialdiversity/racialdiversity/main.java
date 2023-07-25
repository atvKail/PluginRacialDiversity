package racialdiversity.racialdiversity;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import racialdiversity.racialdiversity.Commands.SetAndInfoRace;
import racialdiversity.racialdiversity.Events.AddingEffect;

public final class main extends JavaPlugin {
    public final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        getCommand("race").setExecutor(new SetAndInfoRace());
        getServer().getPluginManager().registerEvents(new AddingEffect(), this);
        config.options().copyDefaults(true);
        saveDefaultConfig();
    }
}
