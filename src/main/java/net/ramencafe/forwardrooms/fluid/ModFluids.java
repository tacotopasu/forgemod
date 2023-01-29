package net.ramencafe.forwardrooms.fluid;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ramencafe.forwardrooms.ForwardRooms;
import net.ramencafe.forwardrooms.block.ModBlocks;
import net.ramencafe.forwardrooms.item.ModItems;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ForwardRooms.MOD_ID);


    public static final RegistryObject<FlowingFluid> ALMOND_FLUID = FLUIDS.register("almond_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.ALMOND_PROPERTIES));
    public static final RegistryObject<FlowingFluid> ALMOND_FLOWING = FLUIDS.register("almond_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ALMOND_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ALMOND_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ALMOND_FLUID.get(), () -> ALMOND_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL).color(0xffe6dbc4).overlay(WATER_OVERLAY_RL))
            .slopeFindDistance(4).levelDecreasePerBlock(1).block(() -> ModFluids.ALMOND_BLOCK.get()).bucket(() -> ModItems.ALMOND_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> ALMOND_BLOCK = ModBlocks.BLOCKS.register("almond", () ->
            new FlowingFluidBlock(() -> ModFluids.ALMOND_FLUID.get(), AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}



