package com.iwaliner.urushi.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class GlowingSaplingBlock extends SaplingBlock {
    public GlowingSaplingBlock(AbstractTreeGrower p_55978_, Properties p_55979_) {
        super(p_55978_, p_55979_);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX() + 0.1D*rand.nextInt(10);
        double d1 = (double)pos.getY() + 0.1D*rand.nextInt(10);
        double d2 = (double)pos.getZ() + 0.1D*rand.nextInt(10);
        world.addParticle(ParticleTypes.FIREWORK, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

}