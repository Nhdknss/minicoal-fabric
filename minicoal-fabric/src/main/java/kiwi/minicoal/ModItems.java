package kiwi.minicoal;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModItems {

    private static final int MINI_COAL_BURN_TIME = 200;

    public static final Item MINI_COAL = register("mini_coal", Item::new, new Item.Settings());
    public static final Item MINI_CHARCOAL = register("mini_charcoal", Item::new, new Item.Settings());

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {

        Identifier id = Identifier.of("minicoal", name);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        settings.registryKey(key);

        return Registry.register(Registries.ITEM, key, factory.apply(settings));
    }

    public static void initialize() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(MINI_COAL, MINI_COAL_BURN_TIME);
            builder.add(MINI_CHARCOAL, MINI_COAL_BURN_TIME);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MINI_COAL);
            entries.add(MINI_CHARCOAL);
        });
    }
}