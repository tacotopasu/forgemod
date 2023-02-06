package net.ramencafe.forwardrooms.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.ramencafe.forwardrooms.util.ModSoundEvents;

import java.util.Random;

public class FirestoneBlock extends Block {
    public FirestoneBlock(Properties properties) {
        super(properties);
    }
    int count = 0;
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        while (count != 160) {
            count++;
        }
        if (count == 160) {
            //Play sound here
            count = 0;
            System.out.println(" TICK IS WORKING YES");
            System.out.println("It worked somehow!");
            worldIn.playSound(null, pos, ModSoundEvents.BUZZING.get()
                    , SoundCategory.BLOCKS, 1, 1);
        }

            if (worldIn.isPlayerWithin(pos.getX(), pos.getY(), pos.getZ(), 7)) {
                System.out.println("It worked somehow!");
                worldIn.playSound(null, pos, ModSoundEvents.BUZZING.get()
                        , SoundCategory.BLOCKS, 1, 1);
            }
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        float chance = 0.35f;
        if(chance < rand.nextFloat()) {
            worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0d,0.05d,0d);

            worldIn.addParticle(new BlockParticleData(ParticleTypes.BLOCK, stateIn), pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0.0D, 0.05D, 0.0D);
        }

        super.animateTick(stateIn, worldIn, pos, rand);
    }
}
