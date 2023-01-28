package net.ramencafe.forwardrooms.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ramencafe.forwardrooms.ForwardRooms;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ForwardRooms.MOD_ID);

    public static final RegistryObject<Item> ALMOND_WATER = ITEMS.register("almond_water",
            () -> {
                return new Item(new Item.Properties().group(ModItemGroup.FORWARDROOMS_GROUP).maxStackSize(1)
                        .food(new Food.Builder().effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 1, 3),1f).saturation(1).build()));
            });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
