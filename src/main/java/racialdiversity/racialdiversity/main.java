package racialdiversity.racialdiversity;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class main extends JavaPlugin {
    public  final FileConfiguration GroupPlayers = YamlConfiguration.
            loadConfiguration(new File("plugins/GlobalSystem", "GroupPlayers.yml"));
    public final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        EffectMapping.addingMap();


    }
}
