package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SimpleWallBlock extends CrossCollisionBlock {

    public SimpleWallBlock(Properties properties) {
        super(4.0F, 4.0F, 16.0F, 16.0F, 16.0F, properties);

    }
    public VoxelShape getVisualShape(BlockState p_53311_, BlockGetter p_53312_, BlockPos p_53313_, CollisionContext p_53314_) {
        return this.getShape(p_53311_, p_53312_, p_53313_, p_53314_);
    }

    public boolean isPathfindable(BlockState p_53306_, BlockGetter p_53307_, BlockPos p_53308_, PathComputationType p_53309_) {
        return false;
    }

    public boolean connectsTo(BlockState p_53330_, boolean p_53331_, Direction p_53332_) {
        Block block = p_53330_.getBlock();
        boolean flag = block instanceof SimpleWallBlock;
        return !isExceptionForConnection(p_53330_) && p_53331_ || flag|| block instanceof IronBarsBlock;
    }


    public BlockState getStateForPlacement(BlockPlaceContext p_53304_) {
        BlockGetter blockgetter = p_53304_.getLevel();
        BlockPos blockpos = p_53304_.getClickedPos();
        FluidState fluidstate = p_53304_.getLevel().getFluidState(p_53304_.getClickedPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos3);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos4);
        return super.getStateForPlacement(p_53304_).setValue(NORTH, Boolean.valueOf(this.connectsTo(blockstate, blockstate.isFaceSturdy(blockgetter, blockpos1, Direction.SOUTH), Direction.SOUTH))).setValue(EAST, Boolean.valueOf(this.connectsTo(blockstate1, blockstate1.isFaceSturdy(blockgetter, blockpos2, Direction.WEST), Direction.WEST))).setValue(SOUTH, Boolean.valueOf(this.connectsTo(blockstate2, blockstate2.isFaceSturdy(blockgetter, blockpos3, Direction.NORTH), Direction.NORTH))).setValue(WEST, Boolean.valueOf(this.connectsTo(blockstate3, blockstate3.isFaceSturdy(blockgetter, blockpos4, Direction.EAST), Direction.EAST))).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    public BlockState updateShape(BlockState p_53323_, Direction p_53324_, BlockState p_53325_, LevelAccessor p_53326_, BlockPos p_53327_, BlockPos p_53328_) {
        if (p_53323_.getValue(WATERLOGGED)) {
            p_53326_.scheduleTick(p_53327_, Fluids.WATER, Fluids.WATER.getTickDelay(p_53326_));
        }

        return p_53324_.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? p_53323_.setValue(PROPERTY_BY_DIRECTION.get(p_53324_), Boolean.valueOf(this.connectsTo(p_53325_, p_53325_.isFaceSturdy(p_53326_, p_53328_, p_53324_.getOpposite()), p_53324_.getOpposite()))) : super.updateShape(p_53323_, p_53324_, p_53325_, p_53326_, p_53327_, p_53328_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53334_) {
        p_53334_.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
