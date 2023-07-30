package racialdiversity.racialdiversity;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import racialdiversity.racialdiversity.Commands.CommandKit;
import racialdiversity.racialdiversity.Events.AddingEffect;

public final class main extends JavaPlugin {
    public final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        getCommand("race").setExecutor(new CommandKit());
        getServer().getPluginManager().registerEvents(new AddingEffect(), this);
        config.options().copyDefaults(true);
        saveDefaultConfig();
        this.reloadConfig();
    }

    @Override
    public  void onDisable(){
        this.reloadConfig();
        this.saveConfig();
    }
}
