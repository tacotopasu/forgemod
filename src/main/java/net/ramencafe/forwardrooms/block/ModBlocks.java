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
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, ForwardRooms.MOD_ID);

    private static <T extends Blocks>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        
    }

    public static void register(IEventBus eventBus){
        ModBlocks.register(eventBus);

    }
}
