package kiwi.minicoal;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static final int MINI_COAL_BURN_TIME = 200;

    public static final Item MINI_COAL = register("mini_coal",
            new Item(new Item.Settings().maxCount(64)));

    public static final Item MINI_CHARCOAL = register("mini_charcoal",
            new Item(new Item.Settings().maxCount(64)));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of("minicoal", name), item);
    }

    public static void initialize() {

        FuelRegistry.INSTANCE.add(MINI_COAL, MINI_COAL_BURN_TIME);
        FuelRegistry.INSTANCE.add(MINI_CHARCOAL, MINI_COAL_BURN_TIME);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MINI_COAL);
            entries.add(MINI_CHARCOAL);
        });
    }
}
