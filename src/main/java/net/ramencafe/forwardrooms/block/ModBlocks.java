package net.ramencafe.forwardrooms.block;

import net.minecraft.block.AbstractBannerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
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

    public static final RegistryObject<Block> WALLPAPER_1 = registerBlock("wallpaper_1", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(50)));

    // Never use capital chars in item names!!!
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }
//Credits to Ricgrimes
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.FORWARDROOMS_GROUP)));
    }

    public static void register(IEventBus eventBus){
     BLOCKS.register(eventBus);
    } // Isto da loop infinito, ve se escreveste igual ao do gajo, e btw o nome de blocos pode ter
      // letras maiusculas, estava Mold_block em vez de mold_block ou items n
}
