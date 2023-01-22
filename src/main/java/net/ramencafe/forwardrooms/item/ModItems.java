package net.ramencafe.forwardrooms.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ramencafe.forwardrooms.ForwardRooms;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ForwardRooms.MOD_ID);

    public static final RegistryObject<Item> MOLD = ITEMS.register("mold", () -> new Item(new Item.Properties().group(ModItemGroup.FORWARDROOMS_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
