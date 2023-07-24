package racialdiversity.racialdiversity;

import org.bukkit.potion.PotionType;

import java.util.HashMap;

public class EffectMapping {
    public static  HashMap<String, PotionType> MapEffect = new HashMap<>();

    public static void addingMap() {
        for (int i = 0; i < 20; i++) {
            MapEffect.put(PotionType.FIRE_RESISTANCE.name(), PotionType.FIRE_RESISTANCE);
            MapEffect.put(PotionType.INSTANT_DAMAGE.name(), PotionType.INSTANT_DAMAGE);
            MapEffect.put(PotionType.INVISIBILITY.name(), PotionType.INVISIBILITY);
            MapEffect.put(PotionType.INSTANT_HEAL.name(), PotionType.INSTANT_HEAL);
            MapEffect.put(PotionType.JUMP.name(), PotionType.JUMP);
            MapEffect.put(PotionType.SLOW_FALLING.name(), PotionType.SLOW_FALLING);
            MapEffect.put(PotionType.SPEED.name(), PotionType.SPEED);
            MapEffect.put(PotionType.LUCK.name(), PotionType.LUCK);
            MapEffect.put(PotionType.SLOWNESS.name(), PotionType.SLOWNESS);
            MapEffect.put(PotionType.STRENGTH.name(), PotionType.STRENGTH);
            MapEffect.put(PotionType.NIGHT_VISION.name(), PotionType.NIGHT_VISION);
            MapEffect.put(PotionType.POISON.name(), PotionType.POISON);
            MapEffect.put(PotionType.TURTLE_MASTER.name(), PotionType.TURTLE_MASTER);
            MapEffect.put(PotionType.WEAKNESS.name(), PotionType.WEAKNESS);
            MapEffect.put(PotionType.WATER_BREATHING.name(), PotionType.WATER_BREATHING);
            MapEffect.put(PotionType.REGEN.name(), PotionType.REGEN);
        }
    }

}
