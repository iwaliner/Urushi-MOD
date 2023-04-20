package com.iwaliner.urushi.block;


import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import twilightforest.block.WaterloggedBlock;

public class BarsBlock extends HorizonalRotateBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    private static final VoxelShape BASE = Block.box(7D, 0.0D, 7D, 9D, 16D, 9D);
    private static final VoxelShape SIDE_WEST = Block.box(1D, 0D, 7D, 7D, 16D, 9D);
    private static final VoxelShape SIDE_EAST = Block.box(9D, 0D, 7D, 15D, 16D, 9D);
    private static final VoxelShape SIDE_NORTH = Block.box(7D, 0D, 1D, 9D, 16D, 7D);
    private static final VoxelShape SIDE_SOUTH = Block.box(7D, 0D, 9D, 9D, 16D, 15D);
    private static final VoxelShape BASE_HIGH = Block.box(7D, 0.0D, 7D, 9D, 24D, 9D);
    private static final VoxelShape SIDE_WEST_HIGH = Block.box(1D, 0D, 7D, 7D, 24D, 9D);
    private static final VoxelShape SIDE_EAST_HIGH = Block.box(9D, 0D, 7D, 15D, 24D, 9D);
    private static final VoxelShape SIDE_NORTH_HIGH = Block.box(7D, 0D, 1D, 9D, 24D, 7D);
    private static final VoxelShape SIDE_SOUTH_HIGH = Block.box(7D, 0D, 9D, 9D, 24D, 15D);

    public BarsBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED,false).setValue(NORTH,false).setValue(EAST,false).setValue(SOUTH,false).setValue(WEST,false));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return Shapes.or(BASE,!state.getValue(NORTH)? BASE:SIDE_NORTH,!state.getValue(EAST)? BASE:SIDE_EAST,!state.getValue(SOUTH)? BASE:SIDE_SOUTH,!state.getValue(WEST)? BASE:SIDE_WEST);

    }
    public FluidState getFluidState(BlockState p_204507_1_) {
        return p_204507_1_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_204507_1_);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return Shapes.or(BASE_HIGH,!state.getValue(NORTH)? BASE_HIGH:SIDE_NORTH_HIGH,!state.getValue(EAST)? BASE_HIGH:SIDE_EAST_HIGH,!state.getValue(SOUTH)? BASE_HIGH:SIDE_SOUTH_HIGH,!state.getValue(WEST)? BASE_HIGH:SIDE_WEST_HIGH);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getBlock()!= ItemAndBlockRegister.sikkui_bars.get();
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getBlock()!= ItemAndBlockRegister.sikkui_bars.get()?60:0;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(NORTH,EAST,SOUTH,WEST,WATERLOGGED,FACING);
    }
    public boolean connectsToByFacing(BlockState thisState, Direction direction, LevelAccessor world, BlockPos pos) {

        BlockState nextState=world.getBlockState(pos.relative(direction));
        boolean flag1 = nextState.getBlock() instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(nextState, direction);

       return nextState.getMaterial()!= Material.WATER&&nextState.getMaterial()!= Material.AIR&&(nextState.getBlock() instanceof BarsBlock||flag1||!FenceBlock.isExceptionForConnection(nextState));
    }
    @Override
    public BlockState updateShape(BlockState state1, Direction facing, BlockState state2, LevelAccessor world, BlockPos pos1, BlockPos pos2) {

        return super.updateShape(state1, facing, state2, world, pos1, pos2).setValue(NORTH, this.connectsToByFacing(state1, Direction.NORTH, world, pos1))
                .setValue(EAST, this.connectsToByFacing(state1, Direction.EAST, world, pos1))
                .setValue(SOUTH, this.connectsToByFacing(state1, Direction.SOUTH, world, pos1))
                .setValue(WEST, this.connectsToByFacing(state1, Direction.WEST, world, pos1));

    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState thisState = iblockreader.getBlockState(blockpos);


        return this.defaultBlockState().setValue(NORTH, this.connectsToByFacing(thisState, Direction.NORTH, iblockreader, blockpos))
                .setValue(SOUTH, this.connectsToByFacing(thisState, Direction.SOUTH, iblockreader, blockpos))
                .setValue(WEST, this.connectsToByFacing(thisState, Direction.WEST, iblockreader, blockpos))
                .setValue(EAST, this.connectsToByFacing(thisState, Direction.EAST, iblockreader, blockpos))
                ;

    }
    public BlockState rotate(BlockState p_52341_, Rotation p_52342_) {
        switch(p_52342_) {
            case CLOCKWISE_180:
                return p_52341_.setValue(NORTH, p_52341_.getValue(SOUTH)).setValue(EAST, p_52341_.getValue(WEST)).setValue(SOUTH, p_52341_.getValue(NORTH)).setValue(WEST, p_52341_.getValue(EAST));
            case COUNTERCLOCKWISE_90:
                return p_52341_.setValue(NORTH, p_52341_.getValue(EAST)).setValue(EAST, p_52341_.getValue(SOUTH)).setValue(SOUTH, p_52341_.getValue(WEST)).setValue(WEST, p_52341_.getValue(NORTH));
            case CLOCKWISE_90:
                return p_52341_.setValue(NORTH, p_52341_.getValue(WEST)).setValue(EAST, p_52341_.getValue(NORTH)).setValue(SOUTH, p_52341_.getValue(EAST)).setValue(WEST, p_52341_.getValue(SOUTH));
            default:
                return p_52341_;
        }
    }

    public BlockState mirror(BlockState p_52338_, Mirror p_52339_) {
        switch(p_52339_) {
            case LEFT_RIGHT:
                return p_52338_.setValue(NORTH, p_52338_.getValue(SOUTH)).setValue(SOUTH, p_52338_.getValue(NORTH));
            case FRONT_BACK:
                return p_52338_.setValue(EAST, p_52338_.getValue(WEST)).setValue(WEST, p_52338_.getValue(EAST));
            default:
                return super.mirror(p_52338_, p_52339_);
        }
    }
}
