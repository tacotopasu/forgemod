package net.ramencafe.forwardrooms.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ramencafe.forwardrooms.ForwardRooms;
import net.ramencafe.forwardrooms.item.ModItemGroup;
import net.ramencafe.forwardrooms.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ForwardRooms.MOD_ID);

    public static final RegistryObject<Block> WALLPAPER = registerBlock("wallpaper", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(50)));
    public static final RegistryObject<Block> LIGHT = registerBlock("light", () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
            .setLightLevel(value -> 10)));

    // Never use capital chars in item names!!!
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.FORWARDROOMS_GROUP)));
    }

    public static void register(IEventBus eventBus){
     BLOCKS.register(eventBus);
    }
}
